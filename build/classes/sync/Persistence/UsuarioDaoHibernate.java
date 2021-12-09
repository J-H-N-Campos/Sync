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
import sync.Entidade.Usuario;

/**
 *
 * @author eduar
 */
public class UsuarioDaoHibernate implements UsuarioDao{

    @Override
    public void create(Usuario entity) throws DataBaseException, DuplicateKeyException {
        
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
    public void edit(Usuario entity) throws DataBaseException {
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
    public void delete(Usuario entity) throws DataBaseException {
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
    public Usuario read(int id) throws DataBaseException {
        Session sessao = null;
        List<Usuario> listaF = null; 
        Usuario func = null;
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Usuario as f Where f.id = "+id+"");
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
    public List<Usuario> read(String query) throws DataBaseException {
        Session sessao = null;
        List<Usuario> listaF = null; 
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
    public List<Usuario> readAll() throws DataBaseException {
        Session sessao = null;
        List<Usuario> listaF = null; 
        try{
            sessao = NewHibernateUtil.getSessionFactory().openSession();

            Query query = sessao.createQuery("from Usuario");
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
