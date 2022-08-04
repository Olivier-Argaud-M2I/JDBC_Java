package fr.m2i.jdbc.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="todobis")
public class TodoBis {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name="nom")
    private String nom;
    @Basic
    @Column(name="description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public TodoBis() {
    }

    public TodoBis(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public TodoBis(Integer id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public TodoBis(Integer id, String nom, String description, Calendar date) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date = date;
    }
}
