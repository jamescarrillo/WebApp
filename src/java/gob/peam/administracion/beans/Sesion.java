/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author jpgprog84
 */
public class Sesion {

    private Integer sesiId;
    private String sesiKey;
    private Date sesiFechaIngreso;
    private Date sesiFechaSalida;
    private Time sesiHoraIngreso;
    private Time sesiHoraSalida;
    private String sesiIp;
    private Usuario usuario;
    private Dependencia dependencia;
    private boolean sesiEstado;

    public Sesion() {
    }

    public Sesion(Integer sesiId, String sesiKey, Date sesiFechaIngreso, Date sesiFechaSalida, Time sesiHoraIngreso, Time sesiHoraSalida, String sesiIp, Usuario usuario, Dependencia dependencia, boolean sesiEstado) {
        this.sesiId = sesiId;
        this.sesiKey = sesiKey;
        this.sesiFechaIngreso = sesiFechaIngreso;
        this.sesiFechaSalida = sesiFechaSalida;
        this.sesiHoraIngreso = sesiHoraIngreso;
        this.sesiHoraSalida = sesiHoraSalida;
        this.sesiIp = sesiIp;
        this.usuario = usuario;
        this.dependencia = dependencia;
        this.sesiEstado = sesiEstado;
    }

    public Integer getSesiId() {
        return sesiId;
    }

    public void setSesiId(Integer sesiId) {
        this.sesiId = sesiId;
    }

    public String getSesiKey() {
        return sesiKey;
    }

    public void setSesiKey(String sesiKey) {
        this.sesiKey = sesiKey;
    }

    public Date getSesiFechaIngreso() {
        return sesiFechaIngreso;
    }

    public void setSesiFechaIngreso(Date sesiFechaIngreso) {
        this.sesiFechaIngreso = sesiFechaIngreso;
    }

    public Date getSesiFechaSalida() {
        return sesiFechaSalida;
    }

    public void setSesiFechaSalida(Date sesiFechaSalida) {
        this.sesiFechaSalida = sesiFechaSalida;
    }

    public Time getSesiHoraIngreso() {
        return sesiHoraIngreso;
    }

    public void setSesiHoraIngreso(Time sesiHoraIngreso) {
        this.sesiHoraIngreso = sesiHoraIngreso;
    }

    public Time getSesiHoraSalida() {
        return sesiHoraSalida;
    }

    public void setSesiHoraSalida(Time sesiHoraSalida) {
        this.sesiHoraSalida = sesiHoraSalida;
    }

    public String getSesiIp() {
        return sesiIp;
    }

    public void setSesiIp(String sesiIp) {
        this.sesiIp = sesiIp;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public boolean isSesiEstado() {
        return sesiEstado;
    }

    public void setSesiEstado(boolean sesiEstado) {
        this.sesiEstado = sesiEstado;
    }
}
