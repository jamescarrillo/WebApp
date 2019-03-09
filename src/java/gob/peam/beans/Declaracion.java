/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author Cj.Legacy
 */
public class Declaracion {

    private Integer id;
    private String titulo;
    private String resumen;
    private String fecha;
    private String cargo;
    private String presentacion;
    private Boolean estado;

    public Declaracion(Integer id, String titulo, String resumen, String fecha, String cargo, String presentacion, Boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.fecha = fecha;
        this.cargo = cargo;
        this.presentacion = presentacion;
        this.estado = estado;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Declaracion() {
    }
}
