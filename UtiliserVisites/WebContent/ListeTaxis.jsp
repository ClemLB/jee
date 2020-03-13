<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fr.eseo.jee.taxi.Taxi" import="fr.eseo.servlet.TrouverTaxis" import="java.util.ArrayList" 
    import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>Liste des taxis</title>
</head>
<body>
	<h1>
	<%= request.getSession().getAttribute("resPhrase") %> <br><br>
	</h1>
	
	<% 
	ArrayList<Taxi> list = (ArrayList<Taxi>) request.getSession().getAttribute("listeTaxis");
	if(!list.isEmpty()) {
		Taxi taxi = new Taxi();

		for(int i = 0; i < list.size(); i++) {
			taxi = list.get(i);
			
			out.write("<span class=\"visitFinder\">");
			out.println("Taxi :");
			out.print("Ville : ");
			out.print(taxi.getVille());
			out.print(" | Type : ");
			out.print(taxi.getCategorie());
			out.print(" | Prix(€) : ");
			out.print(String.valueOf(taxi.getTarif()));
			out.print(" | Code : ");
			out.print(taxi.getCodeTaxi());
			out.write(" | </span>");
			
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