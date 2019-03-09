/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Viatico;
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
public class ViaticoDao {

    private SqlSessionFactory sqlSessionFactory;

    public ViaticoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<Viatico> listViaticoForWeb(HashMap hm) {
        List<Viatico> viaticos;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            viaticos = sqlSession.selectList("Viatico.getListForWeb", hm);
            return viaticos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalViaticoForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Viatico> viaticos = sqlSession.selectList("Viatico.getTotalListForWeb", hm);
            return viaticos.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Viatico> listViaticoForAdmin(HashMap hm) {
        List<Viatico> viaticos;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            viaticos = sqlSession.selectList("Viatico.getListForAdmin", hm);
            return viaticos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalViaticoForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Viatico> viaticos = sqlSession.selectList("Viatico.getTotalListForAdmin", hm);
            return viaticos.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosViaticoForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Viatico.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Viatico> importarViatico(List<Viatico> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Viatico> Viaticos;
        //creamos la tabla temporal
        try {
            sqlSession.update("Viatico.createTableTemp");
            for (Viatico Viatico : list) {
                sqlSession.insert("Viatico.insertTemp", Viatico);
            }
            Viaticos = sqlSession.selectList("Viatico.getListTempForWeb");
            sqlSession.commit();
            return Viaticos;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemViatico(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Viatico> publi = session.selectList("Viatico.getRepetidoViatico", h);
            if (publi.isEmpty()) {
                session.insert("Viatico.addItemViatico", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarViatico(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Viatico.deleteViatico", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<String> listMesViaticoForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Viatico.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }
}
