/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Personal;
import gob.peam.config.WebAppConnectionFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author alabajos
 */
public class PersonalDao {
    private SqlSessionFactory sqlSessionFactory;

    public PersonalDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    
    @SuppressWarnings("rawtypes")
    public List<Personal> listPersonalForAdmin(HashMap hm) {
        List<Personal> personalPLan;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalPLan = sqlSession.selectList("Personal.getListForAdmin", hm);
            return personalPLan;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPersonalForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Personal> personalPLan = sqlSession.selectList("Personal.getTotalListForAdmin", hm);
            return personalPLan.size();
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPersonalForDis(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Personal> personalPLan = sqlSession.selectList("Personal.getTotalListForDis", hm);
            return personalPLan.size();
        } finally {
            sqlSession.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public List<Personal> listPersonalForDis(HashMap hm) {
        List<Personal> personalPLan;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalPLan = sqlSession.selectList("Personal.getListForDis", hm);
            return personalPLan;
        } finally {
            sqlSession.close();
        }
    }
    
    public List<String> listAnhoPersonalForWeb(Integer tipo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anho = sqlSession.selectList("Personal.getListAnioForWeb", tipo);
            return anho;
        } finally {
            sqlSession.close();
        }
    }
    
   /* public List<String> listAnhoPersonalForWeb2(Integer tipo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anho = sqlSession.selectList("Personal.getListAnioForWeb2", tipo);
            return anho;
        } finally {
            sqlSession.close();
        }
    }*/
    
    
    public List<String> listTrimestrePersonalForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anho = sqlSession.selectList("Personal.getListTrimestreForWeb", hm);
            return anho;
        } finally {
            sqlSession.close();
        }
    }
    
    
  public List<String> listMesPersonalForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anho = sqlSession.selectList("Personal.getListTrimestreForWeb", hm);
            return anho;
        } finally {
            sqlSession.close();
        }
    }
    
       
 /* public List<String> listMesPersonalForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Personal.getListMesPersonalForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }*/
    
    @SuppressWarnings("rawtypes")
    public List<Personal> listTempForWeb(HashMap hm) {
        List<Personal> personalPLan;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalPLan = sqlSession.selectList("Personal.getListTempForWeb", hm);
            return personalPLan;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<Personal> importarPersonal(List<Personal> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Personal> personalPLan;
        //creamos la tabla temporal
        try {
            sqlSession.update("Personal.createTableTemp");
            for (Personal personal : list) {
                sqlSession.insert("Personal.insertTemp", personal);
            }
            personalPLan = sqlSession.selectList("Personal.getListTempForWeb");
            sqlSession.commit();
            return personalPLan;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemPersonal(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Personal> personalPLan = session.selectList("Personal.getRepetidoPersonal", h);
            if (personalPLan.isEmpty()) {
                session.insert("Personal.addItemPersonal", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarPersonal(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Personal.deletePersonal", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
