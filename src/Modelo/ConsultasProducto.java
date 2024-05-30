package Modelo;

import Vista.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultasProducto extends CConexion{
    
    public boolean registrar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            PreparedStatement ps = cn.prepareStatement("insert into productos (nombre, descripcion, precio, id_categoria) values (?,?,?,?)");
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getId_categoria());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.out.println("Error al registrar el producto en la BD " + e);
            return false;
        }
    }
    
    public boolean modificar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            int id = pro.getId_prod();
            PreparedStatement ps = cn.prepareStatement("update productos set nombre=?, descripcion=?, precio=?, id_categoria=? where id_prod=? ");
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getId_categoria());
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto en la BD " + e);
            return false;
        }
    }
    
    public static boolean eliminar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM productos WHERE id_prod = ? ");
            ps.setInt(1, pro.getId_prod());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto en la BD " + e);
            return false;
        }
    }
    
    public static void mostrar(DefaultTableModel modelo) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        String consulta = "select * from productos inner join categoria on (productos.id_categoria = categoria.id_categoria)";
        String data[]= new String[7];
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(7);
                modelo.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error al mostrar los datos de la BD");
        }
    }
}
