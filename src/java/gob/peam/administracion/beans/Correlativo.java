/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

/**
 *
 * @author jpgprog84
 */
public class Correlativo {

    private String tiemAnio;
    private String corrRequerimiento;
    private String corrCotizacion;
    private String corrExpediente;
    private String corrNotaIngreso;
    private String corrNotaSalida;
    private String corrCotizacionContrato;
    private String corrCotizacionDirecta;

    public Correlativo() {
    }

    
    public Correlativo(String tiemAnio, String corrRequerimiento, String corrCotizacion, String corrExpediente, String corrNotaIngreso, String corrNotaSalida, String corrCotizacionContrato, String corrCotizacionDirecta) {
        this.tiemAnio = tiemAnio;
        this.corrRequerimiento = corrRequerimiento;
        this.corrCotizacion = corrCotizacion;
        this.corrExpediente = corrExpediente;
        this.corrNotaIngreso = corrNotaIngreso;
        this.corrNotaSalida = corrNotaSalida;
        this.corrCotizacionContrato = corrCotizacionContrato;
        this.corrCotizacionDirecta = corrCotizacionDirecta;
    }

    public String getTiemAnio() {
        return tiemAnio;
    }

    public void setTiemAnio(String tiemAnio) {
        this.tiemAnio = tiemAnio;
    }

    public String getCorrRequerimiento() {
        return corrRequerimiento;
    }

    public void setCorrRequerimiento(String corrRequerimiento) {
        this.corrRequerimiento = corrRequerimiento;
    }

    public String getCorrCotizacion() {
        return corrCotizacion;
    }

    public void setCorrCotizacion(String corrCotizacion) {
        this.corrCotizacion = corrCotizacion;
    }

    public String getCorrExpediente() {
        return corrExpediente;
    }

    public void setCorrExpediente(String corrExpediente) {
        this.corrExpediente = corrExpediente;
    }

    public String getCorrNotaIngreso() {
        return corrNotaIngreso;
    }

    public void setCorrNotaIngreso(String corrNotaIngreso) {
        this.corrNotaIngreso = corrNotaIngreso;
    }

    public String getCorrNotaSalida() {
        return corrNotaSalida;
    }

    public void setCorrNotaSalida(String corrNotaSalida) {
        this.corrNotaSalida = corrNotaSalida;
    }

    public String getCorrCotizacionContrato() {
        return corrCotizacionContrato;
    }

    public void setCorrCotizacionContrato(String corrCotizacionContrato) {
        this.corrCotizacionContrato = corrCotizacionContrato;
    }

    public String getCorrCotizacionDirecta() {
        return corrCotizacionDirecta;
    }

    public void setCorrCotizacionDirecta(String corrCotizacionDirecta) {
        this.corrCotizacionDirecta = corrCotizacionDirecta;
    }
    
}
