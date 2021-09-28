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
import sync.Entidade.Funcionario;

/**
 *
 * @author eduar
 */
public class TableModelFuncionario implements TableModel{
    
    @Override
    public int getRowCount()
    {
        Session sessao = null;
        List<Funcionario> listaF = null; 
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Funcionario");
            listaF = query.list();

        }catch (HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
        
        return listaF.size();
    }

    @Override
    public int getColumnCount()
    {
        return 11;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String vet[] = new String[12];
        vet[0] = "Id";
        vet[1] = "Nome";
        vet[2] = "Sexo";
        vet[3] = "Data de Nascimento";
        vet[4] = "CPF";
        vet[5] = "Telefone";
        vet[6] = "email";
        vet[7] = "Formação";
        vet[8] = "Tipo de Contrato";
        vet[9] = "Salario";
        vet[10] = "Endereço";
        vet[11] = "Cidade";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) 
    {
        Class vet[] = new Class[12];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = String.class;
        vet[3] = Date.class;
        vet[4] = String.class;
        vet[5] = String.class;
        vet[6] = String.class;
        vet[7] = String.class;
        vet[8] = String.class;
        vet[9] = Double.class;
        vet[10] = String.class;
        vet[11] = Integer.class;
        
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
        List<Funcionario> listaF = null; 
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from Funcionario");
            listaF = query.list();

        }catch (HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0)
        {
            obj = listaF.get(rowIndex).getId();
        }
        if(columnIndex==1) 
        {
            obj = listaF.get(rowIndex).getNome();
        }
        if(columnIndex==2) 
        {
            obj = listaF.get(rowIndex).getSexo();
        }
        if(columnIndex==3) 
        {
            obj = listaF.get(rowIndex).getDt_nascimento();
        }
        if(columnIndex==4) 
        {
            obj = listaF.get(rowIndex).getCpf();
        }
        if(columnIndex==5) 
        {
            obj = listaF.get(rowIndex).getTelefone();
        }
     
        if(columnIndex==6)
        {
            obj = listaF.get(rowIndex).getEmail();
        }
        
        if(columnIndex==7)
        {
            obj = listaF.get(rowIndex).getFormacao();
        }
        
        if(columnIndex==8)
        {
            obj = listaF.get(rowIndex).getTipoContrato();
        }
        
        if(columnIndex==9)
        {
            obj = listaF.get(rowIndex).getSalario();
        }
        
        if(columnIndex==10)
        {
            obj = listaF.get(rowIndex).getEndereco();
        }
        
        if (columnIndex==11)
        {
            obj = listaF.get(rowIndex).getCidade();
        }
        
        return obj;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        
    }
}