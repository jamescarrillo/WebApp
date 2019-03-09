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
import java.util.Set;
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
public class ResolucionObraDao {

    private SqlSessionFactory sqlSessionFactory;

    public ResolucionObraDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<ResolucionGerencial> items = new ResolucionObraDao().listItems();
    private static List<Anho> anhos = new ResolucionObraDao().getListAnhos();
    private static Set<ResolucionGerencial> selected;
    private static Anho selectedAnho;
    private static String anho = "";

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        ResolucionObraDao.anho = anho;
    }

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        ResolucionObraDao.selectedAnho = selectedAnho;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anho) {
        ResolucionObraDao.anhos = anhos;
    }

    public List<ResolucionGerencial> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<ResolucionGerencial> items) {
        ResolucionObraDao.items = items;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        ResolucionObraDao.filter = filter;
    }

    public Set<ResolucionGerencial> getSelected() {
        return selected;
    }

    public void setSelected(Set<ResolucionGerencial> selected) {
        this.selected = selected;
    }

    public Boolean insert(ResolucionGerencial doc) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            doc.setTitulo(doc.getTitulo().toLowerCase());
            doc.setTitulo(doc.getTitulo().replaceFirst(doc.getTitulo().charAt(0) + "", (doc.getTitulo().charAt(0) + "").toUpperCase()));

            doc.setResumen(doc.getResumen().toLowerCase());
            doc.setResumen(doc.getResumen().replaceFirst(doc.getResumen().charAt(0) + "", (doc.getResumen().charAt(0) + "").toUpperCase()));
        } catch (Exception ex) {
        }
        
        try {
            session.insert("ResolucionObra.insert", doc);
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
    
    
        public Boolean updateTemporal(ResolucionGerencial xx) {
        SqlSession session = sqlSessionFactory.openSession();
        Boolean flag = true;
        try {
            session.update("ResolucionObra.updateTemporal", xx);
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
        if (null != anho && !"".equals(anho)) {
            hm.put("anho", "and trim(substring(docu_fecha_docx from 7)) ='" + anho + "' ");
        }
        try {
            return (ArrayList) session.selectList("ResolucionObra.getList", hm);
        } finally {
            session.close();
        }
    }

    public ArrayList<Anho> getListAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return (ArrayList) session.selectList("ResolucionObra.getAnho");
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
        hm.put("cateId", 100);
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
                            BindUtils.postNotifyChange(null, null, ResolucionObraDao.this, "*");
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

    public List<ResolucionGerencial> listItemsWeb(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("ResolucionObra.getListWeb", hm);
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public int listTotalWeb(HashMap hm) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return (int) sqlSession.selectList("ResolucionObra.getTotalListForWeb", hm).size();
        } finally {
            sqlSession.close();
        }
    }

    public List<String> listAnhosForWeb(Integer cateId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<String> anhos = sqlSession.selectList("ResolucionObra.getListAnioForWeb", cateId);
            return anhos;
        } finally {
            sqlSession.close();
        }
    }

    public void publicar(Integer id, Integer cateId) {
        SqlSession bdData = sqlSessionFactory.openSession();
        try {
            HashMap hm = new HashMap();
            hm.put("id", id);
            hm.put("cateId", cateId);
            //obtenemos si es Activo o desactivado el registro
            ResolucionGerencial bean = bdData.selectOne("ResolucionObra.get", hm);

            if (bean.getEstado()) {
                hm.put("estado", false);
            } else {
                hm.put("estado", true);
            }
            //Modificar estado definitivamente al registro. Publico o despublicado
            bdData.update("ResolucionObra.publicar", hm);
            bdData.commit();

        } finally {
            bdData.close();
        }
    }
}
