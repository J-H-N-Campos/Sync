/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Persistence;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author joao
 */
public class AuditoriaDao {

    private static final Logger logger = Logger.getLogger(AuditoriaDao.class);
    
    public List<String> getLinhas(Date dataIni, Date dataFin, String msg, String user) {
        List<String> listaLinha = new ArrayList();

        boolean msgIsSet = true;
        boolean userIsSet = true;

        if (dataIni == null) {
            dataIni = new Date(0);
        }
     
        if (dataFin == null) {
            dataFin = new Date();
        }
        
        if (msg.isEmpty()) {
            msgIsSet = false;
        }
        if (user.isEmpty()) {
            userIsSet = false;
        }

        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get("src\\logs\\audit.log"));

        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        for (String lin : list) {
            String[] split = lin.split("/-/");

            boolean verify = true;

            if (!(java.sql.Timestamp.valueOf(split[0].substring(1, split[0].length() - 2)).after(dataIni) && java.sql.Timestamp.valueOf(split[0].substring(1, split[0].length() - 2)).before(dataFin))) {
                verify = false;
            } else if (msgIsSet) {

                if (!msg.equals(split[4].substring(1, msg.length() + 1))) {
                    verify = false;
                }
            } else if (userIsSet) {

                if (!user.equals(split[3].substring(1, user.length() + 1))) {
                    verify = false;
                }
            } else if (!(split[2].substring(1, 5).equals("sync"))){
                verify = false;
            }
            if (verify) {
                listaLinha.add(lin);
            }
        }
        return listaLinha;
    }
}
