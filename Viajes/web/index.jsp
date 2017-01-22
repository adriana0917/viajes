<%-- 
    Document   : index
    Created on : 01-15-2017, 08:27:30 AM
    Author     : Adriana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agencia De Viajes</title>
    </head>
    <body>
                
         <%
            String cerrar="";
            HttpSession objSesion=request.getSession(false);
            String usuario=(String) objSesion.getAttribute("usuario");
            if(usuario.equals(""))
            {
                response.sendRedirect("registro.jsp");
            }
            else
            {
                cerrar="<a href='cerrarsesion.jsp'>Cerrar sesion</a>";
            }
        %>
        <h1>Bienvenido... <% out.println(usuario); %></h1>
        <% out.print(cerrar); %>  
        
        <center>
            <h2>Mantenimientos Agencia De Viajes</h2>
            <table border="1">
                <tr>
                    <td><a href="aerolinea.jsp">Mantenimiento Aerolinea</a></td>
                </tr>
                <tr>
                    <td><a href="hotel.jsp">Mantenimiento Hotel</a></td>
                </tr>
            </table>
        </center>
    </body>
</html>
