<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cic.diplojava.webcompras.modelo.*" %>

<%
    CarroCompras carroCliente = (CarroCompras) session.getAttribute("carroCliente");
%>

<html>
<head>
    <title>Carro Compras</title>
</head>
<body>
<h2>Carro de compras del cliente</h2>


<% if (carroCliente == null || carroCliente.getArticulos().isEmpty()) { %>
<p>Sin productos en carrito de compras..</p>
<%} else {%>
<table>");
    <tr>");
        <th> Producto</th>
        <th> Precio</th>
        <th> Cantidad</th>
        <th> Total</th>
        "
    </tr>
    <%
        for (ArticuloCarro art : carroCliente.getArticulos()) {
    %>
    <tr>
        <td><%=art.getProducto().getNombre()%>
        </td>
        <td><%=art.getProducto().getPrecio()%>
        </td>
        <td><%=art.getCantidad()%>
        </td>
        <td><%=art.totalArticulo()%>
        </td>
    </tr>
    <%}%>>
    <tr>
        <td>Total:</td>
        <td><%=carroCliente.getTotalCompra()%>></td>
    </tr>
</table>
<%}%>

<p><a href="<%=request.getContextPath()%>/productos">Seguir comprando</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Inicio</a></p>

</body>
</html>
