🚀 Employee Management System (EMS)

A professional CRUD (Create, Read, Update, Delete) web application built with Java EE standards. This project features a modern, high-fidelity dashboard interface with a secure authentication system.
🛠 Tech Stack

    Java Version: JDK 1.8 (Java 8)

    Web Server: Apache Tomcat 7.0

    Database: MySQL (5.7 or 8.0)

    Technologies: JSP, Servlets, JDBC, CSS3, FontAwesome 6.x

    Architecture: MVC (Model-View-Controller)

📋 Features

    Secure Login: Professional authentication with error handling for invalid credentials.

    Modern Dashboard: Sidebar-based navigation with a clean, blue-themed UI.

    Employee Management: * Add new employees with icon-enhanced forms.

        View employee list with status badges and formatted currency.

        Search/Filter employees by name, email, or position.

        Edit and Delete records with confirmation prompts.

    Responsive Design: Styled using custom CSS Flexbox and Grid.

⚙️ Installation & Setup
1. Database Setup

Create a MySQL database named gestion_employes and execute the following:
SQL

CREATE DATABASE gestion_employes;

USE gestion_employes;

CREATE TABLE admin (
    id_adm INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    pass_word VARCHAR(100) NOT NULL
);

CREATE TABLE employe (
    id_emp INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    poste VARCHAR(100) NOT NULL,
    salaire DOUBLE NOT NULL
);

INSERT INTO admin (login, pass_word)
VALUES
	('errady', 'errady123'),
	('errachidi', 'errachidi123'),
	('guendaoui', 'guendaoui123'),
	('jalzim', 'jalzim123');

2. Project Configuration

    IDE: Import the project as a Dynamic Web Project in Eclipse.

    JDK: Ensure the Project Facets are set to Java 1.8.

    Drivers: Place mysql-connector-java.jar in the WebContent/WEB-INF/lib/ folder.

    Connection: Update your Database connection class with your MySQL username and password.

📂 Project Structure
Plaintext

WebContent/
├── css/
│   └── style.css       <-- Custom Professional Styles
├── WEB-INF/
│   ├── lib/            <-- MySQL Connector
│   └── web.xml         <-- Servlet Mappings
├── login.jsp           <-- Authentication Page
├── employe_list.jsp    <-- Dashboard & Table View
└── employe_form.jsp    <-- Add/Edit Interface

🚀 How to Run

    Right-click the project in your IDE.

    Select Run As > Run on Server.

    Select Tomcat v7.0 Server.

    Access the app at: http://localhost:8080/GestionEmployes/login.jsp
