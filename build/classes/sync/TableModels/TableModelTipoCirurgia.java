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
import sync.Entidade.TipoCirurgia;

/**
 *
 * @author joao
 */
public class TableModelTipoCirurgia implements TableModel
{
    @Override
    public int getRowCount()
    {
        Session sessao = null;
        List<TipoCirurgia> listaTC = null; 
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from Tipocirurgia");
            listaTC = query.list();
        }catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        
        return listaTC.size();
    }

    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String vet[] = new String[4];
        vet[0] = "Id";
        vet[1] = "Nome";
        vet[2] = "Duração";
        vet[3] = "Produto";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class vet[] = new Class[4];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = String.class;
        vet[3] = Integer.class;
        
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Session sessao = null;
        List<TipoCirurgia> listaTC = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Query query = sessao.createQuery("from Tipocirurgia");
            listaTC = query.list();
 
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0)
        {
            obj = listaTC.get(rowIndex).getId();
        }
        if (columnIndex==1) 
        {
            obj = listaTC.get(rowIndex).getNome();
        }
        if (columnIndex==2)
        {
            obj = listaTC.get(rowIndex).getDuracao();
        }
        if(columnIndex==3)
        {
            obj = listaTC.get(rowIndex).getProduto();
        }
 
        
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}