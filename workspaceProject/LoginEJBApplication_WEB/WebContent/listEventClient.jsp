<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artiste title </title>
</head>
<body>
Welcome ${login }<br>
	<table cellpadding="2" border="2">
	
		<tr>
		<th>Name		</th> <th> category</th> <th>date</th> <th></th>
		</tr>
		<c:forEach var="reservationServlet" items="${Artiste}">
		<tr>
			<td><c:out value="${reservationServlet.a_name}"/> </td>
			<td><c:out value="${reservationServlet.a_category }"/> </td>
			<td><c:out value="${reservationServlet.date}"/> </td>
			<td><a href="EventServlet?action=reservation&idArtiste=${reservationServlet.id_artiste}&category=${reservationServlet.a_category }&seat=${reservationServlet.seat.idSeat}"> see more </a></td>
			
		
		</tr>
		
		
		
		</c:forEach>
	</table>

</body>
</html>