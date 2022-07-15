<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario Login</title>
</head>
<body>
<h2>Iniciar Sesion</h2>

<form action="<%=request.getContextPath()%>/login" method="post">
    <div>
        <label for="username">Usuario</label>
        <input id="username" type="text" name="username"/>
    </div>
    <div>
        <label for="password">Contraseña</label>
        <input id="password" type="password" name="password"/>
    </div>

    <div>

        <input type="submit" name="Login"/>
    </div>

</form>

</body>
</html>
