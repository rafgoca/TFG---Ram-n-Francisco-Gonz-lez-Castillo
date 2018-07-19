/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class Rutas {
    
    
    protected static String bbdd, sesion, docs, ayuntamiento;
    
    public static void setRutas(String rbbdd,String rsesion, String rdocs, String ayto){
        bbdd= rbbdd;
                sesion= rsesion;
                docs=rdocs;
                ayuntamiento = ayto;
    }
    
    public static String ayuntamiento(){
        return ayuntamiento;
    }
    
    public static String rutaDocs(){
        return docs;
    }
    
    public static Image cabecera() throws BadElementException, IOException{
       Image image = Image.getInstance("plantillas/cabecera.png"); 
    //   image.setAlignment(Image.ALIGN_TOP);
        image.setAlignment(Image.ALIGN_UNDEFINED);
     //  image.setAbsolutePosition(0, 0);
       return image;
    }
    
    public static String hoy(){
        java.util.Date fecha = new Date();
        return ""+ fecha.getDate()+"-"+fecha.getMonth()+"-"+(1900+fecha.getYear()); 
    }
}
