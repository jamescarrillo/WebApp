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
public class Agenda implements Serializable {

    private static final long serialVersionUID = 4705082063811979496L;
    private Integer id;
    private String fechaInicio;
    private String horaInicio;
    private String horaFinal;
    private String actividad;
    private String ciudad;
    private String lugar;
    private Integer tipo;
    private boolean estado;

    public Agenda() {
    }

    public Agenda(Integer id, String fechaInicio, String horaInicio, String horaFinal, String actividad, String ciudad, String lugar, Integer tipo, boolean estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.actividad = actividad;
        this.ciudad = ciudad;
        this.lugar = lugar;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
