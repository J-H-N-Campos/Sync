/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.Logger;

/**
 *
 * @author mouri
 */
public class ReportManager {

    private final static Logger logger = Logger.getLogger(ReportManager.class);
    private Connection dbConnection;

    public ReportManager(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    public ReportManager()
    {
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sync","postgres","postgres");
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }
    
    public void setDataBaseConnection(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    public void createReport(Report report) {
        try {
            // Compilar o relatório do formato XML gerando um objeto JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream(report.getPath()));
            // Gera o relatório efetivamente
            JasperPrint print;

            print = JasperFillManager.fillReport(jasperReport, report.getParameters(), this.dbConnection);

            // Exibir o relatório
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            logger.error(ex.getMessage());
        }
    }

}
