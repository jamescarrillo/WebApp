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
public class Anuncio implements Serializable{
    private Integer anuId;
    private String anuFechaInicio;
    private String anuFechaFin;
    private Integer tipo;
    private String titulo;
    private String contenido;
    private Boolean estado;

    public Anuncio() {
    }

    public Anuncio(Integer anuId, String anuFechaInicio, String anuFechaFin, Integer tipo, String titulo, String contenido, Boolean estado) {
        this.anuId = anuId;
        this.anuFechaInicio = anuFechaInicio;
        this.anuFechaFin = anuFechaFin;
        this.tipo = tipo;
        this.titulo = titulo;
        this.contenido = contenido;
        this.estado = estado;
    }

    public String getAnuFechaFin() {
        return anuFechaFin;
    }

    public void setAnuFechaFin(String anuFechaFin) {
        this.anuFechaFin = anuFechaFin;
    }

    public String getAnuFechaInicio() {
        return anuFechaInicio;
    }

    public void setAnuFechaInicio(String anuFechaInicio) {
        this.anuFechaInicio = anuFechaInicio;
    }

    public Integer getAnuId() {
        return anuId;
    }

    public void setAnuId(Integer anuId) {
        this.anuId = anuId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
