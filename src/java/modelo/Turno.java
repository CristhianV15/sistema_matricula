package modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Turno {


     private Integer idTurno;
     private String nombreTurno;
     private Integer estado;
     private Timestamp creado;     

    public Turno() {
    }

    public Turno(String nombreTurno, Integer estado, Timestamp creado) {
       this.nombreTurno = nombreTurno;
       this.estado = estado;
       this.creado = creado;       
    }
   
    public Integer getIdTurno() {
        return this.idTurno;
    }
    
    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }
    public String getNombreTurno() {
        return this.nombreTurno;
    }
    
    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
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
}


