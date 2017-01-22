<%-- 
    Document   : newjspcliente
    Created on : 01-21-2017, 10:38:54 PM
    Author     : Adriana
--%>
<%@page import="modelo.Cliente" %>
<%@page import="java.util.*" %>
<%@page import="modelo.CrudCliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Cliente</title>
        
        <script language="JavaScript">
        function cargar(codCliente, nombre, direccion, telefono, correo){
                document.frmCliente.cod.value=codCliente;                
                document.frmCliente.nom.value=nombre;
                document.frmCliente.dir.value=direccion;
                document.frmCliente.tel.value=telefono;
                document.frmCliente.corr.value=correo;
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
    CrudCliente crud=new CrudCliente();
    %>
    <body>                
        <center>
            <h2>Mantenimiento Cliente</h2>
        <table border="2">
            <form action="ProcesarCliente" name="frmCliente" method="POST">
                <tr>
                    <%
                    CrudCliente obj=new CrudCliente();
                    Object n=obj.contarclientes(obj);
                    %>
                    <td>Codigo:</td>
                    <td><input type="text" name="cod" value="<%=n%>"></td>
                </tr>
                                
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nom"></td>
                </tr>   
                <tr>
                    <td>Direccion:</td>
                    <td><input type="text" name="dir"></td>                    
                </tr> 
                <tr>
                    <td>Telefono:</td>
                    <td><input type="text" name="tel"></td>
                </tr> 
                <tr>
                    <td>Correo:</td>
                    <td><input type="text" name="corr"></td>
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
                      <th>Codigo Cliente</th>
                      <th>Nombre</th>
                      <th>Direccion</th>
                      <th>Telefono</th>
                      <th>Correo</th>
                      <th>Seleccionar</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                  List<Cliente> lst2=crud.mostrarCliente();
                  for(Cliente ve:lst2){
                  %>
                  <tr>
                      <td><%= ve.getCodCliente()%></td>
                      <td><%= ve.getNombre()%></td>                      
                      <td><%= ve.getDireccion()%></td>
                      <td><%= ve.getTelefono()%></td>
                      <td><%= ve.getCorreo()%></td>
                      <td><a href="javascript:cargar(<%=ve.getCodCliente() %>,'<%=ve.getNombre()%>','<%=ve.getDireccion()%>','<%=ve.getTelefono()%>','<%=ve.getCorreo()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
          </table>

        </center>
    </body>
</html>
