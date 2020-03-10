<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation paiement</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("resultat").equals("Paiement effectué !")) {
			out.write("Votre réservation n°" + request.getSession().getAttribute("codeReservation")
					+ " a bien été payée");
		} else if(request.getSession().getAttribute("resultat").equals("Paiement impossible !")){
			out.write("Veuillez nous excuser, il vous est impossible de payer pour cette réservation");
		} else {
			out.write("Veuillez nous excuser, un problème lors du paiement est survenu");
		}
	%>
	<br />
	<br />
	<form action="menu.jsp">
		<button type="submit">Retour au menu</button>
	</form>
</body>
</html>