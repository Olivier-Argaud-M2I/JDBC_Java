package fr.m2i.jdbc.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {

    private static final String BDD = "jdbc:mysql://localhost:3306/sakila";
    private static final String LOGIN = "admin";
    private static final String MDP = "admin";

    private static Connection connection;

    public static Connection getConnexion() throws SQLException {

        if(connection==null){
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(BDD,LOGIN,MDP);
        }
        return connection;
    }


}
