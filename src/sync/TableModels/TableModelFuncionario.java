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
public class TableModelFuncionario implements TableModel{
    
    @Override
    public int getRowCount() {
        Session sessao = null;
        List<Funcionario> listaF = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Funcionario");
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
        return 18;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String vet[] = new String[18];
        vet[0] = "Id";
        vet[1] = "Nome";
        vet[2] = "Sexo";
        vet[3] = "Data de Nascimento";
        vet[4] = "CPF";
        vet[5] = "RG";
        vet[6] = "Telefone";
        vet[7] = "Telefone Opc";
        vet[8] = "email Pessoal";
        vet[9] = "email Empresa";
        vet[10] = "Rua";
        vet[11] = "Número";
        vet[12] = "Complemento";
        vet[13] = "Formação";
        vet[14] = "Tipod e Contrato";
        vet[15] = "Salario Atual";
        vet[16] = "Salario Futuro";
        vet[17] = "Cidade";
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class vet[] = new Class[18];
        vet[0] = Integer.class;
        vet[1] = String.class;
        vet[2] = String.class;
        vet[3] = String.class;
        vet[4] = String.class;
        vet[5] = String.class;
        vet[6] = String.class;
        vet[7] = String.class;
        vet[8] = String.class;
        vet[9] = String.class;
        vet[10] = String.class;
        vet[11] = String.class;
        vet[12] = String.class;
        vet[13] = String.class;
        vet[14] = String.class;
        vet[15] = Double.class;
        vet[16] = Double.class;
        vet[17] = String.class;
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Session sessao = null;
        List<Funcionario> listaF = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from Funcionario");
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
            obj = listaF.get(rowIndex).getNome();
        }
        if (columnIndex==2) {
            obj = listaF.get(rowIndex).getSexo();
        }
        if (columnIndex==3) {
            obj = listaF.get(rowIndex).getDt_nascimento();
        }
        if (columnIndex==4) {
            obj = listaF.get(rowIndex).getCpf();
        }
        if (columnIndex==5) {
            obj = listaF.get(rowIndex).getRg();
        }
        if (columnIndex==6) {
            obj = listaF.get(rowIndex).getTelefone();
        }
        if (columnIndex==7) {
            obj = listaF.get(rowIndex).getTelefone_opc();
        }
        if (columnIndex==8) {
            obj = listaF.get(rowIndex).getEmail_pessoal();
        }
        if (columnIndex==9) {
            obj = listaF.get(rowIndex).getEmail_empresa();
        }
        if (columnIndex==10) {
            obj = listaF.get(rowIndex).getRua();
        }
        if (columnIndex==11) {
            obj = listaF.get(rowIndex).getNumero();
        }
        if (columnIndex==12) {
            obj = listaF.get(rowIndex).getComplemento();
        }
        if (columnIndex==13) {
            obj = listaF.get(rowIndex).getFormacao();
        }
        if (columnIndex==14) {
            obj = listaF.get(rowIndex).getTipo_contrato();
        }
        if (columnIndex==15) {
            obj = listaF.get(rowIndex).getSalario_atual();
        }
        if (columnIndex==16) {
            obj = listaF.get(rowIndex).getSalario_futuro();
        }
        if (columnIndex==17) {
            obj = listaF.get(rowIndex).getCidade();
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
