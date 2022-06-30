package modelo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;


public class Matricula  {


     private Integer idMatricula;
     private Alumno alumno;
     private Salon salon;
     private Usuario usuarioByIdUsuarioCreado;
     private Usuario usuarioByIdUsuarioModificado;
     private Integer estado;
     private String codigoPago;
     private Date fechaPago;
     private Timestamp creado;
     private Timestamp modificado;

    public Matricula() {
    }

	
    public Matricula(Alumno alumno, Salon salon, Usuario usuarioByIdUsuarioCreado) {
        this.alumno = alumno;
        this.salon = salon;
        this.usuarioByIdUsuarioCreado = usuarioByIdUsuarioCreado;
    }
    public Matricula(Alumno alumno, Salon salon, Usuario usuarioByIdUsuarioCreado, Usuario usuarioByIdUsuarioModificado, Integer estado, String codigoPago, Date fechaPago, Timestamp creado, Timestamp modificado) {
       this.alumno = alumno;
       this.salon = salon;
       this.usuarioByIdUsuarioCreado = usuarioByIdUsuarioCreado;
       this.usuarioByIdUsuarioModificado = usuarioByIdUsuarioModificado;
       this.estado = estado;
       this.codigoPago = codigoPago;
       this.fechaPago = fechaPago;
       this.creado = creado;
       this.modificado = modificado;
    }
   
    public Integer getIdMatricula() {
        return this.idMatricula;
    }
    
    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Salon getSalon() {
        return this.salon;
    }
    
    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    public Usuario getUsuarioByIdUsuarioCreado() {
        return this.usuarioByIdUsuarioCreado;
    }
    
    public void setUsuarioByIdUsuarioCreado(Usuario usuarioByIdUsuarioCreado) {
        this.usuarioByIdUsuarioCreado = usuarioByIdUsuarioCreado;
    }
    public Usuario getUsuarioByIdUsuarioModificado() {
        return this.usuarioByIdUsuarioModificado;
    }
    
    public void setUsuarioByIdUsuarioModificado(Usuario usuarioByIdUsuarioModificado) {
        this.usuarioByIdUsuarioModificado = usuarioByIdUsuarioModificado;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public String getCodigoPago() {
        return this.codigoPago;
    }
    
    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    public Timestamp getCreado() {
        return this.creado;
    }
    
    public void setCreado(Timestamp creado) {
        this.creado = creado;
    }
    public Timestamp getModificado() {
        return this.modificado;
    }
    
    public void setModificado(Timestamp modificado) {
        this.modificado = modificado;
    }




}


