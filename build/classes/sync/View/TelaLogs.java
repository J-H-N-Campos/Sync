/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import Utils.CSVUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import sync.Persistence.LogsDao;

/**
 *
 * @author joao
 */
public class TelaLogs extends javax.swing.JFrame {

    private String fileName;
    private final static Logger logger = Logger.getLogger(TelaLogs.class);

    public TelaLogs() {
        initComponents();
        this.fileName = "src\\logs\\logging.log";
        attTArea();

        getRootPane().setDefaultButton(btnBuscar);
    }

    private void attTArea() {

        boolean filterWarn = this.cBoxWARN.isSelected();
        boolean filterError = this.cBoxERROR.isSelected();
        boolean filterFatal = this.cBoxFATAL.isSelected();
        boolean filterAll = (!filterWarn && !filterError && !filterFatal) || (filterWarn && filterError && filterFatal);

        List<String> tipo = new ArrayList();
        if (!filterAll) {

            if (filterWarn) {
                tipo.add("[WARN ]");
            }
            if (filterError) {
                tipo.add("[ERROR]");
            }
            if (filterFatal) {
                tipo.add("[FATAL]");
            }
        } else {
            tipo.add("[WARN ]");
            tipo.add("[ERROR]");
            tipo.add("[FATAL]");
        }
        Date dataIni = this.dcDataInicial.getDate();
        Date dataFin = this.dcDataFinal.getDate();
        String msg = this.tfdBusca.getText();
        LogsDao dao = new LogsDao();
        this.campoLogs.setText("");
        List<String> linhas = dao.getLinhas(tipo, dataIni, dataFin, msg);
        for (String ln : linhas) {
            this.campoLogs.append(ln + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        botaoFechar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCSVLog = new javax.swing.JButton();
        dcDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dcDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoLogs = new javax.swing.JTextArea();
        cBoxERROR = new javax.swing.JCheckBox();
        cBoxWARN = new javax.swing.JCheckBox();
        cBoxFATAL = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Logs");

        jInternalFrame1.setVisible(true);

        botaoFechar.setBackground(new java.awt.Color(200, 200, 200));
        botaoFechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/close-window-30.png"))); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(200, 200, 200));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/search-30.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCSVLog.setBackground(new java.awt.Color(200, 200, 200));
        btnCSVLog.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCSVLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/exportar-csv-30.png"))); // NOI18N
        btnCSVLog.setText("Exportar para CSV");
        btnCSVLog.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnCSVLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVLogActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setText("Última Data Registrada:");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Data Inicial Registrada:");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setText("Filtro de data:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de Log:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("Busca:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Mensagem:");

        tfdBusca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdBusca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoLogs.setEditable(false);
        campoLogs.setColumns(20);
        campoLogs.setRows(5);
        jScrollPane1.setViewportView(campoLogs);

        cBoxERROR.setText("ERROR");

        cBoxWARN.setText("WARN");

        cBoxFATAL.setText("FATAL");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(cBoxWARN)
                                        .addGap(18, 18, 18)
                                        .addComponent(cBoxERROR)
                                        .addGap(18, 18, 18)
                                        .addComponent(cBoxFATAL))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCSVLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoFechar, btnBuscar, btnCSVLog});

        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cBoxWARN)
                                    .addComponent(cBoxERROR)
                                    .addComponent(cBoxFATAL)))
                            .addComponent(btnCSVLog, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(2, 2, 2)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoFechar, btnBuscar, btnCSVLog});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        this.attTArea();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCSVLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVLogActionPerformed
        //GERANDO ARQUIVO DE LOG
        //PEGAR O PATH PARA SALVAR O ARQUIVO
        String getPathFileChooser = CSVUtils.getDirPath();
        //PEDIR UM NOME PARA O ARQUIVO
        String whatTheUserEntered = JOptionPane.showInputDialog(null,
                "Digite um nome para o arquivo CSV", "Nome do arquivo",
                JOptionPane.INFORMATION_MESSAGE);
        if (whatTheUserEntered == null) {
            System.out.println("The user canceled");
        } else {
            String[] cabecalho = {"Data Hora", "Tipo do Erro", "Local", "Mensagem"};
            String arquivopath = getPathFileChooser + "\\" + whatTheUserEntered + ".csv";
            CSVUtils.writeOneLine(cabecalho, arquivopath);
            //COMEÇA PEGAR AS INFORMAÇÕES DA AREA
            boolean filterWarn = this.cBoxWARN.isSelected();
            boolean filterError = this.cBoxERROR.isSelected();
            boolean filterFatal = this.cBoxFATAL.isSelected();
            boolean filterAll = (!filterWarn && !filterError && !filterFatal) || (filterWarn && filterError && filterFatal);

            List<String> tipo = new ArrayList();
            if (!filterAll) {

                if (filterWarn) {
                    tipo.add("[WARN ]");
                }
                if (filterError) {
                    tipo.add("[ERROR]");
                }
                if (filterFatal) {
                    tipo.add("[FATAL]");
                }
            } else {
                tipo.add("[WARN ]");
                tipo.add("[ERROR]");
                tipo.add("[FATAL]");
            }
            Date dataIni = this.dcDataInicial.getDate();
            Date dataFin = this.dcDataFinal.getDate();
            String msg = this.tfdBusca.getText();
            LogsDao dao = new LogsDao();
            this.campoLogs.setText("");
            List<String> list = dao.getLinhas(tipo, dataIni, dataFin, msg);
            for (String ln : list) {
                String[] linha = ln.split("/");//3 COLUNAS
                CSVUtils.writeOneLine(linha, arquivopath);

            }
            //AVISO
            JOptionPane.showMessageDialog(null, "Arquivo de log gerado em: " + arquivopath,
                    "LOG gerado com sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCSVLogActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCSVLog;
    private javax.swing.JCheckBox cBoxERROR;
    private javax.swing.JCheckBox cBoxFATAL;
    private javax.swing.JCheckBox cBoxWARN;
    private javax.swing.JTextArea campoLogs;
    private com.toedter.calendar.JDateChooser dcDataFinal;
    private com.toedter.calendar.JDateChooser dcDataInicial;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdBusca;
    // End of variables declaration//GEN-END:variables
}
