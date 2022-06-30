package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ciclo;


public class CicloDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Ciclo obj) {
        try {
            String sql = "insert into ciclo(nombreCiclo, estado, creado) values(?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreCiclo());
            ps.setInt(2, obj.getEstado());
            ps.setTimestamp(3,obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CicloDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idCiclo) {
        try {
            String sql = "update ciclo set estado=0 where idCiclo=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCiclo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CicloDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Ciclo p) {
        try {
            String sql = "update ciclo set nombreCiclo=?, estado=? where idCiclo=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreCiclo());
            ps.setInt(2, p.getEstado());
            ps.setInt(3, p.getIdCiclo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(CicloDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Ciclo> all() {
        List<Ciclo>lista = new ArrayList<>();
        try { 
            String sql = "select * from ciclo where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Ciclo obj = new Ciclo();
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setNombreCiclo(rs.getString("nombreCiclo"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                lista.add(obj);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CicloDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Ciclo findOne(int idCiclo) {
        Ciclo obj = null;
        try {
            String sql = "select * from ciclo where estado!=0 and idCiclo=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCiclo);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Ciclo();
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setNombreCiclo(rs.getString("nombreCiclo"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CicloDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    

    
}
