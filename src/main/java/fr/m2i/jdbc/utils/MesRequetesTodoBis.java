package fr.m2i.jdbc.utils;


import fr.m2i.jdbc.models.TodoBis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MesRequetesTodoBis {

    private EntityManager em;

    private EntityManagerFactory factory;

    public MesRequetesTodoBis(){
        this.factory = Persistence.createEntityManagerFactory("databaseM2I");
        //Attention pas d'autoclosable
//        this.em = factory.createEntityManager();
    }

    public TodoBis createTodo(TodoBis todo){
        this.em = factory.createEntityManager();
        this.em.getTransaction().begin();
        this.em.persist(todo);
        this.em.getTransaction().commit();
        em.close();
        return todo;
    }

    public List<TodoBis> getTodos(){
        List<TodoBis> todos = new ArrayList<>();

        return todos;
    }

    public List<TodoBis> getTodoByName(String name){
        List<TodoBis> todos = new ArrayList<>();

        return todos;
    }

    public TodoBis getTodoById(Integer id){
        this.em = factory.createEntityManager();
        TodoBis todoBis = this.em.find(TodoBis.class,id);
        em.close();
        return todoBis;
    }

    public TodoBis updateTodo(TodoBis todo){
        this.em = factory.createEntityManager();
        this.em.getTransaction().begin();
        TodoBis todoBis = this.em.merge(todo);
        this.em.getTransaction().commit();
        em.close();
        return todoBis;

    }

    public  void deleteTodo(TodoBis todo){
        this.em = factory.createEntityManager();
        TodoBis todoBis = this.em.find(TodoBis.class,todo.getId());
        this.em.getTransaction().begin();
        this.em.remove(todoBis);
        this.em.getTransaction().commit();
        em.close();
    }




}
