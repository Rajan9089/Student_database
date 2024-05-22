<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        p {
            margin: 10px 0;
            color: #666;
            font-size: 18px; /* Increased font size for better visibility */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Student Information</h2>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String semester = request.getParameter("semester");
            String department = request.getParameter("department");
            String collegeName = request.getParameter("collegeName");
        %>
        <p>Name: <%= name %></p>
        <p>Email Address: <%= email %></p>
        <p>Age: <%= age %></p>
        <p>Gender: <%= gender %></p>
        <p>Semester: <%= semester %></p>
        <p>Department: <%= department %></p>
        <p>College Name: <%= collegeName %></p>
    </div>
</body>
</html>
