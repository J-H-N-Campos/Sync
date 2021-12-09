/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.TableModels;

import Utils.NewHibernateUtil;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sync.Entidade.Paciente;

/**
 *
 * @author joao
 */
public class TableModelPaciente implements TableModel
{
    @Override
    public int getRowCount()
    {
        Session sessao = null;
        List<Paciente> listaP = null; 
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from Paciente");
            listaP = query.list();
        }catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        
        return listaP.size();
    }

    @Override
    public int getColumnCount()
    {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String vet[] = new String[9];
        vet[0] = "Id";
        vet[1] = "Nome";
        vet[2] = "Data Nascimento";
        vet[3] = "Sexo";
        vet[4] = "CPF";
        vet[5] = "Endereço";
        vet[6] = "E-mail";
        vet[7] = "Telefone";
        vet[8] = "Cidade";
        vet[9] = "Convenio";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class vet[] = new Class[9];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = Date.class;
        vet[3] = String.class;
        vet[4] = String.class;
        vet[5] = String.class;
        vet[6] = String.class;
        vet[7] = String.class;
        vet[8] = Integer.class;
        vet[9] = Integer.class;
        
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
        List<Paciente> listaP = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Query query = sessao.createQuery("from Paciente");
            listaP = query.list();
 
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally{
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0)
        {
            obj = listaP.get(rowIndex).getId();
        }
        if (columnIndex==1) 
        {
            obj = listaP.get(rowIndex).getNome();
        }
        if (columnIndex==2)
        {
            obj = listaP.get(rowIndex).getDtNascimento();
        }
        if(columnIndex==3)
        {
            obj = listaP.get(rowIndex).getSexo();
        }
        if (columnIndex==4) 
        {
            obj = listaP.get(rowIndex).getCPF();
        }
        if (columnIndex==5)
        {
            obj = listaP.get(rowIndex).getEndereco();
        }
        if(columnIndex==6)
        {
            obj = listaP.get(rowIndex).getEmail();
        }
        if (columnIndex==7) 
        {
            obj = listaP.get(rowIndex).getTelefone();
        }
        if (columnIndex==8)
        {
            obj = listaP.get(rowIndex).getCidade();
        }
        if (columnIndex==9)
        {
            obj = listaP.get(rowIndex).getConvenio();
        }
        
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
        
    }
}