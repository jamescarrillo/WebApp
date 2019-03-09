/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Glosario;
import gob.peam.config.WebAppConnectionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
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
public class GlosarioDao {

    private SqlSessionFactory sqlSessionFactory;

    public GlosarioDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<Glosario> items = new GlosarioDao().listItems();
    private static Glosario selected;

    public Glosario getSelected() {
        return selected;
    }

    public void setSelected(Glosario selected) {
        GlosarioDao.selected = selected;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        GlosarioDao.filter = filter;
    }
    @Wire
    private Window win;

    public List<Glosario> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<Glosario> items) {
        GlosarioDao.items = items;
    }

    public ArrayList<Glosario> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        String c = "%" + filter + "%";
        try {
            return (ArrayList) session.selectList("Glosario.getList", c);
        } finally {
            session.close();
        }
    }

    @Command
    @NotifyChange({"items"})
    public void changeFilter() {
        items = listItems();
    }

    public Boolean insert(Glosario turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.insert("Glosario.insert", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }

    public Boolean update(Glosario turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.update("Glosario.update", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }

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
                                        sqlSession.update("Glosario.delete", id);
                                        sqlSession.commit();
                                } finally {
                                    sqlSession.close();
                                    items = listItems();
                                    BindUtils.postNotifyChange(null, null, GlosarioDao.this, "*");
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

    public Glosario obtenerBean(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("Glosario.get", id);
        } finally {
            session.close();
        }
    }
    
    public List<Glosario> listItemsWeb(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("Glosario.getListForWeb", hm);
        } finally {
            session.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public int listTotalWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return (int) sqlSession.selectOne("Glosario.getTotalListForWeb", hm);
        } finally {
            sqlSession.close();
        }
    }
}
