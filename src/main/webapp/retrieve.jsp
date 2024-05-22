<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Retrieve Student Information</title>
</head>
<body>
    
     <h2>Retrieve Student Information</h2>
     <form action="RetrieveInformation" method="post">
         <label for="email">Enter Email Address:</label>
         <input type="text" id="email" name="email" required>
         
         <input type="submit" value="Retrieve">
     </form>
   
</body>
</html>
