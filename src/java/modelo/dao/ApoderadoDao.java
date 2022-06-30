/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Apoderado;

/**
 *
 * @author Cristhian
 */
public class ApoderadoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Apoderado obj) {
        try {
            String sql = "insert into apoderado(nombres, apellidoPaterno, apellidoMaterno, tipoDocumento, numeroDocumento, email, celular, direccion, estado, creado) values(?,?,?,?,?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidoPaterno());
            ps.setString(3, obj.getApellidoMaterno());
            ps.setString(4, obj.getTipoDocumento());
            ps.setString(5, obj.getNumeroDocumento());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getCelular());
            ps.setString(8, obj.getDireccion());
            ps.setInt(9, obj.getEstado());
            ps.setTimestamp(10, obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApoderadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

       public boolean update(Apoderado ap) {
        try {            
            String sql = "update apoderado set nombres=?, apellidoPaterno=?, apellidoMaterno=?, tipoDocumento=?, numeroDocumento=?, email=?, celular=?, direccion=?, estado=?, modificado=NOW() where idApoderado=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ap.getNombres());
            ps.setString(2, ap.getApellidoMaterno());
            ps.setString(3, ap.getApellidoPaterno());
            ps.setString(4, ap.getTipoDocumento());
            ps.setString(5, ap.getNumeroDocumento());
            ps.setString(6, ap.getEmail());
            ps.setString(7, ap.getCelular());
            ps.setString(8, ap.getDireccion());
            ps.setInt(9, ap.getEstado());
            ps.setInt(10, ap.getIdApoderado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(SalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    public boolean delete(int idApoderado) {
        try {
            String sql = "update apoderado set estado=0 where idApoderado=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idApoderado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApoderadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }
    
    public List<Apoderado> all() {
        List<Apoderado>lista = new ArrayList<>();
        try { 
            String sql = "select * from apoderado where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Apoderado obj = new Apoderado();
                obj.setIdApoderado(rs.getInt("idApoderado"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidoPaterno(rs.getString("apellidoPaterno"));
                obj.setApellidoMaterno(rs.getString("apellidoMaterno"));
                obj.setTipoDocumento(rs.getString("tipoDocumento"));
                obj.setNumeroDocumento(rs.getString("numeroDocumento"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                obj.setModificado(rs.getTimestamp("modificado"));
                lista.add(obj);           
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApoderadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }
    
      public Apoderado findOne(int idApoderado) {
        Apoderado obj = null;
        try {
            String sql = "select * from apoderado where estado!=0 and idApoderado=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idApoderado);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Apoderado();
                 obj.setIdApoderado(rs.getInt("idApoderado"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidoPaterno(rs.getString("apellidoPaterno"));
                obj.setApellidoMaterno(rs.getString("apellidoMaterno"));
                obj.setTipoDocumento(rs.getString("tipoDocumento"));
                obj.setNumeroDocumento(rs.getString("numeroDocumento"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                obj.setModificado(rs.getTimestamp("modificado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    


}
