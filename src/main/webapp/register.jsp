<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration</title>
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

label {
	display: block;
	margin-bottom: 5px;
	color: #666;
}

input[type="text"], input[type="email"], input[type="password"], input[type="number"],
	select {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"], input[type="button"] {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	border: none;
	border-radius: 4px;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

input[type="button"] {
	background-color: #007BFF;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

input[type="button"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Student Registration Form</h2>
		<form action="StudentServlet" method="post">
			<label for="name">Name:</label> <input type="text" id="name"
				name="name" required> 
			<label for="email">Email:</label>
			 <input type="email" id="email" name="email" required>

			<label for="password">Password:</label> <input type="password"
				id="password" name="password" required> 
			<label for="age">Age:</label>
			<input type="number" id="age" name="age" required> 
			<label
				for="gender">Gender:</label> 
				<select id="gender" name="gender" required>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
				</select>
			 <label for="semester">Semester:</label> 
			 <select id="semester" name="semester" required>
				<option value="First">First</option>
				<option value="Second">Second</option>
				<option value="Third">Third</option>
				<option value="Fourth">Fourth</option>
				<option value="Fifth">Fifth</option>
				<option value="Sixth">Sixth</option>
				<option value="Seventh">Seventh</option>
				<option value="Eighth">Eighth</option>
			</select>
			 <label for="department">Department:</label> 
			 <input type="text" id="department" name="department" required> 
			<label for="collegeName">College Name:</label>
			<input type="text" id="collegeName" name="collegeName" required>
				 
			<input type="submit" value="Register">
		</form>
		<form action="retrieve.jsp" method="get">
			<input type="button" value="Retrieve"
				onclick="window.location.href='retrieve.jsp'">
		</form>
	</div>
</body>
</html>



