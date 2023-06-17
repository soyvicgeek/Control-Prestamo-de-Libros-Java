package data;

import data.interfaces.CrudPrestamosInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entities.Prestamos;
import database.Conexion;
import entities.DetallePrestamo;
import java.sql.Date;
import java.sql.Statement;

public class PrestamosDAO {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public PrestamosDAO() {
        CON = new Conexion("biblioteca", "root", "123", "jdbc:mysql://localhost:3306/");
    }
    
    public List<Prestamos> listar(String texto) {
        List<Prestamos> registros = new ArrayList();
        String sql;
        try{
            sql="Select P.idPrestamo, U.idUsuario, concat(U.nombre, ' ', U.apePat) as Usuario, P.totalLibros, P.fechaPrestamo, P.fechaDevolucion, P.estado\n" +
                "FROM prestamos P INNER JOIN usuarios U ON U.idUsuario = P.idUsuario\n" +
                "AND U.nombre LIKE ? ORDER BY P.idPrestamo ASC";       
                
            ps=CON.conectar().prepareStatement(sql);
            ps.setString(1, "%"+texto+"%");
            
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Prestamos(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    public boolean insertar(Prestamos obj) {
        String sql;
        resp=false;
        
        Connection conn = null;
        try{
            conn = CON.conectar();
            conn.setAutoCommit(false);
            sql="INSERT INTO prestamos(idUsuario,totalLibros,fechaPrestamo,fechaDevolucion,estado)";
            sql = sql+"VALUES(?,?,?,?,?)";
            ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Pasar valores a la consulta
            ps.setInt(1, obj.getIdUsuario());
            ps.setInt(2, obj.getTotalLibros());
            ps.setString(3, obj.getFechaPrestamo());
            ps.setString(4, obj.getFechaDevolucion());
            ps.setString(5, "Aceptado");
            
            int filasAfectadas = ps.executeUpdate();
            int idPrestamoGenerado = 0;
            //Obtener el ID Prestamo
            rs = ps.getGeneratedKeys();
            
            //Asignar el número d eventa generado
            if (rs.next()){
                idPrestamoGenerado = rs.getInt(1);
            }
            
            if(filasAfectadas == 1) {
                //Asignar los detalles
                String sqlDetalles = "INSERT INTO detalleprestamos(idPrestamo, idLibro,cantidad)";
                sqlDetalles +="VALUES(?,?,?)";
                ps = conn.prepareStatement(sqlDetalles);
                
                //Ciclo for para recorrer los detalles
                    for(DetallePrestamo item:obj.getDetalles()){
                    ps.setInt(1, idPrestamoGenerado);
                    ps.setInt(2, item.getIdLibro());
                    ps.setInt(3, item.getCantidad());
                    
                    //Insertar el detalle y vamos a verificar
                    if(ps.executeUpdate() > 0) {
                        resp = true;
                    }
                }
                
                //Cometer la transacción
                conn.commit();
            } else {
                //Oocurrio un error, deshacer la operación
                conn.rollback();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    public boolean devolver(int id) {
        String sql;
        resp=false;
        try{
            sql="UPDATE prestamos SET estado = 'Devuelto' WHERE idPrestamo = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1,id);
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            ps.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }
    
    public int total() {
        String sql;
        int totalRegistros=0;
        try {
            sql="SELECT COUNT(idPrestamo) as numRegistros FROM prestamos";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())    
                totalRegistros=rs.getInt("numRegistros");
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }
}
