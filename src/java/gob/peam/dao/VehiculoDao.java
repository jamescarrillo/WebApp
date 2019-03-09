/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Vehiculo;
import gob.peam.config.WebAppConnectionFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jprada
 */
public class VehiculoDao implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4441614670400520946L;
    private SqlSessionFactory sqlSessionFactory;

    public VehiculoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("rawtypes")
    public List<Vehiculo> listVehiculoForWeb(HashMap hm) {
        List<Vehiculo> vehiculos;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            vehiculos = sqlSession.selectList("Vehiculo.getListForWeb", hm);
            return vehiculos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalVehiculoForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Vehiculo> vehiculos = sqlSession.selectList("Vehiculo.getTotalListForWeb", hm);
            return vehiculos.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listMesVehiculoForWeb(String anho) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> mes = sqlSession.selectList("Vehiculo.getListMesForWeb", anho);
            return mes;
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosVehiculoForWeb() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("Vehiculo.getListAnioForWeb");
            return anhos;
        } finally {
            sqlSession.close();
        }

    }

    @SuppressWarnings("rawtypes")
    public List<Vehiculo> importarVehiculo(List<Vehiculo> list) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Vehiculo> vehiculos;
        //creamos la tabla temporal
        try {
            sqlSession.update("Vehiculo.createTableTemp");
            for (Vehiculo vehiculo : list) {
                sqlSession.insert("Vehiculo.insertTemp", vehiculo);
            }
            vehiculos = sqlSession.selectList("Vehiculo.getListTempForWeb");
            sqlSession.commit();
            return vehiculos;
        } finally {
            sqlSession.close();
        }
    }

    public boolean addItemVehiculo(HashMap h) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            boolean flag = true;
            List<Vehiculo> publi = session.selectList("Vehiculo.getRepetidoVehiculo", h);
            if (publi.isEmpty()) {
                session.insert("Vehiculo.addItemVehiculo", h);
            } else {
                flag = false;
            }
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean eliminarVehiculo(Integer id) {
        boolean estado = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Vehiculo.deleteVehiculo", id);
            sqlSession.commit();
            estado = true;
        } finally {
            sqlSession.close();
        }
        return estado;
    }

    @SuppressWarnings("rawtypes")
    public List<Vehiculo> listVehiculoForAdmin(HashMap hm) {
        List<Vehiculo> vehiculos;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            vehiculos = sqlSession.selectList("Vehiculo.getListForAdmin", hm);
            return vehiculos;
        } finally {
            sqlSession.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalVehiculoForAdmin(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Vehiculo> vehiculos = sqlSession.selectList("Vehiculo.getTotalListForAdmin", hm);
            return vehiculos.size();
        } finally {
            sqlSession.close();
        }
    }
}
