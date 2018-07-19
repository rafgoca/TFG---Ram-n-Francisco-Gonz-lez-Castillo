package capa.negocio;

import capa.datos.CapaDatos;
import capa.datos.elementos.Documento;
import capa.datos.elementos.Reunion;
import capa.datos.elementos.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class CapaNegocio {

    private static CapaDatos capaDatos;
    private static String rutaDocs;

    /**
     * ***************************************************
     */
    // Patrón Singleton: variable donde se guarda la (única) instancia.
    private static CapaNegocio instancia;

    // Patrón Singleton: constructor privado (no se puede llamar al
    // constructor desde fuera de la clase)
    private CapaNegocio() {
        capaDatos = CapaDatos.get();

    }

    // Patrón Singleton: es necesario hacer get para obtener la instancia
    // La primera vez que se llama a get, se crea la instancia.
    // Las siguientes veces, retorna la instancia creada.
    public static CapaNegocio get() {
        if (instancia == null) {
            instancia = new CapaNegocio();
        }
        return instancia;
    }

    /**
     * ***************************************************
     */
    public String[] sindicatos() {
        return capaDatos.sindicatos();
    }

    public boolean validarContrasenya(String username, String password) {
        return capaDatos.login(username, password);
    }

    public void crearUsuario(String dni, String nombre, String ap1,
            String ap2, String dir, String pob, String prov, String tel1,
            String tel2, String email, String cargo) {

        //  capaDatos.crearUsuario(dni, nombre, ap1, ap2, dir, pob,  prov, tel1, tel2, email, cargo, "");//falta sindicato
    }

    public void cerrarBaseDeDatos() {
        capaDatos.cerrarBaseDeDatos();
    }

    public ArrayList<Usuario> buscarUsuarios(String filtro, String valor) {

        return capaDatos.buscarUsuarios(filtro, valor);
    }

    public void crearUsuario(Usuario usuario) {
        capaDatos.crearUsuario(usuario);
    }

    public void insertarReunion(Reunion reunion) {
        capaDatos.insertarReunion(reunion);
    }

    public List<Reunion> buscarReunion(String tipo) {
        return capaDatos.buscarReunion(tipo);
    }

    public void guardarDatosSesion() {
        capaDatos.guardarDatosSesion();
    }

    public void recuperarDatosSesion() {
        capaDatos.recuperarDatosSesion();

    }

    public void bajaUsuario(Usuario usuario) {
        capaDatos.bajaUsuario(usuario);
    }

    public void eliminar(Reunion victima) {
        capaDatos.eliminar(victima);
    }

    public void insertarDocumento(int idReunion, Documento documento) {
        capaDatos.insertarDocumento(idReunion, documento);
    }

    public ArrayList<Documento> buscarDocumentos(Reunion reunion) {
        return capaDatos.buscarDocumentos(reunion);
    }

    public void desvincular(Usuario usuario, int idReunion) {
capaDatos.desvincular( usuario,  idReunion);    }

  public void vincular(Usuario usuario, int idReunion) {
capaDatos.vincular( usuario,  idReunion);    }

    public String[] getUsuarios() {
return capaDatos.getUsuarios();
        }

    public String[] getTiposDoc() {
return capaDatos.tiposDocumento();
    }

    public String[] getTipoReunion() {
return capaDatos.tiposReunion();
    }

    public String[] getTipoUsuario() {
return capaDatos.tiposUsuario();
    }

    public String[] getTipoEmpresa() {
return capaDatos.tiposempresa();
    }

    public void execute(String sql) throws SQLException {
capaDatos.execute(sql);
    }

    public void executeSesion(String sql) {
capaDatos.executeSesion(sql);    }

}
