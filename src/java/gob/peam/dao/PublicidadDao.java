/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Publicidad;
import gob.peam.config.WebAppConnectionFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PublicidadDao {

    private SqlSessionFactory sqlSessionFactory;

    public PublicidadDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<Publicidad> listPublicidadForWeb(HashMap hm) {
        List<Publicidad> publicidads;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            publicidads = sqlSession.selectList("Publicidad.getListForWeb", hm);
            return publicidads;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPublicidadForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Publicidad> publicidads = sqlSession.selectList("Publicidad.getTotalListForWeb", hm);
            return publicidads.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPublicidadForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Publicidad.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Publicidad> importarPublicidad(List<Publicidad> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Publicidad> publicidads;
        //creamos la tabla temporal
        try {
            sqlSession.update("Publicidad.createTableTemp");
            for (Publicidad publicidad : list) {
                sqlSession.insert("Publicidad.insertTemp", publicidad);
            }
            publicidads = sqlSession.selectList("Publicidad.getListTempForWeb");
            sqlSession.commit();
            return publicidads;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemPublicidad(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Publicidad> publi = session.selectList("Publicidad.getRepetidoPublicidad", h);
            if (publi.isEmpty()) {
                session.insert("Publicidad.addItemPublicidad", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarPublicidad(Integer id) {
        boolean estado = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Publicidad.deletePublicidad", id);
            session.commit();
            estado = true;
        } finally {
            session.close();
        }
        return estado;
    }
}
