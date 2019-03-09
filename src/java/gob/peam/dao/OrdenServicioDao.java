/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.OrdenServicio;
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
public class OrdenServicioDao {

    private SqlSessionFactory sqlSessionFactory;

    public OrdenServicioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<OrdenServicio> listOrdenServicioForWeb(HashMap hm) {
        List<OrdenServicio> ordenServicios;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ordenServicios = sqlSession.selectList("OrdenServicio.getListForWeb", hm);
            return ordenServicios;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalOrdenServicioForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<OrdenServicio> ordenServicios = sqlSession.selectList("OrdenServicio.getTotalListForWeb", hm);
            return ordenServicios.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<OrdenServicio> listOrdenServicioForAdmin(HashMap hm) {
        List<OrdenServicio> ordenServicios;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ordenServicios = sqlSession.selectList("OrdenServicio.getListForAdmin", hm);
            return ordenServicios;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalOrdenServicioForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<OrdenServicio> ordenServicios = sqlSession.selectList("OrdenServicio.getTotalListForAdmin", hm);
            return ordenServicios.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosServicioForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("OrdenServicio.getListAnioForWeb");

            return anhos;
        } finally {
            sqlSession.close();
        }

    }

    @SuppressWarnings("rawtypes")
    public List<OrdenServicio> importarServicio(List<OrdenServicio> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<OrdenServicio> ordenServicios;
        //creamos la tabla temporal
        try {
            sqlSession.update("OrdenServicio.createTableTemp");
            for (OrdenServicio ordenServicio : list) {
                sqlSession.insert("OrdenServicio.insertTemp", ordenServicio);
            }
            ordenServicios = sqlSession.selectList("OrdenServicio.getListTempForWeb");
            sqlSession.commit();
            return ordenServicios;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemServicio(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<OrdenServicio> ordenServicio = session.selectList("OrdenServicio.getRepetidoOrdenServicio", h);
            if (ordenServicio.isEmpty()) {
                session.insert("OrdenServicio.addItemServicio", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public List<String> listMesOrdenServicioForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("OrdenServicio.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    public boolean eliminarOrdenServicio(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("OrdenServicio.deleteOrdenServicio", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
