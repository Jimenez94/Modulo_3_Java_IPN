<%@ page import="java.util.Calendar" %>
<%! Calendar cal = Calendar.getInstance(); %>>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola mundo con JSP</title>
</head>
<body>
    <h2>Hola mundo en un JSP</h2>
    <%if(cal.get(Calendar.AM_PM)==Calendar.AM){%>
        Buenos dias
    <%} else {%>
        Buenas tardes
    <%}%>
    <% out.println("Tu diereccion IP es: "+ request.getRemoteAddr()); %>
    <br/>
    <p>La fecha de hoy es: <%=cal.getTime() %></p>

</body>
</html>