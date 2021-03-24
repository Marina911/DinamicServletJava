<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cauta Animal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<center>

<h1>Cautarea animalelor dupa pret</h1>

<form action = "generareCautareAnimal">
	<table>

	<tr>
		<td>Pret minim: </td>
		<td><input type = "text" name = "pretMinim" ></td>
	</tr>
	
	<tr>
		<td>pret maxim: </td>
		<td><input type = "text" name = "pretMaxim" ></td>
	</tr>
	
	<tr>
		<td><input type = "submit" value = "Cauta"></td>
	</tr>
	</table>

</form>

	<form action="backToTheInsertAnimal">
			<button type="submit">Back</button>
	</form>

</center>

</body>
</html>