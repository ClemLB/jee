<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>Réservation visites guidées</title>
</head>
<body>
	<h1> 
		Bienvenue  
		<%  
			out.print(" ");
			out.print(request.getSession().getAttribute("clientPrenom")); 
			out.print(" ");
			out.print(request.getSession().getAttribute("clientNom")); 
			out.print(" !");
		%>
	</h1> 
	
	<br>
		
	Vous souhaitez visiter nos plus belles villes de France ? <br>
	N'attendez plus et trouvez votre séjour parfait ! <br><br>
	
	<form action="TrouverVisite.jsp">
		<button type="submit"> Trouver une visite</button> <br><br>
	</form>
	
	<form action="trouverTaxi.html">
		<button type="submit"> Trouver un taxi</button> <br><br>
	</form>
	
	<form action="reserverVisite.html">
		<button type="submit"> Réserver une visite</button> <br><br>
	</form>
	
	<form action="payerVisite.html">
		<button type="submit"> Payer une visite</button> <br><br>
	</form>
	
	<form action="annulerVisite.html">		
		<button type="submit"> Annuler une visite</button> <br><br>
	</form>
	
	<form action="login.html">
		<button type="submit"> Déconnexion </button> <br><br>
	</form>
</body>
</html>