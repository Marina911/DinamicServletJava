<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="ro.petShop.incapsulare.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Afisare Client Cautat</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


<center>

<h1>Lista tuturor clientilor</h1>

<%

List<Client> listaClienti = (List<Client>)request.getAttribute("listaClientiDB");
Iterator<Client> iteratorList = listaClienti.iterator();


%>

<table border = "2">

<%

while(iteratorList.hasNext()){
	Client client = iteratorList.next();

%>
		<tr>
			<td><%=client.getIdClient() %></td>
			<td><%=client.getNume()%></td>
			<td><%=client.getPrenume() %></td>
			<td><%=client.getLocalitate() %></td>
			<td>
					<form action="editeazaClient">
						<input type="text" name="id" value="<%=client.getIdClient()%>" hidden>
						<button type="submit">Edit</button>
					</form>
				</td>
				<td>
					<form action="stergeClient">
						<input type="text" name="id" value="<%=client.getIdClient()%>" hidden>
						<button type="submit">Sterge</button>
					</form>
			</td>
		
		</tr>
		
<%	
}
%>

</table>

	<form action="cautaClienti">
			<button type="submit">Back</button>
	</form>

</center>


</body>
</html>