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
public class CategoriaDocumento implements Serializable {
    private Integer cateId;
    private String nombre;
    private Integer tidoId;

    public CategoriaDocumento() {
    }

    public CategoriaDocumento(Integer cateId, String Nombre, Integer tidoId) {
        this.cateId = cateId;
        this.nombre = Nombre;
        this.tidoId = tidoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getTidoId() {
        return tidoId;
    }

    public void setTidoId(Integer tidoId) {
        this.tidoId = tidoId;
    }
    
    
    
}
