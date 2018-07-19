
package capa.igu.ventanas;

import capa.datos.Rutas;
import capa.igu.CapaIGU;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class VentanaLogin extends javax.swing.JFrame {

    private CapaIGU capaIGU;
    private boolean estadoBloqMayus;
    public static String basedatos,  sesion, rutaDocs;
     String ayuntamiento;
    
    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
      
        
       
        
        try {
            FileReader fr = new FileReader(new File("config.ini"));
            BufferedReader br = new BufferedReader(fr);
           basedatos=  br.readLine();
           sesion = br.readLine();
          ayuntamiento = br.readLine();
          txtAyto.setText("Ayuntamiento de "+ayuntamiento);
           rutaDocs = br.readLine();
           //  capaIGU = CapaIGU.get();
        Rutas.setRutas(basedatos, sesion, rutaDocs, ayuntamiento);
          capaIGU = CapaIGU.get();
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.exit(1);
        }
        prepararAvisoMayus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFondo = new javax.swing.JLabel();
        jLabelGSINCAT = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelAviso = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAyto = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabelFondo.setText("jLabel1");

        jLabelGSINCAT.setText("GESINCAT");

        jLabelUsuario.setText("Usuario");

        jLabelPassword.setText("Contraseña");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });

        jLabelAviso.setText("Bloq Mayús activado");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sección sindical");

        txtAyto.setText("jLabel3");

        btnAdmin.setText("Modo Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtAyto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUsuario)
                                    .addComponent(jLabelPassword))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelAviso))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelGSINCAT))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdmin)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonEntrar)
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGSINCAT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtAyto))
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelUsuario)
                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPassword)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAviso))))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEntrar)
                            .addComponent(jButton1)
                            .addComponent(btnAdmin))
                        .addGap(78, 78, 78))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
       
            if (nombreYPasswCorrectos()) {
                recuperarDatosSesion();
                salirDeVentana();
                irAVentanaMenuPrincipal();
            }
            else {  // datos incorrectos
                avisarErrorNombreYOPassw();
            }
        
      
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        capaIGU.cerrarBaseDeDatos();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
                    if (jTextFieldUsuario.getText().equalsIgnoreCase("admin") && nombreYPasswCorrectos()) {
                recuperarDatosSesion();
                salirDeVentana();
                new VentanaGestionAdmin().setVisible(true);
            }
            else {  // datos incorrectos
                avisarErrorNombreYOPassw();
            }
    }//GEN-LAST:event_btnAdminActionPerformed

 
    
    private void prepararAvisoMayus () {
        setFocusable(true);
        estadoBloqMayus = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        if (estadoBloqMayus) {
            jLabelAviso.setText("Bloq Mayús activado");
        }
        else {
            jLabelAviso.setText("                   ");
        }
        pack();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
                    estadoBloqMayus = ! estadoBloqMayus;
                    if (estadoBloqMayus) {
                        jLabelAviso.setText("Bloq Mayús activado");
                    }
                    else {
                        jLabelAviso.setText("                  ");
                    }
                    pack();
                }
            }
        });
    }

    
    private boolean nombreYPasswCorrectos () {
        String username = jTextFieldUsuario.getText();
        String password = vectorCharAString(jPasswordField1.getPassword());
        return capaIGU.validarContrasenya(username, password);
    }
    
    private void guardarDatosSesion () {
        
        capaIGU.guardarDatosSesion();
    }
        public void recuperarDatosSesion(){
            capaIGU.recuperarDatosSesion();
        }

    private void salirDeVentana () {
        this.setVisible(false);
    }
    
    private void irAVentanaMenuPrincipal () {
        VentanaMenuPrincipal vmpa = VentanaMenuPrincipal.get(capaIGU);
        
        vmpa.cambiarEtiqAyunt(ayuntamiento);
        vmpa.setVisible(true);        
    }

    private void avisarErrorNombreYOPassw () {
        JOptionPane.showMessageDialog(this, "Nombre y/o contraseña incorrectos","Datos incorrectos",
                JOptionPane.ERROR_MESSAGE);
    }
    
 
    
    private String vectorCharAString (char[] v) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int tam = v.length;
        while (i < tam) {
            sb.append(v[i]);
            i++;
        }
        return sb.toString();
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelGSINCAT;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JLabel txtAyto;
    // End of variables declaration//GEN-END:variables
}