/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jprada
 */
public class ConvocatoriaPers implements Serializable {
    private Integer coperId;
    private String anho;
    private String convocatoria;
    private String descripcion;
    private Date fecha;
    private Boolean estado;

    public ConvocatoriaPers() {
    }

    public ConvocatoriaPers(Integer coperId, String anho, String convocatoria, String descripcion, Date fecha, Boolean estado) {
        this.coperId = coperId;
        this.anho = anho;
        this.convocatoria = convocatoria;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public Integer getCoperId() {
        return coperId;
    }

    public void setCoperId(Integer coperId) {
        this.coperId = coperId;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
