/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import Utils.Sessao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author joao
 */
public class TelaMenu extends javax.swing.JFrame
{

    /**
     * Creates new form TelaMenu
     */
    public TelaMenu()
    {
        initComponents();
        
        URL url = this.getClass().getResource("../Assets/Menu.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(icone);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoRelatorios = new javax.swing.JButton();
        botaoLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        painel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        botaoUsuario = new javax.swing.JButton();
        botaoFuncionario = new javax.swing.JButton();
        botaoCidade = new javax.swing.JButton();
        botaoEstado = new javax.swing.JButton();
        botaoPais = new javax.swing.JButton();
        botaoConvenio = new javax.swing.JButton();
        botaoPaciente = new javax.swing.JButton();
        botaoEmail = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(80, 150, 200));
        setName("menu"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(80, 150, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        botaoRelatorios.setBackground(new java.awt.Color(200, 200, 200));
        botaoRelatorios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/reports.png"))); // NOI18N
        botaoRelatorios.setText("Relatórios");
        botaoRelatorios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        botaoLogout.setBackground(new java.awt.Color(200, 200, 200));
        botaoLogout.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/logout.png"))); // NOI18N
        botaoLogout.setText("Logout");
        botaoLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogoutActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLogout)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoLogout, botaoRelatorios});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLogout)
                .addGap(33, 33, 33))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoLogout, botaoRelatorios});

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        desktop.setBackground(new java.awt.Color(200, 200, 200));
        desktop.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        desktop.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        painel4.setBackground(new java.awt.Color(80, 150, 200));
        painel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Opções do Administrador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 1, 14))); // NOI18N
        painel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(200, 200, 200));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/log-45.png"))); // NOI18N
        jButton1.setText("Logs do Sistema");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton2.setBackground(new java.awt.Color(200, 200, 200));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/auditoria-45.png"))); // NOI18N
        jButton2.setText("Auditoria do Sistema");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton3.setBackground(new java.awt.Color(200, 200, 200));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/combo-chart-45.png"))); // NOI18N
        jButton3.setText("Informações do Sistema");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout painel4Layout = new javax.swing.GroupLayout(painel4);
        painel4.setLayout(painel4Layout);
        painel4Layout.setHorizontalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        painel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        painel4Layout.setVerticalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        painel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        botaoUsuario.setBackground(new java.awt.Color(200, 200, 200));
        botaoUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/usuario.png"))); // NOI18N
        botaoUsuario.setText("Cadastro de Usuário");
        botaoUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoUsuarioActionPerformed(evt);
            }
        });

        botaoFuncionario.setBackground(new java.awt.Color(200, 200, 200));
        botaoFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/juridica.png"))); // NOI18N
        botaoFuncionario.setText("Cadastro de Funcionário");
        botaoFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFuncionarioActionPerformed(evt);
            }
        });

        botaoCidade.setBackground(new java.awt.Color(200, 200, 200));
        botaoCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/cidade.png"))); // NOI18N
        botaoCidade.setText("Cadastro de Cidade");
        botaoCidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCidadeActionPerformed(evt);
            }
        });

        botaoEstado.setBackground(new java.awt.Color(200, 200, 200));
        botaoEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/cidade.png"))); // NOI18N
        botaoEstado.setText("Cadastro de Estado");
        botaoEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEstadoActionPerformed(evt);
            }
        });

        botaoPais.setBackground(new java.awt.Color(200, 200, 200));
        botaoPais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/cidade.png"))); // NOI18N
        botaoPais.setText("Cadastro de país");
        botaoPais.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPaisActionPerformed(evt);
            }
        });

        botaoConvenio.setBackground(new java.awt.Color(200, 200, 200));
        botaoConvenio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoConvenio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/product.png"))); // NOI18N
        botaoConvenio.setText("Cadastro de Convênio");
        botaoConvenio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConvenioActionPerformed(evt);
            }
        });

        botaoPaciente.setBackground(new java.awt.Color(200, 200, 200));
        botaoPaciente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/cadastro.png"))); // NOI18N
        botaoPaciente.setText("Cadastro de Paciente");
        botaoPaciente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPacienteActionPerformed(evt);
            }
        });

        botaoEmail.setBackground(new java.awt.Color(200, 200, 200));
        botaoEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/mail-icon-45.png"))); // NOI18N
        botaoEmail.setText("Enviar E-mail");
        botaoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        desktop.setLayer(painel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoFuncionario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoCidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoPais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoConvenio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoPaciente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botaoEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoFuncionario)
                            .addComponent(botaoPaciente)
                            .addComponent(botaoUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoEstado)
                            .addGroup(desktopLayout.createSequentialGroup()
                                .addComponent(botaoPais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoConvenio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoEmail))
                            .addComponent(botaoCidade)))
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktopLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCidade, botaoConvenio, botaoEmail, botaoEstado, botaoFuncionario, botaoPaciente, botaoPais, botaoUsuario});

        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPais)
                    .addComponent(botaoConvenio)
                    .addComponent(botaoEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFuncionario)
                    .addComponent(botaoEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCidade)
                    .addComponent(botaoPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        desktopLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCidade, botaoConvenio, botaoEmail, botaoEstado, botaoFuncionario, botaoPaciente, botaoPais, botaoUsuario});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        jPanel3.setBackground(new java.awt.Color(80, 150, 200));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setText("SYNC");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogoutActionPerformed
        Sessao.getInstance().setUsuario(null);
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_botaoLogoutActionPerformed

    private void botaoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPacienteActionPerformed

    private void botaoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoUsuarioActionPerformed

    private void botaoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPaisActionPerformed
        TelaCadastroPais tela = new TelaCadastroPais();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoPaisActionPerformed

    private void botaoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEstadoActionPerformed
        TelaCadastroEstado tela = new TelaCadastroEstado();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoEstadoActionPerformed

    private void botaoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCidadeActionPerformed
        TelaCadastroCidade tela = new TelaCadastroCidade();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoCidadeActionPerformed

    private void botaoConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConvenioActionPerformed
        TelaCadastroConvenio tela = new TelaCadastroConvenio();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoConvenioActionPerformed

    private void botaoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFuncionarioActionPerformed
        TelaCadastroFunc tela = new TelaCadastroFunc();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCidade;
    private javax.swing.JButton botaoConvenio;
    private javax.swing.JButton botaoEmail;
    private javax.swing.JButton botaoEstado;
    private javax.swing.JButton botaoFuncionario;
    private javax.swing.JButton botaoLogout;
    private javax.swing.JButton botaoPaciente;
    private javax.swing.JButton botaoPais;
    private javax.swing.JButton botaoRelatorios;
    private javax.swing.JButton botaoUsuario;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel painel4;
    // End of variables declaration//GEN-END:variables
}