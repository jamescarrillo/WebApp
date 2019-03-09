/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Rol;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class RolDao {

    private SqlSessionFactory sqlSessionFactory;

    public RolDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Rol> listarRoles(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarRoles", hm);
            return roles;
        } finally {
            session.close();
        }
    }

    public List<Rol> listarRolesPorGrupo(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarRolesPorGrupo", hm);
            return roles;
        } finally {
            session.close();
        }
    }

    public List<Rol> listarRolesSinGrupo(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarRolesSinGrupo", hm);
            return roles;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalRoles(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarTotalRoles", hm);
            return roles.size();
        } finally {
            session.close();
        }
    }

    public Integer listarTotalRolesPorGrupo(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarTotalRolesPorGrupo", hm);
            return roles.size();
        } finally {
            session.close();
        }
    }

    public Integer listarTotalRolesSinGrupo(HashMap hm) {
        List<Rol> roles;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            roles = session.selectList("Rol.listarTotalRolesSinGrupo", hm);
            return roles.size();
        } finally {
            session.close();
        }
    }

    public boolean insertarModulo(Rol rol) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Rol.insertRol", rol);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean existeRol(String nombre) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Rol rol = session.selectOne("Rol.existeRol", nombre);
            if (rol == null) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }

    public Rol buscarRol(Integer idRol) {
        Rol rol;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            rol = session.selectOne("Rol.buscarRol", idRol);
            return rol;
        } finally {
            session.close();
        }
    }

    public Rol buscarRolPorNombre(String nombre) {
        Rol rol;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            rol = session.selectOne("Rol.buscarRolForNombre", nombre);
            return rol;
        } finally {
            session.close();
        }
    }

    public boolean actualizarRol(Rol rol) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Rol.updateRol", rol);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarRol(Integer idRol) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Rol.deleteRol", idRol);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean hasChildrenRol(Integer idRol) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Rol> list = session.selectList("Rol.listarChildrenForRoles", idRol);
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }
    }

    public boolean insertarPerfil(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Rol.insertPerfil", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
    public boolean eliminarPerfil(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Rol.delPerfil", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
