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
import modelo.Grado;


public class GradoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Grado obj) {
        try {
            String sql = "insert into grado(nombreGrado, nivel, rotulo, estado, creado) values(?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreGrado());
            ps.setString(2, obj.getNivel());
            ps.setInt(3, obj.getRotulo());
            ps.setInt(4, obj.getEstado());
            ps.setTimestamp(5, obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idGrado) {
        try {
            String sql = "update grado set estado=0 where idGrado=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGrado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Grado p) {
        try {
            String sql = "update grado set nombreGrado=?, nivel=?, rotulo=?, estado=? where idGrado=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreGrado());
            ps.setString(2, p.getNivel());
            ps.setInt(3, p.getRotulo());
            ps.setInt(4, p.getEstado());
            ps.setInt(5, p.getIdGrado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Grado> all() {
        List<Grado>lista = new ArrayList<>();
        try { 
            String sql = "select * from grado where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Grado obj = new Grado();
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setNombreGrado(rs.getString("nombreGrado"));
                obj.setNivel(rs.getString("nivel"));
                obj.setRotulo(rs.getInt("rotulo"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                lista.add(obj);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Grado findOne(int idGrado) {
        Grado obj = null;
        try {
            String sql = "select * from grado where estado!=0 and idGrado=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGrado);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Grado();
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setNombreGrado(rs.getString("nombreGrado"));
                obj.setNivel(rs.getString("nivel"));
                obj.setRotulo(rs.getInt("rotulo"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    

    
}
