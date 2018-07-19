/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;

import capa.datos.elementos.Documento;
import capa.datos.elementos.Reunion;
import capa.datos.elementos.Usuario;
import capa.igu.ventanas.VentanaLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class BBDDHelper {

    
    public static final String SQL_CONSULTAR_TODAS_REUNIONES = "SELECT * FROM Reunion";
    public static final String SQL_CONSULTAR_USUARIO = "SELECT * FROM Usuario WHERE dni = ?";
    public static final String SQL_CONSULTAR_USUARIO_SINDICATO = "SELECT * FROM Usuario WHERE Sindicato = ? AND Activo =?";
    public static final String SQL_CONSULTAR_USUARIO_ID = "SELECT * FROM Usuario WHERE id = ?";
    public static final String SQL_CONSULTAR_REUNION = "SELECT * FROM Reunion WHERE id = ?";
    public static final String SQL_CONSULTAR_DOCUMENTO = "SELECT * FROM Documento WHERE id = ?";
    public static final String SQL_CONSULTAR_REUNION_TIPO = "SELECT * FROM Reunion WHERE Tipo = ?";
    public static final String SQL_CONSULTAR_PARTICIPANTES_REUNION = "SELECT * FROM RelacionUsuarioReunion WHERE idReunion = ?";
    public static final String SQL_CONSULTAR_RELACION_REUNION_USUARIO = "SELECT * FROM RelacionUsuarioReunion WHERE idReunion = ? AND idUsuario = ? AND Tipo =?";
    public static final String SQL_CONSULTAR_DOCUMENTOS_REUNION = "SELECT * FROM RelacionDocumentoReunion WHERE idReunion = ?";
    public static final String SQL_INSERTAR_USUARIO = "INSERT INTO Usuario VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?,?)";  // Poner '?'
    public static final String SQL_INSERTAR_REUNION = "INSERT INTO Reunion VALUES (?,?, ?, ?,?, ?, ?,?, ?)";
    public static final String SQL_INSERTAR_DOCUMENTO = "INSERT INTO Documento VALUES (?,?, ?, ?)";
    public static final String SQL_INSERTAR_RELACION_REUNION_USUARIO = "INSERT INTO RelacionUsuarioReunion VALUES (?, ?,?)";
    public static final String SQL_INSERTAR_RELACION_REUNION_DOCUMENTO = "INSERT INTO RelacionDocumentoReunion VALUES (?, ?)";
    public static final String SQL_BORRAR_RELACION_REUNION_USUARIO = "DELETE FROM RelacionUsuarioReunion WHERE idUsuario=? AND idReunion =? ";
    public static final String SQL_BORRAR_USUARIO = "DELETE FROM Usuario WHERE dni = ?";
    public static final String SQL_BAJA_USUARIO = "UPDATE Usuario SET Activo = ? WHERE id = ?";
    public static final String SQL_BORRAR_REUNION = "DELETE FROM Reunion WHERE id = ?";
    

    private static BBDDHelper instancia;
    String ruta;

    private Connection conexion;

    private BBDDHelper() {
        ruta = Rutas.bbdd;
       // ruta= "C:\\Users\\Ramon\\Desktop\\Gesincat\\GESINCAT\\gestincat";
        registrarBD();
        conectarConBD();

    }

    /**
     *
     * @return instancia del objeto del patrón Singleton
     */
    public static BBDDHelper get() {
        if (instancia == null) {
            instancia = new BBDDHelper();
        }
        return instancia;
    }
/**
 *  registra los driver de acceso a la base de datos
 * 
 */
    private void registrarBD() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Base de datos registrada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de bbdd: " + ex);
            System.exit(1);
        }
    }
    
