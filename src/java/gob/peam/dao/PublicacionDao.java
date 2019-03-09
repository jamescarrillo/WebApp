/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Publicacion;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PublicacionDao {

    private SqlSessionFactory sqlSessionFactory;

    public PublicacionDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public Publicacion listPublicacionForNotice(HashMap hm) {
        Publicacion multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectOne("Publicacion.getForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Publicacion> listarPublicacionForWeb(HashMap hm) {
        List<Publicacion> bean;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            bean = session.selectList("Publicacion.getListForWeb", hm);
            return bean;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPublicacionForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Publicacion> bean = sqlSession.selectList("Publicacion.getTotalListForWeb", hm);
            return bean.size();
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalPublicacionForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Publicacion> data = sqlSession.selectList("Publicacion.getTotalListForAdmin", filtro);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Publicacion> listPublicacionAdmin(HashMap hm) {
        List<Publicacion> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Publicacion.getListForAdmin", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Publicacion getPublicacionAdmin(Integer id) {
        Publicacion data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Publicacion.getPublicacionSingle", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Publicacion getPublicacionforWeb(String fecha) {
        Publicacion data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Publicacion.getPublicacionForWeb", fecha);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarPublicacion(Publicacion multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Publicacion.insertPublicacion", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarPublicacion(Publicacion multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Publicacion.updatePublicacion", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarPublicacion(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Publicacion.deletePublicacion", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean publicarPublicacion(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Publicacion.publicarPublicacion", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<String> listAnhosPublicacionForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Publicacion.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * ** Articulos ****
     */
    @SuppressWarnings("rawtypes")
    public List<Publicacion> listarArticuloForWeb(HashMap hm) {
        List<Publicacion> bean;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            bean = session.selectList("Publicacion.getListArticuloForWeb", hm);
            return bean;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalArticuloForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Publicacion> bean = sqlSession.selectList("Publicacion.getTotalListArtciuloForWeb", hm);
            return bean.size();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * ** Otras Publicaciones ****
     */
    @SuppressWarnings("rawtypes")
    public List<Publicacion> listarOtraPublicacionForWeb(HashMap hm) {
        List<Publicacion> bean;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            bean = session.selectList("Publicacion.getListOtraPublicacionForWeb", hm);
            return bean;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalOtraPublicacionForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Publicacion> bean = sqlSession.selectList("Publicacion.getTotalListOtraPublicacionForWeb", hm);
            return bean.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarPublicaciones(Publicacion multimedia) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            HashMap h = new HashMap();
            h.put("docuId", multimedia.getDocuId());
            List<Publicacion> publicacion = sqlSession.selectList("Publicacion.getRepetidoPublicacion", h);
            if (publicacion.isEmpty()) {
                sqlSession.insert("Publicacion.insertPublicacionM", multimedia);
            } else {
                flag = false;
            }
            sqlSession.commit();
            return flag;
        } finally {
            sqlSession.close();
        }
    }
    
    public boolean actualizarPublicaciones(Publicacion multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Publicacion.updatePublicacionM", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    public boolean addItemPublicacion(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Publicacion> publicacion = session.selectList("Publicacion.getRepetidoPublicacion", h);
            if (publicacion.isEmpty()) {
                session.insert("Publicacion.addItemPublicacion", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }
    
     public boolean eliminarPublicaciones(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Publicacion.deletePublicacionM", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
