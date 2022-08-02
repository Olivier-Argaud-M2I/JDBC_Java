package fr.m2i.jdbc.utils;


import fr.m2i.jdbc.models.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MesRequetesTodo {


    public static Todo createTodo(Todo todo){

        try{
            Connection connection = MaConnexionTodo.getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo(nom,description) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,todo.getNom());
            preparedStatement.setString(2,todo.getDescription());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                todo.setId(resultSet.getInt(1));
            }

            preparedStatement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }

        return todo;
    }

    public static List<Todo> getTodos(){

        List<Todo> todos = new ArrayList<>();
        try{
            Connection connection = MaConnexionTodo.getConnexion();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                todos.add(new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description")
                ));
            }

            statement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }

        return todos;
    }

    public static List<Todo> getTodoByName(String name){
        List<Todo> todos = new ArrayList<>();
        try{

            Connection connection = MaConnexionTodo.getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo WHERE nom = ?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Todo todo = new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description")
                );
                todos.add(todo);
            }

            preparedStatement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }

        return todos;
    }

    public static Todo getTodoById(Integer id){
        Todo todo = null;
        try{

            Connection connection = MaConnexionTodo.getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo WHERE id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                todo = new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description")
                );
            }


            preparedStatement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }

        return todo;
    }

    public static Todo updateTodo(Todo todo){

        try{
            Connection connection = MaConnexionTodo.getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE todo SET nom = ?,description = ? WHERE id = ?");
            preparedStatement.setString(1,todo.getNom());
            preparedStatement.setString(2,todo.getDescription());
            preparedStatement.setInt(3,todo.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }


        return todo;
    }

    public static void deleteTodo(Todo todo){
        try{
            Connection connection = MaConnexionTodo.getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM todo WHERE id = ?");
            preparedStatement.setInt(1,todo.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            MaConnexionTodo.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
            e.printStackTrace();
        }

    }



}
