/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Proveedor;
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
public class ProveedorDao {

    private SqlSessionFactory sqlSessionFactory;

    public ProveedorDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<Proveedor> listProveedorForWeb(HashMap hm) {
        List<Proveedor> proveedors;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            proveedors = sqlSession.selectList("Proveedor.getListForWeb", hm);
            return proveedors;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalProveedorForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Proveedor> proveedors = sqlSession.selectList("Proveedor.getTotalListForWeb", hm);
            return proveedors.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Proveedor> listProveedorForAdmin(HashMap hm) {
        List<Proveedor> proveedors;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            proveedors = sqlSession.selectList("Proveedor.getListForAdmin", hm);
            return proveedors;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalProveedorForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Proveedor> proveedors = sqlSession.selectList("Proveedor.getTotalListForAdmin", hm);
            return proveedors.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosProveedorForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Proveedor.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }

    }

    @SuppressWarnings("rawtypes")
    public List<Proveedor> importarProveedor(List<Proveedor> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Proveedor> proveedors;
        //creamos la tabla temporal
        try {
            sqlSession.update("Proveedor.createTableTemp");
            for (Proveedor proveedor : list) {
                sqlSession.insert("Proveedor.insertTemp", proveedor);
            }
            proveedors = sqlSession.selectList("Proveedor.getListTempForWeb");
            sqlSession.commit();
            return proveedors;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemProveedor(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Proveedor> publi = session.selectList("Proveedor.getRepetidoProveedor", h);
            if (publi.isEmpty()) {
                session.insert("Proveedor.addItemProveedor", h);
            } else {
                flag = false;
            }
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public List<String> listTrimestreProveedorForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> trimestre = sqlSession.selectList("Proveedor.getListTrimestreForWeb", anho);
            return trimestre;
        } finally {
            sqlSession.close();
        }
    }

    public boolean eliminarProveedor(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Proveedor.deleteProveedor", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
