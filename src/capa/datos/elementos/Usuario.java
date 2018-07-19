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
public class Usuario {
    
    private static int idUsuarios=0;
    private int id;
    
    private String dni,  nombre,  ap1, ap2,  dir,  pob,  prov,  tel1,
             tel2,  email,  cargo,  sind, tipo;

    /**
     * Crea un nuevo usuario a aprtir de todos sus campos
     * @param id
     * @param dni
     * @param nombre
     * @param ap1
     * @param ap2
     * @param dir
     * @param pob
     * @param prov
     * @param tel1
     * @param tel2
     * @param email
     * @param cargo
     * @param sind
     * @param tipo
     */
    public Usuario(int id, String dni, String nombre, String ap1, String ap2, String dir, String pob, String prov, String tel1, String tel2, String email, String cargo, String sind, String tipo) {
        this(dni,  nombre,  ap1, ap2,  dir,  pob,  prov,  tel1, tel2,  email,  cargo,  sind, tipo);
        this.id= id;
        }
    
    /**
     * Crea un nuevo usuario y le asigna un id automático
     * @param dni
     * @param nombre
     * @param ap1
     * @param ap2
     * @param dir
     * @param pob
     * @param prov
     * @param tel1
     * @param tel2
     * @param email
     * @param cargo
     * @param sind
     * @param tipo
     */
    public Usuario(String dni, String nombre, String ap1, String ap2, String dir, String pob, String prov, String tel1, String tel2, String email, String cargo, String sind, String tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.dir = dir;
        this.pob = pob;
        this.prov = prov;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.email = email;
        this.cargo = cargo;
        this.sind = sind;
        this.tipo = tipo;
        id =++idUsuarios;
    }

    /**
     *
     * @return
     */
    public static int getIdUsuarios() {
        return idUsuarios;
    }

    /**
     *
     * @param id
     */
    public static void setIdUsuarios(int id) {
        idUsuarios = id;
    }

    /**
     *
     * @return
     */
    public int getId(){
    return id;
    
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
    public String getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getAp1() {
        return ap1;
    }

    /**
     *
     * @param ap1
     */
    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    /**
     *
     * @return
     */
    public String getAp2() {
        return ap2;
    }

    /**
     *
     * @param ap2
     */
    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    /**
     *
     * @return
     */
    public String getDir() {
        return dir;
    }

    /**
     *
     * @param dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     *
     * @return
     */
    public String getPob() {
        return pob;
    }

    /**
     *
     * @param pob
     */
    public void setPob(String pob) {
        this.pob = pob;
    }

    /**
     *
     * @return
     */
    public String getProv() {
        return prov;
    }

    /**
     *
     * @param prov
     */
    public void setProv(String prov) {
        this.prov = prov;
    }

    /**
     *
     * @return
     */
    public String getTel1() {
        return tel1;
    }

    /**
     *
     * @param tel1
     */
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    /**
     *
     * @return
     */
    public String getTel2() {
        return tel2;
    }

    /**
     *
     * @param tel2
     */
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return
     */
    public String getSind() {
        return sind;
    }

    /**
     *
     * @param sind
     */
    public void setSind(String sind) {
        this.sind = sind;
    }

    /**
     *
     * @return
     */
    public String getNombreCompleto() {
    return nombre+" "+ap1;
    }
    
    /**
     *
     * @return
     */
    public boolean esSindicalista(){
        return !sind.equalsIgnoreCase("Empresa");
    }
    
    @Override
    public boolean equals(Object otro){
        return dni.equalsIgnoreCase(((Usuario)otro).getDni());
    }
    
}
