/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Persistence;

import sync.Utils.DataBaseException;
import sync.Utils.DuplicateKeyException;

import sync.Utils.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sync.Entidade.Funcionario;
import sync.Entidade.Produto;

/**
 *
 * @author eduar
 */
public class ProdutoDaoHibernate implements ProdutoDao{

    @Override
    public void create(Produto entity) throws DataBaseException, DuplicateKeyException {
        
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
    public void edit(Produto entity) throws DataBaseException {
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
    public void delete(Produto entity) throws DataBaseException {
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
    public Produto read(int id) throws DataBaseException {
        Session sessao = null;
        List<Produto> listaF = null; 
        Produto func = null;
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Produto as f Where f.id = "+id+"");
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
    public List<Produto> read(String query) throws DataBaseException {
        Session sessao = null;
        List<Produto> listaF = null; 
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
    public List<Produto> readAll() throws DataBaseException {
        Session sessao = null;
        List<Produto> listaF = null; 
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Produto");
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
