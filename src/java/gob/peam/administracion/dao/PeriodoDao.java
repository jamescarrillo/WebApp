/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Mes;
import gob.peam.administracion.beans.Periodo;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class PeriodoDao {

    private SqlSessionFactory sqlSessionFactory;

    public PeriodoDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Periodo> listarPeriodos() {
        List<Periodo> periodos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            periodos = session.selectList("Periodo.selectPeriodos");
            return periodos;
        } finally {
            session.close();
        }
    }

    public Periodo buscarPeriodo(String anio) {
        Periodo periodo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            periodo = session.selectOne("Periodo.buscarPeriodo", anio);
            return periodo;
        } finally {
            session.close();
        }
    }

    public List<Mes> listarMeses(String anho) {
        List<Mes> meses;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            meses = session.selectList("Periodo.selectMeses", anho);
            return meses;
        } finally {
            session.close();
        }
    }

    public boolean actualizarPeriodo(Periodo periodo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Periodo.updatePeriodo", periodo);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Periodo buscarPeriodoActivo() {
        Periodo periodo;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            periodo = session.selectOne("Periodo.buscarPeriodoActivo");
            return periodo;
        } finally {
            session.close();
        }
    }

    public Mes buscarMesActivo(String anho) {
        Mes mes;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            mes = session.selectOne("Periodo.buscarMesActivo", anho);
            return mes;
        } finally {
            session.close();
        }
    }

    public boolean incrementarMes(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //primero desactivamos los meses del año
            session.update("Periodo.desactivarMeses", hm.get("anio"));
            session.update("Periodo.incrementMes", hm);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean incrementarAnio(String anio) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //primero desactivamos los meses del año
            session.update("Periodo.desactivarMeses", anio);
            session.update("Periodo.desactivarPeriodo",anio);
            Integer anho = Integer.parseInt(anio) + 1;
            
            session.insert("Periodo.insertAnio", anho.toString());
            String dias[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            for (int i = 1; i <= 12; i++) {
                Mes mes = new Mes();
                mes.setActivo(i == 1 ? true : false);
                mes.setId(String.valueOf(i).length() == 2 ? String.valueOf(i) : "0" + String.valueOf(i));
                mes.setNombre(dias[i - 1]);
                Periodo p = new Periodo();
                p.setAnio(String.valueOf(anho));
                mes.setPeriodo(p);
                session.insert("Periodo.insertMes", mes);
            }
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
