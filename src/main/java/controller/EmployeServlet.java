package controller;

import java.io.IOException;
import java.util.List;

import dao.EmployeDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Employe;

@WebServlet("/EmployeServlet")
public class EmployeServlet extends HttpServlet {
    private EmployeDAO employeDAO;

    @Override
    public void init() {
        employeDAO = new EmployeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        traiterRequete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        traiterRequete(request, response);
    }

    private void traiterRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Admin admin = (session != null) ? (Admin) session.getAttribute("admin") : null;

        if (admin == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertEmploye(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateEmploye(request, response);
                break;
            case "delete":
                deleteEmploye(request, response);
                break;
            case "search":
                rechercherEmploye(request, response);
                break;
            default:
                listEmployes(request, response);
                break;
        }
    }

    private void listEmployes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employe> listEmploye = employeDAO.selectAllEmployes();
        request.setAttribute("listEmploye", listEmploye);
        request.getRequestDispatcher("employe_list.jsp").forward(request, response);
    }

    private void rechercherEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String critere = request.getParameter("critere");
        List<Employe> listEmploye = employeDAO.rechercherEmploye(critere != null ? critere : "");
        request.setAttribute("listEmploye", listEmploye);
        request.getRequestDispatcher("employe_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("employe_form.jsp").forward(request, response);
    }

    private void insertEmploye(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String poste = request.getParameter("poste");
        double salaire = Double.parseDouble(request.getParameter("salaire"));

        Employe newEmp = new Employe();
        newEmp.setNom(nom);
        newEmp.setEmail(email);
        newEmp.setPoste(poste);
        newEmp.setSalaire(salaire);

        employeDAO.insertEmploye(newEmp);
        response.sendRedirect("EmployeServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employe employe = employeDAO.selectEmploye(id);
        request.setAttribute("employe", employe);
        request.getRequestDispatcher("employe_form.jsp").forward(request, response);
    }

    private void updateEmploye(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int id = Integer.parseInt(request.getParameter("id")); 
  
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String poste = request.getParameter("poste");
        double salaire = Double.parseDouble(request.getParameter("salaire"));

        Employe e = new Employe();
        e.setId(id); 
        e.setNom(nom);
        e.setEmail(email);
        e.setPoste(poste);
        e.setSalaire(salaire);

        employeDAO.updateEmploye(e);
        response.sendRedirect("EmployeServlet?action=list");
    }

    private void deleteEmploye(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeDAO.deleteEmploye(id);

        response.sendRedirect("EmployeServlet?action=list");
    }
}