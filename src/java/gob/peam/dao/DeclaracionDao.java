/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.Declaracion;
import gob.peam.beans.Metadata;
import gob.peam.beans.ResolucionGerencial;
import gob.peam.config.WebAppConnectionFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
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
public class DeclaracionDao {

    private SqlSessionFactory sqlSessionFactory;

    public DeclaracionDao() {
        sqlSessionFactory = WebAppConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<Declaracion> items = new DeclaracionDao().listItems();
    private static String anho = "";
    private static Declaracion selected;
    private static List<Anho> anhos = new DeclaracionDao().getListAnhos();
    private static Anho selectedAnho;

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        DeclaracionDao.anho = anho;
    }

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        DeclaracionDao.selectedAnho = selectedAnho;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anho) {
        DeclaracionDao.anhos = anhos;
    }

    public List<Declaracion> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<Declaracion> items) {
        DeclaracionDao.items = items;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        DeclaracionDao.filter = filter;
    }

    public Declaracion getSelected() {
        return selected;
    }

    public void setSelected(Declaracion selected) {
        DeclaracionDao.selected = selected;
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

    public ArrayList<Declaracion> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("c", "%" + filter + "%");
        hm.put("anho", "");

        List<ResolucionGerencial> lista = (List<ResolucionGerencial>) new ArrayList<ResolucionGerencial>();
        List<Declaracion> d = (List<Declaracion>) new ArrayList<Declaracion>();
        if (anho != null && !"".equals(anho)) {
            hm.put("anho", "and trim(substring(docu_fecha_docx from 7)) ='" + anho + "' ");
        }
        try {
            lista = (ArrayList) session.selectList("ResolucionObra.getListK", hm);
            //List<Metadata> m = (List<Metadata>) new ArrayList<Metadata>();

            for (ResolucionGerencial a : lista) {
                String cargo = null, presentacion = null;
                for (Metadata m : getMetadata(a)) {
                    if ("CARGO".equals(m.getCampo())) {
                        cargo = m.getDetalle();

                    }
                    if ("PRESENTACIÓN".equals(m.getCampo())) {
                        presentacion = m.getDetalle();
                    }

                }
                d.add(new Declaracion(a.getId(), a.getTitulo(), a.getResumen(), a.getFecha(), cargo, presentacion, a.getEstado()));
            }


        } finally {
            session.close();
        }
        return (ArrayList) d;
    }

    public List<Declaracion> listItemsWeb(HashMap hm) {
        SqlSession session = sqlSessionFactory.openSession();
        List<ResolucionGerencial> lista = (List<ResolucionGerencial>) new ArrayList<ResolucionGerencial>();
        List<Declaracion> d = (List<Declaracion>) new ArrayList<Declaracion>();
        try {

            lista = session.selectList("ResolucionObra.getListWeb", hm);


            for (ResolucionGerencial a : lista) {
                String cargo = null, presentacion = null;
                for (Metadata m : getMetadata(a)) {
                    if ("CARGO".equals(m.getCampo())) {
                        cargo = m.getDetalle();
                    }
                    if ("PRESENTACIÓN".equals(m.getCampo())) {
                        presentacion = m.getDetalle();
                    }

                }
                d.add(new Declaracion(a.getId(), a.getTitulo(), a.getResumen(), a.getFecha(), cargo, presentacion, a.getEstado()));
            }

        } finally {
            session.close();
        }
        return d;
    }

    public ArrayList<Anho> getListAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return (ArrayList) session.selectList("ResolucionObra.getAnhoK");
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

    @Command
    @NotifyChange({"items"})
    public void changeFilter() {
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
        hm.put("cateId", 1200);
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
                            BindUtils.postNotifyChange(null, null, DeclaracionDao.this, "*");
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

    //-----lista de documentos. filtrado con metadata
    public String getTagValue(String tag, Element elemento) {
        NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();
        Node valor = (Node) lista.item(0);
        return valor.getNodeValue();
    }

    public List<Metadata> getMetadata(ResolucionGerencial arcdig) {

        List<Metadata> metadata = (List<Metadata>) new ArrayList<Metadata>();
        if (arcdig != null) {

            if (arcdig.getMetaData() != null && !"".equals(arcdig.getMetaData())) {
                String metaData = null;
                metaData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + arcdig.getMetaData().trim();

                try {
                    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(metaData));
                    Document doc = docBuilder.parse(is);
                    doc.getDocumentElement().normalize();

                    for (int i = 0; i < doc.getElementsByTagName("docu_metadata").getLength(); i++) {
                        Node documento = doc.getElementsByTagName("docu_metadata").item(i);
                        Element elemento = (Element) documento;
                        metadata.add(new Metadata(getTagValue("meta_nombre", elemento).toUpperCase(), getTagValue("meta_descripcion", elemento)));
                    }
                } catch (ParserConfigurationException | SAXException | IOException e) {
                    //showNotify(e + "", win);
                }
            }
        }
        return metadata;
    }
}
