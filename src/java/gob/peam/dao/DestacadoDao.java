package gob.peam.dao;

import gob.peam.beans.Destacado;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author mvilchez
 */
public class DestacadoDao {

    private SqlSessionFactory sqlSessionFactory;

    public DestacadoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarDestacado(Destacado notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Destacado.insertNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarDestacado(Destacado notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Destacado.updateNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarDestacado(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Destacado.deleteNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean publicarDestacado(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Destacado.publicarNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Destacado getDestacadoForAdmin(Integer id) {
        Destacado notaPrensa;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensa = sqlSession.selectOne("Destacado.getDestacadoSingle", id);
            return notaPrensa;
        } finally {
            sqlSession.close();
        }
    }

    public List<Destacado> listDestacadoForAdmin(HashMap hm) {
        List<Destacado> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Destacado.getListForAdmin", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalDestacadoForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Destacado> items = sqlSession.selectList("Destacado.getTotalListForAdmin", filtro);
            return items.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Destacado> destacadoForWeb(HashMap hm) {
        List<Destacado> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Destacado.getListForWeb", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

}
