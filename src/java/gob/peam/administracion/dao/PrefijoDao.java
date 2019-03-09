/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Prefijo;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class PrefijoDao {

    private SqlSessionFactory sqlSessionFactory;

    public PrefijoDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Prefijo> listarPrefijos(String anio) {
        List<Prefijo> prefijos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            prefijos = session.selectList("Prefijo.selectPrefijos", anio);
            return prefijos;
        } finally {
            session.close();
        }
    }

    public boolean insertPrefijo(Prefijo prefijo) {
        boolean result = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Prefijo.insertPrefijo", prefijo);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public Prefijo buscarPrefijo(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Prefijo prefijo = session.selectOne("Prefijo.buscarPrefijo", hm);
            return prefijo;
        } finally {
            session.close();
        }
    }

    public boolean actualizarPrefijo(Prefijo prefijo) {
        boolean result = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Prefijo.updatePrefijo", prefijo);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }
}
