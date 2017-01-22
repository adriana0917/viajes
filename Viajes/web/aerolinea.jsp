<%-- 
    Document   : aerolinea
    Created on : 01-15-2017, 08:27:43 AM
    Author     : Adriana
--%>
<%@page import="modelo.Aerolinea" %>
<%@page import="java.util.*" %>
<%@page import="modelo.CrudAerolinea" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Aerolinea</title>
        <script language="JavaScript">
        function cargar(codAerolinea, nombre){
                document.frmAerolinea.cod.value=codAerolinea;                
                document.frmAerolinea.nom.value=nombre;                
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
    CrudAerolinea crud=new CrudAerolinea();
    %>
    <body>
        <h2>Mantenimiento Aerolinea</h2>
        
        <center>
        <table border="2">
            <form action="ProcesarAerolinea" name="frmAerolinea" method="POST">
                <tr>
                    <%
                    CrudAerolinea obj=new CrudAerolinea();
                    Object n=obj.contarAerolineas(obj);
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
                      <th>Codigo Aerolinea</th>
                      <th>Nombre</th>                      
                      <th>Seleccionar</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                  List<Aerolinea> lst2=crud.mostrarAerolinea();
                  for(Aerolinea ve:lst2){
                  %>
                  <tr>
                      <td><%= ve.getCodAerolinea()%></td>
                      <td><%= ve.getNombre()%></td>                      
                      <td><a href="javascript:cargar(<%=ve.getCodAerolinea() %>,'<%=ve.getNombre()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
          </table>

        </center>
        
    </body>
</html>
