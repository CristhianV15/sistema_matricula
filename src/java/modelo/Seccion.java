package modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Seccion {


     private Integer idSeccion;
     private String nombreSeccion;
     private Integer estado;
     private Timestamp creado;     

    public Seccion() {
    }

    public Seccion(String nombreSeccion, Integer estado, Timestamp creado) {
       this.nombreSeccion = nombreSeccion;
       this.estado = estado;
       this.creado = creado;       
    }
   
    public Integer getIdSeccion() {
        return this.idSeccion;
    }
    
    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }
    public String getNombreSeccion() {
        return this.nombreSeccion;
    }
    
    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
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


