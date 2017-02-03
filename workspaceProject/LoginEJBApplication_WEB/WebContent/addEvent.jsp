<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD EVENT</title>

 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 
  <link rel="stylesheet" href="/resources/demos/style.css" />
 
  <style>
    .datepicker{
     
    }
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
<form action="ArtisteServlet?action=add" method='post'>
	Artist name: <input type="text" name="a_name" required="" /><br>


Category: <select onchange="Choose(this) "name="a_category" >

<option value="C1">C1:Local artists </option>
     <option value="C2">C2:Low aura national artists </option>
     <option value="C3">C3:Major national artists </option>
     <option value="C4">C4:Major international artists </option>

</select><br>


<input  type= "hidden" name="w" value="25" />
<input type= "hidden" name="x" value="45" />
<input type= "hidden"  name="y" value="100" />
<input  type= "hidden" name="z" value="500" />

<script type="text/javascript" >

$(function() {
    $( ".datepicker" ).datepicker();
  });
  
</script>



Event date : <input type="text" name="date" required="" class="datepicker"/><br>
<input type="submit" value="Add"/>
<input type="reset" value="reset"/>
	
</form>
</center>

</body>
</html>