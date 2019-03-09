/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import gob.peam.administracion.beans.Usuario;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author jprada
 */
public class NotaPrensa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String anho;
    private String titulo;
    private String fuente = "Proyecto Especial Alto Mayo";
    private String fecha;
    private String foto;
    private String contenido = "";
    private boolean estado;
    private Integer usuario;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    

    public NotaPrensa() {
    }

    public NotaPrensa(Integer id, String anho, String titulo, String fecha, String foto, boolean estado, Integer usuario, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.anho = anho;
        this.titulo = titulo;
        this.fecha = fecha;
        this.foto = foto;
        this.estado = estado;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    
    
}
