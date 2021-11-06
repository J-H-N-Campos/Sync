/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync;


import Utils.Application;
import Utils.ApplicationProcess;
import Utils.Authenticator;
import Utils.DataBaseConnectionManager;
import Utils.DataBaseException;
import Utils.FatalSystemException;

import Utils.GenericUser;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sync.Entidade.Usuario;
import sync.Persistence.DaoFactory;
import sync.View.TelaMenu;


/**
 *
 * @author eduar
 */
public class Sistema_Sync extends Application{

    private static final Logger logger = Logger.getLogger(Sistema_Sync.class);
    private static Sistema_Sync sistema = new Sistema_Sync();
    
    DataBaseConnectionManager conn;
    
    public static Sistema_Sync get_instance(){
        return Sistema_Sync_Holder.INSTANCE;
    }
    
    private static class Sistema_Sync_Holder {

        private static final Sistema_Sync INSTANCE = new Sistema_Sync();
    }
    
    private Sistema_Sync(){
        super("Sync","sync");
    }
    
    @Override
    public void defineFirstExecutionProcesses() {
        
        //criar "hibernate.cfg.xml" no pacote default
        //criar "persistence.xml" no pacote META-INF
        //criar o esquema do banco de dados
        //criar 1 usuario admin
        //...
        
//        this.addFirstExecutionProcess(new ApplicationProcess("Criar/Criando..."){
//            @Override
//            public void run() throws FatalSystemException {
//                
//            }
//            
//        });


        
    }

    @Override
    public void defineInitialProcesses() {
        
        //requsitar login
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
        
        
        
        this.addInitialProcess(new ApplicationProcess("Acessando o arquivo de configuração de propriedades do log4j"){
            @Override
            public void run() throws FatalSystemException {
                PropertyConfigurator.configure("log4j.properties");
            }
            
        });
        
    }

    @Override
    public void defineFinalProcesses() {
        this.addFinalProcess(new ApplicationProcess("Encerrando o sistema") {
            @Override
            public void run() throws FatalSystemException {
                System.exit(0);
            }
        });
    }

    
   
    
}
