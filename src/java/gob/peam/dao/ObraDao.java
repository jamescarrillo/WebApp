package gob.peam.dao;

import gob.peam.beans.Obra;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author mvilchez
 */
public class ObraDao {

    private SqlSessionFactory sqlSessionFactory;

    public ObraDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public boolean insertarObra(Obra notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Obra.insertNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarObra(Obra notaPrensa) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Obra.updateNotice", notaPrensa);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarObra(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Obra.deleteNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean publicarObra(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Obra.publicarNotice", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Obra getObraForAdmin(Integer id) {
        Obra notaPrensa;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            notaPrensa = sqlSession.selectOne("Obra.getObraSingle", id);
            return notaPrensa;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> getListAnioForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Obra.getListAnioForWeb", hm);
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<Obra> listObraForAdmin(HashMap hm) {
        List<Obra> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Obra.getListForAdmin", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalObraForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Obra> items = sqlSession.selectList("Obra.getTotalListForAdmin", filtro);
            return items.size();
        } finally {
            sqlSession.close();
        }
    }
    
     public List<Obra> listObraForWeb(HashMap hm) {
        List<Obra> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Obra.getListForWeb", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalObraForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Obra> items = sqlSession.selectList("Obra.getTotalListForWeb", hm);
            return items.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Obra> obraForWeb(HashMap hm) {
        List<Obra> items;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            items = sqlSession.selectList("Obra.getListForWeb", hm);
            return items;
        } finally {
            sqlSession.close();
        }
    }

}
