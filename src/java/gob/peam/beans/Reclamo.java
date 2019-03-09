/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;

/**
 *
 * @author jprada
 */
public class Reclamo {

    private String numero;
    private String anio;
    private String fecha;
    private String usuario;
    private String documentoIdentidad;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String descripcionAtencion;
    private String firmaUsuario;
    private String detalleAcciones;
    private String fechaAcciones;
    private Boolean estado;

    public Reclamo() {
    }

    public Reclamo(String numero, String anio, String fecha, String usuario, String documentoIdentidad, String numeroDocumento, String direccion, String telefono, String email, String descripcionAtencion, String firmaUsuario, String detalleAcciones, String fechaAcciones, Boolean estado) {
        this.numero = numero;
        this.anio = anio;
        this.fecha = fecha;
        this.usuario = usuario;
        this.documentoIdentidad = documentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.descripcionAtencion = descripcionAtencion;
        this.firmaUsuario = firmaUsuario;
        this.detalleAcciones = detalleAcciones;
        this.fechaAcciones = fechaAcciones;
        this.estado = estado;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescripcionAtencion() {
        return descripcionAtencion;
    }

    public void setDescripcionAtencion(String descripcionAtencion) {
        this.descripcionAtencion = descripcionAtencion;
    }

    public String getDetalleAcciones() {
        return detalleAcciones;
    }

    public void setDetalleAcciones(String detalleAcciones) {
        this.detalleAcciones = detalleAcciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaAcciones() {
        return fechaAcciones;
    }

    public void setFechaAcciones(String fechaAcciones) {
        this.fechaAcciones = fechaAcciones;
    }

    public String getFirmaUsuario() {
        return firmaUsuario;
    }

    public void setFirmaUsuario(String firmaUsuario) {
        this.firmaUsuario = firmaUsuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
