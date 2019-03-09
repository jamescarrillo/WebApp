/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.Finanza;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class FinanzaDao {

    private SqlSessionFactory sqlSessionFactory;

    public FinanzaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public Finanza listFinanzaForNotice(HashMap hm) {
        Finanza multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectOne("Finanza.getFinanzaForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Finanza> listarFinanzaForWeb(HashMap hm) {
        List<Finanza> multimedias;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            multimedias = session.selectList("Finanza.getListForWeb", hm);
            return multimedias;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalFinanzaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Finanza> multimedias = sqlSession.selectList("Finanza.getTotalListForWeb", hm);
            return multimedias.size();
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalFinanzaForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Finanza> data = sqlSession.selectList("Finanza.getTotalListForAdmin", filtro);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Finanza> listFinanzaAdmin(HashMap hm) {
        List<Finanza> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Finanza.getListForAdmin", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Finanza getFinanzaAdmin(Integer id) {
        Finanza data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Finanza.getFinanza", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Finanza getFinanzaforWeb(String fecha) {
        Finanza data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Finanza.getFinanzaForWeb", fecha);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarFinanza(Finanza multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Finanza.insertFinanza", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarFinanza(Finanza bean) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Finanza.update", bean);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarFinanza(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Finanza.deleteFinanza", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<Anho> listAnhosFinanzaForWeb(Integer tipo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Anho> anhos = sqlSession.selectList("Finanza.getListAnioForWeb", tipo);
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listMesFinanzaForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Finanza.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemFinanza(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Finanza> finanza = session.selectList("Finanza.getRepetidoFinanza", h);
            if (finanza.isEmpty()) {
                session.insert("Finanza.addItemFinanza", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean activarFinanza(HashMap h) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Finanza.activarFinanza", h);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    
    public void publicar(Integer id) {
        SqlSession bdData = sqlSessionFactory.openSession();
        try {
            HashMap hm = new HashMap();
            hm.put("id", id);
            //obtenemos si es Activo o desactivado el registro
            Finanza bean = bdData.selectOne("Finanza.getFinanza", hm);

            if (bean.getEstado()) {
                hm.put("estado", false);
            } else {
                hm.put("estado", true);
            }
            //Modificar estado definitivamente al registro. Publico o despublicado
            bdData.update("Finanza.publicar", hm);
            bdData.commit();

        } finally {
            bdData.close();
        }
    }
}
