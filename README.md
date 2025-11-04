#  Java Order Management System

A backend-based **Order Management System (OMS)** built using **Java**, **Maven**, and **MySQL**, demonstrating CRUD operations, layered architecture, exception handling, and database connectivity — ideal for showcasing backend development skills.

---

##  Features

- Manage **Products**, **Users**, and **Orders**
- Supports **Admin** and **User** roles
- Add, update, delete, and view product details
- Place and track orders
- Robust **exception handling**
- DAO layer for database access
- Uses **JDBC Utility** for database connectivity
- **Properties file** for configuration (DB credentials, etc.)

---

##  Technologies Used

| Layer | Technology |
|-------|-------------|
| Language | Java (Core + OOP) |
| Build Tool | Maven |
| Database | MySQL |
| Architecture | Layered (Model, DAO, Exception, Util, Main) |
| IDE (optional) | Spring Tool Suite / IntelliJ / Eclipse |
| Version Control | Git & GitHub |

---

##  Project Structure
java-order-management-system/
├── src/main/java/com/vivek/oms/
│ ├── model/ # Entity classes (Product, Order, User)
│ ├── dao/ # DAO interfaces and implementations
│ ├── util/ # Utility classes (DB connection, etc.)
│ ├── exception/ # Custom exceptions
│ ├── main/ # Main application entry point
│ └── DataInitializer.java
├── src/main/resources/
│ └── db.properties # Database configuration file
├── pom.xml # Maven dependencies
└── README.md
