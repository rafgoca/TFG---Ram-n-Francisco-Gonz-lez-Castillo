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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramón Francisco González Castillo
 */
public class DatosSesion {

    private static DatosSesion instancia;

    private static Connection conexion;
   static String ruta;

   /*
   * patrón singleton
   */
    private DatosSesion() {
        ruta = Rutas.sesion;
        registrarBD();
        conectarConBD();
           
    }

    /**
     *
     * @return
     */
    public static DatosSesion get() {
        if (instancia == null) {
            instancia = new DatosSesion();
        }
        return instancia;
    }

    /*
    * registra el driver para acceder a la bd
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
/*
    * abre la base de datos apropiada
    */
    private boolean conectarConBD() {
        boolean resultado;
        try {
            ruta = Rutas.sesion;
        //   ruta = "C:\\temp\\sesion";
            conexion = DriverManager.getConnection("jdbc:derby:"+ruta, "root", "12345");
            System.out.println("Conexión con base de datos");
            resultado = true;
        } catch (SQLException ex) {
            System.out.println("Error al conectar con base de datos: " + ex);
            resultado = false;
        }
        return resultado;
    }

    /**
     * devuelve la lista de sindicatos disponible para la interfaz
     * @return el listado de los sindicatos disponibles
     */
    public String[] sindicatos() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM Sindicatos";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
    }

      /**
     * devuelve la lista de tipos de documento disponible para la interfaz
     * @return el listado de los tipos de documento disponibles
     */
    public String[] tiposDoc() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM TiposDocumento";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
    }

     /**
     * devuelve la lista de tipos de usuario disponible para la interfaz
     * @return el listado de los tipos de usuario disponibles
     */
    public String[] getTiposUsuario() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM TiposUsuario";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
    }
    
       /**
     * devuelve la lista de tipos de usuario de empresa para la interfaz
     * @return el listado de los tipos de reunión disponibles
     */
  String[] getTiposEmpresa() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM TiposEmpresa";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
  }
    /**
     * devuelve la lista de tipos de reunión disponible para la interfaz
     * @return el listado de los tipos de reunión disponibles
     */
    public String[] getTiposReunion() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM TiposReunion";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
    }
    
     public String[] getUsuarios() {
        ArrayList<String> lista = new ArrayList();
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "SELECT * FROM Usuarios";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] a = new String[lista.size()];
        return lista.toArray(a);
    }

    /**
     * comprueba si el usuario tiene privilegios para acceder a la aplicación
     * @param nombre nombre del usuario
     * @param pass contraseña del usuario
     * @return true si ambos campos pertenecen a los usuarios registrados, false en caso contrario
     */
    public boolean login(String nombre, String pass) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM Usuarios WHERE Nombre= ?");

            sentencia.setString(1, nombre);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {

                if (resultado.getString("Pass").equalsIgnoreCase(pass)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * inserta un nuevo usuario en el sistema
     * @param id identificador del usuario
     * @param nombre nombre del usuario
     * @param pass clave del usuario
     */
    public void insertarUsuario(int id, String nombre, String pass) {
        try {

            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO Usuarios VALUES (?,?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(3, nombre);
            sentencia.setString(2, pass);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarSindicato(int id, String nombre) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO Sindicatos VALUES (?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarTipoDoc(int id, String nombre) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO TiposDocumento VALUES (?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarTipoUsuario(int id, String nombre) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO TiposUsuario VALUES (?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void insertarTipoEmpresa(int id, String nombre) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO TiposEmpresa VALUES (?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertarTipoReunion(int id, String nombre) {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO TiposReunion VALUES (?,?)");

            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarContador(int id, int c, String nombre) {
        try {

            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO Contadores VALUES (?,?,?)");

            sentencia.setInt(1, id);
            sentencia.setInt(2, c);
            sentencia.setString(3, nombre);

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * crea la estructura de las tablas de la base de datos
     * @param args
     */
    public static void main(String[] args) throws SQLException {
        new DatosSesion().crearTablas();
        //    new DatosSesion().insertarUsuario(0,"admin","12345");
      //  new DatosSesion().temp();
    }
  /**
     * crea la estructura de las tablas de la base de datos
     * 
     */
    private void crearTablas() {
        try {
            String sql;
            Statement sentencia = conexion.createStatement();

            sql = "CREATE TABLE Usuarios (id INTEGER, Pass VARCHAR(30), Nombre VARCHAR(30))";
            sentencia.execute(sql);

            sql = "CREATE TABLE Sindicatos (id INTEGER, Nombre VARCHAR(10))";
            sentencia.execute(sql);

            sql = "CREATE TABLE Contadores (id INTEGER, Contador INTEGER, Nombre VARCHAR(10))";
            sentencia.execute(sql);

            sql = "CREATE TABLE TiposDocumento (id INTEGER, Nombre VARCHAR(25))";
            sentencia.execute(sql);

             sql = "CREATE TABLE TiposEmpresa (id INTEGER, Nombre VARCHAR(25))";
            sentencia.execute(sql); 
            
            sql = "CREATE TABLE TiposUsuario (id INTEGER, Nombre VARCHAR(25))";
            sentencia.execute(sql);

            sql = "CREATE TABLE TiposReunion (id INTEGER, Nombre VARCHAR(25))";
            sentencia.execute(sql);
            iniciarDatosDefecto();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void temp() throws SQLException{
      String sql;
            Statement sentencia = conexion.createStatement();

            sql = "CREATE TABLE TiposEmpresa (id INTEGER, Nombre VARCHAR(25))";
            sentencia.execute(sql);  
    }
/*
    * inicia la base de datos con los valores por defecto
    */
    private void iniciarDatosDefecto() {
        insertarUsuario(0, "admin", "12345");

        insertarSindicato(0, "CCOO");
        insertarSindicato(1, "CGT");
        insertarSindicato(2, "SFP");
        insertarSindicato(3, "UGT");

        insertarContador(0, 0, "Usuario");
        insertarContador(1, 0, "Reunion");
        insertarContador(2, 0, "Documento");

        insertarTipoDoc(0, "Orden del día");
        insertarTipoDoc(1, "Informe");
        insertarTipoDoc(2, "Acta Firmada");
        insertarTipoDoc(3, "Acta sin Firmar");
        insertarTipoDoc(4, "Comisión de garantías");
        insertarTipoDoc(5, "Comisión Mixta");
        insertarTipoDoc(6, "Convenio");

        insertarTipoUsuario(0, "Delegado");
        insertarTipoUsuario(1, "Delegado LOLS");
        insertarTipoUsuario(2, "Administrador");

        insertarTipoReunion(0, "Comité unitario");
        insertarTipoReunion(1, "MGN");
        insertarTipoReunion(2, "Todas");
    }

    /**
     * inicializa las variables del sistema con los de la última ejecución de éste
     */
    public void recuperarDatosSesion() {
        try {

            PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM Contadores WHERE Nombre = ?");

            sentencia.setString(1, "Usuario");

            ResultSet resultado = sentencia.executeQuery();
            resultado.next();
            Usuario.setIdUsuarios(resultado.getInt("Contador"));

            sentencia.setString(1, "Reunion");

            resultado = sentencia.executeQuery();
            resultado.next();
            Reunion.setIdReuniones(resultado.getInt("Contador"));

            sentencia.setString(1, "Documento");

            resultado = sentencia.executeQuery();
            resultado.next();
            Documento.setIdDocumento(resultado.getInt("Contador"));

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * guarda los datos de la sesión actual
     */
    public void actualizarDatosSesion() {
        try {

            PreparedStatement sentencia = conexion.prepareStatement("UPDATE Contadores SET Contador = ? WHERE Nombre = ?");

            sentencia.setInt(1, Usuario.getIdUsuarios());
            sentencia.setString(2, "Usuario");

            sentencia.execute();

            sentencia.setInt(1, Reunion.getIdReuniones());
            sentencia.setString(2, "Reunion");

            sentencia.execute();
            //docs
            sentencia.setInt(1, Documento.getIdDocumento());
            sentencia.setString(2, "Documento");

            sentencia.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    void execute(String sql) {
        try {
            conexion.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BBDDHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    }

  


