/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Busqueda;
import gob.peam.config.WebAppConnectionFactory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class BusquedaDao implements Serializable {

    private SqlSessionFactory sqlSessionFactory;

    public BusquedaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Busqueda> listarBusqueda(HashMap hashMap) {
        List<Busqueda> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Busqueda.getListBusqueda", hashMap);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public int listarTotalBusqueda(HashMap hm) {
        List<Busqueda> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Busqueda.getTotalBusquedaTotal", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }
}
