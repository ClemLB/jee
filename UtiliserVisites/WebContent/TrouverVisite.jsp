<%@page import="fr.eseo.jee.taxi.Connexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="fr.eseo.jee.visite.Visite"%>
<%@ page import="com.mysql.cj.jdbc.Driver"%>
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
    
    String sql = "SELECT DISTINCT Ville FROM Visites";
	
	statement.executeQuery(sql);
	ResultSet resultSet = statement.getResultSet();
	
	%>
	<label for="nomVille"> Ville : </label>
	<SELECT name="nomVille" id="nomVille" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value="<%= resultSet.getString("Ville")%>"><%= resultSet.getString("Ville")%>
        <% } %>
    </SELECT>
    <br>
    
    <%
    sql = "SELECT DISTINCT typeVisite FROM Visites";
	
	statement.executeQuery(sql);
	resultSet = statement.getResultSet();
	%>
    
    <label for="typeVisite"> Type de visite : </label>
    <SELECT name="typeVisite" id="typeVisite" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value="<%= resultSet.getString("typeVisite")%>"><%= resultSet.getString("typeVisite")%>
        <% } %>
    </SELECT>
    <br>
    
    <%
    sql = "SELECT DISTINCT prixVisite FROM Visites";
	
	statement.executeQuery(sql);
	resultSet = statement.getResultSet(); 
	%>
    
    <label for="prixVisite"> Prix de la visite (en €) : </label>
    <SELECT name="prixVisite" id="prixVisite" size="1">
        <OPTION value="">Choisir
        <%  while(resultSet.next()){ %>
            <OPTION value=<%= resultSet.getDouble("prixVisite")%>><%= resultSet.getDouble("prixVisite")%>
        <% } %>
    </SELECT>
    <br>
    
	<%
		resultSet.close();
    statement.close();
    connection.close();
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
	
	<br>
	
	<form action="menu.jsp">
		<button type="submit"> Retour </button>
	</form>

</body>
</html>