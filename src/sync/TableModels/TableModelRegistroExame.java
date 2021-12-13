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
import sync.Entidade.RegistroExame;

/**
 *
 * @author joao
 */
public class TableModelRegistroExame implements TableModel
{  
    @Override
    public int getRowCount() {
        Session sessao = null;
        List<RegistroExame> listaRE = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            Query query = sessao.createQuery("from registroexame");
            listaRE = query.list();
          
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        
        return listaRE.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String vet[] = new String[5];
        vet[0] = "Id";
        vet[1] = "Data de registro";
        vet[2] = "Tipo de exame";
        vet[3] = "Funcionário";
        vet[4] = "Paciente";
        
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class vet[] = new Class[5];
        vet[0] = Integer.class;
        vet[1] = Date.class;
        vet[2] = Integer.class;
        vet[3] = Integer.class;
        vet[4] = Integer.class;
        
        return vet[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Session sessao = null;
        List<RegistroExame> listaRC = null; 
        try {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            
            
            Query query = sessao.createQuery("from registroexame");
            listaRC = query.list();
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        Object obj = null;
        
        if(columnIndex==0){
            obj = listaRC.get(rowIndex).getId();
        }
        if (columnIndex==1) {
            obj = listaRC.get(rowIndex).getDt_registro();
        }
        
        if (columnIndex==2) {
            obj = listaRC.get(rowIndex).getTipo_exame();
        }
        
        if (columnIndex==3) {
            obj = listaRC.get(rowIndex).getFuncionario();
        }
        
        if (columnIndex==4) {
            obj = listaRC.get(rowIndex).getPaciente();
        }
        
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
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