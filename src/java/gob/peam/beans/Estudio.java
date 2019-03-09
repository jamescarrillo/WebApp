package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mvilchez
 */
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String anho;
    private String titulo;
    private String fecha;
    private String foto;
    private boolean estado;
    private String snip;
    private String objetivo;
    private Integer cantidadBeneficiarios;
    private String caracteristicasBeneficiarios;
    private String lugar;
    private String mapa;
    private String seguimiento;
    private Integer creadoPor;
    private Date fechaCreado;
    private Integer editadoPor;
    private Date fechaEditado;

    public Estudio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getSnip() {
        return snip;
    }

    public void setSnip(String snip) {
        this.snip = snip;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getCantidadBeneficiarios() {
        return cantidadBeneficiarios;
    }

    public void setCantidadBeneficiarios(Integer cantidadBeneficiarios) {
        this.cantidadBeneficiarios = cantidadBeneficiarios;
    }

    public String getCaracteristicasBeneficiarios() {
        return caracteristicasBeneficiarios;
    }

    public void setCaracteristicasBeneficiarios(String caracteristicasBeneficiarios) {
        this.caracteristicasBeneficiarios = caracteristicasBeneficiarios;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Integer creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public Integer getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Integer editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Date getFechaEditado() {
        return fechaEditado;
    }

    public void setFechaEditado(Date fechaEditado) {
        this.fechaEditado = fechaEditado;
    }

}
