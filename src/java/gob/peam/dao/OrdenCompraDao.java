/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.OrdenCompra;
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
public class OrdenCompraDao {

    private SqlSessionFactory sqlSessionFactory;

    public OrdenCompraDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<OrdenCompra> listOrdenCompraForWeb(HashMap hm) {
        List<OrdenCompra> ordenCompras;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ordenCompras = sqlSession.selectList("OrdenCompra.getListForWeb", hm);
            return ordenCompras;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalOrdenCompraForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<OrdenCompra> ordenCompras = sqlSession.selectList("OrdenCompra.getTotalListForWeb", hm);
            return ordenCompras.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosCompraForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("OrdenCompra.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }

    }

    @SuppressWarnings("rawtypes")
    public List<OrdenCompra> listOrdenCompraForAdmin(HashMap hm) {
        List<OrdenCompra> ordenCompras;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ordenCompras = sqlSession.selectList("OrdenCompra.getListForAdmin", hm);
            return ordenCompras;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalOrdenCompraForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<OrdenCompra> ordenCompras = sqlSession.selectList("OrdenCompra.getTotalListForAdmin", hm);
            return ordenCompras.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listMesOrdenCompraForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("OrdenCompra.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<OrdenCompra> listTempForWeb(HashMap hm) {
        List<OrdenCompra> ordenCompras;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ordenCompras = sqlSession.selectList("OrdenCompra.getListTempForWeb", hm);
            return ordenCompras;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<OrdenCompra> importarComprasBienes(List<OrdenCompra> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<OrdenCompra> ordenCompras;
        //creamos la tabla temporal
        try {
            sqlSession.update("OrdenCompra.createTableTemp");
            for (OrdenCompra ordenCompra : list) {
                sqlSession.insert("OrdenCompra.insertTemp", ordenCompra);
            }
            ordenCompras = sqlSession.selectList("OrdenCompra.getListTempForWeb");
            sqlSession.commit();
            return ordenCompras;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemOrdenCompra(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<OrdenCompra> ordenCompras = session.selectList("OrdenCompra.getRepetidoOrdenCompra", h);
            if (ordenCompras.isEmpty()) {
                session.insert("OrdenCompra.addItemOdenCompra", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarOrdenCompra(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("OrdenCompra.deleteOrdenCompra", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
