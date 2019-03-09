/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.math.BigDecimal;
import java.sql.Date;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 *
 * @author jprada
 */
public class TemporalComprasBienes {

    private Integer id;
    private String mes;
    private String anho;
    private String ordenCompra;
    private String fuenteFinanciamiento;
    private Date fechaCompra;
    private String proveedor;
    private BigDecimal monto;
    private String financiamiento;
    private Boolean estado;

    public TemporalComprasBienes() {
    }

    public TemporalComprasBienes(Integer id, String mes, String anho, String ordenCompra, String fuenteFinanciamiento, Date fechaCompra, String proveedor, BigDecimal monto, String financiamiento, Boolean estado) {
        this.id = id;
        this.mes = mes;
        this.anho = anho;
        this.ordenCompra = ordenCompra;
        this.fuenteFinanciamiento = fuenteFinanciamiento;
        this.fechaCompra = fechaCompra;
        this.proveedor = proveedor;
        this.monto = monto;
        this.financiamiento = financiamiento;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    

    public static TemporalComprasBienes load(HSSFRow row) {
        TemporalComprasBienes tpb = new TemporalComprasBienes();
        tpb.setId(row.getRowNum());
        tpb.setAnho(row.getCell(1).toString().trim());
        tpb.setMes(row.getCell(2).toString().trim());
        tpb.setFuenteFinanciamiento(row.getCell(7).toString().trim());
        tpb.setOrdenCompra(row.getCell(5).toString().trim());
        java.sql.Date fecha1 = null;
        String[] s = row.getCell(6).toString().trim().split("/");
        int anios = Integer.parseInt(s[2].toString()) - 1900;
        int meses = Integer.parseInt(s[1].toString()) - 1;
        int dias = Integer.parseInt(s[0].toString());
        fecha1 = new Date(anios, meses, dias);
        tpb.setFechaCompra(fecha1);
        tpb.setProveedor(row.getCell(8).toString().trim());
        tpb.setMonto(BigDecimal.valueOf(Double.parseDouble(row.getCell(9).toString().trim())));
        tpb.setFinanciamiento(row.getCell(10).toString().trim());
        return tpb;
    }
}
