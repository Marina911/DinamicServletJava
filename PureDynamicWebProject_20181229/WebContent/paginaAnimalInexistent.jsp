<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal Inexistent</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	
<center>

	<h1>Nu avem animale intre pretul minim "<%=request.getParameter("pretMinim")%>" si pretul maxim "<%=request.getParameter("pretMaxim")%>"!</h1>
	
	<form action="cautaAnimal">
			<button type="submit">Back</button>
	</form>

</center>
	

</body>
</html>