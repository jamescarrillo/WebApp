/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Multimedia;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class MultimediaDao {

    private SqlSessionFactory sqlSessionFactory;

    public MultimediaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public Multimedia listMultimediaForNotice(HashMap hm) {
        Multimedia multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectOne("Multimedia.getMultimediaForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public List<Multimedia> listMultimediasForNotice(HashMap hm) {
        List<Multimedia> multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectList("Multimedia.getMultimediasForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Multimedia> listarMultimediaForWeb(HashMap hm) {
        List<Multimedia> multimedias;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            multimedias = session.selectList("Multimedia.getListForWeb", hm);
            return multimedias;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalMultimediaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Multimedia> multimedias = sqlSession.selectList("Multimedia.getTotalListForWeb", hm);
            return multimedias.size();
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalMultimediaForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Multimedia> data = sqlSession.selectList("Multimedia.getTotalListForAdmin", filtro);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Multimedia> listMultimediaAdmin(HashMap hm) {
        List<Multimedia> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Multimedia.getListForAdmin", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Multimedia getMultimediaAdmin(Integer id) {
        Multimedia data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Multimedia.getMultimediaSingle", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarMultimedia(Multimedia multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Multimedia.insertMultimedia", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarMultimedia(Multimedia multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Multimedia.updateMultimedia", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean predefinirMultimedia(Multimedia multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Multimedia.predefinirMultimedia", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarMultimedia(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Multimedia.deleteMultimedia", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    public boolean publicarMultimedia(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Multimedia.publicarMultimedia", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
