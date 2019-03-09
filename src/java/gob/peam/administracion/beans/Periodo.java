/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

import java.util.List;

/**
 *
 * @author jpgprog84
 */
public class Periodo {
   private String  anio;
  private boolean activo;
  private String descripcion;
  private List<Mes> meses;

    public Periodo() {
    }

    public Periodo(String anio, boolean activo, String descripcion) {
        this.anio = anio;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Mes> getMeses() {
        return meses;
    }

    public void setMeses(List<Mes> meses) {
        this.meses = meses;
    }
  
}
