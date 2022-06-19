<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Usuario" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.Puja" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="es.taw.tawebayspringbootgrupo21.entity.ProdFavoritos" %><%--
  Created by IntelliJ IDEA.
  User: cecil
  Date: 19/06/2022
  Time: 13:16
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
    <title>Producto Favorito</title>
    <%
        String strError = (String) request.getAttribute("strError");


        Usuario user = (Usuario) request.getAttribute("user");
    %>
</head>
<body>
<jsp:include page="cabecera.jsp" />
<h1>Lista Producto Favoritos:</h1>
<h2><a href="/back/<%=user.getUserId()%>">Back</a></h2></br>
<%
    if(strError.equals(""))
    {
        List<ProdFavoritos> productoList = (List<ProdFavoritos>) request.getAttribute("prodFavoritos");
        for (ProdFavoritos p : productoList) {
            List<Puja> pujalist = (List<Puja>) p.getProductoByProductId().getPujasByProductId();
            LocalDate today = LocalDate.now();
            Usuario vendedor = p.getProductoByProductId().getUsuarioByVendedorId();
            SimpleDateFormat DateFor = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            Date compuja = p.getProductoByProductId().getComienzoPuja();
            Date finpuja = p.getProductoByProductId().getFinalPuja();
            String comienzopuja = DateFor.format(compuja);
            String finalpuja = DateFor.format(finpuja);
            LocalDate fpuja = Instant.ofEpochMilli(finpuja.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            Producto producto = p.getProductoByProductId();
%>
<table style="width:50%">
    <tr>

        <th>Titulo:</th>
        <th><%= producto.getTitulo()%></th>

    </tr>
    <tr>
        <th>Descripcion:</th>
        <td><%= producto.getDescripcion()%></td>
    </tr>
    <tr>
        <th>Vendedor:</th>
        <td><%= vendedor.getNombre()%> <%= vendedor.getApellido()%></td>
    </tr>
    <tr>
        <td colspan="2"><img src="<%= producto.getUrlFoto()%>" width="150" height="150"></td>
    </tr>
    <tr>
        <th>Precio</th>
        <td><%= producto.getPrecio()%> </td>

    </tr>
    <tr>
        <th>Comienzo Puja</th>
        <td><%= comienzopuja%> </td>


    </tr>
    <tr>
        <th>Final Puja</th>
        <td><%= finalpuja%> </td>

    </tr>
    <% if (today.isBefore(fpuja)) {
    %>
    <tr><td colspan="2" align="center"><a href="">Producto Favorito</a></td></tr>
    </form>

    <tr align="center">
        <td colspan = "2" align="center">
            <table align = "center" border="false" style="width:100%">

                <tr colspan = "2" align="center"><td align="center">Puja List:</td></tr>
                <% for (Puja pu : pujalist) {
                %>
                <tr><td align="center">
                    <%= pu.getUsuarioByCompradorId().getNombre()%>
                    <%= pu.getUsuarioByCompradorId().getApellido()%>:
                    <%= pu.getCantidad()%>$
                </td>
                </tr>
                <%
                    }
                %>
            </table>
        <td>
    </tr>
    <tr>
        <td colspan ="2">

            <form align="center" method="get" action="/registration/edit/<%=user.getUserId()%>/<%=p.getProductId()%>">
                <input type="number" name="puja" value="<%=producto.getPrecio()%>" min="<%=producto.getPrecio()%>" step = "0.10" value=""/>
                <input type="submit" value="Enviar"/>
            </form>
        </td>
            <%
        } else {
        %>
    <tr><td colspan ="2" align="center"> <p> Producto Comprado </p></td> </tr>
    <%
            }
        }
    }
    else
    {
    %>
    <h2>No Producto</h2>
    <%
        }
    %>

    <tr>

    </tr>
</table>

</body>
</html>
