/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Enlace;
import gob.peam.config.WebAppConnectionFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class EnlaceDao  {

    private SqlSessionFactory sqlSessionFactory;

    public EnlaceDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Enlace> listEnlacesForNotice() {
        List<Enlace> enlaces;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            enlaces = sqlSession.selectList("Enlace.getListEnlaces");
            return enlaces;
        } finally {
            sqlSession.close();
        }

    }
}
