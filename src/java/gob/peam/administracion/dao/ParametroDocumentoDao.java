/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.ParametroDocumento;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class ParametroDocumentoDao {

    private SqlSessionFactory sqlSessionFactory;

    public ParametroDocumentoDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public ParametroDocumento buscarParametroDocumento(Integer tipoDocumento) {
        ParametroDocumento parametroDocumento;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            parametroDocumento = session.selectOne("ParametroDocumento.searchParametroDocumento", tipoDocumento);
            return parametroDocumento;
        } finally {
            session.close();
        }
    }

    public boolean actualizarParametroDocumento(List<ParametroDocumento> parametrosDocumentos) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean res = false;
        try {
            for (ParametroDocumento parametroDocumento : parametrosDocumentos) {
                ParametroDocumento pd = buscarParametroDocumento(parametroDocumento.getTipoDocumento());
                if (pd == null) {
                    session.insert("ParametroDocumento.insertParametroDocumento", parametroDocumento);
                    session.commit();
                } else {
                    session.update("ParametroDocumento.updateParametroDocumento", parametroDocumento);
                    session.commit();
                }
            }
            res=true;
        } finally {
            session.close();
        }
        return res;
    }
}
