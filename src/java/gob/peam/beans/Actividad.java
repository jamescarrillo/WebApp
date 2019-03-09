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
public class Actividad implements Serializable{
    private Integer actiId;
    private String descripcion;
    private Boolean estado;
    private Integer actiTipo;
    public Actividad(){};

    public Actividad(Integer actiId, String descripcion, Boolean estado, Integer actiTipo) {
        this.actiId = actiId;
        this.descripcion = descripcion;
        this.estado = estado;
        this.actiTipo = actiTipo;
    }

    public Integer getActiId() {
        return actiId;
    }

    public void setActiId(Integer actiId) {
        this.actiId = actiId;
    }

    public Integer getActiTipo() {
        return actiTipo;
    }

    public void setActiTipo(Integer actiTipo) {
        this.actiTipo = actiTipo;
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
    
}
