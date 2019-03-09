/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Configuracion;
import gob.peam.config.WebAppConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class ConfiguracionDao {

    private SqlSessionFactory sqlSessionFactory;

    public ConfiguracionDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public Configuracion configuracionForWeb() {
        Configuracion configuracion;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            configuracion = sqlSession.selectOne("Configuracion.getListForWeb");
            return configuracion;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarConfiguracion(Configuracion configuracion) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("Configuracion.updateConfiguracion", configuracion);
            sqlSession.commit();
            return true;
        } catch (SqlSessionException exception) {
            return false;
        } finally {
            sqlSession.close();
        }
    }
}
