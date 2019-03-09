/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Grupo;
import gob.peam.administracion.beans.Usuario;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class GrupoDao {

    private SqlSessionFactory sqlSessionFactory;

    public GrupoDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Grupo> listarGrupos() {
        List<Grupo> grupos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            grupos = session.selectList("Grupo.seleccionarGrupo");
            return grupos;
        } finally {
            session.close();
        }
    }

    public List<Grupo> listarGrupos(HashMap hm) {
        List<Grupo> grupos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            grupos = session.selectList("Grupo.listarGrupos", hm);
            return grupos;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalGrupos(HashMap hm) {
        List<Grupo> grupos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            grupos = session.selectList("Grupo.listarTotalGrupos", hm);
            return grupos.size();
        } finally {
            session.close();
        }
    }

    public Grupo insertarGrupo(Grupo grupo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Grupo.insertGrupo", grupo);
            session.commit();
        } finally {
            session.close();
        }
        return grupo;
    }

    public boolean existeGrupo(String nombre) {
        boolean existe = false;
        List<Grupo> grupos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            grupos = session.selectList("Grupo.existeGrupo", nombre);
            if (grupos.size() > 0) {
                existe = true;
            } else {
                existe = false;
            }
        } finally {
            session.close();
        }
        return existe;
    }

    public boolean actualizarGrupo(Grupo grupo) {
        boolean result = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Grupo.updateGrupo", grupo);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public Grupo buscarGrupo(String nombre) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Grupo grupo = session.selectOne("Grupo.buscarGrupoPorNombre", nombre);
            return grupo;
        } finally {
            session.close();
        }
    }
     public Grupo buscarGrupoPorId(Integer idGrupo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Grupo grupo = session.selectOne("Grupo.buscarGrupo", idGrupo);
            return grupo;
        } finally {
            session.close();
        }
    }


    public boolean tieneDependencias(Integer id) {
        boolean resul;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Usuario> usuarios = session.selectList("Grupo.childrenGrupo", id);
            if (usuarios.size() > 0) {
                resul = true;
            } else {
                resul = false;
            }
            return resul;
        } finally {
            session.close();
        }
    }

    public boolean eliminarGrupo(Integer id) {
        boolean resul = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Grupo.deleteGrupo", id);
            session.commit();
            resul = true;
        } finally {
            session.close();
        }
        return resul;
    }
}
