/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.beans;

import gob.peam.administracion.beans.Usuario;

/**
 *
 * @author jpgprog84
 */
public class DocumentoGestion extends Documentos{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1713967784720233698L;

	public DocumentoGestion() {
    }

    public DocumentoGestion(Integer id, String titulo, String resumen, String descripcion ,String fecha, Integer tidoId ,String mimeTypes, String origenArchivo, Double version, boolean estado, boolean activo, Usuario usuario, String fechaDocx, Integer cateId, String metaData) {
        super(id, titulo, resumen, descripcion ,fecha, tidoId, mimeTypes, origenArchivo, version, estado, activo, usuario, fechaDocx, cateId, metaData);
    }
    
}