/**
 *  abre la base de datos que contiene los datos necesarios
 * 
 */
    private boolean conectarConBD() {
        boolean resultado;
        try {
//ruta = "c:\\temp\\gestincat";
            conexion = DriverManager.getConnection("jdbc:derby:" + ruta, "root", "12345");
            System.out.println("Conexión con base de datos");
            resultado = true;
        } catch (SQLException ex) {
            System.out.println("Error al conectar con base de datos: " + ex);
            resultado = false;
        }
        return resultado;
    }

    /**
     * crea e inicializa las tablas necesarias
     * @param args
     */
    public static void main(String[] args) {
        new BBDDHelper().crearTablas();
    }

    private void crearTablas() {
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "CREATE TABLE Usuario (id INTEGER, dni VARCHAR(30), Nombre VARCHAR(30), Apellido1 VARCHAR(30), Apellido2 VARCHAR(30), Direccion VARCHAR(30), Poblacion VARCHAR(30), Provincia VARCHAR(30), Telefono1 VARCHAR(11), Telefono2 VARCHAR(11), Email VARCHAR(30), Cargo VARCHAR(30), Sindicato VARCHAR(10), Tipo VARCHAR(30), Activo VARCHAR(1))";
            sentencia.execute(sql);

            sql = "CREATE TABLE Reunion (id INTEGER, Fecha VARCHAR(10), Tipo VARCHAR(50), hInicio INTEGER, mInicio INTEGER, hfinal INTEGER, mfinal INTEGER, Duracion INTEGER, Lugar VARCHAR(30))";
            sentencia.execute(sql);

            sql = "CREATE TABLE RelacionUsuarioReunion (idReunion INTEGER, idUsuario INTEGER, Tipo VARCHAR(10))";
            sentencia.execute(sql);

            sql = "CREATE TABLE Documento (id INTEGER,Fecha VARCHAR(10), Ruta VARCHAR(80), Tipo VARCHAR(25))";
            sentencia.execute(sql);

            sql = "CREATE TABLE RelacionDocumentoReunion (idReunion INTEGER, idDocumento INTEGER)";
            sentencia.execute(sql);
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * cierra la conexion a la base de datos
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    /*
    *   USUARIO
     */

    /**
     * busca un determinado usuario según su campo id
     * @param id el campo id del usuario
     * @return el usuario si existe, null en caso contrario
     */

    public Usuario buscarUsuario(int id) {
        PreparedStatement sentencia;

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_USUARIO_ID);

            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            return procesarUsuario(resultado);
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return null;
    }

    /**
     *busca un determinado usuario según su campo dNI
     * @param dni el campo dni del usuario
     * @return el usuario si existe, null en caso contrario
     */
    public Usuario buscarUsuario(String dni) {

        PreparedStatement sentencia;

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_USUARIO);

            sentencia.setString(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            return procesarUsuario(resultado);
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return null;
    }
