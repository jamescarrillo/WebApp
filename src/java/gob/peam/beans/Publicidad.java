/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 *
 * @author jprada
 */
public class Publicidad implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7681044038968819332L;
    private Integer id;
    private String anho;
    private String bienesServicios;
    private String fuenteFinanciamiento;
    private String proceso;
    private String contrato;
    private String objetoContrato;
    private BigDecimal valorReferencial;
    private String proveedor;
    private String ruc;
    private BigDecimal montoContrato;
    private BigDecimal penalidad;
    private BigDecimal costoFinal;
    private String observaciones;
    private boolean estado;

    public Publicidad() {
    }

    public Publicidad(Integer id, String anho, String bienesServicios, String fuenteFinanciamiento, String proceso, String contrato, String objetoContrato, BigDecimal valorReferencial, String proveedor, String ruc, BigDecimal montoContrato, BigDecimal penalidad, BigDecimal costoFinal, String observaciones, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.bienesServicios = bienesServicios;
        this.fuenteFinanciamiento = fuenteFinanciamiento;
        this.proceso = proceso;
        this.contrato = contrato;
        this.objetoContrato = objetoContrato;
        this.valorReferencial = valorReferencial;
        this.proveedor = proveedor;
        this.ruc = ruc;
        this.montoContrato = montoContrato;
        this.penalidad = penalidad;
        this.costoFinal = costoFinal;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getBienesServicios() {
        return bienesServicios;
    }

    public void setBienesServicios(String bienesServicios) {
        this.bienesServicios = bienesServicios;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public BigDecimal getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(BigDecimal costoFinal) {
        this.costoFinal = costoFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFuenteFinanciamiento() {
        return fuenteFinanciamiento;
    }

    public void setFuenteFinanciamiento(String fuenteFinanciamiento) {
        this.fuenteFinanciamiento = fuenteFinanciamiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMontoContrato() {
        return montoContrato;
    }

    public void setMontoContrato(BigDecimal montoContrato) {
        this.montoContrato = montoContrato;
    }

    public String getObjetoContrato() {
        return objetoContrato;
    }

    public void setObjetoContrato(String objetoContrato) {
        this.objetoContrato = objetoContrato;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getPenalidad() {
        return penalidad;
    }

    public void setPenalidad(BigDecimal penalidad) {
        this.penalidad = penalidad;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public BigDecimal getValorReferencial() {
        return valorReferencial;
    }

    public void setValorReferencial(BigDecimal valorReferencial) {
        this.valorReferencial = valorReferencial;
    }

    public static Publicidad load(HSSFRow row) {
        Publicidad tpb = new Publicidad();
        try {
           
               
            tpb.setEstado(true);
            tpb.setId(row.getRowNum());
            if (!"".equals(row.getCell(0).toString().trim())) {
                tpb.setAnho(row.getCell(0) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(0).toString().trim()))));
            } else {
                tpb.setAnho("0000");
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(1).toString().trim())){
                tpb.setBienesServicios(row.getCell(1) == null ? "" : row.getCell(1).toString().trim());
            }else{
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setFuenteFinanciamiento(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setProceso(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());
            } else {
                tpb.setProceso("no Tiene");
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setContrato(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(5).toString().trim())) {
                tpb.setObjetoContrato(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setValorReferencial(row.getCell(6) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(6).toString().trim())));

            if (!"".equals(row.getCell(7).toString().trim())) {
                tpb.setProveedor(row.getCell(7) == null ? "" : row.getCell(7).toString().trim());
            } else {
                tpb.setEstado(false);
            }
            
            
            if (row.getCell(8).toString().trim().length() <= 11)
                tpb.setRuc(row.getCell(8).toString().trim());
            else 
              tpb.setRuc(row.getCell(8) == null ? "" : String.valueOf((long) Math.ceil(Double.parseDouble(row.getCell(8).toString().trim()))));
            
            tpb.setMontoContrato(row.getCell(9) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(9).toString().trim())));
            tpb.setPenalidad(row.getCell(10) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(10).toString().trim())));
            tpb.setCostoFinal(row.getCell(11) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(11).toString().trim())));
            tpb.setObservaciones(row.getCell(12) == null ? "" : row.getCell(12).toString().trim());
        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }
}
