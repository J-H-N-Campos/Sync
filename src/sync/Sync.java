/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync;

import org.apache.log4j.PropertyConfigurator;
import sync.Entidade.Funcionario;
import sync.View.TelaMenu;

/**
 *
 * @author eduar
 */
public class Sync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        PropertyConfigurator.configure("log4j.properties");
//        TelaMenu tela = new TelaMenu();
//        tela.setVisible(true);
        Sistema_Sync sistema = Sistema_Sync.get_instance();
        sistema.start();
    }
    
}
