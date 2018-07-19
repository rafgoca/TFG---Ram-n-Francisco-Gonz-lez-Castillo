package capa.datos;

import capa.datos.elementos.Documento;
import capa.datos.elementos.Reunion;
import capa.datos.elementos.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class CapaDatos {


    private BBDDHelper baseDeDatos;
    private DatosSesion datosSesion;
   

    /**
     * ***************************************************
     */
    // Patrón Singleton: variable donde se guarda la (única) instancia.
    private static CapaDatos instancia;

    // Patrón Singleton: constructor privado (no se puede llamar al
    // constructor desde fuera de la clase)
    private CapaDatos() {
//        capaNegocio = CapaNegocio.get();
        baseDeDatos = BBDDHelper.get();
        datosSesion = DatosSesion.get();
    }

    // Patrón Singleton: es necesario hacer get para obtener la instancia
    // La primera vez que se llama a get, se crea la instancia.
    // Las siguientes veces, retorna la instancia creada.
    public static CapaDatos get() {
        if (instancia == null) {
            instancia = new CapaDatos();
        }
        return instancia;
    }

    /**
     * ***************************************************
     */
    public boolean login(String nombre, String pass) {

        return datosSesion.login(nombre, pass);
    }

    public String[] sindicatos() {
        return datosSesion.sindicatos();
    }

    public String[] tiposDocumento() {
        return datosSesion.tiposDoc();
    }

    public String[] tiposUsuario() {
        return datosSesion.getTiposUsuario();
    }
    
    public String [] tiposempresa(){
        return datosSesion.getTiposEmpresa();
    }
    
    public String [] getUsuarios(){
        return datosSesion.getUsuarios();
    }

    public String[] tiposReunion() {
        return datosSesion.getTiposReunion();
    }

    public void cerrarBaseDeDatos() {

        try {
            baseDeDatos.cerrarConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Usuario> buscarUsuarios(String filtro, String valor) {

        switch (filtro) {

            case ("Sindicato"):
                return baseDeDatos.buscarUsuariosSindicato(valor);
            case ("Junta"):
                return baseDeDatos.participantesReunion(-1);
            case ("Comite"):
                return baseDeDatos.participantesReunion(-2);
        }

        return null;
    }

    public void crearUsuario(Usuario usuario) {
        baseDeDatos.insertarUsuario(usuario);
    }

    public void insertarReunion(Reunion reunion) {
        baseDeDatos.insertarReunion(reunion);
    }

    public List<Reunion> buscarReunion(String tipo) {
        return baseDeDatos.buscarReunionTipo(tipo);
    }

    public void guardarDatosSesion() {
        datosSesion.actualizarDatosSesion();
    }

    public void recuperarDatosSesion() {
        datosSesion.recuperarDatosSesion();
    }

    public void bajaUsuario(Usuario usuario) {
        baseDeDatos.bajaUsuario(usuario);
    }

    public void eliminar(Usuario usuario) {
        baseDeDatos.eliminarUsuario(usuario);
    }

    public void eliminar(Reunion reunion) {
        baseDeDatos.eliminarReunion(reunion);
    }

    public void insertarDocumento(int idReunion, Documento documento) {
        baseDeDatos.insertarRelacionDocumentoReunion(documento, idReunion);
    }

    public ArrayList<Documento> buscarDocumentos(Reunion reunion) {
        if (reunion == null) {
            return baseDeDatos.buscarDocumentosReunion(-1);
        }
        return baseDeDatos.buscarDocumentosReunion(reunion.getId());
    }

    public void desvincular(Usuario usuario, int idReunion) {
        baseDeDatos.desvincular(usuario.getId(), idReunion);
    }

    public void vincular(Usuario usuario, int idReunion) {
        baseDeDatos.vincular(usuario.getId(), idReunion);
    }

    public void execute(String sql) throws SQLException {
baseDeDatos.execute(sql);
    }

    public void executeSesion(String sql) {
datosSesion.execute(sql);
    }
}
