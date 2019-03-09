/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author Cj.Legacy
 */
public class Metadata {
    private String campo;
    private String detalle;

    public Metadata() {
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Metadata(String campo, String detalle) {
        this.campo = campo;
        this.detalle = detalle;
    }
    
    
    
}
