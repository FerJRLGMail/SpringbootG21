<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Usuario" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 11/06/2022
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
%>
<head>
</head>

<body>
<table width="70%" id="cabecera">
    <tr width="70%">
        <td><h3>Bienvenido,  <%= usuario.getNombre()%></h3></td>
        <td><h3>Session ID:  <%= session.getId()%></h3></td>
        <td><a href="/logout">Salir</a></td>
    </tr>
</table>
</body>
</html>
