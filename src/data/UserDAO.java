package data;

import database.Conexion;
import data.interfaces.CrudUserInterface;
import entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDAO implements CrudUserInterface<Users> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public UserDAO() {
        CON = new Conexion("biblioteca", "root", "123", "jdbc:mysql://localhost:3306/");
    }

    @Override
    public List<Users> listar(String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Users> listarUsuarios() {
        List<Users> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT idUsuario, nombre FROM usuarios WHERE habilitado = 1 order by nombre asc";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Users(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Users obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Users obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(Users obj) {
        String sql;
        resp=false;
        
        try {
            sql = "select usuario, password from usuarios where usuario = ? and password = ?";
            ps=CON.conectar().prepareStatement(sql);

            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getPassword());
            
            rs=ps.executeQuery();
            while(rs.next()){
                resp=true;
            }
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int total() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
