<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fr.eseo.login.Client" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage Réservation</title>
</head>
<body>

Le client au nom de 
	<% 
		Client client = (Client) request.getSession().getAttribute("client");
		out.print(client.getPrenom());
		out.print(" ");
		out.print(client.getNom());
		out.print(" ");
	
	%>
	
	avec le code 
	<%= session.getAttribute("reservation") %> 
	a bien été effectuée
	
	<br><br>
	
	<form action="menu.html">
         <button type="submit">Retour Menu</button>
    </form> 

</body>
</html>