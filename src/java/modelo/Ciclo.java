package modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Ciclo {


     private Integer idCiclo;
     private String nombreCiclo;
     private Integer estado;
     private Timestamp creado;     

    public Ciclo() {
    }

    public Ciclo(String nombreCiclo, Integer estado, Timestamp creado) {
       this.nombreCiclo = nombreCiclo;
       this.estado = estado;
       this.creado = creado;       
    }
   
    public Integer getIdCiclo() {
        return this.idCiclo;
    }
    
    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }
    public String getNombreCiclo() {
        return this.nombreCiclo;
    }
    
    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
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


