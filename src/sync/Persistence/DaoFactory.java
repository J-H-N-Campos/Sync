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
    public static CidadeDao newCidadeDao(){
        return new CidadeDaoHibernate();
    }
    public static ConvenioDao newConvenioDao(){
        return new ConvenioDaoHibernate();
    }
    public static EstadoDao newEstadoDao(){
        return new EstadoDaoHibernate();
    }
    public static FuncaoDao newFuncaoDao(){
        return new FuncaoDaoHibernate();
    }
    public static FuncionarioDao newFuncionarioDao(){
        return new FuncionarioDaoHibernate();
    }
    public static LeitoDao newLeitoDao(){
        return new LeitoDaoHibernate();
    }
    public static PacienteDao newPacienteDao(){
        return new PacienteDaoHibernate();
    }
    public static PaisDao newPaisDao(){
        return new PaisDaoHibernate();
    }
    public static ProdutoDao newProdutoDao(){
        return new ProdutoDaoHibernate();
    }
    public static RegistroCirurgiaDao newRegistroCirurgiaDao(){
        return new RegistroCirurgiaDaoHibernate();
    }
    public static RegistroExameDao newRegistroExameDao(){
        return new RegistroExameDaoHibernate();
    }
    public static RegistroLotacaoDao newRegistroLotacaoDao(){
        return new RegistroLotacaoDaoHibernate();
    }
    public static TipoCirurgiaDao newTipoCirurgiaDao(){
        return new TipoCirurgiaDaoHibernate();
    }
    public static TipoExameDao newTipoExameDao(){
        return new TipoExameDaoHibernate();
    }
    public static UsuarioDao newUsuarioDao(){
        return new UsuarioDaoHibernate();
    }
    
}
