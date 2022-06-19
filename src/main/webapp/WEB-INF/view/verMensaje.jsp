<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Notificacion" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 18/06/2022
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<jsp:include page="cabecera.jsp" />

<%
    List<Notificacion> notificaciones = (List) request.getAttribute("notificaciones");
    Usuario usuario = (Usuario) request.getAttribute("comprador");
%>
<%
Usuario u = (Usuario) session.getAttribute("usuario");
if(u.getRolId() == 5){
%>
<h3> <a href="/listasComprador">Volver a listas </a></h3>
<%
    }else if(u.getRolId() == 1){
%>
<h3> <a href="/back/<%=usuario.getUserId()%>">Volver </a></h3>
<%
    }
%>
<body>
<h1> Bandea de mensajes del comprador <%= usuario.getNombre()%> <%= usuario.getApellido()%> </h1>

<table border="1">
    <tr>
        <th>Mensaje</th>
        <th>Mensajero</th>
        <th>Fecha</th>
    </tr>
    <%
        for (Notificacion notificacion : notificaciones) {
    %>
    <tr>
        <td><%= notificacion.getMensaje()%></td>
        <td><%= notificacion.getUsuarioByMensajero().getNombre()%> <%= notificacion.getUsuarioByMensajero().getApellido()%> </td>
        <td><%= notificacion.getFecha()%></td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>