<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Animal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
		<center>

		<h1>Introduceti un animal</h1>
		<table>
			<tr>
				<form action="cautaAnimal">
					<td><input type="submit" value="Cauta"></td>
				</form>

				<form action="afisareAnimale">
					<td><input type="submit" value="Vezi animalele"></td>
				</form>

		<form action="inserareAnimal">
		
			<tr>
				<td>Specie:</td>
				<td><select name="specie">	
					  <option value="1">caine</option>
					  <option value="2">pisica</option>
					  <option value="3">iepure</option>
					  <option value="4">capra</option>
					  <option value="5">porcusor de guineea</option>
					  <option value="6">hamster pitic</option>
					  <option value="7">sarpe</option>
					  <option value="8">gaina</option>
					  <option value="9">veverita</option>
					  <option value="10">pisica salbatica</option>
					  <option value="11">papagal</option>
					</select>		
				</td>
			
			</tr>
			<tr>
				<td>Culoare:</td>
				<td><input type="text" name="culoareAnimal"></td>
			</tr>
			<tr>
				<td>Pret:</td>
				<td><input type="number" name="pret"></td>
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