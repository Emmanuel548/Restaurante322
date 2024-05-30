/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.rellenarCombo;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Modelo.CConexion;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Evitar duplicados
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session; // Usar javax.mail.Session
import javax.mail.Transport; // Usar javax.mail.Transport
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class formCobrarOrden extends javax.swing.JFrame {

    rellenarCombo rC = new rellenarCombo();
    
    CConexion con = new CConexion();
    Connection cn = con.conectar();
    
    private int idUsuarioCamarero;
    
    public formCobrarOrden() {
        initComponents();
        this.setLocationRelativeTo(null);
        rC.rellenarComboBox("orden","id_orden", cboIDOrden);
    }
    
    public void setNombreCamarero(String nombreCamarero) {
        lblMostrarUsuario.setText("Usuario: " + nombreCamarero);
        ResultSet rs = null;
        try {
            PreparedStatement pss = cn.prepareStatement("select id_usuario from usuarios where nombre = ?;");
            pss.setString(1, nombreCamarero);
            String dat[]= new String[1];
            rs = pss.executeQuery();
            while(rs.next()){
                dat[0] = rs.getString(1);
            }
            idUsuarioCamarero = Integer.parseInt(dat[0]);
        } catch(SQLException e){
            System.out.println("Error al traer datos de la BD");
        }
    }
    
    public void actualizarOrden() {
        int id_orde = Integer.parseInt(cboIDOrden.getSelectedItem().toString());
        try {
            PreparedStatement pps = cn.prepareStatement("update orden set id_usuario = ? where id_orden = ?;");
            pps.setInt(1, idUsuarioCamarero);
            pps.setInt(2, id_orde);
            pps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario de la orden en la BD " + e);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboIDOrden = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblMostrarUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCobro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblImporteTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 235, 165));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRestaurante.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COBRAR ORDEN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Seleccione ID de orden");

        cboIDOrden.setBackground(new java.awt.Color(251, 235, 165));
        cboIDOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboIDOrden.setForeground(new java.awt.Color(0, 0, 0));
        cboIDOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboIDOrdenActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir ticket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblMostrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMostrarUsuario.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cobro                          $");

        txtCobro.setBackground(new java.awt.Color(251, 235, 165));
        txtCobro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCobro.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Importe total            $");

        lblImporteTotal.setBackground(new java.awt.Color(251, 235, 165));
        lblImporteTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImporteTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblImporteTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboIDOrden, 0, 126, Short.MAX_VALUE)
                                    .addComponent(txtCobro)
                                    .addComponent(lblImporteTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboIDOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(lblImporteTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?","Salir",a);
        if (resultado == 0) {
            this.setVisible(false);
            login bu = new login();
            bu.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double cobrar = Double.parseDouble(lblImporteTotal.getText());
        double pago = Double.parseDouble(txtCobro.getText());
        String destino="", nombreArchivo="";
        if (pago >= cobrar) {
            actualizarOrden();
            
            double cambio = pago - cobrar;

            Document documento = new Document(new Rectangle(350, 325)); // Tamaño de ticket personalizado
            int id_orden = Integer.parseInt(cboIDOrden.getSelectedItem().toString());

            try{
                String consult = "select fecha, no_mesa, total, usuarios.nombre from orden inner join usuarios on (orden.id_usuario = usuarios.id_usuario) where id_orden = ?;";
                PreparedStatement pss = cn.prepareStatement(consult);
                pss.setInt(1, id_orden);
                String datos[] = new String[4];
                ResultSet rss = pss.executeQuery();
                while(rss.next()){
                    datos[0] = rss.getString(1);
                    datos[1] = rss.getString(2);
                    datos[2] = rss.getString(3);
                    datos[3] = rss.getString(4);
                }

                try {
                    String ruta = System.getProperty("user.home");
                    destino = ruta + "/Desktop/Ticket" + id_orden + ".pdf";
                    nombreArchivo = "Ticket" + id_orden + ".pdf";
                    File archivo = new File(destino);

                    // Crear directorios si no existen
                    archivo.getParentFile().mkdirs();

                    PdfWriter.getInstance(documento, new FileOutputStream(archivo));
                    System.out.println("Ruta del archivo PDF: " + destino);
                    documento.open();

                    // Fuentes personalizadas
                    Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                    Font fontNormal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
                    Font fontBold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

                    // Encabezado del ticket
                    Paragraph titulo = new Paragraph("Restaurante\n\n", fontTitulo);
                    titulo.setAlignment(Element.ALIGN_CENTER);
                    documento.add(titulo);

                    Paragraph infoOrden = new Paragraph("Orden No: " + id_orden + "\nFecha: " + datos[0] + "\nMesa: "+ datos[1] + "\nCamarero: " + datos[3] + "\n\n", fontNormal);
                    infoOrden.setAlignment(Element.ALIGN_CENTER);
                    documento.add(infoOrden);

                    // Tabla con los detalles
                    PdfPTable tabla = new PdfPTable(3);
                    tabla.setWidthPercentage(100); // Ancho de la tabla
                    tabla.setWidths(new float[]{3, 2, 2}); // Ancho relativo de las columnas

                    tabla.addCell(new PdfPCell(new Phrase("Producto", fontBold)));
                    tabla.addCell(new PdfPCell(new Phrase("Cantidad", fontBold)));
                    tabla.addCell(new PdfPCell(new Phrase("Subtotal", fontBold)));

                    try {
                        String consulta = "SELECT productos.nombre, cantidad, subtotal " +
                                          "FROM detalle_orden " +
                                          "INNER JOIN productos ON (detalle_orden.id_prod = productos.id_prod) " +
                                          "WHERE detalle_orden.id_orden = ?";
                        PreparedStatement ps = cn.prepareStatement(consulta);
                        ps.setInt(1, id_orden);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            tabla.addCell(new PdfPCell(new Phrase(rs.getString(1), fontNormal)));
                            tabla.addCell(new PdfPCell(new Phrase(rs.getString(2), fontNormal)));
                            tabla.addCell(new PdfPCell(new Phrase(rs.getString(3), fontNormal)));
                        }
                        documento.add(tabla);
                    } catch (SQLException e) {
                        System.out.println("Error en la consulta SQL: " + e.getMessage());
                    }

                    // Pie del ticket
                    Paragraph footer = new Paragraph("\nTotal: $" + datos[2] + "\nPago: $" + pago  + "\nCambio: $" + cambio + "\n\n¡Gracias por su compra!\n\n", fontNormal);
                    footer.setAlignment(Element.ALIGN_CENTER);
                    documento.add(footer);

                    JOptionPane.showMessageDialog(null, "Pago realizado con éxito. Ticket impreso", "Confirmación de pago", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "El cambio es: $" + cambio, "Cambio", JOptionPane.INFORMATION_MESSAGE);
                    txtCobro.setText("");
                } catch (DocumentException e) {
                    System.out.println("Error al crear el documento PDF: " + e.getMessage());
                } catch (FileNotFoundException e) {
                    System.out.println("Error, archivo no encontrado: " + e.getMessage());
                } catch (HeadlessException e) {
                    System.out.println("Error de entorno gráfico: " + e.getMessage());
                } finally {
                    if (documento.isOpen()) {
                        documento.close();
                    }
                }
            }catch(SQLException e){
                System.out.println("Error al traer los datos de la BD");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Error: El pago es menor que el monto a cobrar.", "Error de pago", JOptionPane.ERROR_MESSAGE);
            txtCobro.setText("");
            txtCobro.requestFocusInWindow();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboIDOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboIDOrdenActionPerformed
        int id_orden = Integer.parseInt(cboIDOrden.getSelectedItem().toString());
        try{
            String consult = "select total from orden where id_orden = ?;";
            PreparedStatement pss = cn.prepareStatement(consult);
            pss.setInt(1, id_orden);
            String datos[] = new String[1];
            ResultSet rss = pss.executeQuery();
            while(rss.next()){
                datos[0] = rss.getString(1);
            }
            lblImporteTotal.setText(datos[0]);
        }catch(SQLException e){
            System.out.println("Error al traer datos de la BD");
        }
    }//GEN-LAST:event_cboIDOrdenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCobrarOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboIDOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImporteTotal;
    private javax.swing.JLabel lblMostrarUsuario;
    private javax.swing.JTextField txtCobro;
    // End of variables declaration//GEN-END:variables
}
