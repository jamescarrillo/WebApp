/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.Penalidad;
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
public class PenalidadDao {

    private SqlSessionFactory sqlSessionFactory;

    public PenalidadDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<Penalidad> items = new PenalidadDao().listItems();
    private static String anho = "";
    private static Penalidad selected;
    private static List<Anho> anhos = new PenalidadDao().getListAnhos();
    private static Anho selectedAnho;

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        PenalidadDao.selectedAnho = selectedAnho;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anho) {
        PenalidadDao.anhos = anhos;
    }

    public Penalidad getSelected() {
        return selected;
    }

    public void setSelected(Penalidad selected) {
        PenalidadDao.selected = selected;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<Penalidad> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<Penalidad> items) {
        PenalidadDao.items = items;
    }

    public ArrayList<Penalidad> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("c", "%" + filter + "%");
        hm.put("anho", "");
        if (anho != null && !"".equals(anho)) {
            hm.put("anho", "and anho='" + anho + "'");
        }
        try {
            return (ArrayList) session.selectList("Penalidad.getList", hm);
        } finally {
            session.close();
        }
    }

    public ArrayList<Anho> getListAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return (ArrayList) session.selectList("Penalidad.getAnho");
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
    public void changeSelect(@BindingParam("select") String x) {
        anho = x;
        items = listItems();
    }

    public Boolean insert(Penalidad exo) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.insert("Penalidad.insert", exo);
            session.commit();
            items = listItems();
        } finally {
            session.close();
        }
        return flag;
    }

    public Boolean update(Penalidad turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.update("Penalidad.update", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }
    @Wire
    private Window win;

    @Command
    public void delete(@BindingParam("item") final Integer id) {
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

                            sqlSession.update("Penalidad.delete", id);
                            sqlSession.commit();

                        } finally {
                            sqlSession.close();
                            items = listItems();
                            BindUtils.postNotifyChange(null, null, PenalidadDao.this, "*");
                        }
                    }
                }
            });
        } else {
            showNotify("Aviso! Seleccione Primero un Item Para Borrar", win);
        }
    }

    private void showNotify(String msg, Component ref) {
        Clients.showNotification(msg, "warning", ref, "middle_center", 3000);
    }

    public Penalidad obtenerBean(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("Penalidad.get", id);
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return (int) sqlSession.selectList("Penalidad.getTotalListForWeb", hm).size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Penalidad> listItemsWeb(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("Penalidad.getListWeb", hm);
        } finally {
            session.close();
        }
    }
}
