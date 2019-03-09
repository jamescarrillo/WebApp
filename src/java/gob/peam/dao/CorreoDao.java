package gob.peam.dao;

import gob.peam.beans.Correo;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CorreoDao {

    private SqlSessionFactory sqlSessionFactory;

    public CorreoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public Correo buscarCorreo(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("Correo.buscarCorreo", id);
        } finally {
            sqlSession.close();
        }

    }

    public boolean actualizarCorreo(Correo correo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Correo.updateCorreo", correo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
