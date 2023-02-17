package org.example;

public class NotEnoughtException extends Exception {
    public NotEnoughtException(Client client) {
        super(client.getPrenom() + " n'a pas assez avec un solde de " + client.getSolde() + " CHF");
    }
}
