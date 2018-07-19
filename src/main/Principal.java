
package main;

import capa.igu.ventanas.VentanaLogin;
import capa.igu.ventanas.VentanaMenuPrincipal;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class Principal {
    
    public static void main (String[] args) {
        // Implementación con función lambda:
        SwingUtilities.invokeLater( () ->
            {
                new VentanaLogin().setVisible(true);
//                VentanaMenuPrincipalAdmin.get();
            }
        );
    }

}
