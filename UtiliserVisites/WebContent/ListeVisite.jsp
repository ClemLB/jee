<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fr.eseo.jee.Visite" import="fr.eseo.servlet.TrouverVisites" import="java.util.ArrayList" 
    import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des visites</title>
</head>
<body>
	<%= request.getSession().getAttribute("resPhrase") %> <br><br>
	
	<% 
	ArrayList<Visite> list = (ArrayList<Visite>) request.getAttribute("test");
	if(!list.isEmpty()) {
		Visite villeTest = new Visite();

		for(int i = 0; i < list.size(); i++) {
			villeTest = list.get(i);
			
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
		}
	}
	%>
	
	<br><br>
	
	<form action="menu.html">
         <button type="submit">Retour Menu</button>
    </form> 
</body>
</html>