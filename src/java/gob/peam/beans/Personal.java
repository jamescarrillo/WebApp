/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import java.math.BigDecimal;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 *
 * @author alabajos
 */
public class Personal {

    private Integer id;
    private String anho;
    private String denominacion;
    private Integer trimestre;
    private String cargo;
    private String codigoFormato;
    private String pension;
    private String fechaIngreso;
    private String fechaCede;
    private String apellidosNombres;
    private String numeroDni;
    private String codigoCivil;
    private String oficinaArea;
    private BigDecimal remuneracionMensual;
    private BigDecimal beneficios;
    private BigDecimal ingresoTotal;
    private Integer tipo;
    private String categoria;
    private Boolean estado;
    private String observacion;
    private BigDecimal bonificacionQuinqu;
    
    public Personal() {
    }

    public Personal(Integer id, String anho, String denominacion, Integer trimestre, String cargo, String codigoFormato, String pension, String fechaIngreso, String fechaCede, String apellidosNombres, String numeroDni, String codigoCivil, String oficinaArea, BigDecimal remuneracionMensual, BigDecimal beneficios, BigDecimal ingresoTotal, Integer tipo, String categoria, Boolean estado, String observacion, BigDecimal bonificacionQuinqu) {
        this.id = id;
        this.anho = anho;
        this.denominacion = denominacion;
        this.trimestre = trimestre;
        this.cargo = cargo;
        this.codigoFormato = codigoFormato;
        this.pension = pension;
        this.fechaIngreso = fechaIngreso;
        this.fechaCede = fechaCede;
        this.apellidosNombres = apellidosNombres;
        this.numeroDni = numeroDni;
        this.codigoCivil = codigoCivil;
        this.oficinaArea = oficinaArea;
        this.remuneracionMensual = remuneracionMensual;
        this.beneficios = beneficios;
        this.ingresoTotal = ingresoTotal;
        this.tipo = tipo;
        this.categoria = categoria;
        this.estado = estado;
        this.observacion = observacion;
        this.bonificacionQuinqu = bonificacionQuinqu;
    }

    public String getAnho() {
        return anho;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        this.apellidosNombres = apellidosNombres;
    }

