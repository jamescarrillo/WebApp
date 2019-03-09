/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

public class Comentario {

    private String numero;
    private String anho;
    private String usuario="";
    private String fecha;
    private String correo="";
    private String tema="";
    private String descripcion = "";
    private Boolean estado;

    public Comentario() {
    }

    public Comentario(String numero, String anho, String usuario, String fecha, String correo, String tema, Boolean estado) {
        this.numero = numero;
        this.anho = anho;
        this.usuario = usuario;
        this.fecha = fecha;
        this.correo = correo;
        this.tema = tema;
        this.estado = estado;
    }

    public String getAnho() {
        if (anho.length() > 0) {
            return anho;
        } else {
            return " ";
        }
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getCorreo() {
        if (correo.length() > 0) {
            return correo;
        } else {
            return " ";
        }
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        if (descripcion.length() > 0) {
            return descripcion;
        } else {
            return " ";
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        if (fecha.length() > 0) {
            return fecha;
        } else {
            return " ";
        }
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        if (numero.length() > 0) {
            return numero;
        } else {
            return " ";
        }
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTema() {
        if (tema.length() > 0) {
            return tema;
        } else {
            return " ";
        }
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUsuario() {
        if (usuario.length() > 0) {
            return usuario;
        } else {
            return " ";
        }
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
