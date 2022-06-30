package controlador;

import controlador.util.Mensaje;
import controlador.util.Modulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Turno;
import modelo.dao.TurnoDao;
import modelo.util.DbEstado;


public class InicioServlet extends HttpServlet {

    private final String pathView = "/WEB-INF/inicio/" ;
    private final String pathUrl = "./inicio" ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Modulo modulo = new Modulo();
        modulo.setTitulos("Inicio");
        modulo.setTitulo("Inicio");
        modulo.setPathView(pathView);
        modulo.setPathUrl(pathUrl);
        modulo.setMenuItem("inicio");
        request.setAttribute("modulo", modulo);
        String vista = null;
        
        String accion = request.getParameter("accion");
        if(null == accion){accion ="";}                    
        switch(accion){
            case "":                                 
                vista = pathView+"list.jsp";
                this.getServletContext().getRequestDispatcher(vista).include(request, response);
                break;            
            default:
                System.err.println("Error no accion");
                break;
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
