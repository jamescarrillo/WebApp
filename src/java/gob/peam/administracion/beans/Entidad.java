package gob.peam.administracion.beans;

import java.io.Serializable;

public class Entidad implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -12609265391916033L;
    private Integer idEntidad;
    private String nombre;
    private String abreviatura;
    private String direccion;
    private String ruc;
    private String frase;
    private String representanteLegal;
    private byte[] logo;
    private String carpetaSiaf;
    private String secuenciaEjecutora;
    private String pie;
    private String version;

    public Entidad() {
    }

    public Entidad(Integer idEntidad, String nombre, String abreviatura, String direccion, String ruc, String frase, String representanteLegal, byte[] logo, String carpetaSiaf, String secuenciaEjecutora, String pie, String version) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.direccion = direccion;
        this.ruc = ruc;
        this.frase = frase;
        this.representanteLegal = representanteLegal;
        this.logo = logo;
        this.carpetaSiaf = carpetaSiaf;
        this.secuenciaEjecutora = secuenciaEjecutora;
        this.pie = pie;
        this.version = version;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {

        this.logo = logo;
    }

    public String getCarpetaSiaf() {
        return carpetaSiaf;
    }

    public void setCarpetaSiaf(String carpetaSiaf) {
        this.carpetaSiaf = carpetaSiaf;
    }

    public String getSecuenciaEjecutora() {
        return secuenciaEjecutora;
    }

    public void setSecuenciaEjecutora(String secuenciaEjecutora) {
        this.secuenciaEjecutora = secuenciaEjecutora;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
