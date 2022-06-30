/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.util.Mensaje;
import controlador.util.Modulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Apoderado;
import modelo.dao.ApoderadoDao;
import modelo.util.DbEstado;

/**
 *
 * @author Cristhian
 */
@WebServlet(name = "ApoderadoServlet", urlPatterns = {"/ApoderadoServlet"})
public class ApoderadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      private final String pathView = "/WEB-INF/apoderado/" ;
    private final String pathUrl = "./apoderado" ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Modulo modulo = new Modulo();
        modulo.setTitulos("Apoderado");
        modulo.setTitulo("Apoderado");
        modulo.setPathView(pathView);
        modulo.setPathUrl(pathUrl);
        modulo.setMenuItem("apoderado");
        request.setAttribute("modulo", modulo);
        String vista = null;
                       
        String accion = request.getParameter("accion");
        if(null == accion){accion ="";}            
        System.out.println("Accion: " + accion);        
        switch(accion){
            case "":                 
                ApoderadoDao apoderadodao = new ApoderadoDao();
                List<Apoderado> listado = apoderadodao.all();
                request.setAttribute("listado", listado);
                vista = pathView+"list.jsp";
                System.out.println("cantida dde registros"+listado.size());
                this.getServletContext().getRequestDispatcher(vista).include(request, response);
                break;
            case "agregar":
                try {                               
                    List<DbEstado> estados = (new DbEstado()).getEstados();
                    request.setAttribute("estados", estados);
                    vista = pathView+"add.jsp";
                }  catch (Throwable ex) {
                    System.err.println("Error: " + ex.getMessage());
                }                            
                this.getServletContext().getRequestDispatcher(vista).include(request, response);
                break;            
            case "agregar-guardar":
                try {                                                   
                    ApoderadoDao objdao = new ApoderadoDao();
                    String nombre = request.getParameter("nombreA");
                    String apellidoPa = request.getParameter("apellidoPA");
                    String apellidoMa = request.getParameter("apellidoMA");
                    String tipoDocumento = request.getParameter("tipoDocumentoA");
                    String numDocumento = request.getParameter("numDocumentoA");
                    String email = request.getParameter("emailA");
                    String celular= request.getParameter("celularA");
                    String direccion = request.getParameter("direccionA");
                    int estado = Integer.parseInt(request.getParameter("estado"));
                    Timestamp creado = Timestamp.valueOf(LocalDateTime.now());
                    Apoderado obj = new Apoderado();
                    obj.setNombres(nombre);
                    obj.setApellidoPaterno(apellidoPa);
                    obj.setApellidoMaterno(apellidoMa);
                    obj.setTipoDocumento(tipoDocumento);
                    obj.setNumeroDocumento(numDocumento);
                    obj.setEmail(email);
                    obj.setCelular(celular);
                    obj.setDireccion(direccion);
                    obj.setEstado(estado);
                    obj.setCreado(creado);
                    objdao.add(obj);
                    Mensaje mensaje = new Mensaje(request);
                    mensaje.setMsg("Guardado correctamente");                
                    response.sendRedirect(pathUrl);
                }  catch (IOException | NumberFormatException ex) {
                    System.err.println("Error: " + ex.getMessage());
                } 
                break;            
           
            case "eliminar":
                try {                       
                    int id = Integer.parseInt(request.getParameter("id"));                    
                    ApoderadoDao objdao = new ApoderadoDao();                                       
                    objdao.delete(id);
                    Mensaje mensaje = new Mensaje(request);
                    mensaje.setMsg("Eliminado correctamente");                
                    response.sendRedirect(pathUrl);
                }  catch (IOException | NumberFormatException ex) {
                    System.err.println("Error: " + ex.getMessage());
                } 
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
