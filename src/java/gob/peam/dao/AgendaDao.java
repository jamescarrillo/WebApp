package gob.peam.dao;

import gob.peam.beans.Agenda;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AgendaDao {

    private SqlSessionFactory sqlSessionFactory;

    public AgendaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Agenda> listAgendaForWeb(HashMap hm) {
        List<Agenda> agendas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            agendas = sqlSession.selectList("Agenda.getListForWeb", hm);
            return agendas;
        } finally {
            sqlSession.close();
        }
    }

    public List<Agenda> listAgendaDayForWeb(HashMap hm) {
        List<Agenda> agendas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            agendas = sqlSession.selectList("Agenda.getListDayForWeb", hm);
            return agendas;
        } finally {
            sqlSession.close();
        }
    }
    
    public Agenda lastAgendaForWeb(HashMap hm) {
        Agenda agendas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            agendas = sqlSession.selectOne("Agenda.getLastAgendaForWeb", hm);
            return agendas;
        } finally {
            sqlSession.close();
        }
    }

    public List<Agenda> listAgendaForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("Agenda.getListForAdmin", hm);
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalAgendaForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Agenda> data = sqlSession.selectList("Agenda.getTotalForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarActividadAgenda(HashMap hm) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Agenda.insertActividadAgenda", hm);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Agenda buscarActividadAgenda(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("Agenda.buscarActividadAgenda", id);
        } finally {
            sqlSession.close();
        }

    }

    public boolean actualizarActividadAgenda(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Agenda.updateActividadAgenda", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public boolean eliminarActividadAgenda(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Agenda.deleteActividadAgenda", id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public boolean estadoActividadAgenda(HashMap hashMap) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Agenda.estadoActividadAgenda", hashMap);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
