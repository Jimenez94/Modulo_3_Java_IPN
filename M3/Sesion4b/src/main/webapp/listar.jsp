<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, cic.diplojava.webcompras.modelo.*" %>

<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Optional<String> usernameOptional = (Optional<String>) request.getAttribute("username");
    String mensajeApp = (String) session.getServletContext().getAttribute("mensaje");
    String mensajeReq = (String) request.getAttribute("mensaje");
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de productos</title>
</head>
<body>
<h1>Listado de productos disponibles</h1>
<% if (usernameOptional.isPresent()) {%>
<div style='color:blue;'>" <%=usernameOptional.get()%> Bienvenido!</div>
<p><a href="<%=request.getContextPath()%>/productos/form %>">Crear Producto [+]</a></p>
<%}%>
<table>
    <tr>
        <th> id</th>
        <th> Nombre</th>
        <th> Descripcion</th>
        <% if (usernameOptional.isPresent()) {%>
        <th> Precio</th>
        <%}%>
    </tr>
    <% for (Producto p : productos) {%>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getNombre()%>
        </td>
        <td><%=p.getDescripcion()%>
        </td>
        <% if (usernameOptional.isPresent()) {%>
        <td><%=p.getPrecio()%>
        </td>
        <td><a href="<%=request.getContextPath()%>/agrega-producto?id=<%=p.getId()%>">Agregar</a></td>
        <% }%>
    </tr>
    <% }%>
</table>
<p><%=mensajeApp%>></p>
<p><%=mensajeReq%>></p>
</body>
</html>