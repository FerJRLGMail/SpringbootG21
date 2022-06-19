<%--
    Author     : Fernando Jesús Ruano Linares
--%>

<%@page import="java.util.List"%>
<%@ page import="es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.dto.EstudiosDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    List<EstudiosDTO> estudios = (List) request.getAttribute("estudios");
%>

<body>
<jsp:include page="cabecera.jsp" />

<h1>Hola analista</h1>

<table BORDER="1">
    <tr>
        <th>NOMBRE DEL ESTUDIO</th>
        <th>QUERY</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>

    <%
        for (EstudiosDTO e : estudios) {%>
    <tr>
        <td> <%= e.getNombre()%></td>
        <td> <%= e.getQuery()%></td>
        <td> <a href="/analista/<%= e.getEstudioId()%>/visualizar">Visualizar Estudio</a> </td>
        <td> <a href="/analista/<%= e.getQuery()%>/nuevoestudio">Clonar Estudio</a></td>
        <td> <a href="/analista/<%= e.getEstudioId()%>/delete">Borrar Estudio</a></td>
    </tr>


    <%  }
    %>



</table>

<a href="/analista/ /nuevoestudio">Crear nuevo estudio ... </a>


</body>
</html>
