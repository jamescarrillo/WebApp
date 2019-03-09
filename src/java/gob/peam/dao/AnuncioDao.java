/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anuncio;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class AnuncioDao {

    private SqlSessionFactory sqlSessionFactory;

    public AnuncioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public Anuncio listAnuncioForNotice(HashMap hm) {
        Anuncio multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectOne("Anuncio.getAnuncioForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Anuncio> listarAnuncioForWeb(HashMap hm) {
        List<Anuncio> multimedias;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            multimedias = session.selectList("Anuncio.getListForWeb", hm);
            return multimedias;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalAnuncioForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Anuncio> multimedias = sqlSession.selectList("Anuncio.getTotalListForWeb", hm);
            return multimedias.size();
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalAnuncioForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Anuncio> data = sqlSession.selectList("Anuncio.getTotalListForAdmin", filtro);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Anuncio> listAnuncioAdmin(HashMap hm) {
        List<Anuncio> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Anuncio.getListForAdmin", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Anuncio getAnuncioAdmin(Integer id) {
        Anuncio data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Anuncio.getAnuncioSingle", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Anuncio getAnuncioforWeb(String fecha) {
        Anuncio data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Anuncio.getAnuncioForWeb", fecha);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarAnuncio(Anuncio multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Anuncio.insertAnuncio", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarAnuncio(Anuncio multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Anuncio.updateAnuncio", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarAnuncio(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Anuncio.deleteAnuncio", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<String> listAnhosAnuncioForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Anuncio.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public boolean publicarAnuncio(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Anuncio.publicarAnuncio", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
