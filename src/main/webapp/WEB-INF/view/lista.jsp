<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Lista" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.dto.ListaDTO" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16/06/2022
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%

  ListaDTO lista = (ListaDTO) request.getAttribute("lista");
%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Detalle de la lista <%= lista == null ? "" : lista.getNombre()%> </title>
</head>
<jsp:include page="cabecera.jsp" />
<h3> <a href="listasComprador">Volver a listas </a></h3>

<body>
<h1>Detalle de la lista <%= lista == null ? "" : lista.getNombre()%></h1>
<form method="POST" action="/AddyEditLista">
  <input type="hidden" name="id" value="<%= lista == null ? "" : lista.getListaId()%>" />
  Nombre de lista: <input type="text" size="30" name="nombre" value="<%= lista == null ? "" : lista.getNombre()%>" /><br/>

  <input type="submit" value="Enviar" />
</form>
</body>
</html>