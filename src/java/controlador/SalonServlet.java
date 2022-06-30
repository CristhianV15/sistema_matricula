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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ciclo;
import modelo.Grado;
import modelo.Salon;
import modelo.Seccion;
import modelo.Turno;
import modelo.dao.CicloDao;
import modelo.dao.GradoDao;
import modelo.dao.SalonDao;
import modelo.dao.SeccionDao;
import modelo.dao.TurnoDao;
import modelo.dao.UsuarioDao;
import modelo.util.DbEstado;


public class SalonServlet extends HttpServlet {
    private final String pathView = "/WEB-INF/salon/" ;
    private final String pathUrl = "./salon" ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Modulo modulo = new Modulo();
        modulo.setTitulos("Salones");
        modulo.setTitulo("Salon");
        modulo.setPathView(pathView);
        modulo.setPathUrl(pathUrl);
        modulo.setMenuItem("salon");
        request.setAttribute("modulo", modulo);
        String vista = null;
        
        String accion = request.getParameter("accion");
        if(null == accion){accion ="";}            
        System.out.println("Accion: " + accion);        
        switch(accion){
            case "":                 
                SalonDao salondao = new SalonDao();
                List<Salon> listado = salondao.all();
                request.setAttribute("listado", listado);
                vista = pathView+"list.jsp";
                this.getServletContext().getRequestDispatcher(vista).include(request, response);
                break;
            case "agregar":
                try {                  
                    CicloDao ciclodao = new CicloDao();
                    List<Ciclo> ciclos = ciclodao.all();
                    request.setAttribute("ciclos", ciclos);

                    GradoDao gradodao = new GradoDao();
                    List<Grado> grados = gradodao.all();
                    request.setAttribute("grados", grados);

                    TurnoDao turnodao = new TurnoDao();
                    List<Turno> turnos = turnodao.all();
                    request.setAttribute("turnos", turnos);

                    SeccionDao secciondao = new SeccionDao();
                    List<Seccion> seccions = secciondao.all();
                    request.setAttribute("seccions", seccions);

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
                    SalonDao objdao = new SalonDao();                    
                    Timestamp creado = Timestamp.valueOf(LocalDateTime.now());
                    Salon obj = new Salon();
                    obj.setCiclo((new CicloDao()).findOne(Integer.parseInt(request.getParameter("ciclo"))));
                    obj.setGrado((new GradoDao()).findOne(Integer.parseInt(request.getParameter("grado"))));
                    obj.setTurno((new TurnoDao()).findOne(Integer.parseInt(request.getParameter("turno"))));
                    obj.setSeccion((new SeccionDao()).findOne(Integer.parseInt(request.getParameter("seccion"))));
                    obj.setUsuarioCreado((new UsuarioDao()).findOne(1));                                                      
                    obj.setVacantes(Integer.parseInt(request.getParameter("vacantes")));
                    obj.setEstado(Integer.parseInt(request.getParameter("estado")));
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
                    SalonDao objdao = new SalonDao();
                    Salon obj = objdao.findOne(id);
                    request.setAttribute("obj", obj);
                    
                    CicloDao ciclodao = new CicloDao();
                    List<Ciclo> ciclos = ciclodao.all();
                    request.setAttribute("ciclos", ciclos);

                    GradoDao gradodao = new GradoDao();
                    List<Grado> grados = gradodao.all();
                    request.setAttribute("grados", grados);

                    TurnoDao turnodao = new TurnoDao();
                    List<Turno> turnos = turnodao.all();
                    request.setAttribute("turnos", turnos);

                    SeccionDao secciondao = new SeccionDao();
                    List<Seccion> seccions = secciondao.all();
                    request.setAttribute("seccions", seccions);
                    
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
                    SalonDao objdao = new SalonDao();
                    Salon obj = objdao.findOne(id);                                        
                    obj.setCiclo((new CicloDao()).findOne(Integer.parseInt(request.getParameter("ciclo"))));
                    obj.setGrado((new GradoDao()).findOne(Integer.parseInt(request.getParameter("grado"))));
                    obj.setTurno((new TurnoDao()).findOne(Integer.parseInt(request.getParameter("turno"))));
                    obj.setSeccion((new SeccionDao()).findOne(Integer.parseInt(request.getParameter("seccion"))));
                    obj.setUsuarioCreado((new UsuarioDao()).findOne(1));                                                      
                    obj.setVacantes(Integer.parseInt(request.getParameter("vacantes")));
                    obj.setEstado(Integer.parseInt(request.getParameter("estado")));                  
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
                    SalonDao objdao = new SalonDao();                                       
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
        System.out.println("doPost");
        String accion = request.getParameter("accion");
        if("agregar".equals(accion)){
            response.sendRedirect("./salon");
        }else{
            processRequest(request, response);
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
