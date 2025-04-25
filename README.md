**GreenwichBank - COMP1610 Programming Enterprise Components**
A full-stack enterprise web application simulating a student banking system, built using Jakarta EE (Java EE 8) with MySQL and WildFly Application Server. Developed as part of the COMP1610 module at the University of Greenwich.

🚀 Features
-CRUD operations for Students and Student Accounts.
-Dynamic JSP pages with JSTL and Expression Language.
-Servlet controllers handling business logic.
-JPA entities and DAO pattern for database interaction.
-Hosted on WildFly 24 server with MySQL integration.
-Partial implementation of RESTful API services.
-Includes Entity Relationship Diagram (ERD) and Architecture Diagram.

🛠 Tech Stack
-Java 11+
-Jakarta EE (JPA, Servlets, JSTL)
-WildFly 24
-MySQL 8
-Eclipse IDE for Enterprise Java
=HTML, CSS

Getting Started
Prerequisites
Java 11 or newer

WildFly 26+ Application Server

MySQL Server

Eclipse IDE (Enterprise Edition)

Setup Instructions
bash

# Clone the repository
git clone https://github.com/your-username/greenwichbank.git

# Open the project in Eclipse
File -> Import -> Existing Projects into Workspace -> Select the project directory

# Set up the MySQL database
CREATE DATABASE greenwich_bank;

# Deploy the application
Run on WildFly server

# Access the application
http://localhost:8080/GreenwichBank/student-controller
http://localhost:8080/GreenwichBank/account-controller
