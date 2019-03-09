/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.ResolucionGerencial;
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
public class LaudosDao {

    private SqlSessionFactory sqlSessionFactory;

    public LaudosDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<ResolucionGerencial> items = new LaudosDao().listItems();
    private static String anho = "";
    private static ResolucionGerencial selected;
    private static List<Anho> anhos = new LaudosDao().getListAnhos();
    private static Anho selectedAnho;

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        LaudosDao.anho = anho;
    }

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        LaudosDao.selectedAnho = selectedAnho;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anho) {
        LaudosDao.anhos = anhos;
    }

    public List<ResolucionGerencial> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<ResolucionGerencial> items) {
        LaudosDao.items = items;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        LaudosDao.filter = filter;
    }

    public ResolucionGerencial getSelected() {
        return selected;
    }

    public void setSelected(ResolucionGerencial selected) {
        LaudosDao.selected = selected;
    }

    public Boolean insert(ResolucionGerencial turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.insert("ResolucionObra.insert", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }

    public Boolean update(ResolucionGerencial turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.update("ResolucionObra.update", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }

    public ArrayList<ResolucionGerencial> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("c", "%" + filter + "%");
        hm.put("anho", "");
        if (anho != null && !"".equals(anho)) {
            hm.put("anho", "and trim(substring(docu_fecha_docx from 7)) ='" + anho + "' ");
        }
        try {
            return (ArrayList) session.selectList("ResolucionObra.getListD", hm);
        } finally {
            session.close();
        }
    }

    public ArrayList<Anho> getListAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return (ArrayList) session.selectList("ResolucionObra.getAnhoD");
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

    public ResolucionGerencial obtenerBean(Integer id, Integer cate_id) {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("id", id);
        hm.put("cateId", cate_id);
        try {
            return session.selectOne("ResolucionObra.get", hm);
        } finally {
            session.close();
        }
    }
    @Wire
    private Window win;

    @Command
    public void delete(@BindingParam("item") final Integer id) {
        final HashMap hm = new HashMap();
        hm.put("id", id);
        hm.put("cateId", 500);
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
                            sqlSession.update("ResolucionObra.delete", hm);
                            sqlSession.commit();
                        } finally {
                            sqlSession.close();
                            items = listItems();
                            BindUtils.postNotifyChange(null, null, LaudosDao.this, "*");
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
