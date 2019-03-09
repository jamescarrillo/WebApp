/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Usuario;
import gob.peam.config.AdministracionConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class UsuarioDao {

    private SqlSessionFactory sqlSessionFactory;

    public UsuarioDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        Usuario usuario;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            usuario = sqlSession.selectOne("Usuario.buscarUsuarioPorLogin", login);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }

    public Usuario buscarUsuarioPorPersona(Integer id) {
        Usuario usuario;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            usuario = sqlSession.selectOne("Usuario.buscarUsuarioPorPersona", id);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }
    
    public Usuario buscarUsuarioPorId(Integer id) {
        Usuario usuario;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            usuario = sqlSession.selectOne("Usuario.buscarUsuarioPorId", id);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }

  /* */

    public boolean desactivarUsuario(Integer idUsuario) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Usuario.desactivarUsuario", idUsuario);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean activarUsuario(Integer idUsuario) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Usuario.activarUsuario", idUsuario);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarUsuario(Integer usua_id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Usuario.delUsuario", usua_id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean existeUsuarioParaEliminar(Integer usua_id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Usuario u = session.selectOne("Usuario.existeUsuarioParaEliminar", usua_id);
            if (u == null) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }
}
