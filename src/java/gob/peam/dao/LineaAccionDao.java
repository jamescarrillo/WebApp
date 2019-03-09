package gob.peam.dao;

import gob.peam.beans.LineaAccion;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author mvilchez
 */
public class LineaAccionDao {

    private SqlSessionFactory sqlSessionFactory;

    public LineaAccionDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<LineaAccion> listLineaAccionActivos() {
        List<LineaAccion> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("LineaAccion.getListActivos");
            return items;
        } finally {
            sqlSession.close();
        }
    }
    
    public List<LineaAccion> listDireccionesActivos() {
        List<LineaAccion> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("LineaAccion.getDireccionesActivos");
            return items;
        } finally {
            sqlSession.close();
        }
    }
}
