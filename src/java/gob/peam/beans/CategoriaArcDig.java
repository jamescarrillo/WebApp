/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author alabajos
 */
public class CategoriaArcDig {
    private Integer id;
    private String charId;
    private String Nombre;

    public CategoriaArcDig() {
    }

    public CategoriaArcDig(Integer id, String charId, String Nombre) {
        this.id = id;
        this.charId = charId;
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCharId() {
        return charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
