/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.PersonalCAS;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PersonalCASDao {

    private SqlSessionFactory sqlSessionFactory;

    public PersonalCASDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
	public List<PersonalCAS> listPersonalCASForWeb(HashMap hm) {
        List<PersonalCAS> personalCASs;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalCASs = sqlSession.selectList("PersonalCAS.getListForWeb", hm);
            return personalCASs;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalPersonalCASForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PersonalCAS> personalCASs = sqlSession.selectList("PersonalCAS.getTotalListForWeb", hm);
            return personalCASs.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPersonalCASForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("PersonalCAS.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }
}
