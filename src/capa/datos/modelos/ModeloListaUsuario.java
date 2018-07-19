/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.modelos;

import capa.datos.elementos.Usuario;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class ModeloListaUsuario implements ListModel{

    
    List<Usuario> lista;
    
    /**
     * Crea un modelo de lista a partir de los datos proporcionados
     * @param list lista de los elementos a mostrar
     */
    public ModeloListaUsuario(List<Usuario> list){
        super();
        lista = list;
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }
//en vez de mostrar en la lista el usuario completo, solo queremos que muestre su nombre completo
    @Override
    public Object getElementAt(int index) {
        return lista.get(index).getNombreCompleto();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
