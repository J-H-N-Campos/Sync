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
import sync.Entidade.Usuario;

/**
 *
 * @author joao
*/
public class TableModelUsuario implements TableModel
{
    @Override
    public int getRowCount()
    {
        Session sessao = null;
        List<Usuario> listaU = null; 
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from Usuario");
            listaU = query.list();
        }catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        
        return listaU.size();
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
        vet[2] = "Senha";
        vet[3] = "Funcionário";
        
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
        List<Usuario> listaU = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Query query = sessao.createQuery("from Usuario");
            listaU = query.list();
 
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0)
        {
            obj = listaU.get(rowIndex).getId();
        }
        if (columnIndex==1) 
        {
            obj = listaU.get(rowIndex).getLogin();
        }
        if (columnIndex==2)
        {
            obj = listaU.get(rowIndex).getPassword();
        }
        if(columnIndex==3)
        {
            obj = listaU.get(rowIndex).getFuncionario();
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