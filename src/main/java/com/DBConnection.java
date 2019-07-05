package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 * @author om
 */
public class DBConnection {



    public Statement st;
    public DBConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                 st = conn.createStatement();
                System.out.println("ajsjbdkjasnda");

            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
            e.printStackTrace();
        }

    }

}



