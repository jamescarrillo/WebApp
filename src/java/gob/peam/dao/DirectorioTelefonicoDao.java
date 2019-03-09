package gob.peam.dao;

import gob.peam.beans.DirectorioTelefonico;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

public class DirectorioTelefonicoDao {

    private SqlSessionFactory sqlSessionFactory;

    public DirectorioTelefonicoDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
 
    private static String filter = "";
    private static List<DirectorioTelefonico> items = new DirectorioTelefonicoDao().listItems();
    private static DirectorioTelefonico selected;

    public DirectorioTelefonico getSelected() {
        return selected;
    }

    public void setSelected(DirectorioTelefonico selected) {
        DirectorioTelefonicoDao.selected = selected;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        DirectorioTelefonicoDao.filter = filter;
    }
    @Wire
    private Window win;

    public List<DirectorioTelefonico> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<DirectorioTelefonico> items) {
        DirectorioTelefonicoDao.items = items;
    }

    public ArrayList<DirectorioTelefonico> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        String c = "%" + filter + "%";
        try {
            return (ArrayList) session.selectList("DirectorioTelefonico.getList", c);
        } finally {
            session.close();
        }
    }

    @Command
    @NotifyChange({"items"})
    public void changeFilter() {
        items = listItems();
    }

    public Boolean insert(DirectorioTelefonico turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.insert("DirectorioTelefonico.insert", turn);
            session.commit();
        } finally {
            session.close();
        }
        return flag;
    }

    public Boolean update(DirectorioTelefonico turn) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.update("DirectorioTelefonico.update", turn);
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
                                        sqlSession.update("DirectorioTelefonico.delete", id);
                                        sqlSession.commit();
                                } finally {
                                    sqlSession.close();
                                    items = listItems();
                                    BindUtils.postNotifyChange(null, null, DirectorioTelefonicoDao.this, "*");
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

    public DirectorioTelefonico obtenerBean(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("DirectorioTelefonico.get", id);
        } finally {
            session.close();
        }
    }
    
    
    
    @SuppressWarnings("rawtypes")
    public List<DirectorioTelefonico> listarDirectorioTelefonicoForWeb(HashMap hm) {
        List<DirectorioTelefonico> directorioTelefonicos;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            directorioTelefonicos = session.selectList("DirectorioTelefonico.getListForWeb", hm);
            return directorioTelefonicos;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalDirectorioTelefonicoForWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<DirectorioTelefonico> directorioTelefonicos = sqlSession.selectList("DirectorioTelefonico.getTotalListForWeb", hm);
            return directorioTelefonicos.size();
        } finally {
            sqlSession.close();
        }
    }
}
