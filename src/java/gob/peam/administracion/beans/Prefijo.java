/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

/**
 *
 * @author jpgprog84
 */
public class Prefijo {
    private String anio;
    private String prefijo;
    private String ordenCompra;
    private String ordenServicio;

    public Prefijo() {
    }

    public Prefijo(String prefijo, String ordenCompra, String ordenServicio) {
        this.prefijo = prefijo;
        this.ordenCompra = ordenCompra;
        this.ordenServicio = ordenServicio;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(String ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    
}
