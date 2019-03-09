/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

import java.io.Serializable;

/**
 *
 * @author jpgprog84
 */
public class Rol implements Serializable {

    private Integer idRol;
    private String nombre;
    private Boolean estado;

    public Rol() {
    }

    public Rol(Integer idRol, String nombre, Boolean estado) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
