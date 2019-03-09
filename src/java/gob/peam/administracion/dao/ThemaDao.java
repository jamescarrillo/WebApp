/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.SubModulo;
import gob.peam.administracion.beans.Thema;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class ThemaDao {

    private SqlSessionFactory sqlSessionFactory;

    public ThemaDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Thema> listarThema() {
        List<Thema> themas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            themas = session.selectList("Thema.seleccionarThema");
            return themas;
        } finally {
            session.close();
        }
    }

    public Boolean insertarThema(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Thema.insertEstilo", h);
            session.commit();
        } finally {
            session.close();
        }
        return true;
    }

    public boolean existeThema(String descripcion) {
        boolean existe = false;
        List<Thema> themas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            themas = session.selectList("Thema.existeThema", descripcion);
            if (themas.size() > 0) {
                existe = true;
            } else {
                existe = false;
            }
        } finally {
            session.close();
        }
        return existe;
    }

    public boolean actualizarThema(HashMap h) {
        boolean result = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Thema.updateEstilo", h);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public Thema buscarThema(String descripcion) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Thema thema = session.selectOne("Thema.buscarThemaPorDescripcion", descripcion);
            return thema;
        } finally {
            session.close();
        }
    }

    public boolean tieneDependencias(Integer id) {
        boolean resul;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<SubModulo> subModulos = session.selectList("Thema.childrenThema", id);
            if (subModulos.size() > 0) {
                resul = true;
            } else {
                resul = false;
            }
            return resul;
        } finally {
            session.close();
        }
    }

    public boolean eliminarThema(Integer id) {
        boolean resul = false;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Thema.deleteThema", id);
            session.commit();
            resul = true;
        } finally {
            session.close();
        }
        return resul;
    }
    
    public Thema buscarEstiloPorUsuarioyModulo(HashMap hm){
       Thema themas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            themas = session.selectOne("Thema.buscarEstiloPorUsuarioyModulo", hm);
            return themas;
        } finally {
            session.close();
        }
    }
    
     public List<Thema> estiloPorUsuarioyModulo(){
       List<Thema> themas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            themas = session.selectList("Thema.listarEstilos");
            return themas;
        } finally {
            session.close();
        }
    }
}
