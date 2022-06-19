<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Categoria" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cecil
  Date: 18/06/2022
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <%
        String error = (String)request.getAttribute("error");
        if (error == null) error = "";
        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    %>
</head>
<body>
<h1>Registratión Comprador</h1>
<p><%= error %></p>
<%--@elvariable id="usuario" type=""--%>
<%--@elvariable id="usuario_new" type=""--%>
<form:form method="GET" action="/registration/save" modelAttribute="usuario_new">
    <form:hidden path="userId" />
    Nombre: <form:input path="nombre" size="30" maxlength="30"/><br/>
    <br/>
    Apellido: <form:input path="apellido" size="30" maxlength="30"/><br/>
    <br/>
    Correo: <form:input path="email" size="30"/><br/>
    <br/>
    Domicilio: <form:input path="direccion" size="30"/><br/>
    <br/>
    Ciudad: <form:input path="ciudad" size="30"/><br/>
    <br/>
    Edad: <form:input path="edad" type="number" size="2"/><br/>
    <br/>
    Sexo: <br/>
    <form:radiobutton path="sexo" value="H"/>Hombre
    <br/>
    <form:radiobutton path="sexo" value="M"/>Mujer<br/>
    <br/>
    Categorías Preferidas:<br/>
    <%
        for(Categoria i: categorias)
        {
    %>
    <form:checkbox path="catPref" value="<%=i%>"/><%=i.getNombre()%><br/>
    <%
        }
    %>
    <br/>
    <form:button>Enviar</form:button>
</form:form>
</body>
</html>
