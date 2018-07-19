/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.modelos;

import capa.datos.elementos.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class ModeloTablaUsuario extends DefaultTableModel {
    
    private static final String [] columnIds = {"NIF/NIE", "Apellido1", "Apellido2", "Nombre", "Teléfono1", "Tipo", "Sindicato"};
    private List<Usuario> lista;

    public ModeloTablaUsuario( List<Usuario> lista) {
        super(columnIds, lista.size());
       
        this.lista = lista;
    }
    
    @Override
 public String getColumnName(int col) {
     return this.columnIds[col]; 
 }
 
 @Override
 public int getColumnCount() {
     return this.columnIds.length;
 }
 
 @Override
 public int getRowCount() {
     return this.lista == null ? 0 : this.lista.size();
 }
 
 public Object getValueAt(int indiceFil, int indiceCol) {

     
 switch (indiceCol) {
 case 0: 
     return lista.get(indiceFil).getDni();
 case 1: 
     return lista.get(indiceFil).getAp1();
 case 2: 
     return lista.get(indiceFil).getAp2();
 case 3:
     return lista.get(indiceFil).getNombre();
      case 4:
     return lista.get(indiceFil).getTel1();
      case 5:
          return lista.get(indiceFil).getTipo();
      case 6:
          return lista.get(indiceFil).getSind();
 }
 
 return null;
 }
 
}
