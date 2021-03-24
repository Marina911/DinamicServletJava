<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ro.petShop.incapsulare.Animal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<center>

		<h1>Lista tuturor animalelor</h1>

		<%
			List<Animal> listaAnimale = (List<Animal>) request.getAttribute("listaAnimaleDB");
			Iterator iteratorList = listaAnimale.iterator();
		%>

		<table border="2">
			
			<tr>
				<td>ID Animal</td>
				<td>Specie</td>
				<td>Culoare</td>
				<td>Pret</td>
				<td>Optiune Editare</td>
				<td>Optiune Stergere</td>
			</tr>
				
			<%
				while (iteratorList.hasNext()) {
					Animal animal =  (Animal) iteratorList.next();
			%>
			<tr>
				<td><%=animal.getIdAnimal()%></td>
				<td><%=animal.getSpecieAnimal().getNumeSpecie()%></td>
				<td><%=animal.getCuloare()%></td>
				<td><%=animal.getPret()%></td>
				<td>
					<form action="editeazaAnimal">
						<input type="text" name="id" value="<%=animal.getIdAnimal()%>" hidden>
						<button type="submit">Edit</button>
					</form>
				</td>
				<td>
					<form action="stergeAnimal">
						<input type="text" name="id" value="<%=animal.getIdAnimal()%>" hidden>
						<button type="submit">Sterge</button>
					</form>
				</td>

			</tr>
			<%
				}
			%>
		</table>
		
		<form action="backToTheInsertAnimal">
				<button type="submit">Back</button>
		</form>
		
	</center>

</body>
</html>