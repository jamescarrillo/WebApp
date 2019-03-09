/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Directivo;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class DirectivoDao {

    private SqlSessionFactory sqlSessionFactory;

    public DirectivoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Directivo> listDirectivoForWeb() {
        List<Directivo> directivos;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            directivos = sqlSession.selectList("Directivo.getListForWeb");
            return directivos;
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Directivo> listDirectivoForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("Directivo.getListForAdmin", hm);
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalDirectivoForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Directivo> data = sqlSession.selectList("Directivo.getListForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }
    
    public boolean insertarDirectivo(HashMap hm) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Directivo.insertDirectivo", hm);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    
    public Directivo buscarDirectivo(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("Directivo.buscarDirectivo", id);
        } finally {
            sqlSession.close();
        }

    }

    public boolean actualizarDirectivo(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Directivo.updateDirectivo", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public boolean eliminarDirectivo(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Directivo.deleteDirectivo", id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public boolean estadoDirectivo(HashMap hashMap) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Directivo.estadoDirectivo", hashMap);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
