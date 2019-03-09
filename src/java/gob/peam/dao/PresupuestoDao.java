/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Presupuesto;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PresupuestoDao {

    private SqlSessionFactory sqlSessionFactory;

    public PresupuestoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public Presupuesto listPresupuestoForNotice(HashMap hm) {
        Presupuesto multimedia;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            multimedia = sqlSession.selectOne("Presupuesto.getPresupuestoForNotice", hm);
            return multimedia;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Presupuesto> listarPresupuestoForWeb(HashMap hm) {
        List<Presupuesto> multimedias;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            multimedias = session.selectList("Presupuesto.getListForWeb", hm);
            return multimedias;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPresupuestoForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Presupuesto> multimedias = sqlSession.selectList("Presupuesto.getTotalListForWeb", hm);
            return multimedias.size();
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalPresupuestoForAdmin(String filtro) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Presupuesto> data = sqlSession.selectList("Presupuesto.getTotalListForAdmin", filtro);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Presupuesto> listPresupuestoAdmin(HashMap hm) {
        List<Presupuesto> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Presupuesto.getListForAdmin", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Presupuesto getPresupuestoAdmin(Integer id) {
        Presupuesto data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Presupuesto.getPresupuestoSingle", id);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public Presupuesto getPresupuestoforWeb(String fecha) {
        Presupuesto data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectOne("Presupuesto.getPresupuestoForWeb", fecha);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarPresupuesto(Presupuesto pre) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Presupuesto> ordenCompras = sqlSession.selectList("Presupuesto.getRepetidoPresupuesto", pre);
            if (ordenCompras.isEmpty()) {
                sqlSession.insert("Presupuesto.insertPresupuesto", pre);
            } else {
                flag = false;
            }
            sqlSession.commit();
            estado = flag;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean actualizarPresupuesto(Presupuesto multimedia) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Presupuesto.updatePresupuesto", multimedia);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public boolean eliminarPresupuesto(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Presupuesto.deletePresupuesto", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public List<String> listAnhosPresupuestoForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Presupuesto.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listMesPresupuestoForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Presupuesto.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    public boolean activarPresupuesto(HashMap h) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Presupuesto.activarPresupuesto", h);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
