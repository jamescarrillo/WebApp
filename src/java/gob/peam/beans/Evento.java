package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mvilchez
 */
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String anho;
    private String titulo;
    private String fecha;
    private String foto;
    private boolean estado;
    private Integer creadoPor;
    private Date fechaCreado;
    private Integer editadoPor;
    private Date fechaEditado;
    private Integer area;
    private String link;

    public Evento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
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
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

   

}
