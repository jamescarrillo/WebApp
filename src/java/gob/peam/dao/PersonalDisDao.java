/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.PersonalDis;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author Ernesto
 */
public class PersonalDisDao {
    private SqlSessionFactory sqlSessionFactory;

    public PersonalDisDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
	public List<PersonalDis> listPersonalDisForWeb(HashMap hm) {
        List<PersonalDis> personalDis;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalDis = sqlSession.selectList("PersonalDis.getListForWeb", hm);
            return personalDis;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalPersonalDisForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PersonalDis> personalDis = sqlSession.selectList("PersonalDis.getTotalListForWeb", hm);
            return personalDis.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPersonalDisForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("PersonalDis.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }
}