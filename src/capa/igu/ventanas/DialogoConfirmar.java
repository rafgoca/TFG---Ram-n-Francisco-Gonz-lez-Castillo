
package capa.igu.ventanas;

import capa.igu.CapaIGU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class DialogoConfirmar {
    
//    public static JFrame frame = null;
    
    public static boolean preguntar (JFrame jf, String pregunta) {
        boolean resultat;
        int n = JOptionPane.showConfirmDialog(
                    jf,
                    pregunta,
                    "",
                    JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            resultat = true;
        }
        else {  // if (n == JOptionPane.NO_OPTION || n == JOptionPane.CLOSED_OPTION) {
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean preguntarLogout (JFrame jf) {
        
        if(preguntar(jf, "¿Realmente quiere cerrar la sesión y salir de la aplicación?")){
            CapaIGU.get().guardarDatosSesion();
        return true;
        }
        return false;
    }
    
    public static boolean preguntarBorradoUsuario (JFrame jf) {
        return preguntar(jf, "¿Realmente quiere borrar este usuario?");
    }
    
    public static boolean preguntarBorradoReunion (JFrame jf) {
        return preguntar(jf, "¿Realmente quiere borrar esta reunión?");
    }
    
    public static boolean preguntarBorradoDocumento (JFrame jf) {
        return preguntar(jf, "¿Realmente quiere borrar este documento?");
    }
    
    public static void aviso(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void error(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.ERROR_MESSAGE);
    }
}
