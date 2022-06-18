<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 11/06/2022
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<%
    String strError = (String)request.getAttribute("error");
    if (strError == null) strError = "";
%>
<body>
<h1>Login</h1>

<%= strError %>

<form action = "/autentica" method="post">
    Nombre:</br><input type = "text" name = "nombre" value=""/></br>
    Apellido:</br><input type = "text" name = "apellido" value=""/></br>
    Email:</br><input type = "text" name = "email" value=""/></br>
    <input type="submit" value="Enviar"/>
</form>
</body>
</html>
