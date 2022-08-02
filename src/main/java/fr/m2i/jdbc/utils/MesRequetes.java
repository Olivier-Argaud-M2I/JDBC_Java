package fr.m2i.jdbc.utils;

import fr.m2i.jdbc.models.ActorDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class MesRequetes {



    public MesRequetes(){

    }

    public static List<ActorDto> getActors(){

        List<ActorDto> actors = new ArrayList<>();

        try{
            Connection connection = MaConnexion.getConnexion();

            Statement statement = connection.createStatement();

            ResultSet resultSet =  statement.executeQuery("select * from actor");

            while(resultSet.next()){

//                Calendar cal = Calendar.getInstance();
//                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//                cal.setTime(sdf.parse(resultSet.getTimestamp("last_update")));// all done

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(resultSet.getTimestamp("last_update").getTime());


                actors.add(new ActorDto(
                        Integer.valueOf(resultSet.getString("actor_id")),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        calendar
                ));

            }
            statement.close();
            MaConnexion.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
        }


        return actors;
    }


    public static List<ActorDto> getActorById(Integer id){

        List<ActorDto> actors = new ArrayList<>();

        try{
            Connection connection = MaConnexion.getConnexion();

            Statement statement = connection.createStatement();
            System.out.println("ma requete : "+"select * from actor WHERE actor_id = "+id);
            ResultSet resultSet =  statement.executeQuery("select * from actor WHERE actor_id = "+id);

            while(resultSet.next()){

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(resultSet.getTimestamp("last_update").getTime());

                actors.add( new ActorDto(
                        Integer.valueOf(resultSet.getString("actor_id")),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        calendar
                ));

            }
            statement.close();
            MaConnexion.closeConnection();

        }catch(Exception e ){
            System.out.println("oups");
        }


        return actors;
    }

    public static List<ActorDto> getActorByName(String name){

        List<ActorDto> actors = new ArrayList<>();

        try{
            Connection connection = MaConnexion.getConnexion();

            Statement statement = connection.createStatement();
            System.out.println("ma requete : "+"select * from actor WHERE last_name = \'"+name+"\'");
            ResultSet resultSet =  statement.executeQuery("select * from actor WHERE last_name like \'%"+name+"%\'");

            while(resultSet.next()){

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(resultSet.getTimestamp("last_update").getTime());

                actors.add( new ActorDto(
                        Integer.valueOf(resultSet.getString("actor_id")),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        calendar
                ));

            }

            statement.close();
            MaConnexion.closeConnection();


        }catch(Exception e ){
            System.out.println("oups");
        }


        return actors;
    }


}
