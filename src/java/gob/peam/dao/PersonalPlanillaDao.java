/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.PersonalPlanilla;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class PersonalPlanillaDao {

    private SqlSessionFactory sqlSessionFactory;

    public PersonalPlanillaDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
	public List<PersonalPlanilla> listPersonalPlanillaForWeb(HashMap hm) {
        List<PersonalPlanilla> personalPlanillas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personalPlanillas = sqlSession.selectList("PersonalPlanilla.getListForWeb", hm);
            return personalPlanillas;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
	public int listTotalPersonalPlanillaForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<PersonalPlanilla> personalPlanillas = sqlSession.selectList("PersonalPlanilla.getTotalListForWeb", hm);
            return personalPlanillas.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosPersonalPlanillaForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("PersonalPlanilla.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }
    }
}
