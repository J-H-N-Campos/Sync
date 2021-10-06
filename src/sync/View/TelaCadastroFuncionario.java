/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import Utils.DataBaseException;
import Utils.DuplicateKeyException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.apache.log4j.Logger;
import sync.Entidade.Cidade;
import sync.Entidade.Funcao;
import sync.Entidade.Funcionario;
import sync.Persistence.DaoFactory;
import sync.Sistema_Sync;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author joao
 */
public class TelaCadastroFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroFuncionario
     */
    private List<Cidade> listaC = null;
    private List<Funcao> listaF = null;
    private final static Logger logger = Logger.getLogger(TelaCadastroFuncionario.class);

    public TelaCadastroFuncionario() {
        initComponents();
        URL url = this.getClass().getResource("../Assets/juridica.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(icone);

        this.limpaCampos();

//cidades
        try {
            listaC = DaoFactory.newCidadeDao().readAll();
        } catch (DataBaseException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.comboCidade.removeAllItems();

        for (int i = 0; i < listaC.size(); i++) {
            this.comboCidade.addItem(listaC.get(i));
        }

//funcoes
        try {
            listaF = DaoFactory.newFuncaoDao().readAll();
        } catch (DataBaseException ex) {
            java.util.logging.Logger.getLogger(TesteDinamico.class.getName()).log(Level.SEVERE, null, ex);
        }
        initingComponents();

        this.atualizarTabela();

//        this.jCheckBox1.
//        this.buttonGroupFuncao.add(jCheckBox1);
//        this.buttonGroupFuncao.get
    }

    private void atualizarTabela() {
        this.tabela.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                List<Funcionario> lista = null;
                try {
                    lista = DaoFactory.newFuncionarioDao().read("from Funcionario as f Where f.nome LIKE '%" + campoPesquisar.getText() + "%'");
                } catch (DataBaseException ex) {
                    java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lista.size();
            }

            @Override
            public int getColumnCount() {
                return 12;
            }

            @Override
            public String getColumnName(int columnIndex) {
                String vet[] = new String[12];
                vet[0] = "Id";
                vet[1] = "Nome";
                vet[2] = "Sexo";
                vet[3] = "Data de Nascimento";
                vet[4] = "CPF";
                vet[5] = "Telefone";
                vet[6] = "email";
                vet[7] = "Formação";
                vet[8] = "Tipo de Contrato";
                vet[9] = "Salario";
                vet[10] = "Endereço";
                vet[11] = "Cidade";

                return vet[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                Class vet[] = new Class[12];
                vet[0] = Integer.class;
                vet[1] = String.class;
                vet[2] = String.class;
                vet[3] = Date.class;
                vet[4] = String.class;
                vet[5] = String.class;
                vet[6] = String.class;
                vet[7] = String.class;
                vet[8] = String.class;
                vet[9] = Double.class;
                vet[10] = String.class;
                vet[11] = String.class;

                return vet[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                List<Funcionario> listaF = null;
                try {
                    listaF = DaoFactory.newFuncionarioDao().read("from Funcionario as f Where f.nome LIKE '%" + campoPesquisar.getText() + "%'");
                } catch (DataBaseException ex) {
                    java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                Object obj = null;

                if (columnIndex == 0) {
                    obj = listaF.get(rowIndex).getId();
                }
                if (columnIndex == 1) {
                    obj = listaF.get(rowIndex).getNome();
                }
                if (columnIndex == 2) {
                    obj = listaF.get(rowIndex).getSexo();
                }
                if (columnIndex == 3) {
                    obj = listaF.get(rowIndex).getDt_nascimento();
                }
                if (columnIndex == 4) {
                    obj = listaF.get(rowIndex).getCpf();
                }
                if (columnIndex == 5) {
                    obj = listaF.get(rowIndex).getTelefone();
                }

                if (columnIndex == 6) {
                    obj = listaF.get(rowIndex).getEmail();
                }

                if (columnIndex == 7) {
                    obj = listaF.get(rowIndex).getFormacao();
                }

                if (columnIndex == 8) {
                    obj = listaF.get(rowIndex).getTipoContrato();
                }

                if (columnIndex == 9) {
                    obj = listaF.get(rowIndex).getSalario();
                }

                if (columnIndex == 10) {
                    obj = listaF.get(rowIndex).getEndereco();
                }

                if (columnIndex == 11) {
                    obj = listaF.get(rowIndex).getCidade().getNome();
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

    private void initingComponents() {

        Container container = this.jPanel4;
        container.setLayout(new MigLayout());

        for (Funcao funcao : listaF) {

            container.add(getFuncaoBox(funcao), "wrap");
        }
    }

    private JCheckBox getFuncaoBox(Funcao funcao) {
        JCheckBox box = new JCheckBox(funcao.getEspecializacao());
        box.setName(funcao.getId() + "");
        box.setText(funcao.getEspecializacao());
//        this.buttonGroupFuncao.add(box);
        return box;

    }

    private void limpaCampos() {
        campoNome.setText("");
        campoSexo.setText("");
        campoCPF.setText("");
        this.campo_data_nascimento.setDate(new Date());
        campoFone.setText("");
        campoEmail.setText("");
        campoFormacao.setText("");
        campoTipoContrato.setText("");
        campoSalario.setText("");
        campoEndereco.setText("");
    }

    private boolean validaCampos() {
        boolean valido = true;
        if (campoNome.getText().length() == 0 && campoSexo.getText().length() == 0 && campoCPF.getText().length() == 0 && campoFone.getText().length() == 0 && campoEmail.getText().length() == 0 && campoFormacao.getText().length() == 0 && campoTipoContrato.getText().length() == 0 && campoSalario.getText().length() == 0 && campoEndereco.getText().length() == 0) {
            valido = false;
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios.", "Verifique os campos!", JOptionPane.WARNING_MESSAGE);
        }
        return valido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFuncao = new javax.swing.ButtonGroup();
        frameInterno = new javax.swing.JInternalFrame();
        painel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        campoNome = new javax.swing.JFormattedTextField();
        rotuloNome = new javax.swing.JLabel();
        rotulo = new javax.swing.JLabel();
        campoSexo = new javax.swing.JFormattedTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        rotulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoFone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCidade = new javax.swing.JComboBox<>();
        campoEndereco = new javax.swing.JFormattedTextField();
        campoFormacao = new javax.swing.JFormattedTextField();
        campoTipoContrato = new javax.swing.JFormattedTextField();
        campoSalario = new javax.swing.JFormattedTextField();
        campoEmail = new javax.swing.JFormattedTextField();
        campo_data_nascimento = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botaoPesquisar = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();
        rotuloPesquisar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setName("funcionario"); // NOI18N
        setResizable(false);

        frameInterno.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        frameInterno.setFrameIcon(null);
        frameInterno.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        campoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        rotuloNome.setBackground(new java.awt.Color(200, 200, 200));
        rotuloNome.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloNome.setText("Nome: *");

        rotulo.setBackground(new java.awt.Color(200, 200, 200));
        rotulo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotulo.setText("Sexo: *");

        campoSexo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoSexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoCPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoCPF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        rotulo1.setBackground(new java.awt.Color(200, 200, 200));
        rotulo1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotulo1.setText("CPF: *");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("Fone: *");

        campoFone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoFone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("E-mail: *");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setText("Formação: *");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Tipo contrato: *");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setText("Salário: *");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setText("Endereço: *");

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setText("Cidade: *");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setText("Data de nascimento: *");

        comboCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoEndereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoFormacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoFormacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoTipoContrato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoTipoContrato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoSalario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoSalario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campo_data_nascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        campo_data_nascimento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel4);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setText("Funções: *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotuloNome)
                    .addComponent(rotulo)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(campoNome)
                    .addComponent(campo_data_nascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(rotulo1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoFone, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCPF))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(campoFormacao)
                    .addComponent(campoTipoContrato))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCidade, 0, 134, Short.MAX_VALUE)
                            .addComponent(campoEndereco))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campoCPF, campoEmail, campoFone, campoSexo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campoEndereco, campoFormacao, campoSalario, campoTipoContrato, comboCidade});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rotuloNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rotulo1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rotulo)
                                .addComponent(jLabel1)
                                .addComponent(campoFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)
                                .addComponent(campoEmail))
                            .addComponent(jLabel5)
                            .addComponent(campo_data_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoCPF, campoEmail, campoEndereco, campoFone, campoFormacao, campoNome, campoSalario, campoSexo, campoTipoContrato, comboCidade});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, rotulo, rotulo1, rotuloNome});

        painel.addTab("Cadastrar", jPanel1);

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botaoPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/search-30.png"))); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(740, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        painel.addTab("Consultar", jPanel2);

        tabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Sexo", "Data de nascimento", "CPF", "Telefone", "E-mail", "Formação", "Tipo de Contrato", "Salário", "Endereço", "Cidade"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jPanel3.setBackground(new java.awt.Color(200, 200, 200));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addGap(20, 20, 20))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno.getContentPane());
        frameInterno.getContentPane().setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameInternoLayout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameInterno, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameInterno)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (painel.getSelectedIndex() == 0) {
            limpaCampos();
        } else {
            painel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(campoNome.getText());
        funcionario.setSexo(campoSexo.getText());
        funcionario.setCpf(campoCPF.getText());
        funcionario.setDt_nascimento(this.campo_data_nascimento.getDate());
        funcionario.setTelefone(campoFone.getText());
        funcionario.setEmail(campoEmail.getText());
        funcionario.setFormacao(campoFormacao.getText());
        funcionario.setTipoContrato(campoTipoContrato.getText());
        funcionario.setSalario(Double.parseDouble(this.campoSalario.getText()));
        funcionario.setEndereco(campoEndereco.getText());
        funcionario.setCidade((Cidade) this.comboCidade.getSelectedItem());
        List<Funcao> funcoes = new ArrayList();
        Component[] components = this.jPanel4.getComponents();
        for (int i = 0; i < components.length; i++) {
            JCheckBox box = (JCheckBox) components[i];
            if (box.isSelected()) {
                Funcao funcao = null;
                try {
                    funcao = DaoFactory.newFuncaoDao().read(Integer.parseInt(box.getName()));

                } catch (DataBaseException ex) {
                    java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (funcao != null) {

                    funcoes.add(funcao);
                }

            }
        }
        funcionario.setFuncoes(funcoes);

        try {
            DaoFactory.newFuncionarioDao().create(funcionario);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "] [Cadastro do funcionario \"" + funcionario.getNome() + "\" efetuado"); // Adicionar o usuario que fez a modificação depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DuplicateKeyException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do funcionário a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

        try {
            Funcionario funcionario = DaoFactory.newFuncionarioDao().read(id);

            funcionario.setNome(campoNome.getText());
            funcionario.setSexo(campoSexo.getText());
            funcionario.setCpf(campoCPF.getText());
            funcionario.setDt_nascimento(this.campo_data_nascimento.getDate());
            funcionario.setTelefone(campoFone.getText());
            funcionario.setEmail(campoEmail.getText());
            funcionario.setFormacao(campoFormacao.getText());
            funcionario.setTipoContrato(campoTipoContrato.getText());
            funcionario.setSalario(Double.parseDouble(this.campoSalario.getText()));
            funcionario.setEndereco(campoEndereco.getText());
            funcionario.setCidade((Cidade) this.comboCidade.getSelectedItem());
            List<Funcao> funcoes = new ArrayList();
            Component[] components = this.jPanel4.getComponents();
            for (int i = 0; i < components.length; i++) {
                JCheckBox box = (JCheckBox) components[i];
                if (box.isSelected()) {
                    Funcao funcao = null;
                    try {
                        funcao = DaoFactory.newFuncaoDao().read(Integer.parseInt(box.getName()));

                    } catch (DataBaseException ex) {
                        java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (funcao != null) {

                        funcoes.add(funcao);
                    }

                }
            }
            funcionario.setFuncoes(funcoes);

            DaoFactory.newFuncionarioDao().edit(funcionario);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "] [Edicao do funcionario \"" + funcionario.getNome() + "\" efetuado"); // Adicionar o usuario que fez a modificação depois
            this.atualizarTabela();

        } catch (DataBaseException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do funcionário a ser EXCLUÍDO:", "Excluir", JOptionPane.PLAIN_MESSAGE));
        Funcionario func = null;
        try {
            func = DaoFactory.newFuncionarioDao().read(id);
            if (func != null) {
                DaoFactory.newFuncionarioDao().delete(func);
                JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
                logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin() + "] [Exclusao do funcionario \"" + func.getNome() + "\" efetuado"); // Adicionar o usuario que fez a modificação depois
                this.atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado!");
            }
        } catch (DataBaseException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        this.atualizarTabela();
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void campoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.ButtonGroup buttonGroupFuncao;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JFormattedTextField campoEmail;
    private javax.swing.JFormattedTextField campoEndereco;
    private javax.swing.JFormattedTextField campoFone;
    private javax.swing.JFormattedTextField campoFormacao;
    private javax.swing.JFormattedTextField campoNome;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JFormattedTextField campoSalario;
    private javax.swing.JFormattedTextField campoSexo;
    private javax.swing.JFormattedTextField campoTipoContrato;
    private com.toedter.calendar.JDateChooser campo_data_nascimento;
    private javax.swing.JComboBox<Cidade> comboCidade;
    private javax.swing.JInternalFrame frameInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane painel;
    private javax.swing.JLabel rotulo;
    private javax.swing.JLabel rotulo1;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloPesquisar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
