<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remaining seat</title>
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
<form var="ArtisteServlet" items="${Seat}"> 

<table >
                      
<tr>
<th>CATEGORY_A</th>
<th>CATEGORY_B</th>
<th>CATEGORY_C</th>				  
<th>CATEGORY_D</th>
</tr>
                     
<tbody >
                    <tr>
                    <td><c:out value="${Seat.seat_CA}"/></td>
                       <td><c:out value="${Seat.seat_CB}"/></td>
                        <td><c:out value="${Seat.seat_CC}"/></td>
                        <td><c:out value="${Seat.seat_CD}"/> </td>
                    </tr>
                      </tbody>
                    </table>
</form> 
</center>
</body>
</html>