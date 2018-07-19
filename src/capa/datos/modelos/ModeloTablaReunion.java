/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.modelos;

import capa.datos.elementos.Reunion;
import capa.datos.elementos.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramón Francisco González Castillo
 */

public class ModeloTablaReunion extends DefaultTableModel {
    
    private static final String [] columnIds = {"Fecha", "Hora Inicio", "Tipo", "Lugar", "Secretario"};
    private List<Reunion> lista;

    /**
     *
     * @param lista
     */
    public ModeloTablaReunion( List<Reunion> lista) {
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
     return lista.get(indiceFil).getFecha();
 case 1: 
     return lista.get(indiceFil).getInicio();
 case 2: 
     return lista.get(indiceFil).getTipo();
 case 3:
     return lista.get(indiceFil).getLugar();
 case 4:
     return lista.get(indiceFil).getSecretario().getNombreCompleto();

 }
 
 return null;
 }
 
    
}
