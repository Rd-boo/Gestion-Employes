<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employe" %>
<%
    Employe employe = (Employe) request.getAttribute("employe");
    boolean edit = (employe != null);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= edit ? "Modifier Employé" : "Ajouter un employé" %></title>
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
                <li class="nav-item"><a href="EmployeServlet?action=list"><i class="fas fa-th-large"></i> Tableau de bord</a></li>
                <li class="nav-item <%= !edit ? "active" : "" %>"><a href="EmployeServlet?action=new"><i class="fas fa-user-plus"></i> Ajouter</a></li>
                <li class="nav-item"><a href="EmployeServlet?action=list"><i class="fas fa-list"></i> Liste des employés</a></li>
                <li class="nav-item"><a href="LoginServlet?action=logout"><i class="fas fa-sign-out-alt"></i> Déconnexion</a></li>
            </ul>
        </aside>

        <main class="main-content">
            <div class="breadcrumb">
                <i class="fas fa-home"></i> Employés > <span><%= edit ? "Modifier" : "Ajouter un employé" %></span>
            </div>

            <div class="table-card" style="max-width: 900px; margin: 0 auto;">
                <div class="form-header" style="display: flex; align-items: center; gap: 15px; margin-bottom: 30px;">
                    <div class="icon-circle" style="margin: 0; width: 50px; height: 50px;">
                        <i class="fas <%= edit ? "fa-user-edit" : "fa-user-plus" %>"></i>
                    </div>
                    <div>
                        <h2 style="margin: 0;"><%= edit ? "Modifier l'employé" : "Ajouter un employé" %></h2>
                        <p style="color: var(--text-muted); font-size: 0.9rem;">Remplissez le formulaire ci-dessous pour <%= edit ? "mettre à jour" : "ajouter" %> un employé.</p>
                    </div>
                </div>

                <form action="EmployeServlet" method="post">
                    <%-- Hidden Logic --%>
                    <input type="hidden" name="action" value="<%= edit ? "update" : "insert" %>">
                    <% if (edit) { %>
                        <input type="hidden" name="id" value="<%= employe.getId() %>">
                    <% } %>

                    <div class="input-group">
                        <label>Nom complet *</label>
                        <div class="input-with-icon">
                            <i class="far fa-user"></i>
                            <input type="text" name="nom" value="<%= edit ? employe.getNom() : "" %>" placeholder="Entrez le nom complet" required>
                        </div>
                    </div>

                    <div class="input-group">
                        <label>Email *</label>
                        <div class="input-with-icon">
                            <i class="far fa-envelope"></i>
                            <input type="email" name="email" value="<%= edit ? employe.getEmail() : "" %>" placeholder="exemple@email.com" required>
                        </div>
                    </div>

                    <div class="input-group">
                        <label>Poste *</label>
                        <div class="input-with-icon">
                            <i class="fas fa-briefcase"></i>
                            <input type="text" name="poste" value="<%= edit ? employe.getPoste() : "" %>" placeholder="Entrez le poste" required>
                        </div>
                    </div>

                    <div class="input-group">
                        <label>Salaire *</label>
                        <div class="input-with-icon">
                            <i class="fas fa-dollar-sign"></i>
                            <input type="number" step="0.01" name="salaire" value="<%= edit ? employe.getSalaire() : "" %>" placeholder="Entrez le salaire" required>
                        </div>
                    </div>

                    <div style="display: flex; justify-content: flex-end; gap: 15px; margin-top: 30px; border-top: 1px solid var(--border-color); padding-top: 20px;">
                        <a href="EmployeServlet?action=list" class="btn-primary" style="background-color: #f1f5f9; color: var(--text-main); width: auto; padding: 10px 25px;">
                           <i class="fas fa-times"></i> Annuler
                        </a>
                        <button type="submit" class="btn-primary" style="width: auto; padding: 10px 25px;">
                            <i class="fas fa-save"></i> <%= edit ? "Mettre à jour" : "Enregistrer" %>
                        </button>
                    </div>
                </form>
            </div>

            <% if (request.getAttribute("success") != null) { %>
                <div class="error-banner" style="background-color: #dcfce7; color: #166534; border-color: #bbf7d0; margin-top: 20px; max-width: 900px; margin-left: auto; margin-right: auto;">
                    <i class="fas fa-check-circle"></i>
                    <span>${success}</span>
                </div>
            <% } %>

        </main>
    </div>

</body>
</html>