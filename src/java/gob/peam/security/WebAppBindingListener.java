/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.security;

import gob.peam.administracion.beans.Dependencia;
import gob.peam.administracion.beans.Sesion;
import gob.peam.administracion.beans.Usuario;
import gob.peam.administracion.dao.SesionDao;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author jpgprog84
 */
public class WebAppBindingListener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession context = event.getSession();
        synchronized (context) {
            //primero agregamos el dao sesion
            SesionDao dao = new SesionDao();
            Sesion s = new Sesion();       
            Dependencia d= new Dependencia();
            d.setIdDependencia(Integer.parseInt(context.getAttribute("iddependencia").toString()));
             s.setDependencia(d);
             s.setSesiEstado(true);
             s.setSesiFechaIngreso(new java.sql.Date(context.getCreationTime()));
             s.setSesiHoraIngreso(new Time(new Date(context.getCreationTime()).getTime()));
             s.setSesiIp(context.getAttribute("ip").toString());
             s.setSesiKey(context.getId());
             Usuario u= new Usuario();
             u.setIdUsuario(Integer.parseInt(context.getAttribute("idUsuario").toString()));
             s.setUsuario(u);           
             dao.insertarSesion(s);
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession context = event.getSession();
        synchronized (context) {
            SesionDao dao= new SesionDao();
            Sesion s=dao.buscarSesion(context.getId());
            s.setSesiFechaSalida(new java.sql.Date(context.getLastAccessedTime()));
            s.setSesiHoraSalida(new Time(new Date(context.getLastAccessedTime()).getTime()));
            s.setSesiEstado(false);
            dao.actualizarSesion(s);
            event.getSession().invalidate();
        }
    }
}
