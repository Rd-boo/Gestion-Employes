package controller;

import java.io.IOException;

import dao.AdminDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Admin admin = AdminDAO.verifierLogin(login, password);

        if (admin != null) {
        	HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            response.sendRedirect("EmployeServlet?action=list");
        } else {
            request.setAttribute("erreur", "Login ou mot de passe incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}