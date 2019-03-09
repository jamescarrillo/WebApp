package gob.peam.dao;

import gob.peam.beans.Estudio;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author mvilchez
 */
public class EstudioDao {

    private SqlSessionFactory sqlSessionFactory;

    public EstudioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarEstudio(Estudio notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Estudio.insertNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarEstudio(Estudio notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Estudio.updateNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarEstudio(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Estudio.deleteNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean publicarEstudio(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Estudio.publicarNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Estudio getEstudioForAdmin(Integer id) {
        Estudio notaPrensa;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensa = sqlSession.selectOne("Estudio.getEstudioSingle", id);
            return notaPrensa;
        } finally {
            sqlSession.close();
        }
    }

    public List<Estudio> listEstudioForAdmin(HashMap hm) {
        List<Estudio> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Estudio.getListForAdmin", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalEstudioForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Estudio> items = sqlSession.selectList("Estudio.getTotalListForAdmin", filtro);
            return items.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Estudio> estudioForWeb(HashMap hm) {
        List<Estudio> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Estudio.getListForWeb", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

}
