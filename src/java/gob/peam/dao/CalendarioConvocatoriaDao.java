/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.CalendarioConvocatoria;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class CalendarioConvocatoriaDao {

    private SqlSessionFactory sqlSessionFactory;

    public CalendarioConvocatoriaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarCalendarioConvocatoria(CalendarioConvocatoria calendario) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("CalendarioConvocatoria.insertCalendarioConvocatoria", calendario);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public List<CalendarioConvocatoria> listarCalendarioConvocatoriaForAdmin(HashMap hm) {
        List<CalendarioConvocatoria> calendario;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            calendario = session.selectList("CalendarioConvocatoria.listarCalendarioConvocatoriaForAdmin", hm);
            return calendario;
        } finally {
            session.close();
        }
    }

    public int listarTotalConvocatoriaBienForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<CalendarioConvocatoria> data = sqlSession.selectList("CalendarioConvocatoria.listarTotalCalendarioConvocatoriaForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<CalendarioConvocatoria> listarCalendarioConvocatoriaForWeb(Integer codigo) {
        List<CalendarioConvocatoria> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("CalendarioConvocatoria.listarCalendarioConvocatoriaForWeb", codigo);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public CalendarioConvocatoria buscarCalendarioConvocatoria(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CalendarioConvocatoria calendario = session.selectOne("CalendarioConvocatoria.buscarCalendarioConvocatoria", codigo);
            return calendario;
        } finally {
            session.close();
        }
    }

    public boolean actualizarCalendarioConvocatoria(CalendarioConvocatoria c) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("CalendarioConvocatoria.updateCalendarioConvocatoria", c);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    /**
     * *******************
     */
    public boolean eliminarCalendarioConvocatoria(HashMap hm) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<CalendarioConvocatoria> a = sqlSession.selectList("CalendarioConvocatoria.childrenCalendarioConvocatoria", hm);
            if (a.size() > 0) {
                estado = false;
            } else {
                sqlSession.delete("CalendarioConvocatoria.deleteCalendarioConvocatoria", hm);
                sqlSession.commit();
                estado = true;
            }
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    /**
     * **************************Calendario Personal
     * *********************************************
     */
    public boolean insertarCalendarioConvocatoriaPers(CalendarioConvocatoria calendario) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("CalendarioConvocatoria.insertCalendarioConvocatoriaPers", calendario);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public List<CalendarioConvocatoria> listarCalendarioConvocatoriaPersForAdmin(HashMap hm) {
        List<CalendarioConvocatoria> calendario;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            calendario = session.selectList("CalendarioConvocatoria.listarCalendarioConvocatoriaPersForAdmin", hm);
            return calendario;
        } finally {
            session.close();
        }
    }

    public int listarTotalConvocatoriaPersForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<CalendarioConvocatoria> data = sqlSession.selectList("CalendarioConvocatoria.listarTotalCalendarioConvocatoriaPersForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<CalendarioConvocatoria> listarCalendarioConvocatoriaPersForWeb(Integer codigo) {
        List<CalendarioConvocatoria> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("CalendarioConvocatoria.listarCalendarioConvocatoriaPersForWeb", codigo);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public CalendarioConvocatoria buscarCalendarioConvocatoriaPers(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CalendarioConvocatoria calendario = session.selectOne("CalendarioConvocatoria.buscarCalendarioConvocatoriaPers", codigo);
            return calendario;
        } finally {
            session.close();
        }
    }

    public boolean actualizarCalendarioConvocatoriaPers(CalendarioConvocatoria c) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("CalendarioConvocatoria.updateCalendarioConvocatoria", c);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
