<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage Réservation</title>
</head>
<body>
	<%
	
	String phrase = "Désolé ! La visite n'existe pas dans notre base de donnée. " +
		"Veuillez vérifier d'avoir entré le bon code de visite.";
	
		if (session.getAttribute("reservation").equals(phrase)){
			out.print(phrase);
			out.print("</br></br>");
			out.print("<form action=\"reserverVisite.html\">");
			out.print("<button type=\"submit\">Retour Page Réservation</button>");
			out.print("</form>");
			

		}else{
			out.print("Le réservation du client au nom de ");
			out.print(request.getSession().getAttribute("clientPrenom"));
			out.print(" ");
			out.print(request.getSession().getAttribute("clientNom"));
			out.print(" a bien été effectuée.");
			
			out.print("</br></br>");
			out.print("Code Réservation : ");
			out.print(request.getSession().getAttribute("reservation"));
			
		}
	%>
	

	</br></br>

	<form action="menu.html">
		<button type="submit">Retour Menu</button>
	</form>

</body>
</html>