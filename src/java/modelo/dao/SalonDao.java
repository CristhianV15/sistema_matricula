package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ciclo;
import modelo.Salon;


public class SalonDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Salon obj) {
        try {            
            String sql = "insert into salon(idCiclo, idGrado, idTurno, idSeccion, idUsuarioCreado, vacantes, estado, creado) values(?,?,?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getCiclo().getIdCiclo());
            ps.setInt(2, obj.getGrado().getIdGrado());
            ps.setInt(3, obj.getTurno().getIdTurno());
            ps.setInt(4, obj.getSeccion().getIdSeccion());
            ps.setInt(5, obj.getUsuarioCreado().getIdUsuario());            
            ps.setInt(6, obj.getVacantes());            
            ps.setInt(7, obj.getEstado());
            ps.setTimestamp(8,obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idSalon) {
        try {
            String sql = "update salon set estado=0 where idSalon=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSalon);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Salon p) {
        try {            
            String sql = "update salon set idCiclo=?, idGrado=?, idTurno=?, idSeccion=?, idUsuarioCreado=?, vacantes=?, estado=?, modificado=NOW() where idSalon=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCiclo().getIdCiclo());
            ps.setInt(2, p.getGrado().getIdGrado());
            ps.setInt(3, p.getTurno().getIdTurno());
            ps.setInt(4, p.getSeccion().getIdSeccion());
            ps.setInt(5, p.getUsuarioCreado().getIdUsuario());            
            ps.setInt(6, p.getVacantes());            
            ps.setInt(7, p.getEstado());            
            ps.setInt(8, p.getIdSalon());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Salon> all() {
        List<Salon>lista = new ArrayList<>();
        try { 
            String sql = "select * from salon where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Salon obj = new Salon();
                obj.setIdSalon(rs.getInt("idSalon"));                
                obj.setCiclo((new CicloDao()).findOne(rs.getInt("idCiclo")));
                obj.setGrado((new GradoDao()).findOne(rs.getInt("idGrado")));
                obj.setTurno((new TurnoDao()).findOne(rs.getInt("idTurno")));
                obj.setSeccion((new SeccionDao()).findOne(rs.getInt("idSeccion")));
                obj.setUsuarioCreado((new UsuarioDao()).findOne(rs.getInt("idUsuarioCreado")));                
                obj.setVacantes(rs.getInt("vacantes"));                
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                obj.setModificado(rs.getTimestamp("modificado"));
                lista.add(obj);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Salon findOne(int idSalon) {
        Salon obj = null;
        try {
            String sql = "select * from salon where estado!=0 and idSalon=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSalon);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Salon();
                obj.setIdSalon(rs.getInt("idSalon"));                
                obj.setCiclo((new CicloDao()).findOne(rs.getInt("idCiclo")));
                obj.setGrado((new GradoDao()).findOne(rs.getInt("idGrado")));
                obj.setTurno((new TurnoDao()).findOne(rs.getInt("idTurno")));
                obj.setSeccion((new SeccionDao()).findOne(rs.getInt("idSeccion")));
                obj.setUsuarioCreado((new UsuarioDao()).findOne(rs.getInt("idUsuarioCreado")));                
                obj.setVacantes(rs.getInt("vacantes"));                
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                obj.setModificado(rs.getTimestamp("modificado"));         
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    

    
}
