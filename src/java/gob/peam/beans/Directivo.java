/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author jprada
 */
public class Directivo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5665780695779685245L;
	private Integer id;
    private String tratamiento;
    private String nombresApellidos;
    private String cargo;
    private String nivelRemunerativo;
    private String numeroDni;
    private String resolucion;
    private String fechaDesignacion;
    private String telefono;
    private String fax;
    private String eMail;
    private String foto;
    private String profesion;
    private String resumen;
    private String institucion;
    private String regimenLaboral;
    private String retribucionMensual;
    private String hojaVida;
    private boolean estado;

    public Directivo() {
    }

    public Directivo(Integer id, String tratamiento, String nombresApellidos, String cargo, String nivelRemunerativo, String numeroDni, String resolucion, String fechaDesignacion, String telefono, String fax, String eMail, String foto, String profesion, String resumen, String institucion, String regimenLaboral, String retribucionMensual, String hojaVida, boolean estado) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.nombresApellidos = nombresApellidos;
        this.cargo = cargo;
        this.nivelRemunerativo = nivelRemunerativo;
        this.numeroDni = numeroDni;
        this.resolucion = resolucion;
        this.fechaDesignacion = fechaDesignacion;
        this.telefono = telefono;
        this.fax = fax;
        this.eMail = eMail;
        this.foto = foto;
        this.profesion = profesion;
        this.resumen = resumen;
        this.institucion = institucion;
        this.regimenLaboral = regimenLaboral;
        this.retribucionMensual = retribucionMensual;
        this.hojaVida = hojaVida;
        this.estado = estado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFechaDesignacion() {
        return fechaDesignacion;
    }

    public void setFechaDesignacion(String fechaDesignacion) {
        this.fechaDesignacion = fechaDesignacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getHojaVida() {
        return hojaVida;
    }

    public void setHojaVida(String hojaVida) {
        this.hojaVida = hojaVida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNivelRemunerativo() {
        return nivelRemunerativo;
    }

    public void setNivelRemunerativo(String nivelRemunerativo) {
        this.nivelRemunerativo = nivelRemunerativo;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getRegimenLaboral() {
        return regimenLaboral;
    }

    public void setRegimenLaboral(String regimenLaboral) {
        this.regimenLaboral = regimenLaboral;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getRetribucionMensual() {
        return retribucionMensual;
    }

    public void setRetribucionMensual(String retribucionMensual) {
        this.retribucionMensual = retribucionMensual;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

}
