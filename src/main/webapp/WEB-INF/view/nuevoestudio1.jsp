<%@ page import="es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO" %><%--
    Author     : Fernando Jesús Ruano Linares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    String error = (String) request.getAttribute("error");
    if (error == null) {
        error = "";
    }
    String stqr = (String) request.getAttribute("query");
    if (stqr == null) {
        stqr = "";
    }
%>
<body>
<jsp:include page="cabecera.jsp" />

<h1>Nuevo estudio</h1>
<br>


<form method="POST" action="/analista/checkstudio">
    Query: <input name="query" type="text" value="<%= stqr%>">
    <input type="submit" value="Enviar">
</form>

<%= error%>
<br>
<a href="/analista/">Volver al inicio</a>
</body>
</html>
