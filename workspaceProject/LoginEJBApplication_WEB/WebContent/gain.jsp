<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation list</title>
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
<form action="Earnings?action=gain" method='get'>
<h1 >Welcome Administrator here are details about the reservations and earnings</h1>
${error}
<table >                     
<tr>
<th>Client Name</th>
<th>Number of seat reserved</th>
<th>Amount</th>				  
</tr>                   
<tbody >
				<c:set var="total" value="${0}"/>                    
				 <c:forEach var="Earnings" items="${Reservation}">  
                    <tr>
                    <td><c:out value="${Earnings.userName}"/></td>
                       <td><c:out value="${Earnings.nbrSeat}"/></td>
                        <td><c:out value="${Earnings.gain}"/></td>
                         </tr>
                         <c:set var="total" value="${total + Earnings.gain}" />
</c:forEach> 
                      </tbody>
                    </table>


<h1 >Total earnings ${total}</h1>

                      </form>
</center>
</body>
</html>