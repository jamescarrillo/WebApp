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
public class DocumentoConvocatoria implements Serializable{
    private Integer docoId;
    private String nombre;
    private String urlFile;
    private Boolean estado;
    private Integer id;

    public DocumentoConvocatoria(Integer docoId, String nombre, String urlFile, Boolean estado, Integer id) {
        this.docoId = docoId;
        this.nombre = nombre;
        this.urlFile = urlFile;
        this.estado = estado;
        this.id = id;
    }

    public DocumentoConvocatoria() {
    }

    public Integer getDocoId() {
        return docoId;
    }

    public void setDocoId(Integer docoId) {
        this.docoId = docoId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
    

    
    
}
