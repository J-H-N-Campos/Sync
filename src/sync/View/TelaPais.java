/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.View;

import Utils.NewHibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sync.Entidade.Pais;
import sync.TableModels.TableModelPais;

/**
 *
 * @author joao
 */
public class TelaPais extends javax.swing.JFrame
{

    public TelaPais()
    {
        initComponents();
        this.tabela.setModel(new TableModelPais());
    }

    private void atualizarTabela()
    {
        this.tabela.setModel(new TableModel()
        {
            @Override
            public int getRowCount()
            {
                Session sessao = null;
                List<Pais> listaP = null;
                try
                {
                    sessao = NewHibernateUtil.getSessionFactory().openSession();
                    System.out.println(campoPesquisar.getText());
                    Query query = sessao.createQuery("FROM Pais As p Where p.nome like '%"+campoPesquisar.getText()+"%'");
                    listaP = query.list();
                }
                catch(HibernateException hibEx)
                {
                    hibEx.printStackTrace();
                }
                finally
                {
                    sessao.close();
                }
                return listaP.size();
            }
            
            @Override
            public int getColumnCount()
            {
                return 3;
            }
            
            @Override
            public String getColumnName(int columnIndex)
            {
                String vet[] = new String[3];
                vet[0] = "Id";
                vet[1] = "Nome";
                vet[2] = "Idioma";
                return vet[columnIndex];
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                Class vet[] = new Class[3];
                vet[0] = Integer.class;
                vet[1] = String.class;
                vet[2] = String.class;
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
                List<Pais> listaP = null;
                try
                {
                    sessao = NewHibernateUtil.getSessionFactory().openSession();
                    Query query = sessao.createQuery("from Pais as p where p.nome like '%"+campoPesquisar.getText()+"%'");
                    listaP = query.list();
                }
                catch (HibernateException hibEx)
                {
                    hibEx.printStackTrace();
                }
                finally
                {
                    sessao.close();
                }
                Object obj = null;
                
                if(columnIndex==0)
                {
                    obj = listaP.get(rowIndex).getId();
                }
                if(columnIndex==1)
                {
                    obj = listaP.get(rowIndex).getNome();
                }
                if(columnIndex==2)
                {
                    obj = listaP.get(rowIndex).getIdioma();
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
        campoIdioma.setText("");
    }

    private boolean validaCampos()
    {
        boolean valido = true;
        if (campoNome.getText().length() == 0 && campoIdioma.getText().length() == 0)
        {
            valido = false;
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios.", "Verifique os campos!", JOptionPane.WARNING_MESSAGE);
        }
        return valido;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameInterno = new javax.swing.JInternalFrame();
        painel = new javax.swing.JTabbedPane();
        painel2 = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        campoNome = new javax.swing.JFormattedTextField();
        campoIdioma = new javax.swing.JFormattedTextField();
        rotuloNome = new javax.swing.JLabel();
        rotuloIdioma = new javax.swing.JLabel();
        painel4 = new javax.swing.JPanel();
        campoPesquisar = new javax.swing.JTextField();
        rotuloPesquisar = new javax.swing.JLabel();
        botaoPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        painel3 = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("País");

        frameInterno.setBackground(new java.awt.Color(250, 250, 250));
        frameInterno.setTitle("País");
        frameInterno.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        frameInterno.setVisible(true);

        painel.setBackground(new java.awt.Color(200, 200, 200));
        painel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        painel2.setBackground(new java.awt.Color(200, 200, 200));
        painel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        painel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        botaoSalvar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync/Assets/save-30.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        campoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        campoIdioma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        campoIdioma.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        rotuloNome.setBackground(new java.awt.Color(200, 200, 200));
        rotuloNome.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloNome.setText("Nome: *");

        rotuloIdioma.setBackground(new java.awt.Color(200, 200, 200));
        rotuloIdioma.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        rotuloIdioma.setText("Idioma: *");

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(rotuloNome, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rotuloIdioma)))
                .addGap(18, 18, 18)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(campoIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        painel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campoIdioma, campoNome});

        painel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rotuloIdioma, rotuloNome});

        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloIdioma))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        painel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoIdioma, campoNome});

        painel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rotuloIdioma, rotuloNome});

        painel.addTab("Cadastrar", painel2);

        painel4.setBackground(new java.awt.Color(200, 200, 200));
        painel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        painel4.setToolTipText("");
        painel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

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
                "Id", "Nome", "Idioma"
            }
        ));
        jScrollPane1.setViewportView(tabela);

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

        javax.swing.GroupLayout painel4Layout = new javax.swing.GroupLayout(painel4);
        painel4.setLayout(painel4Layout);
        painel4Layout.setHorizontalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(painel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painel4Layout.setVerticalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painel.addTab("Consultar", painel4);

        painel3.setBackground(new java.awt.Color(200, 200, 200));
        painel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        painel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout painel3Layout = new javax.swing.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botaoCancelar)
                .addGap(18, 18, 18)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel3Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        painel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoCancelar, botaoFechar});

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno.getContentPane());
        frameInterno.getContentPane().setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel)
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameInternoLayout.createSequentialGroup()
                .addComponent(painel)
                .addGap(18, 18, 18)
                .addComponent(painel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameInterno)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameInterno)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
       this.atualizarTabela();
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        List resultado = null;
        Session sessao = null;
        
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do pais a ser EXCLUÍDO:", "Excluir", JOptionPane.PLAIN_MESSAGE));
            org.hibernate.Query query = sessao.createQuery("FROM pais WHERE id = " +id);
            resultado = query.list();
            
            for(Object obj : resultado)
            {
                Pais pais = (Pais) obj;
                sessao.delete(pais);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            }
        }
        catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        List resultado = null;
        Session sessao = null;
        
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do pais a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));
            org.hibernate.Query query = sessao.createQuery("FROM pais WHERE id = " +id);
            resultado = query.list();
            
            for(Object obj : resultado)
            {
                Pais pais = (Pais) obj;
                pais.setId(id);
                pais.setNome(campoNome.getText());
                pais.setIdioma(campoIdioma.getText());
                sessao.update(pais);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            }
        }
        catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        Session sessao = null;
        try
        {
            sessao = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            Pais pais = new Pais();
            pais.setNome(campoNome.getText());
            pais.setIdioma(campoIdioma.getText());
            sessao.save(pais);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        }
        catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }
        finally
        {
            sessao.close();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

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

    public static void main(String args[])
    {
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TelaPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new TelaPais().setVisible(true);
                new TelaPais().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JFormattedTextField campoIdioma;
    private javax.swing.JFormattedTextField campoNome;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JInternalFrame frameInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane painel;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel3;
    private javax.swing.JPanel painel4;
    private javax.swing.JLabel rotuloIdioma;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloPesquisar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
