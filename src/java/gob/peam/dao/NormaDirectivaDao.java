/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.NormaDirectiva;
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
public class NormaDirectivaDao {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionFactory sqlSessionFactory1;

    public NormaDirectivaDao() {
        this.sqlSessionFactory = ArcDigConnectionFactory.getSqlSessionFactory();
        this.sqlSessionFactory1 = WebAppConnectionFactory.getSqlSessionFactory();
    }
    @SuppressWarnings("rawtypes")
	public List<NormaDirectiva> listNormasDirectivasForWeb(HashMap hm) {
        List<NormaDirectiva> normasDirectivases;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            normasDirectivases = sqlSession.selectList("NormaDirectiva.getListForWeb", hm);
            return normasDirectivases;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalNormasDirectivasForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            List<NormaDirectiva> normasDirectivases = sqlSession.selectList("NormaDirectiva.getTotalListForWeb", hm);
            return normasDirectivases.size();
        } finally {
            sqlSession.close();
        }
    }

    public NormaDirectiva buscarNormasDirectivasForWeb(Integer id) {
        NormaDirectiva documentoGestion;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            documentoGestion = sqlSession.selectOne("NormaDirectiva.getForWeb", id);
            return documentoGestion;
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
	public List<NormaDirectiva> listNormasDirectivasForAdmin(HashMap hm) {
        List<NormaDirectiva> normasDirectivases;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            normasDirectivases = sqlSession.selectList("NormaDirectiva.getListForAdmin", hm);
            return normasDirectivases;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalNormasDirectivasForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<NormaDirectiva> normasDirectivases = sqlSession.selectList("NormaDirectiva.getTotalListForAdmin", hm);
            return normasDirectivases.size();
        } finally {
            sqlSession.close();
        }
    }
    
}
