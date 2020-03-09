<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fr.eseo.jee.Visite" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des visites</title>
</head>
<body>
	
	<%= request.getSession().getAttribute("resListe") %> <br>
	<%= session.getAttribute("resListe") %> <br>
	
	<br><br>
	
	<form action="menu.html">
         <button type="submit">Retour Menu</button>
    </form> 
</body>
</html>