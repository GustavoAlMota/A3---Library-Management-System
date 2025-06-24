# Library Manager - Final Project A3 (Java CRUD)

## 📚 Project Overview

This is a simple **Library Management System** developed in **Java** as a final semester project (A3) for university. The application allows CRUD operations (Create, Read, Update, Delete) for both users and books. It is designed to work with a **MySQL** database and built using **NetBeans IDE**.

## 🛠️ Technologies Used

- Java (Swing GUI)
- MySQL
- NetBeans IDE
- XAMPP (Apache + MySQL server)

## ✅ Features

- Add, edit, and delete library users
- Add, edit, and delete books
- Login screen with admin access
- Relational database with foreign keys
- Data persistence using JDBC

## 🔐 Admin Access

To access the admin panel:

- **Username**: `admin`  
- **Password**: `admin`  

> Make sure to use all lowercase letters.

---

## 🚀 How to Run the Project

### 1. Requirements

- NetBeans IDE installed
- XAMPP installed and running
- MySQL configured in XAMPP
- Java JDK installed and properly configured in NetBeans

### 2. Database Setup

1. Open **XAMPP** and **start Apache and MySQL**.
2. Open **phpMyAdmin** via your browser (http://localhost/phpmyadmin).
3. Create a new database (e.g., `library_db`).
4. Import the provided `.sql` file located in the project folder to create the necessary tables and initial data.

### 3. Project Configuration

1. Open the project in **NetBeans**.
2. Make sure the JDBC connection settings (URL, user, password) match your MySQL configuration.
   - Example connection string in your code:
     ```java
     String url = "jdbc:mysql://localhost:3306/library_db";
     String user = "root";
     String password = "";
     ```
3. Clean and build the project.
4. Run the application.

---

## 📝 Notes

- This system is intended for academic use and is kept simple for learning purposes.
- Error handling and advanced validation may be limited.

---

## 👨‍🎓 Author

This project was developed as part of a final assignment for the [Name of Course or Professor if you'd like to include].

