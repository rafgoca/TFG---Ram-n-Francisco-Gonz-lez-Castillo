/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.elementos;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class Documento {
    
    private static int idDocumento;
    private int id;
    private String tipo;
    private String ruta;
    private String fecha;
/*
    * crea un documento a partir de todos los datos del mismo
    */
    public Documento(int id, String tipo, String ruta, String fecha) {
        this.tipo = tipo;
        this.ruta = ruta;
        this.fecha = fecha;
        this.id = id;
     
    }

    /*
    * crea un nuevo documento y le asigna un número de identificador nuevo
    */
    public Documento(String tipo, String ruta, String fecha) {
       
        
         this(++idDocumento,tipo, ruta, fecha);
    }
/*
    * getters y setters de los atributos del objeto
    */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static int getIdDocumento() {
        return idDocumento;
    }

    public static void setIdDocumento(int idDocumento) {
        Documento.idDocumento = idDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
    
}
