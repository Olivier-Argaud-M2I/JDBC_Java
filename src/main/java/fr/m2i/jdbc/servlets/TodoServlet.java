package fr.m2i.jdbc.servlets;

import fr.m2i.jdbc.models.ActorDto;
import fr.m2i.jdbc.models.Todo;
import fr.m2i.jdbc.utils.MesRequetes;
import fr.m2i.jdbc.utils.MesRequetesTodo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/todos")
public class TodoServlet extends HttpServlet {

    private static final String PAGE = "/WEB-INF/pages/pageTodo.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        System.out.println(type);

        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");


        String nom = request.getParameter("nom");
        Integer id = null;
        try{
            id = Integer.valueOf(request.getParameter("id"));
        }catch(Exception e){
            System.out.println("probleme de parse");
        }

        List<Todo> todos = new ArrayList<>();
        switch (type){
            case "all":
                todos = MesRequetesTodo.getTodos();
                break;
            case "id":
                if (id !=null) {
                    todos.add(MesRequetesTodo.getTodoById(id));
                }
                break;
            case "nom":
                todos = MesRequetesTodo.getTodoByName(nom);
                break;
            case "create":
                Todo todo = new Todo(request.getParameter("nom"),request.getParameter("description"));
                if(id !=null){
                    todo.setId(id);
                    todos.add(MesRequetesTodo.updateTodo(todo));
                }
                else{
                    todos.add(MesRequetesTodo.createTodo(todo));
                }
                break;
            case "delete":
                MesRequetesTodo.deleteTodo(MesRequetesTodo.getTodoById(id));
                break;
        }

        request.setAttribute("todos",todos);


        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
