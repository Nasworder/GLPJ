package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            CommerceFrame frame = new CommerceFrame(new CommerceService());
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }


    }
}