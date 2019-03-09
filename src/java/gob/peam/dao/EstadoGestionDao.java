/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.Finanza;
import gob.peam.config.WebAppConnectionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author alabajos
 */
public class EstadoGestionDao {

    private SqlSessionFactory sqlSessionFactory;

    public EstadoGestionDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<Finanza> items = new EstadoGestionDao().listItems();
    private static String anho = "";
    private static Finanza selected;
    private static List<Anho> anhos = new EstadoGestionDao().getListAnhos();
    private static Anho selectedAnho;

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        EstadoGestionDao.anho = anho;
    }

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        EstadoGestionDao.selectedAnho = selectedAnho;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anho) {
        EstadoGestionDao.anhos = anhos;
    }

    public List<Finanza> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<Finanza> items) {
        EstadoGestionDao.items = items;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        EstadoGestionDao.filter = filter;
    }

    public Finanza getSelected() {
        return selected;
    }

    public void setSelected(Finanza selected) {
        EstadoGestionDao.selected = selected;
    }

    public ArrayList<Finanza> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("c", "%" + filter + "%");
        hm.put("anho", "");
        hm.put("tipo", 8);
        if (anho != null && !"".equals(anho)) {
            hm.put("anho", "and anho ='" + anho + "' ");
        }
        try {
            return (ArrayList) session.selectList("Finanza.getList", hm);
        } finally {
            session.close();
        }
    }

    public ArrayList<Anho> getListAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        int tipo = 8;
        try {
            return (ArrayList) session.selectList("Finanza.getListAnio", tipo);
        } finally {
            session.close();
        }
    }

    @GlobalCommand
    @NotifyChange({"items"})
    public void changeAnho(@BindingParam("select") String x) {
        anho = x;
        items = listItems();
    }

    @GlobalCommand
    @NotifyChange({"items"})
    public void updateItems(@ExecutionArgParam("anho") String x) {
        anho = x;
        items = listItems();
    }

    @GlobalCommand
    @NotifyChange({"anhos"})
    public void updateAnho() {
        anhos = getListAnhos();
        anho = null;
        HashMap hm = new HashMap();
        hm.put("anho", anho);
        BindUtils.postGlobalCommand(null, null, "updateItems", hm);
    }

    @Command
    @NotifyChange({"items"})
    public void changeFilter() {
        items = listItems();
    }
    @Wire
    private Window win;

    @Command
    public void delete(@BindingParam("item") final Integer id) {
        final HashMap hm = new HashMap();
        hm.put("id", id);

        if (id != null) {
            Messagebox.show(
                    "Estas Seguro de Eliminar?", "Dialogo de Confirmacion ",
                    Messagebox.OK | Messagebox.CANCEL,
                    Messagebox.QUESTION,
                    new org.zkoss.zk.ui.event.EventListener() {
                @Override
                public void onEvent(Event evt) {
                    if (evt.getName().equals("onOK")) {
                        SqlSession sqlSession = sqlSessionFactory.openSession();
                        try {
                            sqlSession.update("Finanza.deleteFinanza", hm);
                            sqlSession.commit();
                        } finally {
                            sqlSession.close();
                            items = listItems();
                            BindUtils.postNotifyChange(null, null, EstadoGestionDao.this, "*");
                        }
                    }
                }
            });
        } else {
            showNotify("Aviso! Seleccione Primero un Item Para Borrar", win);
        }
    }

    private void showNotify(String msg, Component ref) {
        Clients.showNotification(msg, "info", ref, "middle_center", 3000);
    }
}
