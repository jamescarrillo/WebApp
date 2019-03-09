package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mvilchez
 */
public class Obra implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String anho;
    private String mes;
    private boolean estado;
    private Integer creadoPor;
    private Date fechaCreado;
    private Integer editadoPor;
    private Date fechaEditado;
    private String descripcion;
    private Double montoInversion;
    private Double montoGastado;
    private Integer tiempoEjecucion;
    private String modalidadEjecucion;
    private String fechaInicio;
    private String fechaFin;
    private String seguimiento;
    private String ubicacion;
    private String contratista;
    private String supervisor;
    private String residente;
    private Double avanceFisico;
    private Integer area;
    private String galeria;
    private String foto;
    private String anhoActualizacion;
    private String mesActualizacion;
    private String snip;
    private String observacion;
    private String infobras;
    private String leyenda;

    public Obra() {
    }

    public Integer getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        this.galeria = galeria;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMontoInversion() {
        return montoInversion;
    }

    public void setMontoInversion(Double montoInversion) {
        this.montoInversion = montoInversion;
    }

    public Double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(Double montoGastado) {
        this.montoGastado = montoGastado;
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Integer tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getModalidadEjecucion() {
        return modalidadEjecucion;
    }

    public void setModalidadEjecucion(String modalidadEjecucion) {
        this.modalidadEjecucion = modalidadEjecucion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

    public Double getAvanceFisico() {
        return avanceFisico;
    }

    public void setAvanceFisico(Double avanceFisico) {
        this.avanceFisico = avanceFisico;
    }

    public String getAnhoActualizacion() {
        return anhoActualizacion;
    }

    public void setAnhoActualizacion(String anhoActualizacion) {
        this.anhoActualizacion = anhoActualizacion;
    }

    public String getMesActualizacion() {
        return mesActualizacion;
    }

    public void setMesActualizacion(String mesActualizacion) {
        this.mesActualizacion = mesActualizacion;
    }

    public String getSnip() {
        return snip;
    }

    public void setSnip(String snip) {
        this.snip = snip;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getInfobras() {
        return infobras;
    }

    public void setInfobras(String infobras) {
        this.infobras = infobras;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

}
