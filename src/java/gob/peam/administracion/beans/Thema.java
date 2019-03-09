/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.beans;

/**
 *
 * @author alabajos
 */
public class Thema {
    private Integer theId;
    private String theNombre;
    private String theImg;
    private String thePath="";

    public Thema() {
    }

    public Thema(Integer theId, String theNombre, String theImg, String thePath) {
        this.theId = theId;
        this.theNombre = theNombre;
        this.theImg = theImg;
        this.thePath = thePath;
    }

    public Integer getTheId() {
        return theId;
    }

    public void setTheId(Integer theId) {
        this.theId = theId;
    }

    public String getTheImg() {
        return theImg;
    }

    public void setTheImg(String theImg) {
        this.theImg = theImg;
    }

    public String getTheNombre() {
        return theNombre;
    }

    public void setTheNombre(String theNombre) {
        this.theNombre = theNombre;
    }

    public String getThePath() {
        return thePath;
    }

    public void setThePath(String thePath) {
        this.thePath = thePath;
    }
    
    
}
