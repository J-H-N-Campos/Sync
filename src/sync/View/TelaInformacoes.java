/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sync.Persistence.AuditoriaDao;
import sync.Persistence.LogsDao;
import sync.Sistema_Sync;

/**
 *
 * @author joao
 */
public class TelaInformacoes extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(TelaInformacoes.class);

    public TelaInformacoes() throws FileNotFoundException {
        initComponents();

//        URL url = this.getClass().getResource("/sync/Assets/combo-chart-45.png");
//        Image icone = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(icone);

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

        JFreeChart criarGrafico1 = null;
        JFreeChart criarGrafico2 = null;
        int nPerm = 0;
        if (Sistema_Sync.get_instance().getLoggedUser().getNivelAcesso() >= 10) {
            nPerm = 10;
        } else if (Sistema_Sync.get_instance().getLoggedUser().getNivelAcesso() >= 9) {
            nPerm = 9;
        } else if (Sistema_Sync.get_instance().getLoggedUser().getNivelAcesso() >= 3) {
            nPerm = 3;
        }
        if (nPerm == 10) {
            criarGrafico1 = ChartFactory.createLineChart("Gráfico auditoria última semana", "Dias", "Quantidade", dataset1, PlotOrientation.VERTICAL, false, false, false);
            criarGrafico2 = ChartFactory.createLineChart("Gráfico logs última semana", "Dias", "Quantidade", dataset2, PlotOrientation.VERTICAL, false, false, false);
            AuditoriaDao audDao = new AuditoriaDao();
            LogsDao logDao = new LogsDao();

            List<String> tipo = new ArrayList();
            tipo.add("[WARN ]");
            tipo.add("[ERROR]");
            tipo.add("[FATAL]");
            List<String> listAud;
            List<String> listLog;

            for (int i = 7; i >= 1; i--) {
                Date data = new Date();
                Date dataIni = new Date(data.getTime() - ((i * 86400) * 1000));
                Date dataFim = new Date(dataIni.getTime() + (86400 * 1000));
                listAud = audDao.getLinhas(dataIni, dataFim, new String(), new String());
                listLog = logDao.getLinhas(tipo, dataIni, dataFim, new String());
                dataset1.addValue(listAud.size(), "Máximo", "A " + i + " dias");
                dataset2.addValue(listLog.size(), "Máximo", "A " + i + " dias");
            }
        } else if (nPerm == 9) {
            criarGrafico1 = ChartFactory.createLineChart("Gráfico atendimentos gerais última semana", "Dias", "Quantidade", dataset1, PlotOrientation.VERTICAL, false, false, false);
            criarGrafico2 = ChartFactory.createLineChart("Gráfico novos pacientes último mês", "Semanas", "Quantidade", dataset2, PlotOrientation.VERTICAL, false, false, false);
            AuditoriaDao audDao = new AuditoriaDao();

            List<String> listAudGeralE;
            List<String> listAudGeralC;
            List<String> listAudPaciente;

            int atendimentosGerais = 0;

            for (int i = 31; i >= 7; i -= 7) {
                atendimentosGerais = 0;
                Date data = new Date();
                Date dataIni = new Date(data.getTime() - ((i * 86400) * 1000));
                Date dataFim = new Date(dataIni.getTime() + ((7 * 86400) * 1000));
                listAudGeralE = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de exame", new String());
                listAudGeralC = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de cirurgia", new String());
                atendimentosGerais = listAudGeralE.size() + listAudGeralC.size();
                listAudPaciente = audDao.getLinhas(dataIni, dataFim, "Cadastro do paciente", new String());
                dataset1.addValue(atendimentosGerais, "Máximo", "A " + 8 + " Semanas");
                dataset2.addValue(listAudPaciente.size(), "Máximo", "A " + 8 + " Semanas");
            }
        } else if (nPerm == 3) {
            try {
                AuditoriaDao audDao = new AuditoriaDao();
                
                criarGrafico1 = ChartFactory.createLineChart("Gráfico atendimentos gerais última semana", "Dias", "Quantidade", dataset1, PlotOrientation.VERTICAL, false, false, false);
                criarGrafico2 = ChartFactory.createLineChart("Gráfico atendimentos de " + Sistema_Sync.get_instance().getLoggedUser().getLogin() + " última semana", "Dias", "Quantidade", dataset2, PlotOrientation.VERTICAL, false, false, false);
                
                List<String> listAudGeralE;
                List<String> listAudGeralC;
                List<String> listAudIndividualE;
                List<String> listAudIndividualC;
                int atendimentosGerais = 0;
                int atendimentosIndividuais = 0;

                for (int i = 7; i >= 1; i--) {
                    atendimentosGerais = 0;
                    atendimentosIndividuais = 0;
                    
                    Date dataIni = new Date((new Date().getTime() - ((i * 86400) * 1000)));
                    Date dataFim = new Date((new Date().getTime() + (86400 * 1000)));
                 
                    
                    listAudGeralE = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de exame", new String());
                    listAudGeralC = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de cirurgia", new String());
                    atendimentosGerais = listAudGeralE.size() + listAudGeralC.size();
                    
                    String user = Sistema_Sync.get_instance().getLoggedUser().getLogin();
                 
                    listAudIndividualE = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de exame", user);
                   
                    listAudIndividualC = audDao.getLinhas(dataIni, dataFim, "Cadastro do registro de cirurgia", user);
                    atendimentosIndividuais = listAudIndividualE.size() + listAudIndividualC.size();
                    dataset1.addValue(atendimentosGerais, "Máximo", "A " + i + " dias");
                    dataset2.addValue(atendimentosIndividuais, "Máximo", "A " + i + " dias");
                    
                }
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage());
            }

        }
        if (nPerm != 0) {
            try {
                OutputStream png1 = new FileOutputStream("src/sync/Assets/grafico" + nPerm + "1.png");
                OutputStream png2 = new FileOutputStream("src/sync/Assets/grafico" + nPerm + "2.png");
                ChartUtilities.writeChartAsPNG(png1, criarGrafico1, 514, 360);
                ChartUtilities.writeChartAsPNG(png2, criarGrafico2, 514, 360);
                png1.close();
                png2.close();
            } catch (IOException io) {
                logger.error(io.getMessage());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                logger.error(ex.getMessage());
            }
            try{
            this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Assets/grafico" + nPerm + "1.png")));
            this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Assets/grafico" + nPerm + "2.png")));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        grfUm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaofechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações");
        setResizable(false);

        jInternalFrame1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.setVisible(true);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("DashBoard");

        grfUm.setBackground(new java.awt.Color(200, 200, 200));
        grfUm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        grfUm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        grfUm.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout grfUmLayout = new javax.swing.GroupLayout(grfUm);
        grfUm.setLayout(grfUmLayout);
        grfUmLayout.setHorizontalGroup(
            grfUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grfUmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        grfUmLayout.setVerticalGroup(
            grfUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grfUmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grfUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaofechar.setBackground(new java.awt.Color(200, 200, 200));
        botaofechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaofechar.setText("Fechar");
        botaofechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaofechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(472, 472, 472))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(grfUm, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(botaofechar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grfUm, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaofechar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaofecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaofecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaofechar;
    private javax.swing.JPanel grfUm;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
