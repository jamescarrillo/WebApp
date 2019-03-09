package gob.peam.administracion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Modulo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1518554086726050115L;
    private Integer idModulo;
    private String nombre;
    private boolean estado;
    private String descripcion;
    private String url;
    private ArrayList<SubModulo> subModulos;

    public Modulo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Modulo(Integer idModulo, String nombre, boolean estado, String descripcion, String url, ArrayList<SubModulo> subModulos) {
        super();
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.url = url;
        this.subModulos = subModulos;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<SubModulo> getSubModulos() {
        return subModulos;
    }

    public void setSubModulos(ArrayList<SubModulo> subModulos) {
        this.subModulos = subModulos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
