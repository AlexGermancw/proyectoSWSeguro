/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.contabilidad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.contabilidad.Cuenta;
import modelo.contabilidad.dao.CuentaDAO;

/**
 *
 * @author alexg
 */
@WebServlet(name = "ControladorCuenta", urlPatterns = {"/ControladorCuenta"})
public class ControladorCuenta extends HttpServlet {

    CuentaDAO dao = new CuentaDAO();
    Cuenta tc = new Cuenta();
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCuenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCuenta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String accion = request.getParameter("accion");
        if(accion.compareTo("Guardar")==0){
            String codigo = request.getParameter("codigoCuenta");
            String nombre = request.getParameter("nombreCuenta");
            String tipoCu = request.getParameter("tipCueCuenta");
            
            tc.setCodigoCuenta(codigo);
            tc.setNombre(nombre);
            tc.setCodigoTipoCuenta(tipoCu);
            int r = dao.agregar(tc);
            response.sendRedirect("vistas/contabilidad/Cuenta.jsp");
            
        }else if(accion.compareTo("Borrar")==0){         
            String id = request.getParameter("id");//id codigo del tipo cuenta
            dao.borrar(id);
            response.sendRedirect("vistas/contabilidad/Cuenta.jsp");
            
        }else{
            response.sendRedirect("vistas/contabilidad/Cuenta.jsp");
        }
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
