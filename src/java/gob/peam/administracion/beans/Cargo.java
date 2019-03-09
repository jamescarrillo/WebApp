package gob.peam.administracion.beans;

import java.io.Serializable;

public class Cargo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6770049465917642189L;
    private Integer idCargo;
    private Persona responsable;
    private boolean estado;
    private Dependencia dependencia;

    public Cargo() {
    }

    public Cargo(Integer idCargo, Persona responsable, boolean estado,
            Dependencia dependencia) {
        this.idCargo = idCargo;
        this.responsable = responsable;
        this.estado = estado;
        this.dependencia = dependencia;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
}
