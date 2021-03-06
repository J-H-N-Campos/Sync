package sync.View;

import sync.Utils.DataBaseException;
import sync.Utils.DuplicateKeyException;
import sync.Utils.NewHibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sync.Entidade.TipoExame;
import sync.Persistence.DaoFactory;
import sync.Sistema_Sync;


/**
 *
 * @author joao
 */
public class TelaCadastroTipoExame extends javax.swing.JFrame
{
    private final static Logger logger = Logger.getLogger(TelaCadastroTipoExame.class);
    
    public TelaCadastroTipoExame()
    {
        initComponents();
//        URL url = this.getClass().getResource("/sync/Assets/product.png");
//        Image icone = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(icone);
        this.atualizarTabela();
    }
    
    private void atualizarTabela()
    {
        this.tabela.setModel(new TableModel()
        {
            @Override
            public int getRowCount()
            {
                List<TipoExame> listaTE = null;
                try {
                    listaTE = DaoFactory.newTipoExameDao().read("FROM TipoExame As p Where p.nome like '%"+campoPesquisar.getText()+"%'");
                } catch (DataBaseException ex) {
                    logger.error(ex.getMessage());
                }
                    
                return listaTE.size();
            }
        
        @Override
        public int getColumnCount()
        {
            return 2;
        }

        @Override
        public String getColumnName(int columnIndex)
        {
            String vet[] = new String[2];
            vet[0] = "Id";
            vet[1] = "Nome";
            return vet[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex)
        {
            Class vet[] = new Class[2];
            vet[0] = Integer.class;
            vet[1] = String.class;
            return vet[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex)
        {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Session sessao = null;
            List<TipoExame> listaTE = null; 
            try {
                sessao = NewHibernateUtil.getSessionFactory().openSession();

                Query query = sessao.createQuery("from TipoExame");
                listaTE = query.list();

            }catch (HibernateException hibEx)
            {
                hibEx.printStackTrace();
            }finally
            {
                sessao.close();
            }
            Object obj = null;

            if(columnIndex==0)
            {
                obj = listaTE.get(rowIndex).getId();
            }

            if(columnIndex==1)
            {
                obj = listaTE.get(rowIndex).getNome();
            }

            return obj;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex)
        {

        }

        @Override
        public void addTableModelListener(TableModelListener l)
        {

        }

        @Override
        public void removeTableModelListener(TableModelListener l)
        {
        }
        });
    }
    
    private void limpaCampos()
    {
        campoNome.setText("");
    }

    private boolean validaCampos()
    {
        boolean valido = true;
        if (campoNome.getText().length() == 0)
        {
            valido = false;
            JOptionPane.showMessageDialog(null, "Os campos n??o podem estar vazios.", "Verifique os campos!", JOptionPane.WARNING_MESSAGE);
        }
        return valido;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        painel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        campoNome = new javax.swing.JFormattedTextField();
        rotuloNome = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        campoPesquisar = new javax.swing.JTextField();
        rotuloPesquisar = new javax.swing.JLabel();
        botaoPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addGap(22, 22, 22))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        rotuloNome.setBackground(new java.awt.Color(200, 200, 200));
        rotuloNome.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloNome.setText("Nome: *");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(rotuloNome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        painel.addTab("Cadastrar", jPanel2);

        jPanel3.setBackground(new java.awt.Color(200, 200, 200));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        campoPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        painel.addTab("Consultar", jPanel3);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addComponent(painel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if(painel.getSelectedIndex() == 0)
        {
            limpaCampos();
        }
        else
        {
            painel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        TipoExame tipoExame = new TipoExame();
        tipoExame.setNome(campoNome.getText());
        try {
            DaoFactory.newTipoExameDao().create(tipoExame);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Cadastro do tipo de exame \""+ tipoExame.getNome() +"\" efetuado"); // Adicionar o usuario que fez a modifica????o depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        } catch (DuplicateKeyException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "C??digo do tipo de exame a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));
        try{
            TipoExame tipoExame = DaoFactory.newTipoExameDao().read(id);
            DaoFactory.newTipoExameDao().delete(tipoExame);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Edicao do tipo de exame \""+ tipoExame.getNome() +"\" efetuado"); // Adicionar o usuario que fez a modifica????o depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "C??digo do tipo de exame a ser EXCLU??DO:", "Excluir", JOptionPane.PLAIN_MESSAGE));
        try{
            TipoExame tipoExame = DaoFactory.newTipoExameDao().read(id);
            DaoFactory.newTipoExameDao().delete(tipoExame);
            JOptionPane.showMessageDialog(null, "Cadastro exclu??do com sucesso!");
            logger.info(Sistema_Sync.get_instance().getLoggedUser().getLogin()+"]/-/[Exclusao do tipo de exame \""+ tipoExame.getNome() +"\" efetuado"); // Adicionar o usuario que fez a modifica????o depois
            this.atualizarTabela();
        } catch (DataBaseException ex) {
            logger.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

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
    private javax.swing.JFormattedTextField campoNome;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane painel;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloPesquisar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
