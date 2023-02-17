package org.example;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CommerceService {
    private Connection connection;

    public CommerceService() throws IOException, SQLException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("commerce.properties");
        properties.load(inputStream);

        connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
    }

    public ArrayList<Item> getItems() throws CommerceExcepetion {
        final String req = "select items.num, description, prix, client, c.num, c.prenom, c.solde from items left join clients c on items.client = c.num";
        ArrayList<Item> items = new ArrayList<Item>();

        try (PreparedStatement statement = connection.prepareStatement(req);
             ResultSet resSet = statement.executeQuery();) {
            while (resSet.next()) {
                if (resSet.getInt("client") != 0) {
                    items.add(new Item(resSet.getInt("items.num"), resSet.getString("description"), resSet.getBigDecimal("prix"), new Client(resSet.getInt("c.num"), resSet.getString("c.prenom"), resSet.getBigDecimal("c.solde"))));
                } else {
                    items.add(new Item(resSet.getInt("items.num"), resSet.getString("description"), resSet.getBigDecimal("prix"), null));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }

        return items;
    }

    public Client getClientByPrenom(String prenom) throws CommerceExcepetion {
        final String req = "select num, prenom, solde from clients where prenom = ?";
        Client client = null;

        try (PreparedStatement statement = connection.prepareStatement(req);) {
            statement.setString(1, prenom);
            ResultSet resSet = statement.executeQuery();
            if (resSet.next()) {
                client = new Client(resSet.getInt("num"), resSet.getString("prenom"), resSet.getBigDecimal("solde"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }

        return client;
    }

    public Item getItemByNum(int num) throws CommerceExcepetion, ItemNotFoundException {
        final String req = "select num, description, prix, client from items where num = ?";
        Item item = null;

        try (PreparedStatement statement = connection.prepareStatement(req)) {
            statement.setInt(1, num);
            ResultSet resSet = statement.executeQuery();
            if (resSet.next()) {
                if (resSet.getInt("client") == 0) {
                    return new Item(resSet.getInt("num"), resSet.getString("description"), resSet.getBigDecimal("prix"), null);
                }
            }

            throw new ItemNotFoundException(num);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }
    }

    public void debitClient(Client client, Item item) throws CommerceExcepetion, NotEnoughtException {
        final String req = "update clients set solde = solde - ? where prenom = ?";

        try (PreparedStatement statement = connection.prepareStatement(req);) {
            statement.setString(1, item.getPrix().toString());
            statement.setString(2, client.getPrenom());
            statement.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 3819) { // MySQL 8.0.16 and higher (error_er_check_constraint_violated)
                throw new NotEnoughtException(client);
            }
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }

    }

    public void updateItem(Item item, Client client) throws CommerceExcepetion {
        final String req = "update items set client = ? where num = ?";

        try (PreparedStatement statement = connection.prepareStatement(req);) {
            statement.setInt(1, client.getNum());
            statement.setInt(2, item.getNum());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }
    }

    public Client createClient(String prenom) throws CommerceExcepetion {
        final String req = "insert into clients (prenom, solde) values (?, 50)";

        try (PreparedStatement statement = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, prenom);
            statement.executeUpdate();
            ResultSet resSet = statement.getGeneratedKeys();
            if (resSet.next()) {
                return new Client(resSet.getInt(1), prenom, new BigDecimal(50));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommerceExcepetion(e);
        }
    }

    public BigDecimal buyItem(int numItem, String nameClient) throws CommerceExcepetion, ItemNotFoundException, NotEnoughtException {
        try {
            connection.setAutoCommit(false);
            Client client = getClientByPrenom(nameClient);
            if (client == null) {
                client = createClient(nameClient);
            }
            Item item = getItemByNum(numItem);
            debitClient(client, item);
            updateItem(item, client);
            connection.commit();
            return item.getPrix();

        } catch (CommerceExcepetion | ItemNotFoundException | NotEnoughtException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new CommerceExcepetion(e1);
            }
            throw e;
        } catch (SQLException e) {
            throw new CommerceExcepetion(e);
        }
    }

}
