package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mvilchez
 */
public class Destacado implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String anho;
    private String titulo;
    private String contenido;
    private String fecha;
    private String foto;
    private boolean estado;
    private String url;
    private Integer creadoPor;
    private Date fechaCreado;
    private Integer editadoPor;
    private Date fechaEditado;

    public Destacado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Integer creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public Integer getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Integer editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Date getFechaEditado() {
        return fechaEditado;
    }

    public void setFechaEditado(Date fechaEditado) {
        this.fechaEditado = fechaEditado;
    }

}
