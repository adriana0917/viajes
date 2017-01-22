<%-- 
    Document   : hotel
    Created on : 01-15-2017, 11:06:31 AM
    Author     : Adriana
--%>
<%@page import="modelo.Hotel" %>
<%@page import="java.util.*" %>
<%@page import="modelo.CrudHotel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <script language="JavaScript">
        function cargar(codHotel, nombre){
                document.frmHotel.cod.value=codHotel;                
                document.frmHotel.nom.value=nombre;                
            }
        </script>
            <%
            if(request.getAttribute("valor") != null){
            %>
            <script>
                alert('<%= request.getAttribute("valor") %>');
            </script>
                <%
                }
                %>
        
    </head>
    <%
    CrudHotel crud=new CrudHotel();
    %>
    <body>                    
        <center>
            <h2>Mantenimiento Hotel</h2>
        <table border="2">
            <form action="ProcesarHotel" name="frmHotel" method="POST">
                <tr>
                    <%
                    CrudHotel obj=new CrudHotel();
                    Object n=obj.contarHotel(obj);
                    %>
                    <td>Codigo:</td>
                    <td><input type="text" name="cod" value="<%=n%>"></td>
                </tr>
                                
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nom"></td>
                </tr>                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="insertar" value="Insertar">
                        <input type="submit" name="modificar" value="Modificar">
                        <input type="submit" name="eliminar" value="Eliminar">
                        <input type="reset" name="limpiar" value="Limpiar">
                    </td>
                  
                </tr>
            </form>
        </table>
         <br>
          <br>
          <hr>
          <table border="2">
              <thead>
                  <tr>
                      <th>Codigo Hotel</th>
                      <th>Nombre</th>                      
                      <th>Seleccionar</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                  List<Hotel> lst2=crud.mostrarHotel();
                  for(Hotel ve:lst2){
                  %>
                  <tr>
                      <td><%= ve.getCodHotel()%></td>
                      <td><%= ve.getNombre()%></td>                      
                      <td><a href="javascript:cargar(<%=ve.getCodHotel() %>,'<%=ve.getNombre()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
          </table>

        </center>
        
    </body>
</html>
