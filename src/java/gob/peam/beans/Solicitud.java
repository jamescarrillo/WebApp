/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author jprada
 */
public class Solicitud {
    
    private Integer soliId;
    private String anho;
    private String usuario;
    private String dni;
    private String correo;
    private String dependencia = "";
    private String descripcion = "";
    private String fechaRegistro;
    private String fechaAtendido;
    private String telefono;
    private String domicilio;
    private Integer forma;
    private boolean estado;

    public Solicitud() {
    }

    public Solicitud(Integer soliId, String anho, String usuario, String dni, String correo, String fechaRegistro, String fechaAtendido, String telefono, boolean estado, String domicilio, Integer forma) {
        this.soliId = soliId;
        this.anho = anho;
        this.usuario = usuario;
        this.dni = dni;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.fechaAtendido = fechaAtendido;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.forma = forma;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getForma() {
        return forma;
    }

    public void setForma(Integer forma) {
        this.forma = forma;
    }

    
    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaAtendido() {
        return fechaAtendido;
    }

    public void setFechaAtendido(String fechaAtendido) {
        this.fechaAtendido = fechaAtendido;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getSoliId() {
        return soliId;
    }

    public void setSoliId(Integer soliId) {
        this.soliId = soliId;
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
