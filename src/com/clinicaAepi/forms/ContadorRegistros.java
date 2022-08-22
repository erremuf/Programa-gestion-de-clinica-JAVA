/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clinicaAepi.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * Esta clase muestra un contador con el número de pacientes que hay en la base de datos.
 * Cuando insertas un nuevo paciente en la base de datos, el contador se actualiza.
 * @author Ricardo Murillo
 * @version 04/22/2022/A
 * 
 */
public class ContadorRegistros extends javax.swing.JFrame {

    // Variables de clase
    private Connection conexion = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet;


    /**
     * Constructor por defecto de la clase. Muestra los componentes del JFrame al ejecutar el programa
     * y ejecuta desde el inicio el método contadorRegistros() para que la información se visualice nada mas abrir el JFrame.
     */
    public ContadorRegistros() {
        initComponents();
        mostrarContador();
    }
    //Cierre del constructor

    /**
     * Método que nos devuelve el contador de los registros actuales en la bbdd . 
     * Este metodo se concta a la base de datos y selecciona todo el contenido de la tabla.
     * A traves de un bucle while y una variable de tipo int iniciada en 0, va sumando 1 en cada iteración
     * a la variable. Por último asigna al JLabel el valor de la variable int que es la encargada de mostrar el nuemro entero recobido.
     * @see ResultSet
     * @see Connection
     */
    public void mostrarContador() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:pacientes.sqlite");
            statement = conexion.prepareStatement("SELECT * FROM datos");
            resultSet = statement.executeQuery();
            int totalRegistros = 0;
            try {
                while (resultSet.next()) {
                    totalRegistros++;
                }
                etiNumeroRegistros.setText(" " + totalRegistros);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error al seleccionar los registros desde la base de datos", "Aviso del sistema", JOptionPane.ERROR_MESSAGE);
            }
            conexion.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la aplicacion");
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiNumeroRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiNumeroRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Número actual de registros"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(etiNumeroRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(etiNumeroRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ContadorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContadorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContadorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContadorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContadorRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiNumeroRegistros;
    // End of variables declaration//GEN-END:variables
}