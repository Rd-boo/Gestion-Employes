<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<div class="login-wrapper">
	    <header class="top-header">
	        <div class="logo"><i class="fas fa-users"></i> Gestion Employés</div>
	        <div class="user-role"><i class="fas fa-shield-alt"></i> Administrateur</div>
	    </header>
	
	    <main class="login-container">
	        <div class="login-card">
	            <div class="icon-circle"><i class="fas fa-lock"></i></div>
	            <h2>Connexion</h2>
	            <p class="subtitle">Accès à l'espace administrateur</p>
	
	            <form action="LoginServlet" method="post">
	                <div class="input-group">
	                    <label>Login</label>
	                    <div class="input-with-icon">
	                        <i class="far fa-user"></i>
	                        <input type="text" name="login" placeholder="Entrez votre login" required>
	                    </div>
	                </div>
	
	                <div class="input-group">
	                    <label>Password</label>
	                    <div class="input-with-icon">
	                        <i class="fas fa-lock"></i>
	                        <input type="password" name="password" placeholder="Entrez votre mot de passe" required>
	                    </div>
	                </div>
	
	                <button type="submit" class="btn-primary">
	                    <i class="fas fa-sign-in-alt"></i> Se connecter
	                </button>
				    <%
					    String erreur = (String) request.getAttribute("erreur");
					    if (erreur != null) {
					%>
					    <div class="error-banner">
					        <i class="fas fa-exclamation-circle"></i>
					        <span><%= erreur %></span>
					    </div>
					<%
					    }
					%>
	            </form>
	        </div>
	    </main>
	
	</div>
</body>
</html>