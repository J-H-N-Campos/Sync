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
import sync.Entidade.Funcao;

/**
 *
 * @author joao
 */
public class TableModelFuncao  implements TableModel{
    
    @Override
    public int getRowCount() {
        Session sessao = null;
        List<Funcao> listaF = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from Funcao");
            listaF = query.list();
          
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        
        return listaF.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String vet[] = new String[3];
        vet[0] = "Id";
        vet[1] = "Especialização";
        vet[2] = "Nível de Permissão";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class vet[] = new Class[3];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = Integer.class;
        
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Session sessao = null;
        List<Funcao> listaF = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Funcao");
            listaF = query.list();
     
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0){
            obj = listaF.get(rowIndex).getId();
        }
        if (columnIndex==1) {
            obj = listaF.get(rowIndex).getEspecializacao();
        }
        if (columnIndex==2) {
            obj = listaF.get(rowIndex).getNivel_permicao();
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