/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Correlativo;
import gob.peam.config.AdministracionConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class CorrelativoDao {

    private SqlSessionFactory sqlSessionFactory;

    public CorrelativoDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }
     public Correlativo buscarCorrelativo(String tiemAnio) {
        Correlativo correlativo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            correlativo = session.selectOne("Correlativo.searchCorrelativo", tiemAnio);
            return correlativo;
        } finally {
            session.close();
        }
    }
      public boolean actualizarCorrelativo(Correlativo correlativo) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean res = false;
        try {            
                Correlativo c = buscarCorrelativo(correlativo.getTiemAnio());
                if (c == null) {
                    session.insert("Correlativo.insertCorrelativo", correlativo);
                    session.commit();
                } else {
                    session.update("Correlativo.updateCorrelativo", correlativo);
                    session.commit();
                }
            
            res=true;
        } finally {
            session.close();
        }
        return res;
    }

}
