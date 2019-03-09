/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Sesion;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class SesionDao {

    private SqlSessionFactory sqlSessionFactory;

    public SesionDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarSesion(Sesion sesion) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Sesion.insertSesion", sesion);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean actualizarSesion(Sesion sesion) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Sesion.updateSesion", sesion);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Sesion buscarSesion(String sesiKey) {
        Sesion sesion;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            sesion = session.selectOne("Sesion.buscarSesion", sesiKey);
            return sesion;
        } finally {
            session.close();
        }
    }

    public List<Sesion> listarSesionesActivas(HashMap hm) {
        List<Sesion> list;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("Sesion.listarSesionesActivas", hm);
            return list;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalSesiones(HashMap hm) {
        List<Sesion> list;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("Sesion.listarTotalSesiones", hm);
            return list.size();
        } finally {
            session.close();
        }
    }

    public boolean verificarSesion(HttpServletRequest request, HttpServletResponse response) {
       
            Sesion s = buscarSesion(request.getSession().getId());
            if (s == null) {
                return false;
            } else if (s.isSesiEstado()) {
                return true;
            } else {
                request.getSession().invalidate();
                request.getSession(true);
                return false;
            }
    }
}
