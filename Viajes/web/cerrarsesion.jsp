<%-- 
    Document   : cerrarsesion
    Created on : 01-15-2017, 11:14:53 AM
    Author     : Adriana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession objSesion = request.getSession();
objSesion.invalidate();
%>
<jsp:forward page="login.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesion</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
