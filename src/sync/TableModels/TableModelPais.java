/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.TableModels;

import Utils.NewHibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sync.Entidade.Funcionario;
import sync.Entidade.Pais;

/**
 *
 * @author eduar
 */
public class TableModelPais implements TableModel{
    
    @Override
    public int getRowCount() {
        Session sessao = null;
        List<Pais> listaP = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Pais");
            listaP = query.list();
            
            
          
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        
        return listaP.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String vet[] = new String[3];
        vet[0] = "Id";
        vet[1] = "Nome";
        vet[2] = "Idioma";
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class vet[] = new Class[3];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = String.class;
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Session sessao = null;
        List<Pais> listaP = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Pais");
            listaP = query.list();
            
            
          
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0){
            obj = listaP.get(rowIndex).getId();
        }
        if (columnIndex==1) {
            obj = listaP.get(rowIndex).getNome();
        }
        if (columnIndex==2) {
            obj = listaP.get(rowIndex).getIdioma();
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
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
