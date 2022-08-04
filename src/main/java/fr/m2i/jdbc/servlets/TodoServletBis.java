package fr.m2i.jdbc.servlets;

import fr.m2i.jdbc.models.Todo;
import fr.m2i.jdbc.models.TodoBis;
import fr.m2i.jdbc.utils.MesRequetesTodo;
import fr.m2i.jdbc.utils.MesRequetesTodoBis;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServletBis", value = "/todosBis")
public class TodoServletBis extends HttpServlet {


    private static final String PAGE = "/WEB-INF/pages/pageTodoBis.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setAttribute("todos",request.getAttribute("todos"));


        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MesRequetesTodoBis requetesTodoBis = new MesRequetesTodoBis();
        String type = request.getParameter("type");


        String nom = request.getParameter("nom");
        Integer id = null;
        try{
            id = Integer.valueOf(request.getParameter("id"));
        }catch(Exception e){
            System.out.println("probleme de parse parametre id");
        }

        List<TodoBis> todos = new ArrayList<>();
        switch (type){
            case "all":
                todos = requetesTodoBis.getTodos();
                break;
            case "id":
                if (id !=null) {
                    todos.add(requetesTodoBis.getTodoById(id));
                }
                break;
            case "nom":
                todos = requetesTodoBis.getTodoByName(nom);
                break;
            case "create":
                TodoBis todo = new TodoBis(request.getParameter("nom"),request.getParameter("description"));
                if(id !=null){
                    todo.setId(id);
                    todos.add(requetesTodoBis.updateTodo(todo));
                }
                else{
                    todos.add(requetesTodoBis.createTodo(todo));
                }
                break;
            case "delete":
                requetesTodoBis.deleteTodo(requetesTodoBis.getTodoById(id));
                todos = requetesTodoBis.getTodos();
                break;
        }

        request.setAttribute("todos",todos);


        this.doGet(request, response);
    }
}
