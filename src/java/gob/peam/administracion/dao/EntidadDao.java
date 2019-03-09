package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Entidad;
import gob.peam.config.AdministracionConnectionFactory;
import java.io.Serializable;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

public class EntidadDao implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8832903930519973164L;
    private SqlSessionFactory sqlSessionFactory;

    public EntidadDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public Entidad seleccionarEntidad() {
        Entidad entidad;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            entidad = sqlSession.selectOne("Entidad.seleccionarEntidad");
            return entidad;
        } finally {
            sqlSession.close();
        }
    }

    public Entidad seleccionarLogoEntidad() {
        Entidad entidad;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            entidad = sqlSession.selectOne("Entidad.seleccionarLogoEntidad");
            return entidad;
        } finally {
            sqlSession.close();
        }

    }

    public boolean actualizarData(Entidad entidad) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("Entidad.updateDataEntidad", entidad);
            sqlSession.commit();
            return true;
        } catch (SqlSessionException exception) {
            return false;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarImagen(Entidad entidad) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("Entidad.updateImgEntidad", entidad);
            sqlSession.commit();
            return true;
        } catch (SqlSessionException exception) {
            return false;
        } finally {
            sqlSession.close();
        }
    }
}
