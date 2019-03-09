/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author jprada
 */
public class Publicacion {
    private Integer Id;
    private String anho;
    private String titulo;
    private String descripcion;
    private String direccionArchivo;
    private Integer tipo;
    private Boolean estado;
    private Integer docuId;

    public Publicacion() {
    }

    public Publicacion(Integer Id, String anho, String titulo, String descripcion, String direccionArchivo, Integer tipo, Boolean estado, Integer docuId) {
        this.Id = Id;
        this.anho = anho;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccionArchivo = direccionArchivo;
        this.tipo = tipo;
        this.estado = estado;
        this.docuId = docuId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionArchivo() {
        return direccionArchivo;
    }

    public void setDireccionArchivo(String direccionArchivo) {
        this.direccionArchivo = direccionArchivo;
    }

    public Integer getDocuId() {
        return docuId;
    }

    public void setDocuId(Integer docuId) {
        this.docuId = docuId;
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
