package controlador;

import controlador.util.Mensaje;
import controlador.util.Modulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Turno;
import modelo.dao.TurnoDao;
import modelo.util.DbEstado;


public class TurnoServlet extends HttpServlet {
    private final String pathView = "/WEB-INF/turno/" ;
    private final String pathUrl = "./turno" ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Modulo modulo = new Modulo();
        modulo.setTitulos("Turnos");
        modulo.setTitulo("Turno");
        modulo.setPathView(pathView);
        modulo.setPathUrl(pathUrl);
        modulo.setMenuItem("turno");
        request.setAttribute("modulo", modulo);
        String vista = null;
                       
        String accion = request.getParameter("accion");
        if(null == accion){accion ="";}            
        System.out.println("Accion: " + accion);        
        switch(accion){
            case "":                 
                TurnoDao turnodao = new TurnoDao();
                List<Turno> listado = turnodao.all();
                request.setAttribute("listado", listado);
                vista = pathView+"list.jsp";
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
                    TurnoDao objdao = new TurnoDao();
                    String nombre = request.getParameter("nombre");
                    int estado = Integer.parseInt(request.getParameter("estado"));
                    Timestamp creado = Timestamp.valueOf(LocalDateTime.now());
                    Turno obj = new Turno();
                    obj.setNombreTurno(nombre);
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
            case "editar":
                try {                               
                    int id = Integer.parseInt(request.getParameter("id"));
                    TurnoDao objdao = new TurnoDao();
                    Turno obj = objdao.findOne(id);
                    request.setAttribute("obj", obj);
                    
                    List<DbEstado> estados = (new DbEstado()).getEstados();
                    request.setAttribute("estados", estados);
                    
                    vista = pathView+"edit.jsp";
                }  catch (NumberFormatException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }       
                this.getServletContext().getRequestDispatcher(vista).include(request, response);
                break;                        
            case "editar-guardar":
                try {                       
                    int id = Integer.parseInt(request.getParameter("id"));                    
                    TurnoDao objdao = new TurnoDao();
                    Turno obj = objdao.findOne(id);                                        
                    String nombre = request.getParameter("nombre");
                    int estado = Integer.parseInt(request.getParameter("estado"));                    
                    obj.setNombreTurno(nombre);
                    obj.setEstado(estado);                    
                    objdao.update(obj);
                    Mensaje mensaje = new Mensaje(request);
                    mensaje.setMsg("Actualizado correctamente");                
                    response.sendRedirect(pathUrl);
                }  catch (IOException | NumberFormatException ex) {
                    System.err.println("Error: " + ex.getMessage());
                } 
                break;
            case "eliminar":
                try {                       
                    int id = Integer.parseInt(request.getParameter("id"));                    
                    TurnoDao objdao = new TurnoDao();                                       
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
