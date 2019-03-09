/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author jpgprog84
 */
public class Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2567580719312505704L;
    private Integer idUsuario;
    private String login;
    private Date usuaFechaRegistro;
    private Date usuaFechaCaducidad;
    private String clave;
    private boolean estado;
    private Grupo grupo;
    private Persona persona;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String login, Date usuaFechaRegistro, Date usuaFechaCaducidad, String clave, boolean estado, Grupo grupo, Persona persona) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.usuaFechaRegistro = usuaFechaRegistro;
        this.usuaFechaCaducidad = usuaFechaCaducidad;
        this.clave = clave;
        this.estado = estado;
        this.grupo = grupo;
        this.persona = persona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getUsuaFechaCaducidad() {
        return usuaFechaCaducidad;
    }

    public void setUsuaFechaCaducidad(Date usuaFechaCaducidad) {
        this.usuaFechaCaducidad = usuaFechaCaducidad;
    }

    public Date getUsuaFechaRegistro() {
        return usuaFechaRegistro;
    }

    public void setUsuaFechaRegistro(Date usuaFechaRegistro) {
        this.usuaFechaRegistro = usuaFechaRegistro;
    }
}
