<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL="login.jsp" />
<title>Choose seat</title>
</head>
<body>
<form action="EventServlet?action=reserver" method="post">
	Welcome ${login }<br>
	Remining Seats  ${seat.idSeat }<br>
	

		<script>
function myFunction() {
    var cat= document.getElementById("category").value
    var seats = document.getElementById("seat").value
    var nbrSeat= document.getElementById("nbrSeat").value
    if (cat=='C1'){
    	if (seats=='CA'){
    		
    		document.getElementById("gainlabel").innerHTML = 3*5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 3*5*nbrSeat;}
    	else if (seats=='CB'){
    		
    		document.getElementById("gainlabel").innerHTML = 5*2.5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 5*2.5*nbrSeat;
    	}
		else if (seats=='CC'){
    		
    		document.getElementById("gainlabel").innerHTML = 2*5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 5*2*nbrSeat;
    	}
		else if (seats=='CD'){
    		
    		document.getElementById("gainlabel").innerHTML = 5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 5*nbrSeat;
    	}
    	
    
    }else if (cat=='C2'){
    	if (seats=='CA'){
    		
    		document.getElementById("gainlabel").innerHTML = 10*3*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 3*10*nbrSeat;}
    	else if (seats=='CB'){
    		
    		document.getElementById("gainlabel").innerHTML = 10*2.5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 10*2.5*nbrSeat;
    	}
		else if (seats=='CC'){
    		
    		document.getElementById("gainlabel").innerHTML = 2*10*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 10*2*nbrSeat;
    	}
		else if (seats=='CD'){
    		
    		document.getElementById("gainlabel").innerHTML = 10*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 10*nbrSeat;
    	}
    	
    
    }else if (cat=='C3'){
    	if (seats=='CA'){
    		
    		document.getElementById("gainlabel").innerHTML = 3*20*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 3*20*nbrSeat;}
    	else if (seats=='CB'){
    		
    		document.getElementById("gainlabel").innerHTML = 20*2.5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 20*2.5*nbrSeat;
    	}
		else if (seats=='CC'){
    		
    		document.getElementById("gainlabel").innerHTML = 2*20*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 20*2*nbrSeat;
    	}
		else if (seats=='CD'){
    		
    		document.getElementById("gainlabel").innerHTML = 20*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 20*nbrSeat;
    	}
    	
    
    }else if (cat=='C4'){
    	if (seats=='CA'){
    		
    		document.getElementById("gainlabel").innerHTML = 3*50*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 3*50*nbrSeat;}
    	else if (seats=='CB'){
    		
    		document.getElementById("gainlabel").innerHTML = 50*2.5*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 50*2.5*nbrSeat;
    	}
		else if (seats=='CC'){
    		
    		document.getElementById("gainlabel").innerHTML = 2*50*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 50*2*nbrSeat;
    	}
		else if (seats=='CD'){
    		
    		document.getElementById("gainlabel").innerHTML = 50*nbrSeat;
    		document.getElementById("reserver").disabled = false;
    		document.getElementById('gain').value = 50*nbrSeat;
    	}
    	
    
    }
}
</script>
	<label id="gainlabel" >0 </label>euro <br>
	<input type="hidden" id="gain" name="gain" value="" />
	
	<table cellpadding="2" border="2">



		<tr>
			<td>Category A</td>
			<td>${seat.seat_CA}</td>
			
		</tr>
		<tr>
			<td>Category B</td>
			<td>${seat.seat_CB}</td>
			
		</tr>
		<tr>
			<td>Category C</td>
			<td>${seat.seat_CC}</td>
			
		</tr>
		<tr>
			<td>Category D</td>
			<td>${seat.seat_CD}</td>
			
		</tr>



	</table>

<input type="hidden" value="${seat.seat_CA}" name="CA" />
<input type="hidden" value="${seat.seat_CB}" name="CB" />
<input type="hidden" value="${seat.seat_CC}" name="CC" />
<input type="hidden" value="${seat.seat_CD}" name="CD" />
	
	<input type="hidden" value="${idArtiste}" name="artiste" id="artiste"/>
	<input type="text" value="${category}" name="category" id="category"/>
	<input type="text" value="${seat.idSeat }" name="seat" id="category"/>
		<table>

			<tr>
				<td>Seat catégory</td>
				<td><select name="seatCat" id="seat">
						<option value="CA">category A</option>
						<option value="CB">category B</option>
						<option value="CC">category C</option>
						<option value="CD">category D</option>
				</select></td>
			</tr>
			
				<tr>
				<td>Number of seats</td>
				<td><select name="nbrSeat" id="nbrSeat">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
				</select></td>
			</tr>
				


		</table>
		
		<input type="submit" id="reserver" value="Pay" disabled="disabled"/>	
		

	
	

</form>

<button onclick="myFunction()">Ajouter panier</button>
</body>
</html>