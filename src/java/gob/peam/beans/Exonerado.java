/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.util.Date;

/**
 *
 * @author alabajos
 */
public class Exonerado {
    private Integer id;
    private String nroExonerado;
    private Date fecha;
    private String anho;
    private String causa;
    private String objeto;
    private String descripcion;
    private String monto;
    private String contratista;
    private String ruc;
    private String url;

    public Exonerado() {
    }

    public Exonerado(Integer id, Date fecha, String anho, String causa, String objeto, String descripcion, String monto, String contratista, String ruc, String url, String nroExonerado) {
        this.id = id;
        this.fecha = fecha;
        this.anho = anho;
        this.causa = causa;
        this.objeto = objeto;
        this.descripcion = descripcion;
        this.monto = monto;
        this.contratista = contratista;
        this.ruc = ruc;
        this.url = url;
        this.nroExonerado = nroExonerado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getNroExonerado() {
        return nroExonerado;
    }

    public void setNroExonerado(String nroExonerado) {
        this.nroExonerado = nroExonerado;
    }
    
    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
}
