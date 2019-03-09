package gob.peam.dao;

import gob.peam.beans.Evento;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author mvilchez
 */
public class EventoDao {

    private SqlSessionFactory sqlSessionFactory;

    public EventoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarEvento(Evento notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Evento.insertNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarEvento(Evento notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Evento.updateNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarEvento(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Evento.deleteNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean publicarEvento(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Evento.publicarNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Evento getEventoForAdmin(Integer id) {
        Evento notaPrensa;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensa = sqlSession.selectOne("Evento.getEventoSingle", id);
            return notaPrensa;
        } finally {
            sqlSession.close();
        }
    }

    public List<Evento> listEventoForAdmin(HashMap hm) {
        List<Evento> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Evento.getListForAdmin", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalEventoForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Evento> items = sqlSession.selectList("Evento.getTotalListForAdmin", filtro);
            return items.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Evento> eventoForWeb(HashMap hm) {
        List<Evento> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Evento.getListForWeb", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

}
