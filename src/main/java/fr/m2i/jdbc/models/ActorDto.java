package fr.m2i.jdbc.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActorDto {

    private Integer id;
    private String nom;
    private String prenom;
    private Calendar date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


    public ActorDto() {
    }

    public ActorDto(Integer id, String nom, String prenom, Calendar date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }

    @Override
    public String toString() {
        Date date1 = date.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = format1.format(date1);

        return "ActorDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date=" + date2 +
                '}';
    }

    public String dateToString(){
        Date date1 = date.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = format1.format(date1);
        return date2;
    }
}
