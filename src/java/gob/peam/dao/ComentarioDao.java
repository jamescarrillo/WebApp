/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Comentario;
import gob.peam.config.WebAppConnectionFactory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class ComentarioDao implements Serializable {

    private SqlSessionFactory sqlSessionFactory;

    public ComentarioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Comentario> listarComentario(HashMap hashMap) {
        List<Comentario> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Comentario.getListComentario", hashMap);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public int listarTotalComentario(HashMap hm) {
        List<Comentario> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Comentario.getTotalListComentario", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarComentario(Comentario Comentario) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Comentario.insertComentario", Comentario);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<Comentario> listComentarioForAdmin(HashMap hm) {
        List<Comentario> Comentario;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Comentario = sqlSession.selectList("Comentario.getListForAdmin", hm);
            return Comentario;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalComentarioForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Comentario> Comentario = sqlSession.selectList("Comentario.getTotalListForAdmin", filtro);
            return Comentario.size();
        } finally {
            sqlSession.close();
        }
    }

    public Comentario getComentarioForAdmin(String numero) {
        Comentario data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Comentario.getComentarioSingle", numero);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarComentario(Comentario Comentario) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Comentario.updateComentario", Comentario);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
    public boolean eliminarComentario(String id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Comentario.deleteComentario", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
