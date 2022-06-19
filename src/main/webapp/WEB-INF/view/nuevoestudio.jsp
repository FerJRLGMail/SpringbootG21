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

    String sel = "";
    String frm = "";
    String whr = "";

    String stqr = (String) request.getAttribute("query");

    if(stqr != null) {
        //disassemble the query
        String[] spq = stqr.split("SELECT|FROM|WHERE");

        if(spq.length>1) {
            sel = spq[1];
            frm = spq[2];
        }
        if(spq.length>3) {
            whr = spq[3];
        }
    }


    String in = (String) request.getAttribute("in");
    if (in == null) {
        in = "";
    }


%>
<body>
<jsp:include page="cabecera.jsp" />

<h1>Nuevo estudio</h1>
<br>


<form method="POST" action="/analista/checkstudio">
    SELECT: <input name="select" type="text" value="<%= sel%>"> <br>
    FROM: <input name="from" type="text" value="<%= frm%>"> <br>
    WHERE: <input name="where" type="text" value="<%= whr+in%>"> <br>
    <input type="submit" name="submit" value="Enviar">
    <input type="submit" name="in" value="Meter en IN">
</form>

<%= error%>
<br>
<a href="/analista/">Volver al inicio</a>
</body>
</html>
