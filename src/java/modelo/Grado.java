package modelo;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;

public class Grado {


     private Integer idGrado;
     private String nombreGrado;
     private String nivel;
     private Integer rotulo;
     private Integer estado;
     private Timestamp creado;

    public Grado() {
    }

    public Grado(String nombreGrado, String nivel, Integer rotulo, Integer estado, Timestamp creado) {
       this.nombreGrado = nombreGrado;
       this.nivel = nivel;
       this.rotulo = rotulo;
       this.estado = estado;
       this.creado = creado;
    }
   
    public Integer getIdGrado() {
        return this.idGrado;
    }
    
    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }
    public String getNombreGrado() {
        return this.nombreGrado;
    }
    
    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }
    public String getNivel() {
        return this.nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public Integer getRotulo() {
        return this.rotulo;
    }
    
    public void setRotulo(Integer rotulo) {
        this.rotulo = rotulo;
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


