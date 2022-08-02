package fr.m2i.jdbc.servlets;

import fr.m2i.jdbc.models.ActorDto;
import fr.m2i.jdbc.utils.MesRequetes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ActorServlet", value = "/actors")
public class ActorServlet extends HttpServlet {

    private static final String PAGE = "/WEB-INF/pages/pageActor.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        System.out.println(type);

        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        System.out.println("type : "+type);
        System.out.println("id :"+id);
        System.out.println("nom :" +nom);
        List<ActorDto> actors = new ArrayList<>();
        switch (type){
            case "all":
                actors = MesRequetes.getActors();
                break;
            case "id":
                actors = MesRequetes.getActorById(Integer.valueOf(id));
                break;
            case "nom":
                actors = MesRequetes.getActorByName(nom);
                break;
        }

        request.setAttribute("actors",actors);


        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
