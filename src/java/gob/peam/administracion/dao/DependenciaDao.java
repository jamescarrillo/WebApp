package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Cargo;
import gob.peam.administracion.beans.Dependencia;
import gob.peam.administracion.beans.Persona;
import gob.peam.config.AdministracionConnectionFactory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DependenciaDao implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4608543267717992049L;
    private SqlSessionFactory sqlSessionFactory;

    public DependenciaDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Dependencia> listarDependencias(HashMap hm) {
        List<Dependencia> dependencias;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            dependencias = sqlSession.selectList("Dependencia.listarDependencias", hm);
            return dependencias;
        } finally {
            sqlSession.close();
        }
    }

    public List<Dependencia> listarDependenciasForCombo() {
        List<Dependencia> dependencias;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            dependencias = sqlSession.selectList("Dependencia.listarDependenciasForCombo");
            return dependencias;
        } finally {
            sqlSession.close();
        }
    }

    public boolean insertarDependencia(Dependencia dependencia) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            session.insert("Dependencia.insertarDependencia", dependencia);
            result = true;
            session.commit();
        } finally {
            session.close();
        }
        return result;
    }

    public Persona seleccionarRepresentante(Integer depe_id) {
        Persona p;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            p = session.selectOne("Persona.selectRepresentante", depe_id);
            return p;
        } finally {
            session.close();
        }
    }

    public Dependencia buscarDependencia(Integer id) {
        Dependencia dependencia;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            dependencia = session.selectOne("Dependencia.buscarDependencia", id);
            return dependencia;
        } finally {
            session.close();
        }
    }

    public boolean actualizarDependencia(Dependencia dependencia) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            session.update("Dependencia.actualizarDependencia", dependencia);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public Integer totalSubDependencias(Integer id) {
        List< Dependencia> dependencias;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            dependencias = session.selectList("Dependencia.mostrarSubDependencia", id);
            return dependencias.size();
        } finally {
            session.close();
        }
    }

    public boolean eliminarDependencia(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            session.delete("Dependencia.eliminarDependencia", id);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public boolean actualizarCargo(Cargo cargo) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            Cargo representante = session.selectOne("Persona.existeCargo", cargo);
            if (representante == null) {//insertamos  pero antes desactivamos el anterior
                session.update("Persona.desactivarCargo", cargo.getDependencia());
                session.insert("Persona.insertCargo", cargo);
                session.commit();
            } else {                //actualizamos pero antes desactivamos el anterior
                session.update("Persona.desactivarCargo", cargo.getDependencia());
                session.update("Persona.updateCargo", cargo);
                session.commit();
            }
            result = true;
        } finally {
            session.close();
        }
        return result;
    }

    public List<Persona> listarPersonasPorDependencia(int depe_id) {
        List<Persona> personas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            personas = session.selectList("Persona.selectPersonasForDependencia", depe_id);
            return personas;
        } finally {
            session.close();
        }
    }
    
    public boolean insertarTrabajadorEnDependencia(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            session.insert("Dependencia.insertarTrabajadorInDependencia", hm);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }
   
   
    public boolean eliminarTrabajadorEnDependencia(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = false;
        try {
            session.delete("Dependencia.eliminarTrabajadorInDependencia", hm);
            session.commit();
            result = true;
        } finally {
            session.close();
        }
        return result;
    }
}
