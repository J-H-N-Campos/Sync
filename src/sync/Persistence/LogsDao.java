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
 * @author eduar
 */
public class LogsDao {

    private static final Logger logger = Logger.getLogger(LogsDao.class);

    public List<String> getLinhas(List<String> tipo, Date dataIni, Date dataFin, String msg) {

        List<String> listaLinha = new ArrayList();

        if (dataIni == null) {
            dataIni = new Date(0);
        }

        if (dataFin == null) {
            dataFin = new Date();
        }

        boolean msgIsSet = true;
        if (msg.isEmpty()) {
            msgIsSet = false;
        }

        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get("src\\logs\\logging.log"));

        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        for (String lin : list) {
            String[] split = lin.split("/-/");

            boolean verify = true;

            int count = 0;
            for (String s : tipo) {

                if (split[1].equals(s)) {
                    count++;
                }
            }
            if (count == 0) {
                verify = false;
            }
            if (!(java.sql.Timestamp.valueOf(split[0].substring(1, split[0].length() - 2)).after(dataIni) && java.sql.Timestamp.valueOf(split[0].substring(1, split[0].length() - 2)).before(dataFin))) {
                verify = false;
            } else if (msgIsSet) {

                if (!msg.equals(split[3].substring(1, msg.length() + 1))) {
                    verify = false;
                }
            }
            if (verify) {
                listaLinha.add(lin);
            }

        }
        return listaLinha;
    }
}
