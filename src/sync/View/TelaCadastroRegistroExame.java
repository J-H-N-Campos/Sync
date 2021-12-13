/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import sync.Utils.DataBaseException;
import sync.Utils.DuplicateKeyException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.apache.log4j.Logger;
import sync.Entidade.Funcionario;
import sync.Entidade.Paciente;
import sync.Entidade.RegistroExame;
import sync.Entidade.TipoExame;
import sync.Persistence.DaoFactory;
import sync.Sistema_Sync;

/**
 *
 * @author joao
 */
public class TelaCadastroRegistroExame extends javax.swing.JFrame {
    
    private List<Paciente> listaP = null;
    private List<Funcionario> listaF = null;
    private List<TipoExame> listaTE = null;
    private final static Logger logger = Logger.getLogger(TelaCadastroRegistroExame.class);
    
    public TelaCadastroRegistroExame() {
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

//tipo de exames
        try {
            listaTE = DaoFactory.newTipoExameDao().readAll();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
        
        this.comboTipoExame.removeAllItems();
        
        for (int i = 0; i < listaTE.size(); i++) {
            this.comboTipoExame.addItem(listaTE.get(i));
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
                List<RegistroExame> lista = null;
                if (!campoPesquisar.getText().isEmpty()) {
                    try {
                        lista = DaoFactory.newRegistroExameDao().read("from RegistroExame as f Where f.tipo_exame =" + campoPesquisar.getText() + "");
                    } catch (DataBaseException ex) {
                        logger.error(ex.getMessage());
                    }
                } else {
                    try {
                        lista = DaoFactory.newRegistroExameDao().readAll();
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
                vet[2] = "Tipo de exame";
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
                List<RegistroExame> listaF = null;
                if (!campoPesquisar.getText().isEmpty()) {
                    try {
                        listaF = DaoFactory.newRegistroExameDao().read("from RegistroExame as f Where f.tipo_exame =" + campoPesquisar.getText() + "");
                    } catch (DataBaseException ex) {
                        logger.error(ex.getMessage());
                    }
                } else {
                    try {
                        listaF = DaoFactory.newRegistroExameDao().readAll();
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
                    obj = listaF.get(rowIndex).getTipo_exame();
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
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                
            }
            
            @Override
            public void addTableModelListener(TableModelListener l) {
                
            }
            
            @Override
            public void removeTableModelListener(TableModelListener l) {
                
            }
        });
    }
    
    private void limpaCampos() {
        this.campo_dt_registro.setDate(new Date());
    }
    
    @SuppressWarnings("unchecked")
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
        comboTipoExame = new javax.swing.JComboBox<>();
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
        setTitle("Registro de Exame");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addGap(46, 46, 46))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        painel3.setBackground(new java.awt.Color(200, 200, 200));

        rotuloIdioma.setBackground(new java.awt.Color(200, 200, 200));
        rotuloIdioma.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloIdioma.setText("Tipo de exame: *");

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

        comboTipoExame.setBackground(new java.awt.Color(240, 240, 240));
        comboTipoExame.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboTipoExame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rotuloIdioma2)
                                    .addComponent(rotuloIdioma)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rotuloIdioma1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoExame, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                        .addContainerGap(1139, Short.MAX_VALUE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campo_dt_registro, comboFuncionario, comboPaciente, comboTipoExame});

        painel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, rotuloIdioma1});

        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloIdioma2)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloIdioma))
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(campo_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(19, 19, 19)))
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rotuloIdioma1))
                        .addContainerGap(91, Short.MAX_VALUE))))
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campo_dt_registro, comboFuncionario, comboPaciente, comboTipoExame});

        painel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, rotuloIdioma, rotuloIdioma1, rotuloIdioma2});

        painel1.addTab("Cadastrar", painel3);

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoPesquisar.setText("1");
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
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
                .addComponent(painel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        
        RegistroExame registroExame = new RegistroExame();
        registroExame.setDt_registro(this.campo_dt_registro.getDate());
        registroExame.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
        registroExame.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
        registroExame.setTipo_exame((TipoExame) this.comboTipoExame.getSelectedItem());
        try {
            
            DaoFactory.newRegistroExameDao().create(registroExame);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            this.atualizarTabela();
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "]/-/[Cadastro do registro de exame \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        } catch (DuplicateKeyException ex) {
            logger.error(ex.getMessage());
        }

    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do registro de exame a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));
        
        RegistroExame registroExame;
        try {
            registroExame = DaoFactory.newRegistroExameDao().read(id);
            registroExame.setDt_registro(this.campo_dt_registro.getDate());
            registroExame.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
            registroExame.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
            registroExame.setTipo_exame((TipoExame) this.comboTipoExame.getSelectedItem());
            DaoFactory.newRegistroExameDao().edit(registroExame);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "]/-/[Edicao do registro de exame \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do registro da cirurgia a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));
        
        RegistroExame registroExame;
        try {
            registroExame = DaoFactory.newRegistroExameDao().read(id);
            registroExame.setDt_registro(this.campo_dt_registro.getDate());
            registroExame.setPaciente((Paciente) this.comboPaciente.getSelectedItem());
            registroExame.setFuncionario((Funcionario) this.comboFuncionario.getSelectedItem());
            registroExame.setTipo_exame((TipoExame) this.comboTipoExame.getSelectedItem());
            DaoFactory.newRegistroExameDao().delete(registroExame);
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "]/-/[Exclusao do registro de exame \"" + this.campo_dt_registro.getDate() + "\" efetuado"); //adicionar o usuário que fez a alteração depois
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
    private javax.swing.JComboBox<TipoExame> comboTipoExame;
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
