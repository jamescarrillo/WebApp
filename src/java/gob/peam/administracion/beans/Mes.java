/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

/**
 *
 * @author jpgprog84
 */
public class Mes {

    private String nombre;
    private boolean activo;
    private Periodo periodo;
    private String idMes;

    public Mes() {
    }

    public Mes(String nombre, boolean activo, Periodo periodo, String idMes) {
        this.nombre = nombre;
        this.activo = activo;
        this.periodo = periodo;
        this.idMes = idMes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getId() {
        return idMes;
    }

    public void setId(String id) {
        this.idMes = id;
    }
}
