/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.config;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author jprada
 */
public class ArcDigConnectionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        try {
            String resource = "gob/peam/config/WebAppSql.xml";
            try {
                reader = Resources.getResourceAsReader(resource);
            } catch (IOException ex) {
                Logger.getLogger(WebAppConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "ArcDig");
            }
        } catch (SqlSessionException ex) {
            sqlSessionFactory = null;
            Logger.getLogger(WebAppConnectionFactory.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(WebAppConnectionFactory.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        return sqlSessionFactory;
    }
}
