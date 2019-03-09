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
public class Telefonia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7061113973326484324L;
    private Integer id;
    private String anho;
    private String mes;
    private String areaOficina;
    private String asignadoA;
    private String cargoActividad;
    private BigDecimal importe;
    private boolean estado;
    private String tipo;
    private String numero;

    public Telefonia() {
    }

    public Telefonia(Integer id, String anho, String mes, String areaOficina, String asignadoA, String cargoActividad, BigDecimal importe, boolean estado, String tipo, String numero) {
        this.id = id;
        this.anho = anho;
        this.mes = mes;
        this.areaOficina = areaOficina;
        this.asignadoA = asignadoA;
        this.cargoActividad = cargoActividad;
        this.importe = importe;
        this.estado = estado;
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getAreaOficina() {
        return areaOficina;
    }

    public void setAreaOficina(String areaOficina) {
        this.areaOficina = areaOficina;
    }

    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    public String getCargoActividad() {
        return cargoActividad;
    }

    public void setCargoActividad(String cargoActividad) {
        this.cargoActividad = cargoActividad;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static Telefonia load(HSSFRow row) {
        Telefonia tpb = new Telefonia();
        try {
            tpb.setEstado(true);
            tpb.setId(row.getRowNum());

            if (!"".equals(row.getCell(0).toString().trim())) {
                tpb.setAnho(row.getCell(0) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(0).toString().trim()))));
            } else {
                tpb.setAnho("0000");
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(1).toString().trim())) {
                tpb.setMes(row.getCell(1) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim()))));
                if (tpb.getMes().length() == 1) {
                    tpb.setMes("0" + tpb.getMes());
                }
            } else {
                tpb.setMes("00");
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setTipo(row.getCell(2).toString().trim());
            } else {
                tpb.setTipo(" ");
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setNumero(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setAreaOficina(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(5).toString().trim())) {
                tpb.setAsignadoA(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setCargoActividad(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setImporte(row.getCell(7) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(7).toString().trim())));


        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }
}
