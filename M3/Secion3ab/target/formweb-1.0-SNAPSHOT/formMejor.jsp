<%@ page contentType="text" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Formulario JSP</title>
    </head>
    <body>
        <h1>Formulario JSP</h1>
        <%if (errores != null && errores.size() > 0) {%>

        <ul>
            <% for (String error : errores.values()) {%>
            <li><%=error%></li>


            <%}%>
        </ul>
        <%}%>
        <form action="./validaSegundoServlet" method="post">
            <div>
                <label for="username">Usuario</label>
                <div>
                    <input id="username" type="text" name="username"/>
                    <%
                        if (errores!= null && errores.containsKey("username"))
                            out.println("<h5 style = 'color:red;'>"+errores.get("username")+"</h5>");
                    %>
                </div>
            </div>
            <div>
                <label for="password">Contraseña</label>
                <div>
                    <input id="password" type="password" name="password"/>
                </div>
                <%
                    if (errores!= null && errores.containsKey("password"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("password")+"</h5>");
                %>
            </div>
            <div>
                <label for="email">Correo</label>
                <div>
                    <input id="email" type="text" name="email"/>
                </div>
                <%
                    if (errores!= null && errores.containsKey("email"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("email")+"</h5>");
                %>
            </div>
            <div>
                <label for="pais">Pais:</label>
                <div>
                    <select id="pais" name="pais">
                        <option value="">Seleccione un pais</option>
                        <option value="MX" selected>Mexico</option>
                        <option value="US">Estados unidos</option>
                        <option value="CN">Canada</option>
                    </select>
                </div>
                <%
                    if (errores!= null && errores.containsKey("pais"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("pais")+"</h5>");
                %>
            </div>
            <div>
                <label for="lenguajes">lenguajes de programacion</label>
                <div>
                    <select id="lenguajes" name="lenguajes" multiple>
                        <option value="">Seleccione un lenguaje</option>
                        <option value="java">Java</option>
                        <option value="python">Python</option>
                        <option value="c++">C++</option>
                        <option value="c">C</option>
                        <option value="matlab">Matlab</option>
                    </select>
                </div>
                <%
                    if (errores!= null && errores.containsKey("lenguajes"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("lenguajes")+"</h5>");
                %>
            </div>
            <div>
                <label>Roles:</label>
                <div>
                    <input type="checkbox" name="roles" value="ADMON"/>
                    <label>Administrador</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="GENERAL"/>
                    <label>Usuario General</label>
                </div>
                <div>
                    <input type="checkbox" name="roles" value="ANONIMO"/>
                    <label>Usuario Anonimo</label>
                </div>
                <%
                    if (errores!= null && errores.containsKey("roles"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("roles")+"</h5>");
                %>
            </div>
            <div>
                <label>Idioma:</label>
                <div>
                    <input type="radio" name="idioma" value="es"/>
                    <label>Español</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="en"/>
                    <label>Ingles</label>
                </div>
                <div>
                    <input type="radio" name="idioma" value="fr"/>
                    <label>Frances</label>
                </div>
                <%
                    if (errores!= null && errores.containsKey("idioma"))
                        out.println("<h5 style = 'color:red;'>"+errores.get("idioma")+"</h5>");
                %>
            </div>

            <div>
                <label for="soltero">Soltero/a</label>
                <div>
                    <input type="checkbox" id="soltero" name="soltero" checked>
                </div>
            </div>
            <div>
                <input type="submit" value="Enviar"/>
            </div>
            <input type="hidden" name="oculto" value="555"/>
        </form>
    </body>
</html>