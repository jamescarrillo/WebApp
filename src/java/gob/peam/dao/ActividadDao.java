/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Actividad;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class ActividadDao {

    private SqlSessionFactory sqlSessionFactory;

    public ActividadDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Actividad> listarActividad(HashMap h) {
        List<Actividad> acti;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            acti = session.selectList("Actividad.listarActividad", h);
            return acti;
        } finally {
            session.close();
        }
    }

    public Actividad buscarActividad(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Actividad actividad = session.selectOne("Actividad.buscarActividad", codigo);
            return actividad;
        } finally {
            session.close();
        }
    }

    /**
     * ********************** PERSONAL    ************************
     */
    public List<Actividad> listarActividadPers(HashMap h) {
        List<Actividad> acti;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            acti = session.selectList("Actividad.listarActividadPers", h);
            return acti;
        } finally {
            session.close();
        }
    }

    public Actividad buscarActividadPers(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Actividad actividad = session.selectOne("Actividad.buscarActividadPers", codigo);
            return actividad;
        } finally {
            session.close();
        }
    }

    public Boolean insertarActividadPers(Actividad a) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Actividad.insertActividad", a);
            session.commit();
        } finally {
            session.close();
        }
        return true;
    }

    /*
     * public boolean existeEtiqueta(String descripcion) { boolean existe =
     * false; List<Etiqueta> etiquetas; SqlSession session =
     * sqlSessionFactory.openSession(); try { etiquetas =
     * session.selectList("Etiqueta.existeEtiqueta", descripcion); if
     * (etiquetas.size() > 0) { existe = true; } else { existe = false; } }
     * finally { session.close(); } return existe; }
     */
    public boolean actualizarActividad(Actividad actividad) {
        boolean result = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Actividad.updateActividad", actividad);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }
    /*
     * public boolean tieneDependencias(Integer id) { boolean resul; SqlSession
     * session = sqlSessionFactory.openSession(); try { List<SubModulo>
     * subModulos = session.selectList("Etiqueta.childrenEtiqueta", id); if
     * (subModulos.size() > 0) { resul = true; } else { resul = false; } return
     * resul; } finally { session.close(); } }
     */

    public boolean eliminarActividad(Integer id) {
        boolean existe = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Actividad> a = session.selectList("Actividad.childrenActividad", id);
            if (a.size() > 0) {
                 existe = false;
            } else {
                existe = true;
                session.delete("Actividad.deleteActividad", id);
                session.commit();
            }
        } finally {
            session.close();
        }
        return existe;
    }
}
