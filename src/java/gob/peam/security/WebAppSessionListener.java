/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.security;

import gob.peam.administracion.beans.Sesion;
import gob.peam.administracion.dao.SesionDao;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author jpgprog84
 */
public class WebAppSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sesion creada");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession context = se.getSession();
        synchronized (context) {
            SesionDao dao = new SesionDao();
            Sesion s = dao.buscarSesion(context.getId());
            s.setSesiFechaSalida(new java.sql.Date(context.getLastAccessedTime()));
            s.setSesiHoraSalida(new Time(new Date(context.getLastAccessedTime()).getTime()));
            s.setSesiEstado(false);
            dao.actualizarSesion(s);
            se.getSession().invalidate();
        }
    }
}
