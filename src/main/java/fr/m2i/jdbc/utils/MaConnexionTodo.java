package fr.m2i.jdbc.utils;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexionTodo {

    private static final String BDD = "jdbc:mysql://localhost:3306/M2I";
    private static final String LOGIN = "admin";
    private static final String MDP = "admin";

    private static Connection connection;

    private static DataSource dataSource;

    static{
        try {
            Context envContext = InitialContext.doLookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("dataSource");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnexion() throws SQLException {

        if(connection==null){
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            connection = DriverManager.getConnection(BDD,LOGIN,MDP);
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
        connection = null;

    }

}
