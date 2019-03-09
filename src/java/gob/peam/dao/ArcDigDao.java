/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.ResolucionGerencial;
import gob.peam.config.ArcDigConnectionFactory;
import java.io.IOException;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author alabajos
 */
public class ArcDigDao {

    private SqlSessionFactory sqlSessionFactory;

    public ArcDigDao() {
        sqlSessionFactory = ArcDigConnectionFactory.getSqlSessionFactory();
    }
    private static String filter = "";
    private static List<ResolucionGerencial> items = new ArcDigDao().listItems();
    private static String anho = "";
    private static Set<ResolucionGerencial> selected;
    private static Integer tipo = 0;
    private static Integer cateId = 0;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        ArcDigDao.cateId = cateId;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public List<ResolucionGerencial> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<ResolucionGerencial> items) {
        ArcDigDao.items = items;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        ArcDigDao.anho = anho;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        ArcDigDao.filter = filter;
    }

    public Set<ResolucionGerencial> getSelected() {
        return selected;
    }

    public void setSelected(Set<ResolucionGerencial> selected) {
        this.selected = selected;
    }

    public ArrayList<ResolucionGerencial> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        hm.put("c", "%" + filter + "%");
        hm.put("anho", "");
        hm.put("tipo", "");
        List<ResolucionGerencial> lista = (List<ResolucionGerencial>) new ArrayList<ResolucionGerencial>();
        if (anho != null) {
            hm.put("anho", "and trim(substring(t1.docu_fecha_docx from 7)) ='" + anho + "' ");
        }
        if (tipo != null) {
            hm.put("tipo", "and t2.etiq_id='" + tipo + "' ");
        }
        try {
            lista = session.selectList("ResolucionObra.getListArcDig", hm);
            if (tipo != null && tipo == 29) {
                if (!lista.isEmpty()) {
                    for (int i = 0; i < lista.size(); i++) {
                        String dni = getMetaData(lista.get(i), "DNI");
                        lista.get(i).setTitulo(dni);
                    }
                }
            }
        } finally {
            session.close();
        }



        return (ArrayList) lista;
    }

    public List<String> getAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("ResolucionObra.getAnhoArcDig");
        } finally {
            session.close();
        }
    }

    public List<ResolucionGerencial> temporal() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("ResolucionObra.temporal");
        } finally {
            session.close();
        }
    }

    @GlobalCommand
    @NotifyChange({"dato", "items"})
    public void changeSelect(@BindingParam("select") String x, @BindingParam("tipo") Integer tip) {
        anho = x;
        tipo = tip;
        items = listItems();
    }

    @Command
    @NotifyChange({"items"})
    public void update() {
        anho = null;
        tipo = null;
        items = listItems();
    }

    @Command
    @NotifyChange({"items"})
    public void changeFilter() {
        items = listItems();
    }

    public ResolucionGerencial obtenerBean(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        ResolucionGerencial a = new ResolucionGerencial();
        try {
            a = session.selectOne("ResolucionObra.getArcDig", id);
            if (tipo != null && tipo == 29) {
                if (a != null) {
                    String dni = getMetaData(a, "DNI");
                    a.setTitulo(dni);
                }
            }
        } finally {
            session.close();
            return a;
        }

    }
    @Wire
    private Window win;

    private void showNotify(String msg, Component ref) {
        Clients.showNotification(msg, "warning", ref, "middle_center", 3000);
    }

    public String getTagValue(String tag, Element elemento) {
        NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();
        Node valor = (Node) lista.item(0);
        return valor.getNodeValue();
    }

    public String getMetaData(ResolucionGerencial a, String tag) {
        String result = "";
        if (a.getMetaData() != null && !"".equals(a.getMetaData())) {
            String metaData = null;
            metaData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + a.getMetaData().trim();
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
                    if (tag.equals(getTagValue("meta_nombre", elemento).toLowerCase())) {
                        result = getTagValue("meta_descripcion", elemento);
                    }
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
            }
        }
        return result;
    }
}
