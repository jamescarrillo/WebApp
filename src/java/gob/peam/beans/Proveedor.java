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
public class Proveedor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4698988816964680451L;
    private Integer id;
    private String anho;
    private String trimestre;
    private String ruc;
    private String proveedor;
    private BigDecimal importe;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(Integer id, String anho, String trimestre, String ruc, String proveedor, BigDecimal importe, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.trimestre = trimestre;
        this.ruc = ruc;
        this.proveedor = proveedor;
        this.importe = importe;
        this.estado = estado;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
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

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public static Proveedor load(HSSFRow row) {
        Proveedor tpb = new Proveedor();
        try {
            tpb.setId(row.getRowNum());

            tpb.setEstado(true);

            if (!"".equals(row.getCell(0).toString().trim())) {
                tpb.setAnho(row.getCell(0) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(0).toString().trim()))));
            } else {
                tpb.setAnho("0000");
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(1).toString().trim())) {
                tpb.setTrimestre(row.getCell(1) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim()))));
            } else {
                tpb.setTrimestre("0");
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setRuc(row.getCell(2) == null ? "" : String.valueOf((long) Math.ceil(Double.parseDouble(row.getCell(2).toString().trim()))));
            } else {
                tpb.setEstado(false);
            }
            //tpb.setRuc(row.getCell(3).toString().trim());
            
            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setProveedor(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setImporte(row.getCell(4) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(4).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }
}
