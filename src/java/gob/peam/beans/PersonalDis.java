/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;

/**
 *
 * @author Ernesto
 */
public class PersonalDis implements Serializable {
    private static final long serialVersionUID = -8307248725891306252L;
	private Integer id;
    private String anho;
    private Integer trimestre;
    private String codigoFormato;
    private String apellidosNombres;
    private String codigoCivil;
    private String oficinaArea;
    private Double remuneracionMensual;
    private boolean estado;

    public PersonalDis() {
    }

    public PersonalDis(Integer id, String anho, Integer trimestre, String codigoFormato, String apellidosNombres, String codigoCivil, String oficinaArea, Double remuneracionMensual, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.trimestre = trimestre;
        this.codigoFormato = codigoFormato;
        this.apellidosNombres = apellidosNombres;
        this.codigoCivil = codigoCivil;
        this.oficinaArea = oficinaArea;
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

    public String getCodigoCivil() {
        return codigoCivil;
    }

    public void setCodigoCivil(String codigoCivil) {
        this.codigoCivil = codigoCivil;
    }

    public String getCodigoFormato() {
        return codigoFormato;
    }

    public void setCodigoFormato(String codigoFormato) {
        this.codigoFormato = codigoFormato;
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

    public String getOficinaArea() {
        return oficinaArea;
    }

    public void setOficinaArea(String oficinaArea) {
        this.oficinaArea = oficinaArea;
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
