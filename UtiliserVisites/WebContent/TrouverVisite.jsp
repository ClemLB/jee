<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="fr.eseo.jee.visite.Visite"%>
<%@page import="com.mysql.cj.jdbc.Driver;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>Trouver une visite</title>
</head>
<body style ="text-align:center;">
	<h1> Trouver votre visite : </h1> <br><br>
	
	<form method="post" action="TrouverVisites">
	<%
    try{
    DriverManager.registerDriver(new Driver());
	Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.4.197/GestionnaireVisites","java","network");

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.getResultSet();
	%>
	<SELECT name="nomVille" id="nomVille" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value=<%= resultSet.getString("Ville")%>>
        <% } %>
    </SELECT>
    
    <SELECT name="typeVisite" id="typeVisite" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value=<%= resultSet.getString("typeVisite")%>>
        <% } %>
    </SELECT>
    
    <SELECT name="prixVisite" id="prixVisite" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value=<%= resultSet.getString("prixVisite")%>>
        <% } %>
    </SELECT>
    
	<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
	%>

	<label for="dateVisite"> Date de la visite : </label>
	<input type="date" id="dateVisite" name="dateVisite"/>
	
	<br>
	
	<label for="codeVisite"> Code de la visite : </label>
	<input type="text" placeholder="" id="codeVisite" name="codeVisite"/>
	
	<br><br>
	
	<input type="submit" value="Chercher">
	</form>
	
	<form action="menu.jsp">
		<button type="submit"> Retour </button>
	</form>

</body>
</html>