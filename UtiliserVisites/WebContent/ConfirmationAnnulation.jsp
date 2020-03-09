<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation d'annulation</title>
</head>
<body>
	<%
		if ((boolean) request.getSession().getAttribute("resultat")) {
			out.write("Votre réservation a bien été annulée");
		} else {
			out.write("Veuillez nous excuser, votre requête n'a pas aboutie");
		}
	%>
</body>
</html>