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
public class Enlace implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7952061071731754192L;
	private Integer id;
    private String descripcion;
    private String abreviatura;
    private String url;
    private String logo;
    private boolean estado;

    public Enlace() {
    }

    public Enlace(Integer id, String descripcion, String abreviatura, String url, String logo, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.url = url;
        this.logo = logo;
        this.estado = estado;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
