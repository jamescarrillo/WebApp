/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author alabajos
 */
public class Correo {
    public Integer id;
    public String paraCorreo;
    public String ccCorreo;
    public String parteCorreo;
    public String mensajeCorreo;
    public Boolean estado;
    public Integer tipo;

    public Correo() {
    }

    public Correo(Integer id, String paraCorreo, String ccCorreo, String parteCorreo, String mensajeCorreo, Boolean estado, Integer tipo) {
        this.id = id;
        this.paraCorreo = paraCorreo;
        this.ccCorreo = ccCorreo;
        this.parteCorreo = parteCorreo;
        this.mensajeCorreo = mensajeCorreo;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getCcCorreo() {
        return ccCorreo;
    }

    public void setCcCorreo(String ccCorreo) {
        this.ccCorreo = ccCorreo;
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

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getParaCorreo() {
        return paraCorreo;
    }

    public void setParaCorreo(String paraCorreo) {
        this.paraCorreo = paraCorreo;
    }

    public String getParteCorreo() {
        return parteCorreo;
    }

    public void setParteCorreo(String parteCorreo) {
        this.parteCorreo = parteCorreo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
           
    
}
