<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fr.eseo.jee.visite.Visite" import="fr.eseo.servlet.TrouverVisites" import="java.util.ArrayList" 
    import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>Liste des visites</title>
</head>
<body>
	<h1>
	<%= request.getSession().getAttribute("resPhrase") %> <br><br>
	</h1>
	
	<% 
	ArrayList<Visite> list = (ArrayList<Visite>) request.getSession().getAttribute("test");
	if(!list.isEmpty()) {
		Visite villeTest = new Visite();

		for(int i = 0; i < list.size(); i++) {
			villeTest = list.get(i);
			
			out.write("<span class=\"visitFinder\">");
			out.println("Visite :");
			out.print("Ville : ");
			out.print(villeTest.getVille());
			out.print(" | Type : ");
			out.print(villeTest.getTypeVisite());
			out.print(" | Date : ");
			out.print(villeTest.getDateVisite());
			out.print(" | Prix(€) : ");
			out.print(String.valueOf(villeTest.getPrix()));
			out.print(" | Code : ");
			out.print(villeTest.getCodeVisite());
			out.write(" | </span>");
			
			out.write("<a href=\"reserverVisite.html?codeVisite=" + villeTest.getCodeVisite() + "\">");
			out.print("Réserver cette visite");
			out.write("</a>");
			out.write("<br><br>");
		}
	}
	%>
	
	<br><br>
	
	<form action="menu.jsp">
         <button type="submit">Retour Menu</button>
    </form> 
</body>
</html>