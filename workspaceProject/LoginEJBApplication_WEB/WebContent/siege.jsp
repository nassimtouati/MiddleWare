<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table cellpadding="2" border="2">
	
		<tr>
		<th>Name		</th> <th> category</th> <th>date</th> <th></th>
		</tr>
		<c:forEach var="seat" items="${Seats}">
		<tr>
			<td><c:out value="${seat.seat_CA}"/> </td>
			<td><c:out value="${seat.seat_CB }"/> </td>
			<td><c:out value="${seat.seat_CC}"/> </td>
				<td><c:out value="${seat.seat_CD}"/> </td>
			
			
		
		</tr>
		
		
		
		</c:forEach>
	</table>


</body>
</html>