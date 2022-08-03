package fr.m2i.jdbc.models;

public class Log {
    private Integer id;
    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public Log() {
    }

    public Log(String data) {
        this.data = data;
    }

    public Log(Integer id, String data) {
        this.id = id;
        this.data = data;
    }
}
