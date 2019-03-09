/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.PersonalSNP;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PersonalSNPDao  {

    private SqlSessionFactory sqlSessionFactory;

    public PersonalSNPDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
	public List<PersonalSNP> listPersonalSNPForWeb(HashMap hm) {
        List<PersonalSNP> personalSNPs;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalSNPs = sqlSession.selectList("PersonalSNP.getListForWeb", hm);
            return personalSNPs;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalPersonalSNPForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PersonalSNP> personalSNPs = sqlSession.selectList("PersonalSNP.getTotalListForWeb", hm);
            return personalSNPs.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPersonalSNPForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("PersonalSNP.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }
}
