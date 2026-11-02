👨‍💻 Employee Management System

A web-based Employee Management System built using Java, Spring Boot, Spring Data JPA, MySQL, Thymeleaf, HTML, and CSS.

This application helps manage employee records efficiently with CRUD operations, search, sorting, validation, and REST API integration.

---

✨ Features

 📊 Dashboard with department-wise employee count
 
 ➕ Add new employees
 
 👥 View all employees
 
 ✏️ Update employee details
 
 🗑️ Delete employee records
 
 🔍 Search employees by name
 
 ↕️ Sort employees by ID, Name, Department, and Salary
 
 ✅ Form validation
 
 📧 Duplicate email validation
 
 🔗 REST API integration
 
 ⚠️ Global exception handling
 

---

🛠️ Technologies Used

 ☕ Java 21
 
 🌱 Spring Boot
 
 📦 Spring Data JPA
 
 🔄 Hibernate
 
 🐬 MySQL
 
 🍃 Thymeleaf
 
 🌐 HTML5
 
 🎨 CSS3
 
 🏗️ Maven
 
 💻 Eclipse IDE
 
 🚀 Postman
 
 🔧 Git & GitHub

---

📂 Project Structure

```text
Employee-Management-System/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/employeemanagement/
│       │       ├── Controller/
│       │       ├── Entity/
│       │       ├── Repository/
│       │       ├── Service/
│       │       ├── Exception/
│       │       └── EmployeemanagementApplication.java
│       │
│       └── resources/
│           ├── templates/
│           │   ├── index.html
│           │   ├── employees.html
│           │   ├── add-employee.html
│           │   ├── edit-employee.html
│           │   └── search-result.html
│           │
│           ├── static/style.css
│           └── application.properties
│
├── .gitignore
└── pom.xml
```

---

🗄️ Database Configuration

Database Name: `Emp_Management`

The application uses MySQL to store employee information.

Configure the following environment variables:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

⚠️ Make sure MySQL Server is running before starting the application.

---

⚙️ How to Run the Project

1. Clone the repository
   

```bash
git clone https://github.com/YOUR_USERNAME/Employee-Management-System.git
```


2. Open the project in Eclipse IDE.

3. Configure the MySQL database and environment variables.

4. Update Maven dependencies.

5. Run `EmployeemanagementApplication.java`.

6. Open your browser:

```text
http://localhost:8090
```

---

🔗 REST API Endpoints

Base URL: `/api/employees`

- `GET /api/employees` – Get all employees
- `GET /api/employees/{id}` – Get employee by ID
- `POST /api/employees` – Add employee
- `PUT /api/employees` – Update employee
- `DELETE /api/employees/{id}` – Delete employee
- `GET /api/employees/page` – Pagination
- `GET /api/employees/sort` – Sorting
- `GET /api/employees/page-sort` – Pagination with sorting

---

🎯 Project Objective

The objective of this project is to gain practical experience in Spring Boot, REST API development, database integration, MVC architecture, and frontend development.



👨‍💻 Author

Mari Selvam E

💼 Java Full Stack Developer | Aspiring Software Developer



⭐ If you find this project useful, feel free to explore the repository!
