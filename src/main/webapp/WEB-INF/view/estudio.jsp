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
<jsp:include page="cabecera.jsp" />

<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    EstudiosDTO estudio = (EstudiosDTO) request.getAttribute("estudio");
    List<Object[]> datos = (List) request.getAttribute("datos");

    int ntitulos = 0;
%>

<body>
<h1>Visualización de Estudio</h1>

Query: <%= estudio.getQuery()%> <br>

<% if (datos.isEmpty()) { %>
La consulta está vacía
<% } else { %>
<table border="1">

    <tr>
        <%
            String[] titulos = estudio.getTitulos().split(";");
            ntitulos = titulos.length;
            for (int i = 0; i < ntitulos; i++) {%>
        <th> <%= titulos[i].equals("_") ? "TITULO" + (i + 1) : titulos[i]%></th>
        <% } %>
    </tr>


    <%  for (Object[] o : datos) { %>
    <tr>
        <% for (int i = 0; i < o.length; i++) {%>
        <td><%= o[i].toString()%></td>
        <% } %>
    </tr>
    <%  }
    }%>

</table>

<form method="POST" action="/analista/updatestudio">
    <input type="hidden" name="analistaid" value="<%= usuario.getId()%>">
    <input type="hidden" name="estudioid" value="<%= estudio.getEstudioId()%>">
    <input type="hidden" name="ntitulos" value="<%= ntitulos%>">
    Nombre del estudio: <input type="text" size="30" name="nombre" value="<%= estudio.getNombre() == null ? "" : estudio.getNombre()%>" /> <br>
    <% for (int i = 0; i < ntitulos; i++) {%>
    Título <%= (i + 1)%>: <input type="text" size="30" name="titulo<%= (i + 1)%>" value="<%= estudio.getTitulos().split(";")[i].equals("_") ? "" : estudio.getTitulos().split(";")[i]%>" /> <br>
    <% }%>

    <input type="submit" value="Actualizar"><br>
</form>

<a href="/analista/">Volver al inicio</a>

</body>
</html>
