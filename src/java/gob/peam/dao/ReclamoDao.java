/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Reclamo;
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
public class ReclamoDao implements Serializable {

    private SqlSessionFactory sqlSessionFactory;

    public ReclamoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Reclamo> listarReclamo(HashMap hashMap) {
        List<Reclamo> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Reclamo.getListReclamo", hashMap);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public int listarTotalReclamo(HashMap hm) {
        List<Reclamo> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Reclamo.getTotalListReclamo", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public String insertarReclamo(Reclamo reclamo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String numero = null;
        try {
            numero = sqlSession.selectOne("Reclamo.getRepetidoIdReclamo", reclamo);
            if (numero==null) {
                reclamo.setNumero("0000000001");
                sqlSession.insert("Reclamo.insertReclamo", reclamo);
            } else {
                reclamo.setNumero(numero);
                sqlSession.insert("Reclamo.insertReclamo", reclamo);
            }
             
            sqlSession.commit();
            
        } finally {
            sqlSession.close();
        }
        return numero;
    }

    public List<Reclamo> listReclamoForAdmin(HashMap hm) {
        List<Reclamo> reclamo;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            reclamo = sqlSession.selectList("Reclamo.getListForAdmin", hm);
            return reclamo;
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalReclamoForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Reclamo> reclamo = sqlSession.selectList("Reclamo.getTotalListForAdmin", filtro);
            return reclamo.size();
        } finally {
            sqlSession.close();
        }
    }

    public Reclamo getReclamoForAdmin(HashMap h) {
        Reclamo data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Reclamo.getReclamoSingle", h);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean actualizarReclamo(Reclamo reclamo) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Reclamo.updateReclamo", reclamo);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarReclamo(HashMap h) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Reclamo.deleteReclamo", h);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
