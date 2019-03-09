/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

import java.io.Serializable;

/**
 * 
 * @author jpgprog84
 */
public class Grupo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4602466772673024436L;
	private Integer idGrupo;
	private String nombre;
	private boolean estado;

	public Grupo() {
	}

	public Grupo(Integer idGrupo, String nombre, boolean estado) {
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
