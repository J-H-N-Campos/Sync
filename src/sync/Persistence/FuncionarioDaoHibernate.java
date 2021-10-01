/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Persistence;

import Utils.DataBaseException;
import Utils.DuplicateKeyException;

import Utils.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sync.Entidade.Funcionario;

/**
 *
 * @author eduar
 */
public class FuncionarioDaoHibernate implements FuncionarioDao{

    @Override
    public void create(Funcionario entity) throws DataBaseException, DuplicateKeyException {
        
        Session sessao = null;
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(entity);
            transacao.commit();
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
        
        
    }

    @Override
    public void edit(Funcionario entity) throws DataBaseException {
        Session sessao = null;
        try{
        sessao = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(entity);
        transacao.commit();
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
    }

    @Override
    public void delete(Funcionario entity) throws DataBaseException {
        Session sessao = null;
        try{
        sessao = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(entity);
        transacao.commit();
        }catch(HibernateException hibEx){
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
    }

    @Override
    public Funcionario read(int id) throws DataBaseException {
        Session sessao = null;
        List<Funcionario> listaF = null; 
        Funcionario func = null;
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Funcionario as f Where f.id = "+id+"");
            listaF = query.list();
            if(listaF.size()>0){
                func = listaF.get(0);
            }
        }catch (HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
        return func;
    }

    @Override
    public List<Funcionario> read(String query) throws DataBaseException {
        Session sessao = null;
        List<Funcionario> listaF = null; 
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query q = sessao.createQuery(query);
            listaF = q.list();

        }catch (HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }
        return listaF;
    }

    @Override
    public List<Funcionario> readAll() throws DataBaseException {
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
        return listaF;
    }

    
    
}
