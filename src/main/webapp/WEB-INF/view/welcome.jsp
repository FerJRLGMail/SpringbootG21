<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: cecil
  Date: 18/06/2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }

    </style>
    <title>Welcome</title>
    <%
        Usuario usuario = (Usuario) request.getAttribute("usuario");
    %>
</head>
<body>
<jsp:include page="/WEB-INF/view/cabecera.jsp" />
<h1>Welcome, <%=usuario.getNombre()%> <%=usuario.getApellido()%></h1>
<h2><a href="/listaProducto/<%=usuario.getUserId()%>">Lista producto</a></h2></br>
<h2><a href="/listaproductoFavorito/<%=usuario.getUserId()%>">Producto Favoritos</a></h2></br>
<h2><a href="/listaproductoComprado/<%=usuario.getUserId()%>">Producto Comprado</a></h2></br>
<h2><a href="/mensajes/<%=usuario.getUserId()%>">Mensajes</a></h2></br>
</body>
</html>
