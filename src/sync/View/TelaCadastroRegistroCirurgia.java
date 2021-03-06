/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import sync.Utils.DataBaseException;
import sync.Utils.DuplicateKeyException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.apache.log4j.Logger;
import sync.Entidade.Funcionario;
import sync.Entidade.Paciente;
import sync.Entidade.RegistroCirurgia;
import sync.Entidade.TipoCirurgia;
import sync.Persistence.DaoFactory;
import sync.Sistema_Sync;

/**
 *
 * @author joao
 */
public class TelaCadastroRegistroCirurgia extends javax.swing.JFrame {

    private List<Paciente> listaP = null;
    private List<Funcionario> listaF = null;
    private List<TipoCirurgia> listaIC = null;
    private final static Logger logger = Logger.getLogger(TelaCadastroRegistroCirurgia.class);
    
    public TelaCadastroRegistroCirurgia()
    {
        initComponents();
//        URL url = this.getClass().getResource("/sync/Assets/checked.png");
//        Image icone = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(icone);

        this.limpaCampos();

//pacientes
        try {
            listaP = DaoFactory.newPacienteDao().readAll();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }

        this.comboPaciente.removeAllItems();

        for (int i = 0; i < listaP.size(); i++) {
            this.comboPaciente.addItem(listaP.get(i));
        }
        
//tipo de cirurgias
        try {
            listaIC = DaoFactory.newTipoCirurgiaDao().readAll();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
        
        this.comboTipoCirurgia.removeAllItems();

        for (int i = 0; i < listaIC.size(); i++) {
            this.comboTipoCirurgia.addItem(listaIC.get(i));
        }
        

//funcionários
        try {
            listaF = DaoFactory.newFuncionarioDao().readAll();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
        this.comboFuncionario.removeAllItems();
        for (int i = 0; i < listaF.size(); i++) {
            this.comboFuncionario.addItem(listaF.get(i));
        }

        this.atualizarTabela();
    }

    private void atualizarTabela() {
        this.tabela.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                List<RegistroCirurgia> lista = null;
                if (!campoPesquisar.getText().isEmpty()) {
                    try {
                    lista = DaoFactory.newRegistroCirurgiaDao().read("FROM RegistroCirurgia As rc Where rc.tipo_cirurgia =" + campoPesquisar.getText()+"");
                } catch (DataBaseException ex) {
                    logger.error(ex.getMessage());
                }
                }else{
                    try {
                    lista = DaoFactory.newRegistroCirurgiaDao().readAll();
                } catch (DataBaseException ex) {
                    logger.error(ex.getMessage());
                }
                }
                
                return lista.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public String getColumnName(int columnIndex) {
                String vet[] = new String[5];
                vet[0] = "Id";
                vet[1] = "Data de registro";
                vet[2] = "Tipo de cirurgia";
                vet[3] = "Paciente";
                vet[4] = "Funcionário";

                return vet[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                Class vet[] = new Class[5];
                vet[0] = Integer.class;
                vet[1] = Date.class;
                vet[2] = Integer.class;
                vet[3] = Integer.class;
                vet[4] = Integer.class;

                return vet[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                List<RegistroCirurgia> listaF = null;
                if (!campoPesquisar.getText().isEmpty()) {
                    try {
                    listaF = DaoFactory.newRegistroCirurgiaDao().read("from RegistroCirurgia as f Where f.tipo_cirurgia =" + campoPesquisar.getText() + "");
                } catch (DataBaseException ex) {
                    logger.error(ex.getMessage());
                }
                }else{
                    try {
                    listaF = DaoFactory.newRegistroCirurgiaDao().readAll();
                } catch (DataBaseException ex) {
                    logger.error(ex.getMessage());
                }
                }
                

                Object obj = null;

                if (columnIndex == 0) {
                    obj = listaF.get(rowIndex).getId();
                }
                if (columnIndex == 1) {
                    obj = listaF.get(rowIndex).getDt_registro();
                }
                if (columnIndex == 2) {
                    obj = listaF.get(rowIndex).getTipoCirurgia();
                }
                if (columnIndex == 3) {
                    obj = listaF.get(rowIndex).getPaciente();
                }
                if (columnIndex == 4) {
                    obj = listaF.get(rowIndex).getFuncionario();
                }

                return obj;
            }

            @Override
            public void setValueAt(Object o, int i, int i1) {

            }

            @Override
            public void addTableModelListener(TableModelListener tl) {

            }

            @Override
            public void removeTableModelListener(TableModelListener tl) {

            }
        });
    }

    private void limpaCampos() {
        this.campo_dt_registro.setDate(new Date());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        painel = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        painel1 = new javax.swing.JTabbedPane();
        painel3 = new javax.swing.JPanel();
        rotuloIdioma = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        comboTipoCirurgia = new javax.swing.JComboBox<>();
        campo_dt_registro = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        comboFuncionario = new javax.swing.JComboBox<>();
        rotuloIdioma1 = new javax.swing.JLabel();
        rotuloIdioma2 = new javax.swing.JLabel();
        comboPaciente = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisar = new javax.swing.JTextField();
        rotuloPesquisar = new javax.swing.JLabel();
        botaoPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Cirurgia");
        setResizable(false);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.setVisible(true);

        painel.setBackground(new java.awt.Color(200, 200, 200));
        painel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        botaoCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/cancel-30.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

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

        tabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        painelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addGap(46, 46, 46))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        painel3.setBackground(new java.awt.Color(200, 200, 200));

        rotuloIdioma.setBackground(new java.awt.Color(200, 200, 200));
        rotuloIdioma.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloIdioma.setText("Tipo de cirurgia: *");

        botaoSalvar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/save-30.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoEditar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/edit-30.png"))); // NOI18N
        botaoEditar.setText("Editar");
        botaoEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoExcluir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/delete-30.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        comboTipoCirurgia.setBackground(new java.awt.Color(240, 240, 240));
        comboTipoCirurgia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboTipoCirurgia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campo_dt_registro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        campo_dt_registro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setText("Data de registro: *");

        comboFuncionario.setBackground(new java.awt.Color(240, 240, 240));
        comboFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        rotuloIdioma1.setBackground(new java.awt.Color(200, 200, 200));
        rotuloIdioma1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloIdioma1.setText("Funcionários: *");

        rotuloIdioma2.setBackground(new java.awt.Color(200, 200, 200));
        rotuloIdioma2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloIdioma2.setText("Pacientes: *");

        comboPaciente.setBackground(new java.awt.Color(240, 240, 240));
        comboPaciente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboPaciente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout painel3Layout = new javax.swing.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rotuloIdioma2)
                                .addComponent(rotuloIdioma)))
                        .addGap(18, 18, 18)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoCirurgia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(rotuloIdioma1)
                        .addGap(18, 18, 18)
                        .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campo_dt_registro, comboFuncionario, comboPaciente, comboTipoCirurgia});

        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloIdioma2)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(rotuloIdioma))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(15, 15, 15)))
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(rotuloIdioma1))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campo_dt_registro, comboFuncionario, comboPaciente, comboTipoCirurgia});

        painel1.addTab("Cadastrar", painel3);

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisarActionPerformed(evt);
            }
        });

        rotuloPesquisar.setBackground(new java.awt.Color(200, 200, 200));
        rotuloPesquisar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloPesquisar.setText("Pesquisar: *");

        botaoPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/search-30.png"))); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        painel1.addTab("Consultar", jPanel1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (painel1.getSelectedIndex() == 0) {
            limpaCampos();
        } else {
            painel1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        RegistroCirurgia registroCirurgia = new RegistroCirurgia();
        registroCirurgia.setDt_registro(this.campo_dt_registro.getDate());
        registroCirurgia.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
        registroCirurgia.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
        registroCirurgia.setTipoCirurgia((TipoCirurgia) this.comboTipoCirurgia.getSelectedItem());
        try{
            
            DaoFactory.newRegistroCirurgiaDao().create(registroCirurgia);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            this.atualizarTabela();
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Cadastro do registro da cirurgia \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
            } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        } catch (DuplicateKeyException ex) {
            logger.error(ex.getMessage());
        }
        
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do registro da cirurgia a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

        RegistroCirurgia registroCirurgia;
        try {
            registroCirurgia = DaoFactory.newRegistroCirurgiaDao().read(id);
            registroCirurgia.setDt_registro(this.campo_dt_registro.getDate());
            registroCirurgia.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
            registroCirurgia.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
            registroCirurgia.setTipoCirurgia((TipoCirurgia) this.comboTipoCirurgia.getSelectedItem());
            DaoFactory.newRegistroCirurgiaDao().edit(registroCirurgia);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Edicao do registro da cirurgia \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do registro da cirurgia a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

        RegistroCirurgia registroCirurgia;
        try {
            registroCirurgia = DaoFactory.newRegistroCirurgiaDao().read(id);
            registroCirurgia.setDt_registro(this.campo_dt_registro.getDate());
            registroCirurgia.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
            registroCirurgia.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
            registroCirurgia.setTipoCirurgia((TipoCirurgia) this.comboTipoCirurgia.getSelectedItem());
            DaoFactory.newRegistroCirurgiaDao().delete(registroCirurgia);
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Exclusao do registro de cirurgia \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void campoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisarActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        this.atualizarTabela();
    }//GEN-LAST:event_botaoPesquisarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoPesquisar;
    private com.toedter.calendar.JDateChooser campo_dt_registro;
    private javax.swing.JComboBox<Funcionario> comboFuncionario;
    private javax.swing.JComboBox<Paciente> comboPaciente;
    private javax.swing.JComboBox<TipoCirurgia> comboTipoCirurgia;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTabbedPane painel1;
    private javax.swing.JPanel painel3;
    private javax.swing.JLabel rotuloIdioma;
    private javax.swing.JLabel rotuloIdioma1;
    private javax.swing.JLabel rotuloIdioma2;
    private javax.swing.JLabel rotuloPesquisar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
