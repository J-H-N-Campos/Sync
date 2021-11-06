/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.TableModels;

import Utils.NewHibernateUtil;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sync.Entidade.TipoExame;

/**
 *
 * @author joao
 */
public class TabelModelTipoExame implements TableModel{
    
    @Override
    public int getRowCount() {
        Session sessao = null;
        List<TipoExame> listaTE = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from tipoexame");
            listaTE = query.list();
          
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        
        return listaTE.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String vet[] = new String[2];
        vet[0] = "Id";
        vet[1] = "Nome";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class vet[] = new Class[2];
        vet[0] = Integer.class;
        vet[1] = String.class;
        
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Session sessao = null;
        List<TipoExame> listaTE = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Tipoexame");
            listaTE = query.list();
            
            
          
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0){
            obj = listaTE.get(rowIndex).getId();
        }
        if (columnIndex==1) {
            obj = listaTE.get(rowIndex).getNome();
        }
        
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
        
    }
}