package fr.m2i.jdbc.servlets;

import fr.m2i.jdbc.utils.MesRequetes;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private static final String BDD = "jdbc:mysql://localhost:3306/sakila";
    private static final String LOGIN = "admin";
    private static final String MDP = "admin";
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(MesRequetes.getActors());

        System.out.println(MesRequetes.getActorById(3));

        System.out.println(MesRequetes.getActorByName("WAHLBERG"));

//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Connection connection = DriverManager.getConnection(BDD,LOGIN,MDP);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet =  statement.executeQuery("select first_name,last_name from actor");
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("last_name"));
//            }
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }



        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}