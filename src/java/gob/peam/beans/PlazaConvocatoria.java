/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author jprada
 */
public class PlazaConvocatoria {
    private Integer puesId;
    private String cargo;
    private String entidad;
    private String modalidad;
    private Integer nroPlaza;
    private String ingreMensual;
    private Boolean estado;
    private Integer coperId;

    public PlazaConvocatoria() {
    }

    public PlazaConvocatoria(Integer puesId, String cargo, String entidad, String modalidad, Integer nroPlaza, String ingreMensual, Boolean estado, Integer coperId) {
        this.puesId = puesId;
        this.cargo = cargo;
        this.entidad = entidad;
        this.modalidad = modalidad;
        this.nroPlaza = nroPlaza;
        this.ingreMensual = ingreMensual;
        this.estado = estado;
        this.coperId = coperId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCoperId() {
        return coperId;
    }

    public void setCoperId(Integer coperId) {
        this.coperId = coperId;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIngreMensual() {
        return ingreMensual;
    }

    public void setIngreMensual(String ingreMensual) {
        this.ingreMensual = ingreMensual;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getNroPlaza() {
        return nroPlaza;
    }

    public void setNroPlaza(Integer nroPlaza) {
        this.nroPlaza = nroPlaza;
    }

    public Integer getPuesId() {
        return puesId;
    }

    public void setPuesId(Integer puesId) {
        this.puesId = puesId;
    }
    
    
}
