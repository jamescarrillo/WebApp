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
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 6843278992045147710L;
    private Integer id;
    private String mes = "";
    private String anho;
    private String nro;
    private String fecha;
    private String fuenteFinanciamiento;
    private String proveedor;
    private BigDecimal monto;
    private String financiamiento;
    private boolean estado;
    private String nroSiaf;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer id, String anho, String nro, String fecha, String fuenteFinanciamiento, String proveedor, BigDecimal monto, String financiamiento, boolean estado, String nroSiaf) {
        this.id = id;
        this.anho = anho;
        this.nro = nro;
        this.fecha = fecha;
        this.fuenteFinanciamiento = fuenteFinanciamiento;
        this.proveedor = proveedor;
        this.monto = monto;
        this.financiamiento = financiamiento;
        this.estado = estado;
        this.nroSiaf = nroSiaf;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getNroSiaf() {
        return nroSiaf;
    }

    public void setNroSiaf(String nroSiaf) {
        this.nroSiaf = nroSiaf;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public static OrdenCompra load(HSSFRow row) {
        OrdenCompra tpb = new OrdenCompra();
        try {
            tpb.setEstado(true);
            
            tpb.setId(row.getRowNum());

            if (!"".equals(row.getCell(1).toString().trim())) {
                tpb.setNro(row.getCell(1) == null ? "" : row.getCell(1).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                String[] s = (String[]) (row.getCell(2) == null ? "" : row.getCell(2).toString().trim().split("/"));
                tpb.setAnho(String.valueOf((int) Math.ceil(Double.parseDouble(s[2]))));
                tpb.setMes(String.valueOf((int) Math.ceil(Double.parseDouble(s[1]))));
                tpb.setFecha(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setAnho("0");
                tpb.setMes("0");
                tpb.setEstado(false);
                tpb.setFecha("01-01-0001");
            }

            if ("".equals(row.getCell(4).toString().trim())) {
                tpb.setEstado(false);
            }
            
            tpb.setMonto(row.getCell(5) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(5).toString().trim())));
            
            tpb.setProveedor(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());

            if (!"".equals(row.getCell(6).toString())) {
                tpb.setNroSiaf(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setNroSiaf("Anulado");
            }
            
            
            tpb.setFuenteFinanciamiento(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());

            String[] finan = row.getCell(3).toString().toUpperCase().replace(" POR ", " ").replace("-", "").replace(" DE ", " ").trim().split(" ");
            String finanx = "";

            for (int i = 0; i < finan.length; i++) {
                if (i < finan.length - 1) {
                    finanx += finan[i].substring(0, 1) + ".";
                } else {
                    finanx += finan[i].substring(0, 1);
                }
            }

            tpb.setFinanciamiento(finanx.replace(".Y", "").replace("-", ""));

        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;

    }
}
