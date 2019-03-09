/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;

/**
 *
 * @author jprada
 */
public class Convocatoria implements Serializable {
   private Integer id;
   private String anho;
   private String numero;
   private String titulo;
   private String descripcion;
   private String objeto;
   private String modalidad;
   private Integer vacantes;
   private String fechaEntrevista;
   private String calificacionDocumentos;
   private String fecha;
   private String fechaPublicacion;
   private String recepcionDocumentos;
   private String evaluacionDocumentos;
   private String entrevistaPersonal;
   private String publicacionResultados;
   private String suscripcionContratos;
   private String observaciones;
   private String basesAdministrativas;
   private String terminosReferencia;
   private String resultados;
   private String tipoProceso;
   private Boolean estado;
   private String ruta;
   private Convocatoria(){}

    public Convocatoria(Integer id, String anho, String numero, String titulo, String descripcion, String objeto, String modalidad, Integer vacantes, String fechaEntrevista, String calificacionDocumentos, String fecha, String fechaPublicacion, String recepcionDocumentos, String evaluacionDocumentos, String entrevistaPersonal, String publicacionResultados, String suscripcionContratos, String observaciones, String basesAdministrativas, String terminosReferencia, String resultados, String tipoProceso, Boolean estado, String ruta) {
        this.id = id;
        this.anho = anho;
        this.numero = numero;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.objeto = objeto;
        this.modalidad = modalidad;
        this.vacantes = vacantes;
        this.fechaEntrevista = fechaEntrevista;
        this.calificacionDocumentos = calificacionDocumentos;
        this.fecha = fecha;
        this.fechaPublicacion = fechaPublicacion;
        this.recepcionDocumentos = recepcionDocumentos;
        this.evaluacionDocumentos = evaluacionDocumentos;
        this.entrevistaPersonal = entrevistaPersonal;
        this.publicacionResultados = publicacionResultados;
        this.suscripcionContratos = suscripcionContratos;
        this.observaciones = observaciones;
        this.basesAdministrativas = basesAdministrativas;
        this.terminosReferencia = terminosReferencia;
        this.resultados = resultados;
        this.tipoProceso = tipoProceso;
        this.estado = estado;
        this.ruta = ruta;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getBasesAdministrativas() {
        return basesAdministrativas;
    }

    public void setBasesAdministrativas(String basesAdministrativas) {
        this.basesAdministrativas = basesAdministrativas;
    }

    public String getCalificacionDocumentos() {
        return calificacionDocumentos;
    }

    public void setCalificacionDocumentos(String calificacionDocumentos) {
        this.calificacionDocumentos = calificacionDocumentos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntrevistaPersonal() {
        return entrevistaPersonal;
    }

    public void setEntrevistaPersonal(String entrevistaPersonal) {
        this.entrevistaPersonal = entrevistaPersonal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getEvaluacionDocumentos() {
        return evaluacionDocumentos;
    }

    public void setEvaluacionDocumentos(String evaluacionDocumentos) {
        this.evaluacionDocumentos = evaluacionDocumentos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(String fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPublicacionResultados() {
        return publicacionResultados;
    }

    public void setPublicacionResultados(String publicacionResultados) {
        this.publicacionResultados = publicacionResultados;
    }

    public String getRecepcionDocumentos() {
        return recepcionDocumentos;
    }

    public void setRecepcionDocumentos(String recepcionDocumentos) {
        this.recepcionDocumentos = recepcionDocumentos;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getSuscripcionContratos() {
        return suscripcionContratos;
    }

    public void setSuscripcionContratos(String suscripcionContratos) {
        this.suscripcionContratos = suscripcionContratos;
    }

    public String getTerminosReferencia() {
        return terminosReferencia;
    }

    public void setTerminosReferencia(String terminosReferencia) {
        this.terminosReferencia = terminosReferencia;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }
   
   
   
}
