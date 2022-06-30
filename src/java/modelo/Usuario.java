package modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.util.DbEstado;


public class Usuario {


     private Integer idUsuario;
     private String email;
     private String clave;
     private String nombreUsuario;
     private String tipo;
     private Integer estado;
     private Timestamp creado;
     private Timestamp modificado;
    public Usuario() {
    }

    public Usuario(String email, String clave, String nombreUsuario, String tipo, Integer estado, Timestamp creado) {
       this.email = email;
       this.clave = clave;
       this.nombreUsuario = nombreUsuario;
       this.tipo = tipo;
       this.estado = estado;
       this.creado = creado;       
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    public void setModificado(Timestamp modificado) {
        this.modificado = modificado;
    }

}


