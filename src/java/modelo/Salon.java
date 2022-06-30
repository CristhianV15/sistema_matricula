package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Salon {


     private Integer idSalon;
     private Ciclo ciclo;
     private Grado grado;
     private Seccion seccion;
     private Turno turno;
     private Usuario usuarioModificado;
     private Usuario usuarioCreado;     
     private Integer vacantes;          
     private Integer estado;
     private Timestamp creado;
     private Timestamp modificado;     

    public Salon() {
    }

	
    public Salon(Ciclo ciclo, Grado grado, Seccion seccion, Turno turno, Usuario usuarioCreado) {
        this.ciclo = ciclo;
        this.grado = grado;
        this.seccion = seccion;
        this.turno = turno;
        this.usuarioCreado = usuarioCreado;
    }    
   
    public Integer getIdSalon() {
        return this.idSalon;
    }
    
    public void setIdSalon(Integer idSalon) {
        this.idSalon = idSalon;
    }
    public Ciclo getCiclo() {
        return this.ciclo;
    }
    
    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    public Grado getGrado() {
        return this.grado;
    }
    
    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    public Seccion getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    public Turno getTurno() {
        return this.turno;
    }
    
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public Usuario getUsuarioModificado() {
        return this.usuarioModificado;
    }
    
    public void setUsuarioModificado(Usuario usuarioModificado) {
        this.usuarioModificado = usuarioModificado;
    }
    public Usuario getUsuarioCreado() {
        return this.usuarioCreado;
    }
    
    public void setUsuarioCreado(Usuario usuarioCreado) {
        this.usuarioCreado = usuarioCreado;
    }
    public Integer getVacantes() {
        return this.vacantes;
    }
    
    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }    
    
    public Integer getEstado() {
        return this.estado;
    }
    public String getEstadoString() {
        String est = "";
        List<DbEstado> estados = (new DbEstado()).getEstadosAll();
        for (int i = 0; i < estados.size(); i++) {
            if ( estados.get(i).getId() == this.estado ) {
                est = estados.get(i).getNombre();
                break;
            }
        }
        return est;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Timestamp getCreado() {
        return this.creado;
    }
    public String getCreadoString(){
        return new SimpleDateFormat("dd/MM/yyyy KK:mm a").format(this.creado);
    }
    public void setCreado(Timestamp creado) {
        this.creado = creado;
    }
    public Timestamp getModificado() {
        return this.modificado;
    }
    public String getModificadoString(){
        if (this.modificado==null) {
            return "";
        }else{
            return new SimpleDateFormat("dd/MM/yyyy KK:mm a").format(this.modificado);
        }        
    }
    
    public void setModificado(Timestamp modificado) {
        this.modificado = modificado;
    }
    




}


