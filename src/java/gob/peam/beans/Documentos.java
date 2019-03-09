/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import gob.peam.administracion.beans.Usuario;
import java.io.Serializable;

/**
 *
 * @author jprada
 */
public class Documentos implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 425812149382936587L;
    private Integer id;
    private String titulo;
    private String resumen;
    private String descripcion;
    private String fecha;
    private Integer tidoId;
    private String mimeTypes;
    private String origenArchivo;
    private Double version;
    private Boolean estado;
    private Boolean activo;
    private Usuario usuario;
    private String fechaDocx;
    private Integer cateId;
    private String metaData;
    
    public Documentos() {
    }

    public Documentos(Integer id, String titulo, String resumen, String descripcion, String fecha, Integer tidoId, String mimeTypes, String origenArchivo, Double version, Boolean estado, Boolean activo, Usuario usuario, String fechaDocx, Integer cateId, String metaData) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tidoId = tidoId;
        this.mimeTypes = mimeTypes;
        this.origenArchivo = origenArchivo;
        this.version = version;
        this.estado = estado;
        this.activo = activo;
        this.usuario = usuario;
        this.fechaDocx = fechaDocx;
        this.cateId = cateId;
        this.metaData = metaData;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaDocx() {
        return fechaDocx;
    }

    public void setFechaDocx(String fechaDocx) {
        this.fechaDocx = fechaDocx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMimeTypes() {
        return mimeTypes;
    }

    public void setMimeTypes(String mimeTypes) {
        this.mimeTypes = mimeTypes;
    }

    public String getOrigenArchivo() {
        return origenArchivo;
    }

    public void setOrigenArchivo(String origenArchivo) {
        this.origenArchivo = origenArchivo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Integer getTidoId() {
        return tidoId;
    }

    public void setTidoId(Integer tidoId) {
        this.tidoId = tidoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

}
