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
import modelo.Aerolinea;
import modelo.CrudAerolinea;

/**
 *
 * @author Adriana
 */
public class ProcesarAerolinea extends HttpServlet {

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
            Aerolinea aero=new Aerolinea();
            CrudAerolinea cAero=new CrudAerolinea();
            String val=null;
            try{
                aero.setCodAerolinea(Integer.parseInt(request.getParameter("cod")));
                aero.setNombre(request.getParameter("nom"));
                if(request.getParameter("insertar") != null){
                    cAero.insertarAerolinea(aero);
                    val="Datos insertados correctamente";
                }else if(request.getParameter("modificar") != null){
                    cAero.modificarAerolinea(aero);;
                    val="Datos modificados correctamente";
                }else if(request.getParameter("eliminar") != null){
                   cAero.eliminarAerolinea(aero);;
                   val="Datos eliminados correctamente";
                }
                rd=request.getRequestDispatcher("aerolinea.jsp");
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
