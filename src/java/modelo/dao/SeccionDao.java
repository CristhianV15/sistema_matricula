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
import modelo.Seccion;


public class SeccionDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Seccion obj) {
        try {
            String sql = "insert into seccion(nombreSeccion, estado, creado) values(?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreSeccion());
            ps.setInt(2, obj.getEstado());
            ps.setTimestamp(3,obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idSeccion) {
        try {
            String sql = "update seccion set estado=0 where idSeccion=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSeccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Seccion p) {
        try {
            String sql = "update seccion set nombreSeccion=?, estado=? where idSeccion=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreSeccion());
            ps.setInt(2, p.getEstado());
            ps.setInt(3, p.getIdSeccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(SeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Seccion> all() {
        List<Seccion>lista = new ArrayList<>();
        try { 
            String sql = "select * from seccion where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Seccion obj = new Seccion();
                obj.setIdSeccion(rs.getInt("idSeccion"));
                obj.setNombreSeccion(rs.getString("nombreSeccion"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                lista.add(obj);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Seccion findOne(int idSeccion) {
        Seccion obj = null;
        try {
            String sql = "select * from seccion where estado!=0 and idSeccion=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSeccion);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Seccion();
                obj.setIdSeccion(rs.getInt("idSeccion"));
                obj.setNombreSeccion(rs.getString("nombreSeccion"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    

    
}
