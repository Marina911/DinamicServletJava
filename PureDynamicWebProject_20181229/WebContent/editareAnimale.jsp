<%@page import="ro.petShop.incapsulare.Animal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editare Animal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<%
		
	Animal animal = (Animal) request.getAttribute("animal");
		
	%>

<center>

<h1>Editati animalul</h1>

<form action = "editeazaAnimal" method = "post">
	<table>
	<tr>
		<td>ID animal:</td> 
		<td><input type = "text" name = "id"  value = "<%=animal.getIdAnimal()%>" readonly></td>
	</tr> 
	
	<tr>
		<td>Specie: </td>
		<td><input type = "text" name = "specie" value = "<%=animal.getSpecieAnimal().getNumeSpecie()%>" readonly></td>
	</tr>
	
	<tr>	
		<td>Culoare: </td>
		<td><input type = "text" name = "culoareAnimal" value = "<%=animal.getCuloare()%>"></td>
	</tr>
	
	<tr>
		<td>Pret: </td>
		<td><input type = "text" name = "pret" value = "<%=animal.getPret()%>"></td>
	</tr>	  
	
	<tr>
		<td><input type = "submit" value = "Edit"></td>
	</tr>
	
	</table>


</form>

		<form action="backToTheAllAnimals">
				<button type="submit">Back</button>
		</form>

</center>

</body>
</html>