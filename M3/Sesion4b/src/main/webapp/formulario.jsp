<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cic.diplojava.webcompras.modelo.Producto" %>
<%@ page import="java.util.Map" %>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Producto</title>
</head>
<body>
<h1>Formulario de Producto</h1>
<form action="<%=request.getContextPath()%>/productos/form" method="post">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input id="nombre" type="text" value="<%=producto.getNombre()!= null?producto.getNombre():""%>"
                   name="nombre"/>
        </div>
        <%if (errores != null && errores.containsKey("nombre")) {%>
        <small style="color: red"><%= errores.get("nombre")%>
        </small>
        <%}%>
    </div>
    <div>
        <label for="descripcion">Descripcion</label>
        <div>
            <input id="descripcion" type="text"
                   value="<%=producto.getDescripcion()!= null?producto.getDescripcion():""%> name=" descripcion"/>
        </div>
        <%if (errores != null && errores.containsKey("descripcion")) {%>
        <small style="color: red"><%= errores.get("descripcion")%>
        </small>
        <%}%>
    </div>
    <div>
        <label for="precio">Precio</label>
        <div>
            <input id="precio" type="text" name="precio"/>
        </div>
    </div>
    <div>
        <input type="submit" value="Guardar"/>
    </div>

</form>
</body>
</html>
