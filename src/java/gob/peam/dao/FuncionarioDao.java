/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Funcionario;
import gob.peam.config.WebAppConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class FuncionarioDao {

    private SqlSessionFactory sqlSessionFactory;

    public FuncionarioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    public List<Funcionario> listFuncionarioForWeb() {
        List<Funcionario> funcionarios;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            funcionarios = sqlSession.selectList("Funcionario.getListForWeb");
            return funcionarios;
        } finally {
            sqlSession.close();
        }
    }

    public List<Funcionario> listFuncionarioDirectorioForWeb(HashMap hm) {
        List<Funcionario> funcionarios;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            funcionarios = sqlSession.selectList("Funcionario.getListDirectorioForWeb", hm);
            return funcionarios;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listFuncionarioDirectorioTotalForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Funcionario> bean = sqlSession.selectList("Funcionario.getTotalDirectorioForWeb", hm);
            return bean.size();
        } finally {
            sqlSession.close();
        }
    }

    public Funcionario getFuncionarioFowFlowchart(String organigrama) {
        Funcionario funcionario;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            funcionario = sqlSession.selectOne("Funcionario.getFuncionarioForFlowchart", organigrama);
            return funcionario;
        } finally {
            sqlSession.close();
        }

    }

    public String getGerenteForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("Funcionario.getGerenteForWeb");
        } finally {
            sqlSession.close();
        }
    }

    public List<Funcionario> listFuncionarioForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("Funcionario.getListForAdmin", hm);
        } finally {
            sqlSession.close();
        }
    }

    public int listTotalFuncionarioForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Funcionario> data = sqlSession.selectList("Funcionario.getListForAdmin", hm);
            return data.size();
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarFuncionario(HashMap hm) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Funcionario.insertFuncionario", hm);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    public Funcionario buscarFuncionario(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("Funcionario.buscarFuncionario", id);
        } finally {
            sqlSession.close();
        }

    }

    public boolean actualizarFuncionario(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Funcionario.updateFuncionario", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarFuncionario(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Funcionario.deleteFuncionario", id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean estadoFuncionario(HashMap hashMap) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Funcionario.estadoFuncionario", hashMap);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
