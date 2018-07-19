
package capa.igu;

import capa.datos.elementos.Documento;
import capa.datos.elementos.Reunion;
import capa.datos.elementos.Usuario;
import capa.negocio.CapaNegocio;
import capa.igu.ventanas.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class CapaIGU {

    private static CapaNegocio capaNegocio;
    
    /******************************************************/

    // Patrón Singleton: variable donde se guarda la (única) instancia.
    private static CapaIGU instancia;
    
    // Patrón Singleton: constructor privado (no se puede llamar al
    // constructor desde fuera de la clase)
    private CapaIGU () {
        capaNegocio = CapaNegocio.get();
    }
    
    // Patrón Singleton: es necesario hacer get para obtener la instancia
    // La primera vez que se llama a get, se crea la instancia.
    // Las siguientes veces, retorna la instancia creada.
    public static CapaIGU get () {
        if (instancia == null) {
            instancia = new CapaIGU();
        }
        return instancia;
    }

    /******************************************************/

    public void guardarDatosSesion () {
        capaNegocio.guardarDatosSesion();
    }
    
        public void recuperarDatosSesion(){
            capaNegocio.recuperarDatosSesion();
        }

    
    // Pide comprobación de la contraseña a la capa inmediatamente inferior:
    public boolean validarContrasenya (String username, String password) {
        return capaNegocio.validarContrasenya(username, password);
    }
    
    public void crearUsuario (String dni, String nombre, String ap1,
            String ap2, String dir, String pob, String prov, String tel1,
            String tel2, String email, String cargo) {
        
        capaNegocio.crearUsuario(dni, nombre, ap1, ap2, dir, pob,
                prov, tel1, tel2, email, cargo);
    }
    
    public void cerrarBaseDeDatos () {
        capaNegocio.cerrarBaseDeDatos();
    }

  public ArrayList<Usuario> buscarUsuarios(String filtro, String valor){
      return capaNegocio.buscarUsuarios(filtro, valor);
  }
  
  public void desvincular(Usuario usuario, int idReunion){
      capaNegocio.desvincular( usuario,  idReunion);
  }
 public void vincular(Usuario usuario, int idReunion){
      capaNegocio.vincular( usuario,  idReunion);
  }
  public String [] sindicatos(){
      return capaNegocio.sindicatos();
  }
    public void crearUsuario(Usuario usuario) {
capaNegocio.crearUsuario(usuario);
        }

    public void insertarReunion(Reunion reunion) {
capaNegocio.insertarReunion( reunion);
    }

    public List<Reunion> buscarReunion(String tipo) {
    return capaNegocio.buscarReunion(tipo);
    }

    public void bajaUsuario(Usuario usuario) {
capaNegocio.bajaUsuario(usuario);
    }

    public void eliminar(Reunion victima) {
capaNegocio.eliminar(victima);
    }

    public void insertarDocumento(int idReunion, Documento documento) {
capaNegocio.insertarDocumento(idReunion,  documento);
    }

    public ArrayList<Documento> buscarDocumentos(Reunion reunion) {
return capaNegocio.buscarDocumentos(reunion);  
    }

    public String[] getUsuarios() {
return capaNegocio.getUsuarios();
    }

    public String[] getTiposDoc() {
return  capaNegocio.getTiposDoc();
    }

    public String[] getTiposReunion() {
return capaNegocio.getTipoReunion();    }

    public String[] getTiposUsuarios() {
return capaNegocio.getTipoUsuario();
    }

    public String[] getTiposEmpresa() {
return capaNegocio.getTipoEmpresa();
    }

   public void execute(String sql) throws SQLException{
       capaNegocio.execute(sql);
   }

   public void executeSesion(String sql){
       capaNegocio.executeSesion(sql);
   }
}
