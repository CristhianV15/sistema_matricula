package modelo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Apoderado {


     private Integer idApoderado;
     private String nombres;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String tipoDocumento;
     private String numeroDocumento;
     private String email;
     private String celular;
     private String direccion;
     private Integer estado;
     private Timestamp creado;
     private Timestamp modificado;
     private Set<Alumno> alumnos = new HashSet<Alumno>(0);

    public Apoderado() {
    }

    public Apoderado(String nombres, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroDocumento, String email, String celular, String direccion, Integer estado, Timestamp creado, Timestamp modificado, Set<Alumno> alumnos) {
       this.nombres = nombres;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.tipoDocumento = tipoDocumento;
       this.numeroDocumento = numeroDocumento;
       this.email = email;
       this.celular = celular;
       this.direccion = direccion;
       this.estado = estado;
       this.creado = creado;
       this.modificado = modificado;
       this.alumnos = alumnos;
    }
   
    public Integer getIdApoderado() {
        return this.idApoderado;
    }
    
    public void setIdApoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Date getCreado() {
        return this.creado;
    }
    
    public void setCreado(Timestamp creado) {
        this.creado = creado;
    }
    public Date getModificado() {
        return this.modificado;
    }
    
    public void setModificado(Timestamp modificado) {
        this.modificado = modificado;
    }
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }




}


