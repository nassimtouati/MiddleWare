<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTER </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: left;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
<center>
<form action="AccountServlet?action=insert" method='post'>
	Username : <input type="text" name="username" required="" /><br>
	Password : <input type="password" name="password" required="" /><br>
	Email : <input type="email" name="email" required="" /><br>
	Tel : <input type="text" name="tel" required="" /><br>

<input type="submit" value="subscribe"/>
<input type="reset" value="reset"/>
	
</form>
</center>
</body>
</html>