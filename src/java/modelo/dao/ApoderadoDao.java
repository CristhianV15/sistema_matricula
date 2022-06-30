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

    public boolean add(Apoderado apo) {
        try {
            String sql = "insert into apoderado(nombres, apellidoPaterno, apellidoMaterno, tipoDocumento, numeroDocumento, email, celular, direccion, estado, creado) values(?,?,?,?,?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, apo.getNombres());
            ps.setString(2, apo.getApellidoPaterno());
            ps.setString(3, apo.getApellidoMaterno());
            ps.setString(4, apo.getTipoDocumento());
            ps.setString(5, apo.getNumeroDocumento());
            ps.setString(6, apo.getEmail());
            ps.setString(7, apo.getCelular());
            ps.setString(8, apo.getDireccion());
            ps.setTimestamp(9, apo.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
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
                lista.add(obj);           
                System.out.println("datos" + obj.getApellidoMaterno());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }



}