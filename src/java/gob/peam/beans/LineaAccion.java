package gob.peam.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mvilchez
 */
public class LineaAccion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String descripcion;
    private boolean estado;

    public LineaAccion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
