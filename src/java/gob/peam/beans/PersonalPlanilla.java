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
public class PersonalPlanilla implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5715181857183952234L;
	private Integer id;
    private String anho;
    private Integer trimestre;
    private String categoria;
    private String apellidosNombres;
    private String regimenLaboral;
    private String cargo;
    private Double remuneracionMensual;
    private boolean estado;

    public PersonalPlanilla() {
    }

    public PersonalPlanilla(Integer id, String anho, Integer trimestre, String categoria, String apellidosNombres, String regimenLaboral, String cargo, Double remuneracionMensual, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.trimestre = trimestre;
        this.categoria = categoria;
        this.apellidosNombres = apellidosNombres;
        this.regimenLaboral = regimenLaboral;
        this.cargo = cargo;
        this.remuneracionMensual = remuneracionMensual;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        this.apellidosNombres = apellidosNombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegimenLaboral() {
        return regimenLaboral;
    }

    public void setRegimenLaboral(String regimenLaboral) {
        this.regimenLaboral = regimenLaboral;
    }

    public Double getRemuneracionMensual() {
        return remuneracionMensual;
    }

    public void setRemuneracionMensual(Double remuneracionMensual) {
        this.remuneracionMensual = remuneracionMensual;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }
   
}
