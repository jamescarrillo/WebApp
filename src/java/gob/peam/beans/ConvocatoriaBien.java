/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.util.Date;

public class ConvocatoriaBien {

    private Integer convoId;
    private String anho;
    private Date fecha;
    private Integer tipo;
    private String titulo;
    private String referencia;
    private String valReferencial;
    private String costParticipacion;
    private String lugRegParticipante;
    private String basesFile;
    private String resEjectFile;
    private String absConObserFile;
    private String absConsultFile;
    private String absObservaFile;
    private String ProEntiFile;
    private String ProOsceFile;
    private String basInteFile;
    private String actEvalTecFile;
    private String cuaCompaFile;
    private String actaBuenaProFile;
    private String notiSusFile;
    private String resRecEntiFile;
    private String resRecTribFile;
    private Boolean estado;
    private Integer proceso;

    public ConvocatoriaBien() {
    }

    public ConvocatoriaBien(Integer convoId, String anho, Date fecha, Integer tipo, String titulo, String referencia, String valReferencial, String costParticipacion, String lugRegParticipante, String basesFile, String resEjectFile, String absConObserFile, String absConsultFile, String absObservaFile, String ProEntiFile, String ProOsceFile, String basInteFile, String actEvalTecFile, String cuaCompaFile, String actaBuenaProFile, String notiSusFile, String resRecEntiFile, String resRecTribFile, Boolean estado, Integer proceso) {
        this.convoId = convoId;
        this.anho = anho;
        this.fecha = fecha;
        this.tipo = tipo;
        this.titulo = titulo;
        this.referencia = referencia;
        this.valReferencial = valReferencial;
        this.costParticipacion = costParticipacion;
        this.lugRegParticipante = lugRegParticipante;
        this.basesFile = basesFile;
        this.resEjectFile = resEjectFile;
        this.absConObserFile = absConObserFile;
        this.absConsultFile = absConsultFile;
        this.absObservaFile = absObservaFile;
        this.ProEntiFile = ProEntiFile;
        this.ProOsceFile = ProOsceFile;
        this.basInteFile = basInteFile;
        this.actEvalTecFile = actEvalTecFile;
        this.cuaCompaFile = cuaCompaFile;
        this.actaBuenaProFile = actaBuenaProFile;
        this.notiSusFile = notiSusFile;
        this.resRecEntiFile = resRecEntiFile;
        this.resRecTribFile = resRecTribFile;
        this.estado = estado;
        this.proceso = proceso;
    }

    public String getProEntiFile() {
        return ProEntiFile;
    }

    public void setProEntiFile(String ProEntiFile) {
        this.ProEntiFile = ProEntiFile;
    }

    public String getProOsceFile() {
        return ProOsceFile;
    }

    public void setProOsceFile(String ProOsceFile) {
        this.ProOsceFile = ProOsceFile;
    }

    public String getAbsConObserFile() {
        return absConObserFile;
    }

    public void setAbsConObserFile(String absConObserFile) {
        this.absConObserFile = absConObserFile;
    }

    public String getAbsConsultFile() {
        return absConsultFile;
    }

    public void setAbsConsultFile(String absConsultFile) {
        this.absConsultFile = absConsultFile;
    }

    public String getAbsObservaFile() {
        return absObservaFile;
    }

    public void setAbsObservaFile(String absObservaFile) {
        this.absObservaFile = absObservaFile;
    }

    public String getActEvalTecFile() {
        return actEvalTecFile;
    }

    public void setActEvalTecFile(String actEvalTecFile) {
        this.actEvalTecFile = actEvalTecFile;
    }

    public String getActaBuenaProFile() {
        return actaBuenaProFile;
    }

    public void setActaBuenaProFile(String actaBuenaProFile) {
        this.actaBuenaProFile = actaBuenaProFile;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getBasInteFile() {
        return basInteFile;
    }

    public void setBasInteFile(String basInteFile) {
        this.basInteFile = basInteFile;
    }

    public String getBasesFile() {
        return basesFile;
    }

    public void setBasesFile(String basesFile) {
        this.basesFile = basesFile;
    }

    public Integer getConvoId() {
        return convoId;
    }

    public void setConvoId(Integer convoId) {
        this.convoId = convoId;
    }

    public String getCostParticipacion() {
        return costParticipacion;
    }

    public void setCostParticipacion(String costParticipacion) {
        this.costParticipacion = costParticipacion;
    }

    public String getCuaCompaFile() {
        return cuaCompaFile;
    }

    public void setCuaCompaFile(String cuaCompaFile) {
        this.cuaCompaFile = cuaCompaFile;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugRegParticipante() {
        return lugRegParticipante;
    }

    public void setLugRegParticipante(String lugRegParticipante) {
        this.lugRegParticipante = lugRegParticipante;
    }

    public String getNotiSusFile() {
        return notiSusFile;
    }

    public void setNotiSusFile(String notiSusFile) {
        this.notiSusFile = notiSusFile;
    }

    public Integer getProceso() {
        return proceso;
    }

    public void setProceso(Integer proceso) {
        this.proceso = proceso;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getResEjectFile() {
        return resEjectFile;
    }

    public void setResEjectFile(String resEjectFile) {
        this.resEjectFile = resEjectFile;
    }

    public String getResRecEntiFile() {
        return resRecEntiFile;
    }

    public void setResRecEntiFile(String resRecEntiFile) {
        this.resRecEntiFile = resRecEntiFile;
    }

    public String getResRecTribFile() {
        return resRecTribFile;
    }

    public void setResRecTribFile(String resRecTribFile) {
        this.resRecTribFile = resRecTribFile;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValReferencial() {
        return valReferencial;
    }

    public void setValReferencial(String valReferencial) {
        this.valReferencial = valReferencial;
    }

    

}
