/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.DocumentoConvocatoria;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class DocumentoConvocatoriaDao {
    private SqlSessionFactory sqlSessionFactory;

    public DocumentoConvocatoriaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();

    }

    @SuppressWarnings("rawtypes")
    public List<DocumentoConvocatoria> listDocumentoConvocotariaForAdmin(HashMap hm) {
        List<DocumentoConvocatoria> doc;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            doc = sqlSession.selectList("DocumentoConvocatoria.getListForAdmin", hm);
            return doc;
        } finally {
            sqlSession.close();
        }
    }

    public List<DocumentoConvocatoria> listarDocumentoConvocatoriaForWeb(Integer codigo) {
        List<DocumentoConvocatoria> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("DocumentoConvocatoria.getListForWeb", codigo);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalDocumentoConvocatoriaForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<DocumentoConvocatoria> resolucionGerencials = sqlSession.selectList("DocumentoConvocatoria.getTotalListForAdmin", hm);
            return resolucionGerencials.size();
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public int TotalDocumentoConvocatoriaForWeb(Integer codigo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return  sqlSession.selectOne("DocumentoConvocatoria.getTotalForWeb", codigo);
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")

    public boolean insertarDocumentoConvocatoria(DocumentoConvocatoria documento) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("DocumentoConvocatoria.insertDocumentoConvocatoria", documento);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarDocumentoConvocatoria(Integer id) {
        boolean existe = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            existe = true;
            session.delete("DocumentoConvocatoria.deleteDocumentoConvocatoria", id);
            session.commit();
        } finally {
            session.close();
        }
        return existe;
    }
}
