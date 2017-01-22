/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CrudCliente;
import modelo.Cliente;

/**
 *
 * @author Adriana
 */
public class ProcesarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        RequestDispatcher rd=null;
            Cliente cliente=new Cliente();
            CrudCliente cCliente=new CrudCliente();
            String val=null;
            try{
                cliente.setCodCliente(Integer.parseInt(request.getParameter("cod")));
                cliente.setNombre(request.getParameter("nom"));
                cliente.setDireccion(request.getParameter("dir"));
                cliente.setTelefono(request.getParameter("tel"));
                cliente.setCorreo(request.getParameter("corr"));
                if(request.getParameter("insertar") != null){
                    cCliente.insertarCliente(cliente);
                    val="Datos insertados correctamente";
                }else if(request.getParameter("modificar") != null){
                    cCliente.modificarCliente(cliente);;
                    val="Datos modificados correctamente";
                }else if(request.getParameter("eliminar") != null){
                   cCliente.eliminarCliente(cliente);;
                   val="Datos eliminados correctamente";
                }
                rd=request.getRequestDispatcher("cliente.jsp");
                request.setAttribute("valor", val);
            }catch(Exception e) {
                request.setAttribute("error", e.toString());
            }
            rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
