package org.example;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CommerceFrame extends JFrame {

    private CommerceService service;
    private JTextField fieldItem;
    private JTextField fieldName;
    private JButton btnBuy;

    private JTextArea areaItems;

    private JTextArea areaInfo;

    public CommerceFrame(CommerceService service) {
        super("Commerce");
        this.service = service;
        setDisplay();

        fieldItem = new JTextField(1);
        fieldName = new JTextField(7);
        btnBuy = new JButton("Achète");
        areaItems = new JTextArea(5, 1);
        areaInfo = new JTextArea(1, 1);
        areaItems.setEditable(false);
        areaInfo.setEditable(false);
        areaInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JPanel upperPanel = new JPanel();
        upperPanel.add(new JLabel("Item: "));
        upperPanel.add(fieldItem);
        upperPanel.add(new JLabel("Prénom: "));
        upperPanel.add(fieldName);
        upperPanel.add(btnBuy);
        add(upperPanel);
        add(areaItems);
        add(areaInfo);

        btnBuy.addActionListener(e -> {
            try {
                BigDecimal price = service.buyItem(Integer.parseInt(fieldItem.getText()), fieldName.getText());
                areaInfo.setText(fieldName.getText() + " a acheté l'item " + fieldItem.getText() + " pour " + price + " CHF");
            } catch (ItemNotFoundException | NotEnoughtException | CommerceExcepetion ex) {
                areaInfo.setText(ex.getMessage());
            }
            setAreaItems();
        });

        pack();
        setAreaItems();

    }


    private void setDisplay() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set visible
        setVisible(true);

        setPreferredSize(new Dimension(300, 200));

        setResizable(false);

        pack();

    }

    public void setAreaItems() {
        areaItems.setText("");
        try {
            for (Item item : service.getItems()) {
                areaItems.append(item.toString() + "\n");
            }
        } catch (CommerceExcepetion e) {
            areaInfo.setText(e.getMessage());
        }

    }


}
