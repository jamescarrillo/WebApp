/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.ResolucionGerencial;
import gob.peam.config.ArcDigConnectionFactory;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class ResolucionGerencialDao {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionFactory sqlSessionFactory1;

    public ResolucionGerencialDao() {
        sqlSessionFactory = ArcDigConnectionFactory.getSqlSessionFactory();
        sqlSessionFactory1 = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<ResolucionGerencial> listResolucionGerencialForWeb(HashMap hm) {
        List<ResolucionGerencial> resolucionGerencials;
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getListForWeb", hm);
            return resolucionGerencials;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalResolucionGerencialForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        try {
            List<ResolucionGerencial> resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getTotalListForWeb", hm);
            return resolucionGerencials.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosResolucionGerencialForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("ResolucionGerencial.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public ResolucionGerencial buscarResolucionGerencialForWeb(Integer id) {
        ResolucionGerencial resolucionGerencial;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            resolucionGerencial = sqlSession.selectOne("ResolucionGerencial.getForWeb", id);
            return resolucionGerencial;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<ResolucionGerencial> listResolucionGerencialForAdmin(HashMap hm) {
        List<ResolucionGerencial> resolucionGerencials;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getListForAdmin", hm);
            return resolucionGerencials;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalResolucionGerencialForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<ResolucionGerencial> resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getTotalListForAdmin", hm);
            return resolucionGerencials.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPresupuestoFinanzas(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<ResolucionGerencial> resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getPFTotalList", hm);
            return resolucionGerencials.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<ResolucionGerencial> listPresupuestoFinanzas(HashMap hm) {
        List<ResolucionGerencial> resolucionGerencials;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getPFList", hm);
            return resolucionGerencials;
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public List<ResolucionGerencial> listFinanzasPresupuesto(HashMap hm) {
        List<ResolucionGerencial> resolucionGerencials;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getFPList", hm);
            return resolucionGerencials;
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public List<ResolucionGerencial> listActualizarFinanzas(HashMap hm) {
        List<ResolucionGerencial> resolucionGerencials;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            resolucionGerencials = sqlSession.selectList("ResolucionGerencial.getTodoFinanzasList", hm);
            return resolucionGerencials;
        } finally {
            sqlSession.close();
        }
    }
    
        
    public boolean eliminarResolucion(Integer id) {
        SqlSession session = sqlSessionFactory1.openSession();
        try {
            session.update("ResolucionGerencial.deleteResolucion", id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
