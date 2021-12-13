/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync;

import java.io.IOException;
import sync.Utils.Application;
import sync.Utils.ApplicationProcess;
import sync.Utils.Authenticator;
import sync.Utils.DataBaseConnectionManager;
import sync.Utils.DataBaseException;
import sync.Utils.DuplicateKeyException;
import sync.Utils.Encriptation;
import sync.Utils.FatalSystemException;

import sync.Utils.GenericUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import sync.Entidade.Funcao;
import sync.Entidade.Funcionario;
import sync.Entidade.Usuario;
import sync.Persistence.DaoFactory;
import sync.View.TelaMenu;

/**
 *
 * @author eduar
 */
public class Sistema_Sync extends Application {

    private static final Logger logger = Logger.getLogger(Sistema_Sync.class);
    private static Sistema_Sync sistema = new Sistema_Sync();

    DataBaseConnectionManager conn;

    public static Sistema_Sync get_instance() {
        return Sistema_Sync_Holder.INSTANCE;
    }

    private static class Sistema_Sync_Holder {

        private static final Sistema_Sync INSTANCE = new Sistema_Sync();
    }

    private Sistema_Sync() {
        super("Sync", "sync");
    }

    @Override
    public void defineFirstExecutionProcesses() {
        
        this.addFirstExecutionProcess(new ApplicationProcess("Criando administrador do sistema") {
            @Override
            public void run() throws FatalSystemException {
                Funcao funcao = new Funcao();
                funcao.setEspecializacao("Administrador do sistema");
                funcao.setNivel_permicao(10);
                Funcionario funcionario = new Funcionario();
                funcionario.setNome("admin");
                List<Funcao> lf = new ArrayList();
                lf.add(funcao);
                funcionario.setFuncoes(lf);
                Usuario user = new Usuario();
                user.setFuncionario(funcionario);
                user.setNome("admin");
                user.setSenha(Encriptation.criptografar("admin"));
                try {
                    DaoFactory.newFuncaoDao().create(funcao);
                    DaoFactory.newFuncionarioDao().create(funcionario);
                    DaoFactory.newUsuarioDao().create(user);
                } catch (DataBaseException | DuplicateKeyException ex) {
                    java.util.logging.Logger.getLogger(Sistema_Sync.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    @Override
    public void defineInitialProcesses() {
   
        this.addInitialProcess(new ApplicationProcess("Requisitando Login...") {
            @Override
            public void run() throws FatalSystemException {

                List<GenericUser> usuarios = new ArrayList();
                try {
                    List<Usuario> users = DaoFactory.newUsuarioDao().readAll();

                    for (Usuario user : users) {

                        usuarios.add(user);
                    }
                    Authenticator auth = new Authenticator(usuarios);

                    auth.runAuthentication();

                    if (auth.getLoggedUser() == null) {
                        throw new FatalSystemException("Processo de autenticação cancelado");
                    }

                    // setar o usuário logado na aplicação
                    setLoggedUser(auth.getLoggedUser());

                } catch (DataBaseException ex) {
                    logger.fatal(ex.getMessage());
                }

            }

        });
        this.addInitialProcess(new ApplicationProcess("Abrindo a tela principal do sistema...") {
            @Override
            public void run() throws FatalSystemException {
                TelaMenu t = new TelaMenu();
                t.setVisible(true);
            }
        });
        //...

    }

    @Override
    public void defineFinalProcesses() {
        
        this.addFinalProcess(new ApplicationProcess("Fazendo Backup..."){
            @Override
            public void run() throws FatalSystemException {
                
            }
        });
        
        this.addFinalProcess(new ApplicationProcess("Encerrando o sistema...") {
            @Override
            public void run() throws FatalSystemException {
                System.exit(0);
            }
        });
    }

}
