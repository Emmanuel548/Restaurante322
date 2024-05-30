package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ConsultasUsuario extends CConexion{
    
    public boolean modificar(Usuario usser) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            int id = usser.getId_usuario();
            PreparedStatement ps = cn.prepareStatement("update usuarios set nombre=?, telefono=?, id_tipoU=? where id_usuario=? ");
            ps.setString(1, usser.getNombre());
            ps.setString(2, usser.getTelefono());
            ps.setDouble(3, usser.getId_tipoU());
            ps.setInt(4, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar el producto en la BD " + e);
            return false;
        }
    }
    
    public static boolean eliminar(Usuario usser) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();

        try {
            int id = usser.getId_usuario();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario en la BD " + e);
            return false;
        }
    }
    
    public static void mostrar(DefaultTableModel modelo) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        String consulta = "select * from usuarios inner join tiposusuario on (usuarios.id_tipoU = tiposusuario.id_tipoU);";
        String data[]= new String[4];
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(7);
                modelo.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error al mostrar los datos de la BD");
        } 
    }
}
