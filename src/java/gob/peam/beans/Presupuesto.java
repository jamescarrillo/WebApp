/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author jprada
 */
public class Presupuesto {
    private Integer id;
    private String anho;
    private String titulo;
    private String descripcion;
    private String resolucionAprobacion="";
    private String fechaAprobacion;
    private String ubicacion;
    private Integer Tipo;
    private Integer docuId;
    private Boolean estado;
   

    public Presupuesto() {
    }

    public Presupuesto(Integer id, String anho, String titulo, String descripcion, String fechaAprobacion, String ubicacion, Integer Tipo, Integer docuId, Boolean estado) {
        this.id = id;
        this.anho = anho;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaAprobacion = fechaAprobacion;
        this.ubicacion = ubicacion;
        this.Tipo = Tipo;
        this.docuId = docuId;
        this.estado = estado;
    }

    public Integer getTipo() {
        return Tipo;
    }

    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
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

    public String getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(String fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResolucionAprobacion() {
        return resolucionAprobacion;
    }

    public void setResolucionAprobacion(String resolucionAprobacion) {
        this.resolucionAprobacion = resolucionAprobacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}