<%--
  Created by IntelliJ IDEA.
  User: IsaelPC
  Date: 14/07/2022
  Time: 04:19 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar producto</title>
</head>
<body>
<h2>Busqueda de producto</h2>
<form action="<%=request.getContextPath()%>/busca-producto" method="post">
    <div>
        <label for="cproducto">Producto</label>

        <div>
            <input type="text" name="nombre", id = "cproducto"/>
        </div>

        <div>
        <input type="submit" value="Buscar"/>
        </div>
    </div>

</form>
</body>
</html>
