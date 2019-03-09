/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.PersonalCategoria;
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
public class PersonalCategoriaDao {

    private SqlSessionFactory sqlSessionFactory;

    public PersonalCategoriaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<PersonalCategoria> listPersonalCategoriaForWeb(HashMap hm) {
        List<PersonalCategoria> personalCategorias;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalCategorias = sqlSession.selectList("PersonalCategoria.getListForWeb", hm);
            return personalCategorias;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalPersonalCategoriaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PersonalCategoria> personalCategorias = sqlSession.selectList("PersonalCategoria.getTotalListForWeb", hm);
            return personalCategorias.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPersonalCategoriaForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("PersonalCategoria.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listTrimestreCategoriaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anho = sqlSession.selectList("PersonalCategoria.getListTrimestreForWeb", hm);
            return anho;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public List<PersonalCategoria> importarPersonalCategoria(List<PersonalCategoria> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<PersonalCategoria> personalPLan;
        //creamos la tabla temporal
        try {
            sqlSession.update("PersonalCategoria.createTableTemp");
            for (PersonalCategoria personal : list) {
                sqlSession.insert("PersonalCategoria.insertTemp", personal);
            }
            personalPLan = sqlSession.selectList("PersonalCategoria.getListTempForWeb");
            sqlSession.commit();
            return personalPLan;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemPersonalCategoria(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<PersonalCategoria> personalPLan = session.selectList("PersonalCategoria.getRepetidoPersonalCategoria", h);
            if (personalPLan.isEmpty()) {
                session.insert("PersonalCategoria.addItemPersonalCategoria", h);
            } else {
                flag = false;
            }
            session.commit();
            return flag;
        } finally {
            session.close();
        }
    }

    public boolean eliminarPersonalCategoria(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("PersonalCategoria.deletePersonalCategoria", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }
}
