/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Solicitud;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class SolicitudDao {

    private SqlSessionFactory sqlSessionFactory;

    public SolicitudDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Solicitud> listarSolicitud(HashMap hashMap) {
        List<Solicitud> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Solicitud.getListSolicitud", hashMap);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public int listarTotalSolicitud(HashMap hm) {
        List<Solicitud> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Solicitud.getTotalListSolicitud", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public Integer insertarSolicitud(Solicitud reclamo) {
        Integer id = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Solicitud.insertSolicitud", reclamo);
            id=sqlSession.selectOne("Solicitud.maxIdSolicitud");
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return id;
    }

    public List<Solicitud> listSolicitudForAdmin(HashMap hm) {
        List<Solicitud> reclamo;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            reclamo = sqlSession.selectList("Solicitud.getListForAdmin", hm);
            return reclamo;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalSolicitudForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Solicitud> reclamo = sqlSession.selectList("Solicitud.getTotalListForAdmin", filtro);
            return reclamo.size();
        } finally {
            sqlSession.close();
        }
    }

    public Solicitud getSolicitudForAdmin(Integer id) {
        Solicitud data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Solicitud.getSolicitudSingle", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarSolicitud(Solicitud reclamo) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Solicitud.updateSolicitud", reclamo);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarSolicitud(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Solicitud.deleteSolicitud", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<Solicitud>  getAlertaForAdmin() {
            SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("Solicitud.getAlertaSolicitud");
            
        } finally {
            sqlSession.close();
        }
    }
}
