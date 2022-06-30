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
import modelo.Usuario;


public class UsuarioDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Usuario obj) {
        try {
            String sql = "insert into usuario(nombreUsuario, clave, tipo, email, estado, creado, modificado) values(?,?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreUsuario());
            ps.setString(2, obj.getClave());
            ps.setString(3, obj.getTipo());
            ps.setString(4, obj.getEmail());
            ps.setInt(5, obj.getEstado());
            ps.setTimestamp(6,obj.getCreado());
            ps.setTimestamp(7, obj.getModificado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idUsuario) {
        try {
            String sql = "update usuario set estado=0 where idUsuario=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Usuario p) {
        try {
            String sql = "update usuario set nombreUsuario=?, clave=?, tipo=?, email=?, estado=?, creado=?, modificado=? where idUsuario=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreUsuario());
            ps.setString(2, p.getClave());
            ps.setString(3, p.getTipo());
            ps.setString(4, p.getEmail());
            ps.setInt(5, p.getEstado());
            ps.setTimestamp(6, p.getCreado());
            ps.setTimestamp(7, p.getModificado());
            ps.setInt(8, p.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Usuario> all() {
        List<Usuario>lista = new ArrayList<>();
        try { 
            String sql = "select * from usuario where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("idUsuario"));
                obj.setNombreUsuario(rs.getString("nombreUsuario"));
                obj.setTipo(rs.getString("tipo"));
                obj.setTipo(rs.getString("email"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Usuario findOne(int idUsuario) {
        Usuario obj = null;
        try {
            String sql = "select * from usuario where estado!=0 and idUsuario=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Usuario();
                obj.setIdUsuario(rs.getInt("idUsuario"));
                obj.setNombreUsuario(rs.getString("nombreUsuario"));
                obj.setClave(rs.getString("clave"));
                obj.setTipo(rs.getString("tipo"));
                obj.setEmail(rs.getString("email"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    
}
