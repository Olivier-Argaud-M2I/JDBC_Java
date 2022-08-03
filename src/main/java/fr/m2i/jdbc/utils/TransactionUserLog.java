package fr.m2i.jdbc.utils;

import fr.m2i.jdbc.models.Log;
import fr.m2i.jdbc.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionUserLog {


    public TransactionUserLog(User user, Log log) throws SQLException {

        Connection connection = MaConnexionTodo.getConnexion();
        connection.setAutoCommit(false);
        boolean isTransactionValid = true;

        try{

            try{
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(nom,prenom) VALUES (?,?)");
                preparedStatement.setString(1,user.getNom());
                preparedStatement.setString(2,user.getPrenom());
                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                isTransactionValid = false;
//                throw new RuntimeException(e);
            }


            try{
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO log(id,data) VALUES (?,?)");
                preparedStatement.setString(1,log.getId().toString());
                preparedStatement.setString(2,log.getData());
                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                isTransactionValid = false;
//                throw new RuntimeException(e);
            }



        }
        finally {

            if(isTransactionValid){
                connection.commit();
            }
            else{
                connection.rollback();
            }

        }













    }
}
