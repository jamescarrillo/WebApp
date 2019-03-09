package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Modulo;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ModuloDao {

    private SqlSessionFactory sqlSessionFactory;

    public ModuloDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Modulo> listarModulosForMenus() {
        List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.selectModulosForMenu");
            return modulos;
        } finally {
            session.close();
        }
    }

    public List<Modulo> listarModulosForGadget() {
        List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.selectModulosForGadget");
            return modulos;
        } finally {
            session.close();
        }
    }

    public List<Modulo> listarModulos(HashMap hm) {
        List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.listarModulos", hm);
            return modulos;
        } finally {
            session.close();
        }
    }

    public List<Modulo> listarModulosForPermisos() {
        List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.listarModulosForPermisos");
            return modulos;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalModulos(HashMap hm) {
        List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.listarTotalModulos", hm);
            return modulos.size();
        } finally {
            session.close();
        }
    }

    public boolean insertarModulo(Modulo modulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Modulo.insertModulo", modulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean existeModulo(String nombre) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Modulo m = session.selectOne("Modulo.existeModulo", nombre);
            if (m == null) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }
    
    public Integer getIdModulo(Integer Id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Integer m = session.selectOne("Modulo.getIdModulo", Id);
            return m;
        } finally {
            session.close();
        }
    }
    public Modulo buscarModulo(Integer idModulo) {
        Modulo modulo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulo = session.selectOne("Modulo.buscarModulo", idModulo);
            return modulo;
        } finally {
            session.close();
        }
    }

    public Modulo buscarModuloPorNombre(String nombre) {
        Modulo modulo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulo = session.selectOne("Modulo.buscarModuloForNombre", nombre);
            return modulo;
        } finally {
            session.close();
        }
    }

    public boolean actualizarModulo(Modulo modulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Modulo.updateModulo", modulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarModulo(Integer idModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Modulo.deleteModulo", idModulo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean hasChildrenModulo(Integer idModulo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Modulo> list = session.selectList("Modulo.listarChildrenForModulo", idModulo);
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }
    }
      public List<Modulo> listarModulosPorUsuario(Integer idUsuario){
          List<Modulo> modulos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            modulos = session.selectList("Modulo.listarModulosPorUsuario", idUsuario);
            return modulos;
        } finally {
            session.close();
        }
    }
}
