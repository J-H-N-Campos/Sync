/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Persistence;

/**
 *
 * @author eduar
 */
public class DaoFactory {
    public static FuncionarioDao newFuncionarioDao(){
        return new FuncionarioDaoHibernate();
    }
    public static UsuarioDao newUsuarioDao(){
        return new UsuarioDaoHibernate();
    }
    public static PaisDao newPaisDao(){
        return new PaisDaoHibernate();
    }
}
