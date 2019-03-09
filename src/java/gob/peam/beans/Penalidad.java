/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author alabajos
 */
public class Penalidad {

    private Integer id;
    private String anho;
    private String montoContrato;
    private String contratista;
    private String ruc;
    private String objeto;
    private String nroProceso;
    private String nroContrato;
    private String tipo;
    private String montoPenalidad;

    public Penalidad() {
    }

    public Penalidad(Integer id, String anho, String montoContrato, String contratista, String ruc, String objeto, String nroProceso, String nroContrato, String tipo, String montoPenalidad) {
        this.id = id;
        this.anho = anho;
        this.montoContrato = montoContrato;
        this.contratista = contratista;
        this.ruc = ruc;
        this.objeto = objeto;
        this.nroProceso = nroProceso;
        this.nroContrato = nroContrato;
        this.tipo = tipo;
        this.montoPenalidad = montoPenalidad;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMontoContrato() {
        return montoContrato;
    }

    public void setMontoContrato(String montoContrato) {
        this.montoContrato = montoContrato;
    }

    public String getMontoPenalidad() {
        return montoPenalidad;
    }

    public void setMontoPenalidad(String montoPenalidad) {
        this.montoPenalidad = montoPenalidad;
    }

    public String getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(String nroContrato) {
        this.nroContrato = nroContrato;
    }

    public String getNroProceso() {
        return nroProceso;
    }

    public void setNroProceso(String nroProceso) {
        this.nroProceso = nroProceso;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
