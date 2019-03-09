package gob.peam.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class Viatico implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9029182982526122849L;
    private Integer id;
    private String anho;
    private String mes;
    private String tipoViatico;
    private String modalidad;
    private String areaOficina;
    private String usuarios;
    private String fuenteFinanciamiento;
    private String fechaSalida;
    private String fechaRetorno;
    private String ruta;
    private String autorizacionViaje;
    private String resolucion;
    private BigDecimal costoPasajes;
    private BigDecimal viaticos;
    private boolean estado;

    public Viatico() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Viatico(Integer id, String anho, String mes, String tipoViatico, String modalidad, String areaOficina, String usuarios, String fuenteFinanciamiento, String fechaSalida, String fechaRetorno,
            String ruta, String autorizacionViaje, String resolucion, BigDecimal costoPasajes, BigDecimal viaticos, boolean estado) {
        super();
        this.id = id;
        this.anho = anho;
        this.mes = mes;
        this.tipoViatico = tipoViatico;
        this.modalidad = modalidad;
        this.areaOficina = areaOficina;
        this.usuarios = usuarios;
        this.fuenteFinanciamiento = fuenteFinanciamiento;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.ruta = ruta;
        this.autorizacionViaje = autorizacionViaje;
        this.resolucion = resolucion;
        this.costoPasajes = costoPasajes;
        this.viaticos = viaticos;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTipoViatico() {
        return tipoViatico;
    }

    public void setTipoViatico(String tipoViatico) {
        this.tipoViatico = tipoViatico;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getAreaOficina() {
        return areaOficina;
    }

    public void setAreaOficina(String areaOficina) {
        this.areaOficina = areaOficina;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getFuenteFinanciamiento() {
        return fuenteFinanciamiento;
    }

    public void setFuenteFinanciamiento(String fuenteFinanciamiento) {
        this.fuenteFinanciamiento = fuenteFinanciamiento;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getAutorizacionViaje() {
        return autorizacionViaje;
    }

    public void setAutorizacionViaje(String autorizacionViaje) {
        this.autorizacionViaje = autorizacionViaje;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public BigDecimal getCostoPasajes() {
        return costoPasajes;
    }

    public void setCostoPasajes(BigDecimal costoPasajes) {
        this.costoPasajes = costoPasajes;
    }

    public BigDecimal getViaticos() {
        return viaticos;
    }

    public void setViaticos(BigDecimal viaticos) {
        this.viaticos = viaticos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static Viatico load(HSSFRow row) {
        Viatico tpb = new Viatico();
        try {
            tpb.setEstado(true);
            tpb.setId(row.getRowNum());

            if (!"".equals(row.getCell(6).toString().trim())) {
                String[] s = (String[]) (row.getCell(6) == null ? "" : row.getCell(6).toString().trim().split("/"));
                tpb.setAnho(String.valueOf((int) Math.ceil(Double.parseDouble(s[2]))));
                tpb.setMes(String.valueOf((int) Math.ceil(Double.parseDouble(s[1]))));
                tpb.setFechaSalida(row.getCell(6) == null ? "" : row.getCell(6).toString().trim());
            } else {
                tpb.setAnho("0");
                tpb.setMes("0");
                tpb.setEstado(false);
                tpb.setFechaSalida("01-01-0001");
            }
            
            if (!"".equals(row.getCell(1).toString().trim())) {
                tpb.setTipoViatico(row.getCell(1).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(2).toString().trim())) {
                tpb.setModalidad(row.getCell(2).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(3).toString().trim())) {
                tpb.setAreaOficina(row.getCell(3).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(4).toString().trim())) {
                tpb.setUsuarios(row.getCell(4).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(5).toString().trim())) {
                tpb.setFuenteFinanciamiento(row.getCell(5).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(7).toString().trim())) {
                tpb.setFechaRetorno(row.getCell(7).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(8).toString().trim())) {
                tpb.setRuta(row.getCell(8).toString().trim());
            } else {
                tpb.setEstado(false);
            }

            if (!"".equals(row.getCell(9).toString().trim())) {
                tpb.setAutorizacionViaje(row.getCell(9).toString().trim());
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(10).toString())) {
                tpb.setResolucion(row.getCell(10).toString().trim());
            } else {
                tpb.setResolucion("");
            }
            
            if (!"".equals(row.getCell(11).toString().trim())) {
                tpb.setCostoPasajes(row.getCell(11) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(11).toString().trim())));
            } else {
                tpb.setEstado(false);
            }
            
            if (!"".equals(row.getCell(12).toString().trim())) {
                tpb.setViaticos(row.getCell(12) == null ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Double.parseDouble(row.getCell(12).toString().trim())));
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
