/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

public class CalendarioConvocatoria implements Serializable{
    private Integer Id;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean estado;
    private Integer convoId;
    private Integer actiId;
    private Actividad actividad;
    
    public CalendarioConvocatoria() {
    }

    public CalendarioConvocatoria(Integer Id, Date fechaInicio, Date fechaFin, Boolean estado, Integer convoId, Integer actiId, Actividad actividad) {
        this.Id = Id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.convoId = convoId;
        this.actiId = actiId;
        this.actividad = actividad;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getActiId() {
        return actiId;
    }

    public void setActiId(Integer actiId) {
        this.actiId = actiId;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Integer getConvoId() {
        return convoId;
    }

    public void setConvoId(Integer convoId) {
        this.convoId = convoId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

}
