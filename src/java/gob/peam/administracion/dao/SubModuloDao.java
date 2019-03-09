/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.SubModulo;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class SubModuloDao {

    private SqlSessionFactory sqlSessionFactory;

    public SubModuloDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<SubModulo> listarSubModulosForModulo(HashMap hm) {
        List<SubModulo> subModulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            subModulos = session.selectList("SubModulo.listarSubModuloPorModulo", hm);
            return subModulos;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalSubModulosForModulo(HashMap hm) {
        List<SubModulo> subModulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            subModulos = session.selectList("SubModulo.listarTotalSubModuloPorModulo", hm);
            return subModulos.size();
        } finally {
            session.close();
        }
    }

    public boolean insertarSubModulo(SubModulo subModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("SubModulo.insertSubModulo", subModulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean existeSubModulo(String nombre) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SubModulo m = session.selectOne("SubModulo.existeSubModulo", nombre);
            if (m == null) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }

    public SubModulo buscarSubModulo(Integer idSubModulo) {
        SubModulo subModulo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            subModulo = session.selectOne("SubModulo.buscarSubModulo", idSubModulo);
            return subModulo;
        } finally {
            session.close();
        }
    }

    public SubModulo buscarSubModuloPorNombre(String nombre) {
        SubModulo subModulo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            subModulo = session.selectOne("SubModulo.buscarSubModuloForNombre", nombre);
            return subModulo;
        } finally {
            session.close();
        }
    }

    public boolean actualizarSubModulo(SubModulo subModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("SubModulo.updateSubModulo", subModulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarSubModulo(Integer idSubModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("SubModulo.deleteSubModulo", idSubModulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
       public boolean hasChildrenSubModulo(Integer idSubModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<SubModulo> list = session.selectList("SubModulo.listarChildrenForSubModulo", idSubModulo);
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }
    }
}
