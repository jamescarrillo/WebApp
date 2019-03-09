package gob.peam.beans;

import java.io.Serializable;

public class DirectorioTelefonico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8440341294862433857L;

	private Integer id;
	private String oficina;
	private String seccion;
	private String anexo;
	private boolean estado;

	public DirectorioTelefonico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirectorioTelefonico(Integer id, String oficina, String seccion, String anexo, boolean estado) {
		super();
		this.id = id;
		this.oficina = oficina;
		this.seccion = seccion;
		this.anexo = anexo;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
