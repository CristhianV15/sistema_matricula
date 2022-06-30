package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Alumno  {
    
     private int idAlumno;
     private Apoderado apoderado;
     private Usuario usuario;
     private String nombres;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String tipoDocumento;
     private String numeroDocumento;
     private String direccion;
     private Date fechaNacimiento;
     private String sexo;
     private Integer estado;
     private Timestamp creado;
     private Timestamp modificado;
     private Set<Salon> salons = new HashSet<Salon>(0);
     private Set<Matricula> matriculas = new HashSet<Matricula>(0);

    public Alumno() {
    }

	
    public Alumno(int idAlumno, Apoderado apoderado, Usuario usuario) {
        this.idAlumno = idAlumno;
        this.apoderado = apoderado;
        this.usuario = usuario;
    }
    public Alumno(int idAlumno, Apoderado apoderado, Usuario usuario, String nombres, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroDocumento, String direccion, Date fechaNacimiento, String sexo, Integer estado, Timestamp creado, Timestamp modificado, Set<Salon> salons, Set<Matricula> matriculas) {
       this.idAlumno = idAlumno;
       this.apoderado = apoderado;
       this.usuario = usuario;
       this.nombres = nombres;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.tipoDocumento = tipoDocumento;
       this.numeroDocumento = numeroDocumento;
       this.direccion = direccion;
       this.fechaNacimiento = fechaNacimiento;
       this.sexo = sexo;
       this.estado = estado;
       this.creado = creado;
       this.modificado = modificado;
       this.salons = salons;
       this.matriculas = matriculas;
    }
   
    public int getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    public Apoderado getApoderado() {
        return this.apoderado;
    }
    
    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public Set<Salon> getSalons() {
        return this.salons;
    }
    
    public void setSalons(Set<Salon> salons) {
        this.salons = salons;
    }
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }
    
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }




}


