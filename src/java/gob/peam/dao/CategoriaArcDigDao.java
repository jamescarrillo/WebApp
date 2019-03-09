/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.dao;

import gob.peam.beans.Anho;
import gob.peam.beans.CategoriaArcDig;
import gob.peam.config.ArcDigConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author alabajos
 */
public class CategoriaArcDigDao {

    private SqlSessionFactory sqlSessionFactory;

    public CategoriaArcDigDao() {
        sqlSessionFactory = ArcDigConnectionFactory.getSqlSessionFactory();
    }
    private static List<CategoriaArcDig> items = new CategoriaArcDigDao().listItems();
    private static CategoriaArcDig selected;
    private static List<Anho> anhos = new CategoriaArcDigDao().listAnhos();
    
    private static Anho selectedAnho;

    public Anho getSelectedAnho() {
        return selectedAnho;
    }

    public void setSelectedAnho(Anho selectedAnho) {
        CategoriaArcDigDao.selectedAnho = selectedAnho;
    }
    
    private Integer tidoId=0;

    public Integer getTidoId() {
        return tidoId;
    }

    public void setTidoId(Integer tidoId) {
        this.tidoId = tidoId;
    }
    
    
    public List<CategoriaArcDig> getItems() {
        return new ListModelList<>(items);
    }

    public void setItems(List<CategoriaArcDig> items) {
        CategoriaArcDigDao.items = items;
    }

    public List<Anho> getAnhos() {
        return new ListModelList<>(anhos);
    }

    public void setAnhos(List<Anho> anhos) {
        CategoriaArcDigDao.anhos = anhos;
    }

    public CategoriaArcDig getSelected() {
        return selected;
    }

    public void setSelected(CategoriaArcDig selected) {
        this.selected = selected;
    }

    public ArrayList<CategoriaArcDig> listItems() {
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            return (ArrayList) session.selectList("ResolucionObra.getListCategoria");
        } finally {
            session.close();
        }
    }

    public ArrayList<Anho> listAnhos() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return (ArrayList) session.selectList("ResolucionObra.getAnhoArcDig", tidoId);
        } finally {
            session.close();
        }
    }

    @GlobalCommand
    @NotifyChange({"items", "anhos"})
    public void refresh() {
        items = listItems();
        anhos = listAnhos();
    }
    
    @Command
    @NotifyChange({"anhos"})
    public void changeFilterDato(@BindingParam("dato") Integer id) {
        tidoId = id;
        anhos = listAnhos();
    }
    
    
    
}
