/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;

/**
 *
 * @author jprada
 */
public class Multimedia implements Serializable {

    private static final long serialVersionUID = -1381455005569987035L;
    private Integer id;
    private String titulo;
    private String fuente;
    private String fecha;
    private boolean estado;
    private boolean defecto;
    private Integer usuario;
    

    public Multimedia() {
    }

    public boolean isDefecto() {
        return defecto;
    }

    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Multimedia(Integer id, String titulo, String fuente, String fecha, boolean estado, boolean defecto, Integer usuario) {
        this.id = id;
        this.titulo = titulo;
        this.fuente = fuente;
        this.fecha = fecha;
        this.estado = estado;
        this.defecto = defecto;
        this.usuario = usuario;
    }


}
