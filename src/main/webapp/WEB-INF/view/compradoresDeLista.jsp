<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Lista" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16/06/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Listado de compradores</title>
</head>
<body>
<jsp:include page="cabecera.jsp" />
<h3> <a href="/listasComprador">Volver a listas </a></h3>
<%
    Lista lista = (Lista) request.getAttribute("lista");
    List<Usuario> compradoresDisponibles = (List) request.getAttribute("compradoresDisponibles");
%>
<!-- Compradores que no estan en esta lista -->
<h1>Compradores de la lista <%= lista.getNombre()%></h1>

<table border="1">
    <tr>
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>EMAIL</th>
        <th>DIRECCION</th>
        <th>ROL</th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (UsuarioHasLista usuarioHasLista : lista.getUsuarioHasListasByListaId()) {
    %>
    <tr>
        <td><%= usuarioHasLista.getUsuarioByUserId().getNombre()%></td>
        <td><%= usuarioHasLista.getUsuarioByUserId().getApellido()%></td>
        <td><%= usuarioHasLista.getUsuarioByUserId().getEmail()%></td>
        <td><%= usuarioHasLista.getUsuarioByUserId().getDireccion()%></td>
        <td><%= usuarioHasLista.getUsuarioByUserId().getRolByRolId().getNombre()%></td>
        <td><a href="/Lista/<%=usuarioHasLista.getListaId()%>/delete/<%=usuarioHasLista.getUserId()%>">Borrar</a></td>
        <td><a href="/verMensajes/<%= usuarioHasLista.getUsuarioByUserId().getUserId()%>">Ver Mensajes</a></td>
    </tr>

    <%
        }
    %>
</table>
<!-- Compradores que no estan en esta lista -->
<h1>Compradores Disponibles</h1>
<h5>Descripcion: En esta tabla solo se muestran los compradores que no estan en la tabla de arriba</h5>
    <table border="1">
        <tr>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>EMAIL</th>
            <th>DIRECCION</th>
            <th>ROL</th>
            <th></th>
            <th></th>
        </tr>
        <%
            for (Usuario comprador : compradoresDisponibles) {
        %>
        <tr>
            <td><%= comprador.getNombre()%></td>
            <td><%= comprador.getApellido()%></td>
            <td><%= comprador.getEmail()%></td>
            <td><%= comprador.getDireccion()%></td>
            <td><%= comprador.getRolByRolId().getNombre()%></td>
            <td><a href="/Lista/<%=lista.getListaId()%>/add/<%=comprador.getUserId()%>">Añadir</a></td>
            <td><a href="/verMensajes/<%= comprador.getUserId()%>">Ver Mensajes</a></td>
        </tr>

        <%
            }
        %>
    </table>
    <br>
    <br>
    <br>
    <!-- Notificacion -->
    Notificacion:<br/>
    <form method="POST" action="/notificar">
        <input type="hidden" name="idLista" value="<%=lista.getListaId()%>" />
        <textarea name="notificacion" rows="10" cols="60">
                </textarea>
        <br>
        <input type="submit" value="Enviar Mensaje" />

    </form>
</body>
</html>
