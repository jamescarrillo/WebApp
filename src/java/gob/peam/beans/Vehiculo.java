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
public class Vehiculo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4276190005939733229L;
    private Integer id;
    private String anho;
    private String mes;
    private String tipoClase;
    private String claseVehiculo;
    private String asignadoA;
    private String cargoActividad;
    private String tipoCombustible;
    private BigDecimal recorridoKm;
    private BigDecimal costoCombustible;
    private String soatFechaVencimiento = "";
    private String placa;
    private String observaciones;
    private boolean estado;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String anho, String mes, String tipoClase, String claseVehiculo, String asignadoA, String cargoActividad, String tipoCombustible, BigDecimal recorridoKm, BigDecimal costoCombustible, String soatFechaVencimiento, String placa, String observaciones, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.mes = mes;
        this.tipoClase = tipoClase;
        this.claseVehiculo = claseVehiculo;
        this.asignadoA = asignadoA;
        this.cargoActividad = cargoActividad;
        this.tipoCombustible = tipoCombustible;
        this.recorridoKm = recorridoKm;
        this.costoCombustible = costoCombustible;
        this.soatFechaVencimiento = soatFechaVencimiento;
        this.placa = placa;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
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

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public BigDecimal getCostoCombustible() {
        return costoCombustible;
    }

    public void setCostoCombustible(BigDecimal costoCombustible) {
        this.costoCombustible = costoCombustible;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getRecorridoKm() {
        return recorridoKm;
    }

    public void setRecorridoKm(BigDecimal recorridoKm) {
        this.recorridoKm = recorridoKm;
    }

    public String getSoatFechaVencimiento() {
        return soatFechaVencimiento;
    }

    public void setSoatFechaVencimiento(String soatFechaVencimiento) {
        this.soatFechaVencimiento = soatFechaVencimiento;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public static Vehiculo load(HSSFRow row) {
        Vehiculo tpb = new Vehiculo();
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
                tpb.setMes(row.getCell(1) == null ? "" : String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim()))));
                if (tpb.getMes().length() == 1) {
                    tpb.setMes("0" + tpb.getMes());
                }
            } else {
                tpb.setMes("00");
                tpb.setEstado(false);
            }
            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setTipoClase(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setClaseVehiculo(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());
            } else {
                tpb.setEstado(false);
            }
            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setAsignadoA(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(5).toString().trim())) {
                tpb.setCargoActividad(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setTipoCombustible(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setRecorridoKm(row.getCell(7) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(7).toString().trim())));

            tpb.setCostoCombustible(row.getCell(8) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(8).toString().trim())));

            if (!"".equals(row.getCell(9).toString().trim())) {
                tpb.setSoatFechaVencimiento(row.getCell(9) == null ? "" : row.getCell(9).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(10).toString().trim())){
                tpb.setPlaca(row.getCell(10) == null ? "" : row.getCell(10).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setObservaciones(row.getCell(11) == null ? "" : row.getCell(11).toString().trim());

        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }
}
