/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Telefonia;
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
public class TelefoniaDao {

    private SqlSessionFactory sqlSessionFactory;

    public TelefoniaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<Telefonia> listTelefoniaForWeb(HashMap hm) {
        List<Telefonia> telefonias;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            telefonias = sqlSession.selectList("Telefonia.getListForWeb", hm);
            return telefonias;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalTelefoniaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Telefonia> telefonias = sqlSession.selectList("Telefonia.getTotalListForWeb", hm);
            return telefonias.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Telefonia> listTelefoniaForAdmin(HashMap hm) {
        List<Telefonia> telefonias;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            telefonias = sqlSession.selectList("Telefonia.getListForAdmin", hm);
            return telefonias;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalTelefoniaForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Telefonia> telefonias = sqlSession.selectList("Telefonia.getTotalListForAdmin", hm);
            return telefonias.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosTelefoniaForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Telefonia.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listMesTelefoniaForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Telefonia.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Telefonia> importarTelefonia(List<Telefonia> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Telefonia> telefonias;
        //creamos la tabla temporal
        try {
            sqlSession.update("Telefonia.createTableTemp");
            for (Telefonia telefonia : list) {
                sqlSession.insert("Telefonia.insertTemp", telefonia);
            }
            telefonias = sqlSession.selectList("Telefonia.getListTempForWeb");
            sqlSession.commit();
            return telefonias;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemTelefonia(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Telefonia> publi = session.selectList("Telefonia.getRepetidoTelefonia", h);
            if (publi.isEmpty()) {
                session.insert("Telefonia.addItemTelefonia", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarTelefonia(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Telefonia.deleteTelefonia", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