    public BigDecimal getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(BigDecimal beneficios) {
        this.beneficios = beneficios;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigoCivil() {
        return codigoCivil;
    }

    public void setCodigoCivil(String codigoCivil) {
        this.codigoCivil = codigoCivil;
    }

    public String getCodigoFormato() {
        return codigoFormato;
    }

    public void setCodigoFormato(String codigoFormato) {
        this.codigoFormato = codigoFormato;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaCede() {
        return fechaCede;
    }

    public void setFechaCede(String fechaCede) {
        this.fechaCede = fechaCede;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getIngresoTotal() {
        return ingresoTotal;
    }

    public void setIngresoTotal(BigDecimal ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getOficinaArea() {
        return oficinaArea;
    }

    public void setOficinaArea(String oficinaArea) {
        this.oficinaArea = oficinaArea;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public BigDecimal getRemuneracionMensual() {
        return remuneracionMensual;
    }

    public void setRemuneracionMensual(BigDecimal remuneracionMensual) {
        this.remuneracionMensual = remuneracionMensual;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }
    
    public BigDecimal getBonificacionQuinqu() {
        return bonificacionQuinqu;
    }

    public void setBonificacionQuinqu(BigDecimal bonificacionQuinqu) {
        this.bonificacionQuinqu = bonificacionQuinqu;
    }


    public static Personal loadPlanilla(HSSFRow row) {
        Personal tpb = new Personal();
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
                tpb.setTrimestre(row.getCell(1) == null ? 0 : (int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim())));
            } else {
                tpb.setTrimestre(0);
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setApellidosNombres(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setNumeroDni(String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(3).toString().trim()))));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setFechaIngreso(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setFechaCede(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setOficinaArea(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(7).toString().trim())) {
                tpb.setCargo(row.getCell(7) == null ? "" : row.getCell(7).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(8).toString().trim())) {
                tpb.setCategoria(row.getCell(8) == null ? "" : row.getCell(8).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(9).toString().trim())) {
                tpb.setCodigoCivil(row.getCell(9) == null ? "" : row.getCell(9).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(10).toString().trim())) {
                tpb.setPension(row.getCell(10) == null ? "" : row.getCell(10).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(11).toString().trim())) {
                tpb.setRemuneracionMensual(row.getCell(11) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(11).toString().trim())));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(12).toString().trim())) {
                tpb.setBeneficios(row.getCell(12) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(12).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(13).toString().trim())) {
                tpb.setBonificacionQuinqu(row.getCell(13) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(13).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(14).toString().trim())) {
                tpb.setIngresoTotal(row.getCell(14) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(14).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
            tpb.setObservacion(row.getCell(15) == null ? "" : row.getCell(15).toString().trim());
            tpb.setCodigoFormato("");

            tpb.setTipo(1);
        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }

    public static Personal loadLocador(HSSFRow row) {
        Personal tpb = new Personal();
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
                tpb.setTrimestre(row.getCell(1) == null ? 0 : (int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim())));
            } else {
                tpb.setTrimestre(0);
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setApellidosNombres(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setNumeroDni(String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(3).toString().trim()))));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setFechaIngreso(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setFechaCede(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setOficinaArea(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(7).toString().trim())) {
                tpb.setCargo(row.getCell(7) == null ? "" : row.getCell(7).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(8).toString().trim())) {
                tpb.setCodigoCivil(row.getCell(8) == null ? "" : row.getCell(8).toString().trim());
            } else {
                tpb.setEstado(false);
            }
           
            if (!"".equals(row.getCell(9).toString().trim())) {
                tpb.setRemuneracionMensual(row.getCell(9) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(9).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
             if (!"".equals(row.getCell(10).toString().trim())) {
                tpb.setIngresoTotal(row.getCell(10) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(10).toString().trim())));
            } else {
                tpb.setEstado(false);
            }

            
            //tpb.setRemuneracionMensual(BigDecimal.valueOf(0));
            //tpb.setIngresoTotal(BigDecimal.valueOf(0));
            tpb.setObservacion(row.getCell(11) == null ? "" : row.getCell(11).toString().trim());
            tpb.setCodigoFormato("");
            tpb.setBeneficios(BigDecimal.valueOf(0));
            tpb.setCategoria("");
            //tpb.setCargo("");
            tpb.setPension("");

            tpb.setTipo(2);
        } catch (Exception ex) {
            return tpb;
        }
        return tpb;
    }

    public static Personal loadCAS(HSSFRow row) {
        Personal tpb = new Personal();
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
                tpb.setTrimestre(row.getCell(1) == null ? 0 : (int) Math.ceil(Double.parseDouble(row.getCell(1).toString().trim())));
            } else {
                tpb.setTrimestre(0);
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setApellidosNombres(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setNumeroDni(String.valueOf((int) Math.ceil(Double.parseDouble(row.getCell(3).toString().trim()))));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setFechaIngreso(row.getCell(4) == null ? "" : row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            tpb.setFechaCede(row.getCell(5) == null ? "" : row.getCell(5).toString().trim());

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setOficinaArea(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(7).toString().trim())) {
                tpb.setCargo(row.getCell(7) == null ? "" : row.getCell(7).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(8).toString().trim())) {
                tpb.setCodigoCivil(row.getCell(8) == null ? "" : row.getCell(8).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(9).toString().trim())) {
                tpb.setRemuneracionMensual(row.getCell(9) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(9).toString().trim())));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(10).toString().trim())) {
                tpb.setIngresoTotal(row.getCell(10) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(10).toString().trim())));
            } else {
                tpb.setEstado(false);
            }

            tpb.setCodigoFormato("");
            
            tpb.setObservacion(row.getCell(11) == null ? "" : row.getCell(11).toString().trim());
            
            tpb.setBeneficios(BigDecimal.valueOf(0));

            tpb.setCategoria("");
            //tpb.setCargo("");
            tpb.setPension("");

            tpb.setTipo(3);

        } catch (Exception ex) {
            tpb.setEstado(false);
            return tpb;
        }
        return tpb;
    }
}
