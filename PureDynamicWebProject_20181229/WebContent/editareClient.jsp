<%@page import="java.util.List"%>
<%@page import="ro.petShop.incapsulare.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editare Client</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<%
	
	Client client = (Client) request.getAttribute("client");
	
	%>

<center>

<h1>Editati clientul</h1>

<form action = "editeazaClient" method = "post">
	<table>
	<tr>
		<td>ID client:</td> 
		<td><input type = "text" name = "id"  value = "<%=client.getIdClient()%>" readonly></td>
	</tr>
	
	<tr>
		<td>Nume: </td>
		<td><input type = "text" name = "numeClient" value = "<%=client.getNume()%>"></td>
	</tr>
	
	<tr>	
		<td>Prenume: </td>
		<td><input type = "text" name = "prenumeClient" value = "<%=client.getPrenume()%>"></td>
	</tr>client
	
	<tr>
		<td>Localitate: </td>
		<td><input type = "text" name = "localitate" value = "<%=client.getLocalitate()%>"></td>
	</tr>	  
	
	<tr>
		<td><input type = "submit" value = "Edit"></td>
	</tr>
	</table>
	

</form>
	
		<form action="backToTheAllClients">
				<button type="submit">Back</button>
		</form>
		
</center>

</body>
</html>