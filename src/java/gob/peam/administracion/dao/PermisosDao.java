/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Permisos;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class PermisosDao {

    private SqlSessionFactory sqlSessionFactory;

    public PermisosDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Permisos> listarPermisosPorSubModulo(HashMap hm) {
        List<Permisos> permisoses;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            permisoses = session.selectList("Permisos.listarPermisosForSubModulo", hm);
            return permisoses;
        } finally {
            session.close();
        }
    }

    public boolean insertarPermisos(List<Permisos> permisoses) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean res = false;
        try {
            for (Permisos permisos : permisoses) {
                HashMap hm = new HashMap();
                hm.put("idSubModulo", permisos.getSubModulo().getIdSubModulo());
                hm.put("idRol", permisos.getRol().getIdRol());
                Permisos p = session.selectOne("Permisos.buscarPermiso", hm);
                if (p == null) {
                    session.insert("Permisos.insertPermisos", permisos);
                    session.commit();
                } else {
                    session.update("Permisos.updatePermisos", permisos);
                    session.commit();
                }
            }
            res = true;
        } finally {
            session.close();
        }
        return res;
    }
    
    public Permisos buscarPermisoPorUsuario(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("Permisos.buscarPermisoPorUsuario", hm);
        } finally {
            session.close();
        }
    }
}
