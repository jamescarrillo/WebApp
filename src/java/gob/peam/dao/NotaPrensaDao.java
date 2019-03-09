/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.NotaPrensa;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class NotaPrensaDao {

    private SqlSessionFactory sqlSessionFactory;

    public NotaPrensaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<NotaPrensa> listNotaPrensaForNotice(HashMap hm) {
        List<NotaPrensa> notaPrensas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensas = sqlSession.selectList("NotaPrensa.getListForNotice", hm);
            return notaPrensas;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosNotaPrensaForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("NotaPrensa.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<NotaPrensa> listarNotaPrensaForWeb(HashMap hm) {
        List<NotaPrensa> notaPrensas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            notaPrensas = session.selectList("NotaPrensa.getListForWeb", hm);
            return notaPrensas;
        } finally {
            session.close();
        }
    }

    public int listTotalNotaPrensaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<NotaPrensa> notaPrensas = sqlSession.selectList("NotaPrensa.getTotalListForWeb", hm);
            return notaPrensas.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<NotaPrensa> listNotaPrensaForAdmin(HashMap hm) {
        List<NotaPrensa> notaPrensas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensas = sqlSession.selectList("NotaPrensa.getListForAdmin", hm);
            return notaPrensas;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarNotaPrensa(NotaPrensa notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("NotaPrensa.insertNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public NotaPrensa getNotaPrensaForAdmin(Integer id) {
        NotaPrensa notaPrensa;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensa = sqlSession.selectOne("NotaPrensa.getNotaPrensaSingle", id);
            return notaPrensa;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarNotaPrensa(NotaPrensa notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("NotaPrensa.updateNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarNotaPrensa(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("NotaPrensa.deleteNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    public boolean publicarNotaPrensa(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("NotaPrensa.publicarNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    public int listTotalNotaPrensaForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<NotaPrensa> notaPrensas = sqlSession.selectList("NotaPrensa.getTotalListForAdmin",filtro);
            return notaPrensas.size();
        } finally {
            sqlSession.close();
        }
    }
}
