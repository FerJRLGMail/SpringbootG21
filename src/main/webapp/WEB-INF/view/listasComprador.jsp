<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 12/06/2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="es.taw.tawebayspringbootgrupo21.dto.ListaDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listas de compradores</title>
</head>
<body>
<jsp:include page="cabecera.jsp" />
<h1>Listas de compradores</h1>
<%
    List<ListaDTO> listasCompradors = (List<ListaDTO>) request.getAttribute("listasComprador");
    if (listasCompradors == null || listasCompradors.isEmpty()) {
%>
<h2>No hay niuguna lista</h2>
<form method="post" action="/Reset">
    <input type="submit" value="Reset" />
</form>
<%
} else {
%>
<form method="post" action="/listaFiltrar">
    Nombre: <input type="text" name="clave" value="" />
    <input type="submit" value="Filtrar" />
</form>
<form method="post" action="/Reset">
    <input type="submit" value="Reset" />
</form>
<br/>

<table border="1">
    <tr>
        <th>NOMBRE DE LISTA</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (ListaDTO lista : listasCompradors) {
    %>

    <tr>
        <td><%= lista.getNombre()%></td>
        <td><a href="/verLista/<%= lista.getListaId()%>">Ver lista</a></td>
        <td><a href="/editLista/<%= lista.getListaId()%>">Editar</a></td>
        <td><a href="/deleteLista/<%= lista.getListaId()%>">Borrar</a></td>
    </tr>
    <%
            }
        }
    %>
</table>
<br/>
<a href="/nuevoLista">Crear nueva lista de compradores ... </a>

</body>
</html>
