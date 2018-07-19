/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.modelos;


import capa.datos.elementos.Documento;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramón Francisco González Castillo
 */

public class ModeloTablaDocumento extends DefaultTableModel {
    
    // cabecera de las columnas de la tabla
    private static final String [] columnIds = {"Fecha",  "Tipo", "Ruta"};
    //lista con los elementos a mostrar
    private List<Documento> lista;

    /**
     * crea un modelo de tabla a partir de los datos proporcionados
     * @param lista
     */
    public ModeloTablaDocumento( List<Documento> lista) {
        //el constructor de la clase padre necesita los nombres de la cabecera y el número de datos que va a mostrar
        super(columnIds, lista.size());
       
        this.lista = lista;
    }
    
    // obtiene la cabecera de la columna en la posicion "col"
    @Override
 public String getColumnName(int col) {
     return this.columnIds[col]; 
 }
 
 //número de columnas
 @Override
 public int getColumnCount() {
     return this.columnIds.length;
 }
 // numero de filas (elementos)
 @Override
 public int getRowCount() {
     return this.lista == null ? 0 : this.lista.size();
 }
 
 /*
 * devuelve el valor que se debe mostrar en una determinada celda de la tabla
 * @param indiceFil coordenada y de la celda
  @param indiceCol coordenada z de la celda
  * @return el objeto a representar en la celda
 */
 
 public Object getValueAt(int indiceFil, int indiceCol) {

     
 switch (indiceCol) {
 case 0: 
     return lista.get(indiceFil).getFecha();
 case 1: 
     return lista.get(indiceFil).getTipo();
 case 2: 
     return lista.get(indiceFil).getRuta();

 }
 
 return null;
 }
 
    
}