/*
    * devuelve un objeto usaurio a partir del resutlado de una búsqueda que lo contiene
    */
    private Usuario procesarUsuario(ResultSet resultado) {

        try {
            if (resultado.next()) {
                return new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("dni"),
                        resultado.getString("Nombre"),
                        resultado.getString("Apellido1"),
                        resultado.getString("Apellido2"),
                        resultado.getString("Direccion"),
                        resultado.getString("Poblacion"),
                        resultado.getString("Provincia"),
                        resultado.getString("Telefono1"),
                        resultado.getString("Telefono2"),
                        resultado.getString("Email"),
                        resultado.getString("Cargo"),
                        resultado.getString("Sindicato"),
                        resultado.getString("Tipo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * inserta un usuario en el sistema si no existe previamente
     * @param usuario el usuario a insertar
     * @return true si la inserción ha tenido éxito, false si el usuario ya existía
     */
    public boolean insertarUsuario(Usuario usuario) {

        PreparedStatement sentencia;
        try {

            if (buscarUsuario(usuario.getDni()) != null) {
                return false;
            }

            sentencia = conexion.prepareStatement(SQL_INSERTAR_USUARIO);
            sentencia.setInt(1, usuario.getId());
            sentencia.setString(2, usuario.getDni());
            sentencia.setString(3, usuario.getNombre());
            sentencia.setString(4, usuario.getAp1());
            sentencia.setString(5, usuario.getAp2());
            sentencia.setString(6, usuario.getDir());
            sentencia.setString(7, usuario.getPob());
            sentencia.setString(8, usuario.getProv());
            sentencia.setString(9, usuario.getTel1());
            sentencia.setString(10, usuario.getTel2());
            sentencia.setString(11, usuario.getEmail());
            sentencia.setString(12, usuario.getCargo());
            sentencia.setString(13, usuario.getSind());
            sentencia.setString(14, usuario.getTipo());
            sentencia.setString(15, "T");

            sentencia.execute();
            sentencia.close();

            return true;

        } catch (SQLException ex) {

            System.out.println("Error al insertar usuario " + usuario.getDni());
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * da de baja al usuario del sistema
     * @param usuario el usuario al que da de baja
     * @return true si se encontró al usuaio, false en caso contrario
     */
    public boolean bajaUsuario(Usuario usuario) {
        try {
            if (buscarUsuario(usuario.getDni()) == null) {
                return false;
            }
            PreparedStatement sentencia = conexion.prepareStatement(SQL_BAJA_USUARIO);

            sentencia.setString(1, "F");
            sentencia.setInt(2, usuario.getId());
            sentencia.execute();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * elimina permanentemente el usuario del sistema
     * @param usuario el usuario a eliminar
     * @return true si se encontró al usuaio, false en caso contrario
     */
    public boolean eliminarUsuario(Usuario usuario) {
        try {
            if (buscarUsuario(usuario.getDni()) == null) {
                return false;
            }
            PreparedStatement sentencia = conexion.prepareStatement(SQL_BORRAR_USUARIO);

            sentencia.setString(1, usuario.getDni());
            sentencia.execute();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * busca todos lo usuario que pertenecen al sindicato indicado
     * @param valor el sindicato por el que filtrar
     * @return listado de los usuarios que cumplen los requisitos
     */
    public ArrayList<Usuario> buscarUsuariosSindicato(String valor) {
        PreparedStatement sentencia;
        ArrayList<Usuario> filtro = new ArrayList();

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_USUARIO_SINDICATO);

            sentencia.setString(1, valor);
            sentencia.setString(2, "T");
            ResultSet resultado = sentencia.executeQuery();
            Usuario usuario = procesarUsuario(resultado);

            while (usuario != null) {
                filtro.add(usuario);
                usuario = procesarUsuario(resultado);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return filtro;
    }

    /*
    *   REUNION
     */

    /**
     * inserta una nueva relación en el sistema entre un usuario y una reunión al que está asociado
     * @param idReunion identificador de la reunión a la que vincular el usuario
     * @param idUsuario identificador del usuario que vincular
     * @param tipo tipo de vinculación entre el usuario y la reunión
     * @return true si se pudo insertar, false si ya se encontraba la relación
     */

    public boolean insertarReunionUsuario(int idReunion, int idUsuario, String tipo) {

        PreparedStatement sentencia;

        try {
            if (existeRelacion(idReunion, idUsuario, tipo)) {
                return false;
            }
            sentencia = conexion.prepareStatement(SQL_INSERTAR_RELACION_REUNION_USUARIO);

            sentencia.setInt(1, idReunion);
            sentencia.setInt(2, idUsuario);
            sentencia.setString(3, tipo);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return true;
    }

    /**
     * indica si le reunión y el usuario proporcionados ya se encuentran en el sistema
     * @param idReunion identificador de la reunión
     * @param idUsuario identificador del usuario
     * @param tipo tipo de relación que se busca
     * @return true si existe, false en caso contrario
     */
    public boolean existeRelacion(int idReunion, int idUsuario, String tipo) {
        PreparedStatement sentencia;

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_RELACION_REUNION_USUARIO);  
            if (tipo == null) {
              sentencia = conexion.prepareStatement( "SELECT * FROM RelacionUsuarioReunion WHERE idReunion = ? AND idUsuario = ?");
            } else {
                sentencia.setString(3, tipo);
            }
            sentencia.setInt(1, idReunion);
            sentencia.setInt(2, idUsuario);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;
    }
    
    /*
    * Devuelve todas las reuniones de un tipo concreto
    */

  protected  List<Reunion> buscarReunionTipo(String tipo) {
        ArrayList<Reunion> lista = new ArrayList();

        try {
            PreparedStatement sentencia;

            if (tipo.equalsIgnoreCase("Todas")) {
                sentencia = conexion.prepareStatement(SQL_CONSULTAR_TODAS_REUNIONES);
            } else {
                sentencia = conexion.prepareStatement(SQL_CONSULTAR_REUNION_TIPO);
                sentencia.setString(1, tipo);
            }
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                lista.add(buscarReunion(id));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    /**
     * busca la reunión con el identificador proporcionado
     * @param idReunion el identificador dela reunión a buscar
     * @return la reunión buscada si existe o null en caso contrario
     */
    public Reunion buscarDatosReunion(int idReunion) {
        PreparedStatement sentencia;

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_REUNION);
            sentencia.setInt(1, idReunion);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return new Reunion(
                        idReunion,
                        resultado.getString("Tipo"),
                        resultado.getString("Fecha"),
                        resultado.getInt("hInicio"),
                        resultado.getInt("mInicio"),
                        resultado.getInt("hFinal"),
                        resultado.getInt("mFinal"),
                        resultado.getInt("duracion"),
                        resultado.getString("Lugar")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;
    }

    /**
     * devuelve un listado con todos los participantes de la reunión indicada
     * @param idReunion el identificador de la reunión
     * @return listado con los participantes
     */
    public ArrayList<Usuario> participantesReunion(int idReunion) {
        PreparedStatement sentencia;
        ArrayList<Usuario> participantes = new ArrayList();
        try {

            sentencia = conexion.prepareStatement(SQL_CONSULTAR_PARTICIPANTES_REUNION);
            sentencia.setInt(1, idReunion);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Usuario usuario = buscarUsuario(resultado.getInt("idUsuario"));
                if (usuario != null) {
                    participantes.add(usuario);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return participantes;
    }
    /*
    * busca una reunión a partir de su identificador
    */

    private Reunion buscarReunion(int idReunion) {
        PreparedStatement sentencia;
        ArrayList<Usuario> participantesSindicatos = new ArrayList();
        ArrayList<Usuario> participantesEmpresa = new ArrayList();
        ArrayList<Usuario> asesores = new ArrayList();
        Usuario secretario = null;

        try {

            sentencia = conexion.prepareStatement(SQL_CONSULTAR_PARTICIPANTES_REUNION);
            sentencia.setInt(1, idReunion);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Usuario usuario = buscarUsuario(resultado.getInt("idUsuario"));
                if (usuario != null) {
                    switch (resultado.getString("Tipo")) {
                        case "Sindicato":
                            participantesSindicatos.add(usuario);
                            break;
                        case "Empresa":
                            participantesEmpresa.add(usuario);
                            break;
                        case "Asesor":
                            asesores.add(usuario);
                            break;
                        case "Secretario":
                            secretario = usuario;
                            break;
                    }
                }

            }
            Reunion reunion = buscarDatosReunion(idReunion);
            reunion.setDatos(participantesSindicatos, participantesEmpresa, asesores, secretario);
            return reunion;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * inserta una reunión en el sistema si no se encontraba ya
     * @param reunion la reunión a insertar
     * @return true si se pudo insertar, false en caso contrario
     */
    public boolean insertarReunion(Reunion reunion) {

        PreparedStatement sentencia;
        try {

            if (buscarDatosReunion(reunion.getId()) != null) {
                return false;
            }

            sentencia = conexion.prepareStatement(SQL_INSERTAR_REUNION);
            sentencia.setInt(1, reunion.getId());
            sentencia.setString(2, reunion.getFecha());
            sentencia.setString(3, reunion.getTipo());
            sentencia.setInt(4, reunion.getHoraInicio());
            sentencia.setInt(5, reunion.getMinutoInicio());
            sentencia.setInt(6, reunion.getHoraFin());
            sentencia.setInt(7, reunion.getMinutoFin());
            sentencia.setInt(8, reunion.getDuracion());
            sentencia.setString(9, reunion.getLugar());

            sentencia.execute();
            sentencia.close();

            for (Usuario usuario : reunion.getParticipantesSindicatos()) {
                insertarReunionUsuario(reunion.getId(), usuario.getId(), "Sindicato");
            }
            for (Usuario usuario : reunion.getAsesores()) {
                insertarReunionUsuario(reunion.getId(), usuario.getId(), "Asesor");
            }
            for (Usuario usuario : reunion.getParticipantesEmpresa()) {
                insertarReunionUsuario(reunion.getId(), usuario.getId(), "Empresa");
            }

            insertarReunionUsuario(reunion.getId(), reunion.getSecretario().getId(), "Secretario");

            return true;

        } catch (SQLException ex) {

            System.out.println("Error al insertar usuario " + reunion.getId());
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * vincula un usuario a una reunión
     * @param idUsuario identificador del usuario
     * @param idReunion identificador de la reunión
     */
    public void vincular(int idUsuario, int idReunion) {

        try {
            if (!(existeRelacion(idReunion, idUsuario, null))) {

                PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERTAR_RELACION_REUNION_USUARIO);

                sentencia.setInt(2, idUsuario);
                sentencia.setInt(1, idReunion);
sentencia.setString(3, "");
                sentencia.execute();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * desvincula un usuario de una reunión
     * @param idUsuario identificador del usuario
     * @param idReunion identificador de la reunión
     */
    public void desvincular(int idUsuario, int idReunion) {

        try {
            if (!(existeRelacion(idReunion, idUsuario, null))) {

                PreparedStatement sentencia = conexion.prepareStatement(SQL_BORRAR_RELACION_REUNION_USUARIO);

                sentencia.setInt(1, idUsuario);
                sentencia.setInt(2, idReunion);
                sentencia.execute();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * elimina una reunión del sistema
     * @param reunion la reunión a eliminar
     * @return true si se encontró, false en caso contrario
     */
    public boolean eliminarReunion(Reunion reunion) {
        try {
            if (buscarReunion(reunion.getId()) == null) {
                return false;
            }
            PreparedStatement sentencia = conexion.prepareStatement(SQL_BORRAR_REUNION);

            sentencia.setInt(1, reunion.getId());
            sentencia.execute();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    /*
    *   Documento
     */

    /**
     * inserta un documento en el sistema
     * @param documento el documento a insertar
     * @return true si se pudo insertar, false en caso contrario
     */

    public boolean insertarDocumento(Documento documento) {
        PreparedStatement sentencia;
        try {

            if (buscarDocumento(documento.getId()) != null) {
                return false;
            }

            sentencia = conexion.prepareStatement(SQL_INSERTAR_DOCUMENTO);
            sentencia.setInt(1, documento.getId());
            sentencia.setString(2, documento.getFecha());
            sentencia.setString(3, documento.getRuta());
            sentencia.setString(4, documento.getTipo());

            sentencia.execute();
            sentencia.close();
            return true;
        } catch (SQLException ex) {

            System.out.println("Error al insertar usuario " + documento.getId());
            ex.printStackTrace();

        }
        return false;
    }

    /**
     * asocia un documento a una reunión
     * @param documento el documento a vincular
     * @param idReunion la reunión donde vincular el documento
     */
    public void insertarRelacionDocumentoReunion(Documento documento, int idReunion) {
        insertarDocumento(documento);
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(SQL_INSERTAR_RELACION_REUNION_DOCUMENTO);//r d
            sentencia.setInt(1, idReunion);
            sentencia.setInt(2, documento.getId());
            sentencia.execute();
            sentencia.close();

        } catch (SQLException ex) {

            System.out.println("Error al insertar documento " + documento.getId());
            ex.printStackTrace();

        }
    }

    /**
     * busca un documento a partir de su identificador
     * @param id el identificador del documento
     * @return el documento si se encontró, null en caso contrario
     */
    public Documento buscarDocumento(int id) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_DOCUMENTO);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return new Documento(id,
                        resultado.getString("Tipo"),
                        resultado.getString("Ruta"),
                        resultado.getString("Fecha")
                );
            }

        } catch (SQLException ex) {

            System.out.println("Error al insertar usuario " + id);
            ex.printStackTrace();

        }
        return null;
    }

    /**
     * busca todos los documentos asociados a una determinada reunión
     * @param idReunion el identificador de la reunión 
     * @return los documentos asociados a la reunión
     */
    public ArrayList<Documento> buscarDocumentosReunion(int idReunion) {
        ArrayList<Documento> lista = new ArrayList();
        PreparedStatement sentencia;

        try {
            sentencia = conexion.prepareStatement(SQL_CONSULTAR_DOCUMENTOS_REUNION);
            sentencia.setInt(1, idReunion);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Documento doc = buscarDocumento(resultado.getInt("idDocumento"));
                if (doc != null) {
                    lista.add(doc);
                }
            }
        } catch (SQLException ex) {

            System.out.println("Error al buscar documento" + idReunion);
            ex.printStackTrace();

        }
        return lista;
    }

    void execute(String sql) throws SQLException {
     
            conexion.createStatement().execute(sql);

    }

}
