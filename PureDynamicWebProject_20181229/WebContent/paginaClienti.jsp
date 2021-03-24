<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Client</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<center>

		<h1>Introduceti un client 2</h1>
		<table>
			<tr>
				<form action="cautaClienti">
					<td><input type="submit" value="Cauta"></td>
				</form>

				<form action="afisareClienti">
					<td><input type="submit" value="Vezi toti clientii"></td>
				</form>

				<form action="inserareClient" method="post">
				</tr>

				<tr>
					<td>Nume:</td>
					<td><input type="text" name="numeClient"></td>
				</tr>
				<tr>
					<td>Prenume:</td>
					<td><input type="text" name="prenumeClient"></td>
				</tr>
				<tr>
					<td>Localitate:</td>
					<td><input type="text" name="localitate"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Insert"></td>
				</tr>

			</form>



		</table>
		
		
		<form action="inapoiLaIndex">
				<button type="submit">Back</button>
		</form>


	</center>

</body>
</html>