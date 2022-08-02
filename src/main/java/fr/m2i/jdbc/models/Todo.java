package fr.m2i.jdbc.models;

public class Todo {

    private Integer id;
    private String nom;
    private String description;

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

    public Todo() {
    }

    public Todo(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Todo(Integer id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
}
