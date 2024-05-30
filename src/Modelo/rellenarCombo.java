/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.CConexion;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Alexander
 */
public class rellenarCombo {                
    public void rellenarComboBox(String tabla, String valor, JComboBox combo) {
        String sql = "select * from " + tabla;
        Statement st;
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
    }
}
