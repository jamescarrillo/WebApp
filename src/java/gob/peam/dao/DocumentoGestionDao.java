/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.CategoriaDocumento;
import gob.peam.beans.DocumentoGestion;
import gob.peam.beans.Documentos;
import gob.peam.config.ArcDigConnectionFactory;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class DocumentoGestionDao {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionFactory sqlSessionFactory1;

    public DocumentoGestionDao() {
        this.sqlSessionFactory = ArcDigConnectionFactory.getSqlSessionFactory();
        this.sqlSessionFactory1 = WebAppConnectionFactory.getSqlSessionFactory();

    }

    @SuppressWarnings("rawtypes")
    public List<DocumentoGestion> listDocumentoGestionForWeb(HashMap hm) {
        List<DocumentoGestion> documentoGestions;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            documentoGestions = sqlSession.selectList("DocumentoGestion.getListForWeb", hm);
            return documentoGestions;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalDocumentoGestionForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            List<DocumentoGestion> documentoGestions = sqlSession.selectList("DocumentoGestion.getTotalListForWeb", hm);
            return documentoGestions.size();
        } finally {
            sqlSession.close();
        }
    }

    public Documentos buscarDocumentoGestionForWeb(Integer id) {
        Documentos documentoGestion;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            documentoGestion = sqlSession.selectOne("DocumentoGestion.getForWeb", id);
            return documentoGestion;
        } finally {
            sqlSession.close();
        }
    }

    public DocumentoGestion buscarDocumentoGestionPublico(Integer id) {
        DocumentoGestion documentoGestion;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            documentoGestion = sqlSession.selectOne("DocumentoGestion.getDataPublicado", id);
            return documentoGestion;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<CategoriaDocumento> listCategoriaDocumento(HashMap hm) {
        List<CategoriaDocumento> categoriaDocumento;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            categoriaDocumento = sqlSession.selectList("CategoriaDocumento.getListForWeb", hm);
            return categoriaDocumento;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<DocumentoGestion> listDocumentoGestionForAdmin(HashMap hm) {
        List<DocumentoGestion> documentoGestions;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            documentoGestions = sqlSession.selectList("DocumentoGestion.getListForAdmin", hm);
            return documentoGestions;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalDocumentoGestionForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<DocumentoGestion> documentoGestions = sqlSession.selectList("DocumentoGestion.getTotalListForAdmin", hm);
            return documentoGestions.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertDocumentoGestionPublico(Documentos documento) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            sqlSession.insert("DocumentoGestion.updateDocumentoGestionPublico", documento);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarDocumentoGestionPublico(Documentos documento) {
        SqlSession session = sqlSessionFactory1.openSession();
        boolean result = false;
        try {
            session.update("DocumentoGestion.modiDocumentoGestionPublico", documento);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public Documentos sincronizarDocumentos(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            
            return  sqlSession.selectOne("DocumentoGestion.getDataPublicado", id);
        } finally {
            sqlSession.close();
        }
    }

    
}
