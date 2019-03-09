/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Convocatoria;
import gob.peam.beans.ConvocatoriaBien;
import gob.peam.beans.ConvocatoriaPers;
import gob.peam.beans.PlazaConvocatoria;
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
public class ConvocatoriaDao implements Serializable {

    private SqlSessionFactory sqlSessionFactory;

    public ConvocatoriaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<ConvocatoriaBien> listarConvocatoriaBienForAdmin(HashMap hm) {
        List<ConvocatoriaBien> convBien;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            convBien = session.selectList("ConvocatoriaBien.listarConvocatoriaBien", hm);
            return convBien;
        } finally {
            session.close();
        }
    }

    public int listarTotalConvocatoriaBienForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Convocatoria> data = sqlSession.selectList("ConvocatoriaBien.listarTotalConvocatoriaBien", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<ConvocatoriaBien> listarConvocatoriaBienForWeb(HashMap hm) {
        List<ConvocatoriaBien> convBien;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            convBien = session.selectList("ConvocatoriaBien.listarConvocatoriaBienForWeb", hm);
            return convBien;
        } finally {
            session.close();
        }
    }

    public int listarTotalConvocatoriaBienForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Convocatoria> data = sqlSession.selectList("ConvocatoriaBien.listarTotalConvocatoriaBienForWeb", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarConvocatoriaBien(ConvocatoriaBien convo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("ConvocatoriaBien.insertConvocatoriaBien", convo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean estadoConvocatoriaBien(HashMap hashMap) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("ConvocatoriaBien.estadoConvocatoriaBien", hashMap);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public ConvocatoriaBien buscarConvocatoriaBien(Integer idConvo) {
        ConvocatoriaBien convo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            convo = session.selectOne("ConvocatoriaBien.buscarConvocatoriaBien", idConvo);
            return convo;
        } finally {
            session.close();
        }
    }

    public boolean actualizarConvocatoriaBien(ConvocatoriaBien c) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("ConvocatoriaBien.updateConvocatoriaBien", c);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean hasChildrenConvocatoriaBien(Integer convoId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<ConvocatoriaBien> list = session.selectList("ConvocatoriaBien.listarChildrenForConvocatoriaBien", convoId);
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }
    }

    public boolean eliminarConvocatoriaBien(Integer convoId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("ConvocatoriaBien.deleteConvocatoriaBien", convoId);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    /**
     * *********************************PERSONAL*****************************************
     */
    @SuppressWarnings("rawtypes")
    public List<ConvocatoriaPers> listConvocatoriaPersForWeb(HashMap hm) {
        List<ConvocatoriaPers> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("Convocatoria.getListForWeb", hm);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalConvocatoriaPersForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<ConvocatoriaPers> data = sqlSession.selectList("Convocatoria.getTotalListForWeb", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public ConvocatoriaPers getConvocatoriaPersForWeb(Integer id) {
        ConvocatoriaPers convocatoria;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            convocatoria = sqlSession.selectOne("Convocatoria.getConvocatoriaPersForWeb", id);
            return convocatoria;
        } finally {
            sqlSession.close();
        }
    }

    public List<ConvocatoriaPers> listarConvocatoriaPersForAdmin(HashMap hm) {
        List<ConvocatoriaPers> convBien;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            convBien = session.selectList("Convocatoria.listarConvocatoriaPers", hm);
            return convBien;
        } finally {
            session.close();
        }
    }

    public int listarTotalConvocatoriaPersForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<ConvocatoriaPers> data = sqlSession.selectList("Convocatoria.listarTotalConvocatoriaPers", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarConvocatoriaPers(ConvocatoriaPers convo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Convocatoria.insertConvocatoriaPers", convo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean estadoConvocatoriaPers(HashMap hashMap) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Convocatoria.estadoConvocatoriaPers", hashMap);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public ConvocatoriaPers buscarConvocatoriaPers(Integer idConvo) {
        ConvocatoriaPers convo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            convo = session.selectOne("Convocatoria.buscarConvocatoriaPers", idConvo);
            return convo;
        } finally {
            session.close();
        }
    }

    public boolean actualizarConvocatoriaPers(ConvocatoriaPers c) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Convocatoria.updateConvocatoriaPers", c);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean hasChildrenConvocatoriaPers(Integer coperId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<ConvocatoriaPers> list = session.selectList("Convocatoria.listarChildrenForConvocatoriaPers", coperId);
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }
    }

    public boolean eliminarConvocatoriaPers(Integer coperId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Convocatoria.deleteConvocatoriaPers", coperId);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    /**
     * ******************************************PLAZAS**************************************
     */
    public List<PlazaConvocatoria> listarTotalPlazaConvocatoriaForWeb(Integer codigo) {
        List<PlazaConvocatoria> data;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            data = sqlSession.selectList("PlazaConvocatoria.listarPlazaConvocatoriaForWeb", codigo);
            return data;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarPlazaConvocatoria(PlazaConvocatoria plaza) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("PlazaConvocatoria.insertPlazaConvocatoria", plaza);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public List<PlazaConvocatoria> listarPlazaConvocatoriaForAdmin(HashMap hm) {
        List<PlazaConvocatoria> c;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            c = session.selectList("PlazaConvocatoria.listarPlazaConvocatoriaForAdmin", hm);
            return c;
        } finally {
            session.close();
        }
    }

    public int listarTotalPlazaConvocatoriaForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PlazaConvocatoria> data = sqlSession.selectList("PlazaConvocatoria.listarTotalPlazaConvocatoriaForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean eliminarPlazaConvocatoria(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("PlazaConvocatoria.deletePlazaConvocatoria", id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean actualizarPlazaPers(PlazaConvocatoria p) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("PlazaConvocatoria.updatePlaza", p);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
