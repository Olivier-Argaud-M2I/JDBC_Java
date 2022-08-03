package fr.m2i.jdbc.servlets;

import fr.m2i.jdbc.models.ActorDto;
import fr.m2i.jdbc.models.Log;
import fr.m2i.jdbc.models.User;
import fr.m2i.jdbc.utils.MesRequetes;
import fr.m2i.jdbc.utils.TransactionUserLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserLogServlet", value = "/userLog")
public class UserLogServlet extends HttpServlet {

    private static final String PAGE = "/WEB-INF/pages/pageUserLog.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("nom"),request.getParameter("prenom"));
        Log log = new Log(Integer.valueOf(request.getParameter("idlog")),request.getParameter("log"));


        try {
            TransactionUserLog transactionUserLog = new TransactionUserLog(user,log);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.doGet(request,response);
    }
}
