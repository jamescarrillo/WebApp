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
public class Configuracion implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1322095278912135312L;
    private Integer id;
    private String resolucion;
    private String presupuesto;
    private String documentos;
    private String normas;
    private String viatico;

    public Configuracion() {
    }

    public Configuracion(Integer id, String resolucion, String presupuesto, String documentos, String normas, String viatico) {
        this.id = id;
        this.resolucion = resolucion;
        this.presupuesto = presupuesto;
        this.documentos = documentos;
        this.normas = normas;
        this.viatico = viatico;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getViatico() {
        return viatico;
    }

    public void setViatico(String viatico) {
        this.viatico = viatico;
    }
}
