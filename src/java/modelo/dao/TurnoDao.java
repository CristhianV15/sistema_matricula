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
import modelo.Turno;


public class TurnoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Turno obj) {
        try {
            String sql = "insert into turno(nombreTurno, estado, creado) values(?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreTurno());
            ps.setInt(2, obj.getEstado());
            ps.setTimestamp(3,obj.getCreado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean delete(int idTurno) {
        try {
            String sql = "update turno set estado=0 where idTurno=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTurno);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public boolean update(Turno p) {
        try {
            String sql = "update turno set nombreTurno=?, estado=? where idTurno=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreTurno());
            ps.setInt(2, p.getEstado());
            ps.setInt(3, p.getIdTurno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Logger.getLogger(TurnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    
    public List<Turno> all() {
        List<Turno>lista = new ArrayList<>();
        try { 
            String sql = "select * from turno where estado!=0 order by creado desc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Turno obj = new Turno();
                obj.setIdTurno(rs.getInt("idTurno"));
                obj.setNombreTurno(rs.getString("nombreTurno"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));
                lista.add(obj);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }

    
    public Turno findOne(int idTurno) {
        Turno obj = null;
        try {
            String sql = "select * from turno where estado!=0 and idTurno=?";
            System.out.println("sql: " + sql);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTurno);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Turno();
                obj.setIdTurno(rs.getInt("idTurno"));
                obj.setNombreTurno(rs.getString("nombreTurno"));
                obj.setEstado(rs.getInt("estado"));
                obj.setCreado(rs.getTimestamp("creado"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return obj;
    }
    

    
}
