/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

/**
 *
 * @author jpgprog84
 */
public class ParametroDocumento {

    private Integer tipoDocumento;
    private String tituloFirmaHechoPor;
    private String tituloFirmaAdquisiciones;
    private String tituloFirmaAbastecimientos;
    private String tituloFirmaAdministrador;
    private String tituloPieInforme;
    private String tituloFirmaJefe;

    public ParametroDocumento() {
    }

    public ParametroDocumento(Integer tipoDocumento, String tituloFirmaHechoPor, String tituloFirmaAdquisiciones, String tituloFirmaAbastecimientos, String tituloFirmaAdministrador, String tituloPieInforme, String tituloFirmaJefe) {
        this.tipoDocumento = tipoDocumento;
        this.tituloFirmaHechoPor = tituloFirmaHechoPor;
        this.tituloFirmaAdquisiciones = tituloFirmaAdquisiciones;
        this.tituloFirmaAbastecimientos = tituloFirmaAbastecimientos;
        this.tituloFirmaAdministrador = tituloFirmaAdministrador;
        this.tituloPieInforme = tituloPieInforme;
        this.tituloFirmaJefe = tituloFirmaJefe;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTituloFirmaHechoPor() {
        return tituloFirmaHechoPor;
    }

    public void setTituloFirmaHechoPor(String tituloFirmaHechoPor) {
        this.tituloFirmaHechoPor = tituloFirmaHechoPor;
    }

    public String getTituloFirmaAdquisiciones() {
        return tituloFirmaAdquisiciones;
    }

    public void setTituloFirmaAdquisiciones(String tituloFirmaAdquisiciones) {
        this.tituloFirmaAdquisiciones = tituloFirmaAdquisiciones;
    }

    public String getTituloFirmaAbastecimientos() {
        return tituloFirmaAbastecimientos;
    }

    public void setTituloFirmaAbastecimientos(String tituloFirmaAbastecimientos) {
        this.tituloFirmaAbastecimientos = tituloFirmaAbastecimientos;
    }

    public String getTituloFirmaAdministrador() {
        return tituloFirmaAdministrador;
    }

    public void setTituloFirmaAdministrador(String tituloFirmaAdministrador) {
        this.tituloFirmaAdministrador = tituloFirmaAdministrador;
    }

    public String getTituloPieInforme() {
        return tituloPieInforme;
    }

    public void setTituloPieInforme(String tituloPieInforme) {
        this.tituloPieInforme = tituloPieInforme;
    }

    public String getTituloFirmaJefe() {
        return tituloFirmaJefe;
    }

    public void setTituloFirmaJefe(String tituloFirmaJefe) {
        this.tituloFirmaJefe = tituloFirmaJefe;
    }
    
}
