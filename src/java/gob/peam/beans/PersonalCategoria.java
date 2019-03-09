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
public class PersonalCategoria implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2288980154601179933L;
    private Integer id;
    private String anho;
    private Integer trimestre;
    private String codigo;
    private String categoria;
    private BigDecimal remuneracionMinima;
    private BigDecimal remuneracionMaxima;
    private Integer numeroTrabajadores;
    private boolean estado;

    public PersonalCategoria() {
    }

    public PersonalCategoria(Integer id, String anho, Integer trimestre, String codigo, String categoria, BigDecimal remuneracionMinima, BigDecimal remuneracionMaxima, Integer numeroTrabajadores, boolean estado) {
        this.id = id;
        this.anho = anho;
        this.trimestre = trimestre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.remuneracionMinima = remuneracionMinima;
        this.remuneracionMaxima = remuneracionMaxima;
        this.numeroTrabajadores = numeroTrabajadores;
        this.estado = estado;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Integer getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(Integer numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public BigDecimal getRemuneracionMaxima() {
        return remuneracionMaxima;
    }

    public void setRemuneracionMaxima(BigDecimal remuneracionMaxima) {
        this.remuneracionMaxima = remuneracionMaxima;
    }

    public BigDecimal getRemuneracionMinima() {
        return remuneracionMinima;
    }

    public void setRemuneracionMinima(BigDecimal remuneracionMinima) {
        this.remuneracionMinima = remuneracionMinima;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public static PersonalCategoria loadCategoria(HSSFRow row) {
        PersonalCategoria tpb = new PersonalCategoria();
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
                tpb.setCodigo(row.getCell(2) == null ? "" : row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setCategoria(row.getCell(3) == null ? "" : row.getCell(3).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setRemuneracionMinima(row.getCell(4) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(4).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(5).toString().trim())) {
                tpb.setRemuneracionMaxima(row.getCell(5) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(5).toString().trim())));
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(6).toString().trim())) {
                tpb.setNumeroTrabajadores(row.getCell(6) == null ? 0 : (int) Math.ceil(Double.parseDouble(row.getCell(6).toString().trim())));
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
