/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos.elementos;

import java.util.ArrayList;
/**
 *
 * @author Ramón Francisco González Castillo
 */
public class Reunion {

    private static int idReuniones = 0;
    private int id;

    private String tipo; //comité unitario o MGN
    private int horaInicio, minutoInicio;
    private int horaFin, minutoFin;
    private int duracion;

    private String lugar;
    private String fecha;
    private ArrayList<Usuario> participantesSindicatos;
    private ArrayList<Usuario> participantesEmpresa;
    private ArrayList<Usuario> asesores;
    private Usuario secretario;

      /*
    * crea una nueva reunión y le asigna un número de identificador nuevo
    */

    /**
     *
     * @param tipo
     * @param fecha
     * @param horaInicio
     * @param minutoInicio
     * @param horaFin
     * @param minutoFin
     * @param duracion
     * @param lugar
     */

    public Reunion(String tipo, String fecha, int horaInicio, int minutoInicio, int horaFin, int minutoFin, int duracion, String lugar) {
        this(++idReuniones, tipo, fecha, horaInicio, minutoInicio, horaFin, minutoFin, duracion, lugar);

    }

    /**
     *
     * @return
     */
    public static int getIdReuniones() {
        return idReuniones;
    }

    /**
     *
     * @param idReuniones
     */
    public static void setIdReuniones(int idReuniones) {
        Reunion.idReuniones = idReuniones;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }
/*
    * crea una reunión a partir de todos los datos del mismo
    */

    /**
     *
     * @param id
     * @param tipo
     * @param fecha
     * @param horaInicio
     * @param minutoInicio
     * @param horaFin
     * @param minutoFin
     * @param duracion
     * @param lugar
     */

    public Reunion(int id, String tipo, String fecha, int horaInicio, int minutoInicio, int horaFin, int minutoFin, int duracion, String lugar) {
        this.tipo = tipo;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.horaFin = horaFin;
        this.minutoFin = minutoFin;
        this.duracion = duracion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.id = id;
        participantesSindicatos = new ArrayList();
        participantesEmpresa = new ArrayList();
        asesores = new ArrayList();
    }

    /**
     * asocia una serie de participantes a la reunión
     * @param participantesSindicatos lista de participantes de sindicato
     * @param participantesEmpresa lista de participantes de la empresa
     * @param asesores lista de participantes asesores
     * @param secretario secretario de la reunión
     */
    public void setDatos(ArrayList<Usuario> participantesSindicatos, ArrayList<Usuario> participantesEmpresa, ArrayList<Usuario> asesores, Usuario secretario) {
        this.participantesSindicatos = participantesSindicatos;
        this.participantesEmpresa = participantesEmpresa;
        this.asesores = asesores;
        this.secretario = secretario;
    }

    /**
     *
     * @return
     */
    public String getInicio() {
        return "" + horaInicio + ":" + minutoInicio;
    }

    /**
     *
     * @return
     */
    public String getFinal() {
        return "" + horaFin + ":" + minutoFin;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public int getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @param horaInicio
     */
    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     *
     * @return
     */
    public int getMinutoInicio() {
        return minutoInicio;
    }

    /**
     *
     * @param minutoInicio
     */
    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    /**
     *
     * @return
     */
    public int getHoraFin() {
        return horaFin;
    }

    /**
     *
     * @param horaFin
     */
    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    /**
     *
     * @return
     */
    public int getMinutoFin() {
        return minutoFin;
    }

    /**
     *
     * @param minutoFin
     */
    public void setMinutoFin(int minutoFin) {
        this.minutoFin = minutoFin;
    }

    /**
     *
     * @return
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return
     */
    public String getLugar() {
        return lugar;
    }

    /**
     *
     * @param lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     *
     * @return
     */
    public ArrayList<Usuario> getParticipantesSindicatos() {
        return participantesSindicatos;
    }

    /**
     *
     * @param participantesSindicatos
     */
    public void setParticipantesSindicatos(ArrayList<Usuario> participantesSindicatos) {
        this.participantesSindicatos = participantesSindicatos;
    }

    /**
     *
     * @return
     */
    public ArrayList<Usuario> getParticipantesEmpresa() {
        return participantesEmpresa;
    }

    /**
     *
     * @param participantesEmpresa
     */
    public void setParticipantesEmpresa(ArrayList<Usuario> participantesEmpresa) {
        this.participantesEmpresa = participantesEmpresa;
    }

    /**
     *
     * @return
     */
    public ArrayList<Usuario> getAsesores() {
        return asesores;
    }

    /**
     *
     * @param asesores
     */
    public void setAsesores(ArrayList<Usuario> asesores) {
        this.asesores = asesores;
    }

    /**
     *
     * @return
     */
    public Usuario getSecretario() {
        return secretario;
    }

    /**
     *
     * @param secretario
     */
    public void setSecretario(Usuario secretario) {
        this.secretario = secretario;
    }

    /**
     * genera una estructura html con una tabla de los asistentes a la reunión
     * @return el código html con los asistentes
     */
    public String getAsistentes() {

        StringBuilder cadena = new StringBuilder();
        // crea una tabla en html a partir de su código
        cadena.append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"0\" style=\"width:500px;\"><tbody>");

        //para cada asistente genera una fila en la tabla y una columna para cada uno de sus parámetros
        for (Usuario asistente : participantesSindicatos) {
            cadena.append("<tr><td>");
            cadena.append(asistente.getNombreCompleto());
            cadena.append(" (" + asistente.getSind() + ")");
            cadena.append("</td>");
            cadena.append("<td>");
            cadena.append(" (" + asistente.getTipo() + ")");
            cadena.append("</td>");
            cadena.append("</tr>");
        }
        for (Usuario asistente : participantesEmpresa) {
            cadena.append("<tr><td>");
            cadena.append(asistente.getNombreCompleto());
                      cadena.append(" (" + asistente.getSind() + ")");
            cadena.append("</td>");
            cadena.append("<td>");
            cadena.append(" (" + asistente.getTipo() + ")");
            cadena.append("</td>");
            cadena.append("</tr>");
        }
        for (Usuario asistente : asesores) {
            cadena.append("<tr><td>");
            cadena.append(asistente.getNombreCompleto());
           
            cadena.append(" (" + asistente.getSind() + ")");
            cadena.append("</td>");
            cadena.append("<td>");
            cadena.append(" (" + asistente.getTipo() + ")");
            cadena.append("</td>");
            cadena.append("</tr>");
        }

        cadena.append("</tbody></table>");
        
        return cadena.toString();
    }

}
