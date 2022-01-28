<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL : expression language</title>
</head>
<body>
<jsp:useBean id="emp" class="fr.formation.inti.entity.Employee"></jsp:useBean>
<h2>Hello : </h2>

<jsp:setProperty property="lastName" name="emp" value= "Ermeneg"/>
<jsp:setProperty property="firstName" name="emp" value= "Alaric"/>

<h1> Hello ${emp.firstName } ${emp.lastName}</h1>


<form action="emp" method="post">
<input type="text" name="firstName">
<br>
<input type="text" name="lastName">
<br>
<input type="submit" value="hello">
</form>
<h1>hello ${firstName} ${lastName }</h1>
<h2>Hello Employee ${employee.firstName}</h2>
</body>
</html>