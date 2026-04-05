<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Employe" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des employés - Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="dashboard-body">

    <div class="dashboard-container">
        <aside class="sidebar">
            <div class="sidebar-header">
                <i class="fas fa-users"></i> Gestion Employés
            </div>
            <ul class="nav-menu">
                <li class="nav-item active"><a href="EmployeServlet?action=list"><i class="fas fa-th-large"></i> Tableau de bord</a></li>
                <li class="nav-item"><a href="EmployeServlet?action=new"><i class="fas fa-user-plus"></i> Ajouter</a></li>
                <li class="nav-item"><a href="EmployeServlet?action=list"><i class="fas fa-list"></i> Liste des employés</a></li>
                <li class="nav-item"><a href="LogoutServlet"><i class="fas fa-sign-out-alt"></i> Déconnexion</a></li>
            </ul>
        </aside>

        <main class="main-content">
            <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 25px;">
                <div>
                    <h2 style="margin: 0; color: var(--text-dark);">Tableau de bord</h2>
                    <p style="color: var(--text-muted); font-size: 0.9rem;">Consultez et gérez vos employés en temps réel.</p>
                </div>
                
                <a href="EmployeServlet?action=new" class="btn-primary" style="width: auto; padding: 10px 20px; border-radius: 8px;">
                    <i class="fas fa-plus"></i> Nouvel Employé
                </a>
            </div>

            <div class="table-card" style="margin-bottom: 20px; padding: 15px 25px;">
                <form action="EmployeServlet" method="get" style="display: flex; gap: 15px; align-items: center;">
                    <input type="hidden" name="action" value="search">
                    <div class="input-with-icon" style="flex: 1;">
                        <i class="fas fa-search"></i>
                        <input type="text" name="critere" placeholder="Rechercher par nom, email ou poste..." style="margin-bottom: 0;">
                    </div>
                    <button type="submit" class="btn-primary" style="width: auto; padding: 10px 25px; margin: 0;">
                        Rechercher
                    </button>
                </form>
            </div>

            <div class="table-card">
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Email</th>
                            <th>Poste</th>
                            <th>Salaire</th>
                            <th style="text-align: center;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Employe> listEmploye = (List<Employe>) request.getAttribute("listEmploye");
                            if (listEmploye != null && !listEmploye.isEmpty()) {
                                for (Employe e : listEmploye) {
                        %>
                        <tr>
                            <td style="font-weight: 500;"><%= e.getNom() %></td>
                            <td style="color: var(--text-muted);"><%= e.getEmail() %></td>
                            <td>
                                <span style="background: #eef2ff; color: #4338ca; padding: 4px 10px; border-radius: 20px; font-size: 0.8rem; font-weight: 600;">
                                    <%= e.getPoste() %>
                                </span>
                            </td>
                            <td><strong><%= String.format("%.2f", e.getSalaire()) %> €</strong></td>
                            <td style="text-align: center;">
                                <a href="EmployeServlet?action=edit&id=<%= e.getId() %>" class="btn-edit" title="Modifier">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="EmployeServlet?action=delete&id=<%= e.getId() %>" class="btn-delete" title="Supprimer"
                                   onclick="return confirm('Voulez-vous vraiment supprimer cet employé ?');">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                        <% 
                                } 
                            } else { 
                        %>
                        <tr>
                            <td colspan="5" style="padding: 40px; text-align: center;">
                                <div style="color: #94a3b8;">
                                    <i class="fas fa-folder-open" style="font-size: 3rem; display: block; margin-bottom: 10px;"></i>
                                    <p>Aucun employé trouvé pour votre recherche.</p>
                                </div>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </main>
    </div>

</body>
</html>