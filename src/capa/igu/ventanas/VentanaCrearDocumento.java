package capa.igu.ventanas;


import capa.datos.CapaDatos;
import capa.datos.Rutas;
import capa.datos.elementos.Documento;
import capa.datos.elementos.Reunion;
import capa.igu.CapaIGU;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class VentanaCrearDocumento extends javax.swing.JFrame {

    Reunion reunion;
    JFrame padre;

    /**
     * Creates new form VentanaEdicionOrdenDelDia
     */
    public VentanaCrearDocumento(JFrame padre, Reunion reunion) {
        initComponents();
        prepararCierreVentana();
        this.padre = padre;
        this.reunion = reunion;
        tipoDoc.setModel(new DefaultComboBoxModel(CapaDatos.get().tiposDocumento()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tipoDoc = new javax.swing.JComboBox<>();
        txtFecha = new datechooser.beans.DateChooserCombo();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        txtActa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(getPreferredSize());
        setSize(getPreferredSize());

        jLabel1.setText("GESINCAT");

        jLabel2.setText("Crear documento");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar documento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha");

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo documento:");

        tipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Cargar plantilla");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(texto);

        jLabel3.setText("Nº Acta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipoDoc, 0, 119, Short.MAX_VALUE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton4)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preguntarLogoutYOCerrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombreFichero = reunion.getId()+"_"+tipoDoc.getSelectedItem()+"_"+Documento.getIdDocumento();
        String ruta = Rutas.rutaDocs()+nombreFichero;

        if (txtFecha.getText().equalsIgnoreCase("")) {
            DialogoConfirmar.aviso("Debe rellenar todos los campos");
        } else {
            
            try {
                CapaIGU.get().insertarDocumento(reunion.getId(),
                        new Documento(
                                (String) tipoDoc.getSelectedItem(),
                                ruta+".pdf",
                                txtFecha.getText()
                        ));
                
                crearPDF(ruta);
        
                this.setVisible(false);
                padre.setVisible(true);
            } catch (DocumentException |  IOException ex) {
                ex.printStackTrace();
            } 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        padre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        String seleccion = (String)tipoDoc.getSelectedItem();
        
        try {
          
            BufferedReader br = new BufferedReader( new FileReader(new File("plantillas\\"+seleccion+".html")));
            procesarPlantilla(br);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No existe la plantilla solicitada", "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void preguntarLogoutYOCerrar() {
        boolean si = DialogoConfirmar.preguntarLogout(this);
        if (si) {
            System.exit(0);
        }
    }

    private void prepararCierreVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                preguntarLogoutYOCerrar();
            }
        });
    }
    
    private void crearPDF(String ruta) throws IOException, DocumentException{
        File f = new File(ruta+".html");
        f.createNewFile();               
        FileWriter w = new FileWriter(f);
        w.write(texto.getText());
        w.close();
        
        
      Document document = new Document(PageSize.A4); 
      PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(ruta+".pdf")); 
      document.open(); 
      document.addAuthor("Ayuntamiento de "+Rutas.ayuntamiento()); 
      document.addCreationDate(); 
      document.addTitle((String) tipoDoc.getSelectedItem()+" "+ txtFecha.getText()); 
      document.add(Rutas.cabecera());
      HTMLWorker htmlWorker = new HTMLWorker(document); 
      
      String str = texto.getText(); 
     
      htmlWorker.parse(new StringReader(str)); 
      document.close(); 
    }
    
    public void procesarPlantilla( BufferedReader br){
        try {
            texto.setText("");
            texto.setContentType("text/html");
            
            StringBuilder cadena= new StringBuilder();
            String lectura = br.readLine();
            
            while(lectura!=null){
                
               lectura= lectura.replaceAll("#fecha", reunion.getFecha());
             lectura=   lectura.replaceAll("#numActa", txtActa.getText());
             lectura=   lectura.replaceAll("#hInicio", reunion.getInicio());
             lectura=   lectura.replaceAll("#hFin", reunion.getFinal());
             lectura=   lectura.replaceAll("#lugar", reunion.getLugar());
             lectura=   lectura.replaceAll("#Asistentes", reunion.getAsistentes());
             lectura=   lectura.replaceAll("#Secretario", reunion.getSecretario().getNombreCompleto());
             lectura=   lectura.replaceAll("#Ayuntamiento", Rutas.ayuntamiento());
                
                cadena.append(lectura);
                lectura = br.readLine();
            }
            
            texto.setText(cadena.toString());
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(VentanaCrearDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane texto;
    private javax.swing.JComboBox<String> tipoDoc;
    private javax.swing.JTextField txtActa;
    private datechooser.beans.DateChooserCombo txtFecha;
    // End of variables declaration//GEN-END:variables
}
