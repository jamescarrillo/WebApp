/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

/**
 *
 * @author jprada
 */
public class Finanza {
    private Integer id;
    private Integer tipo;
    private String anho;
    private String mes;
    private String tituloFormato;
    private String documento; 
    private String descripcion;
    private String ubicacion;
    private Boolean estado;
    private Integer docuId;
    private String fecha;
    
    public Finanza() {
    }

    public Finanza(Integer id, Integer tipo, String anho, String mes, String tituloFormato, String documento, String descripcion, String ubicacion, Boolean estado, Integer docuId, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.anho = anho;
        this.mes = mes;
        this.tituloFormato = tituloFormato;
        this.documento = documento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.docuId = docuId;
        this.fecha = fecha;
    }

   

    public String getAnho() {
        return anho;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDocuId() {
        return docuId;
    }

    public void setDocuId(Integer docuId) {
        this.docuId = docuId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTituloFormato() {
        return tituloFormato;
    }

    public void setTituloFormato(String tituloFormato) {
        this.tituloFormato = tituloFormato;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
   
}
