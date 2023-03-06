package view;

import com.sun.glass.events.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.AlunoModel;
import model.AvaliacaoModel;
import controller.AvaliacaoController;
import controller.AlunoController;
import javax.swing.JOptionPane;

/**
 *
 * @author José Orlando
 */
public class ViewAvaliacao extends javax.swing.JFrame {

    String boasVindas = "AVALIAÇÕES - "
            + ViewLogin.usuSelecionado.getNome()
            + " - Modo: "
            + ViewLogin.usuSelecionado.getCargo()
            + (ViewLogin.usuSelecionado.getCargo().equals("Professor") ? " - " + ViewLogin.usuSelecionado.getLeciona() : "")
            + (ViewLogin.usuSelecionado.getCargo().equals("Coordenador") ? " - " + ViewLogin.usuSelecionado.getCoordena() : "");

    AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
    AvaliacaoController avaliacaoController = new AvaliacaoController();
    AlunoModel alunoModel = new AlunoModel();
    AlunoController alunoController = new AlunoController();

    int alunoId = 0;
    String cadAlt = "cad";

    /**
     * Creates new form ViewAvaliacao
     */
    public ViewAvaliacao() {
        initComponents();
        setLocationRelativeTo(null);
        carregarTabela("");
        definirUsuario();
    }

    private void carregarTabela(String filtro) {
        List<AvaliacaoModel> listaAvaliacoes;
        String where = "";

        if (ViewLogin.usuSelecionado.getCargo().equals("Professor")) {
            where = "where f.nome = '" + ViewLogin.usuSelecionado.getNome() + "'";

        } else if (ViewLogin.usuSelecionado.getCargo().equals("Aluno")) {
            where = "where a.nome = '" + ViewLogin.usuSelecionado.getNome() + "'";

        } else if (ViewLogin.usuSelecionado.getCargo().equals("Coordenador")) {
            where = "join area_conhecimento ac on d.id_area_conhecimento = ac.id "
                    + "where ac.nome = '" + ViewLogin.usuSelecionado.getCoordena() + "'";
        }

        listaAvaliacoes = avaliacaoController.getListaAvaliacoesController(where + filtro);
        DefaultTableModel tabela = (DefaultTableModel) jTabela.getModel();
        tabela.setNumRows(0);
        for (int i = 0; i < listaAvaliacoes.size(); i++) {
            tabela.addRow(new Object[]{
                listaAvaliacoes.get(i).getNomeProfessor(),
                listaAvaliacoes.get(i).getDisciplina(),
                listaAvaliacoes.get(i).getNomeAluno(),
                listaAvaliacoes.get(i).getAno(),
                listaAvaliacoes.get(i).getTurma(),
                String.format("%.1f", listaAvaliacoes.get(i).getBim1()),
                String.format("%.1f", listaAvaliacoes.get(i).getBim2()),
                String.format("%.1f", listaAvaliacoes.get(i).getBim3()),
                String.format("%.1f", listaAvaliacoes.get(i).getBim4())
            });
        }
    }

    private void definirUsuario() {
        if (ViewLogin.usuSelecionado.getCargo().equals("Professor")) {
            jtfNomeProfessor.setText(ViewLogin.usuSelecionado.getNome());
            jbAlterar.setEnabled(true);
            jbExcluir.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbPesquisarAluno.setEnabled(true);
            jbSalvar.setEnabled(true);
            jbPesquisaFiltro.setEnabled(true);
            jtfFiltroTabelaPrincipal.setEnabled(true);
            jtfNomeProfessor.setEnabled(true);
            jtfNomeAluno.setEnabled(true);
            jtfNota1.setEnabled(true);
            jtfNota2.setEnabled(true);
            jtfNota3.setEnabled(true);
            jtfNota4.setEnabled(true);
            jtfNota1.setEditable(true);
            jtfNota2.setEditable(true);
            jtfNota3.setEditable(true);
            jtfNota4.setEditable(true);
        }

        if (ViewLogin.usuSelecionado.getCargo().equals("Diretor")) {
            jbPesquisaFiltro.setEnabled(true);
            jtfFiltroTabelaPrincipal.setEnabled(true);
            jbLimpar.setEnabled(true);
        }

        if (ViewLogin.usuSelecionado.getCargo().equals("Coordenador")) {
            jbPesquisaFiltro.setEnabled(true);
            jtfFiltroTabelaPrincipal.setEnabled(true);
            jbLimpar.setEnabled(true);
        }
    }

    private void limparFormularios() {
        jtfNomeAluno.setText("");
        jtfFiltroTabelaPrincipal.setText("");
        jtfNota1.setText("");
        jtfNota2.setText("");
        jtfNota3.setText("");
        jtfNota4.setText("");
        jtfFiltroTabelaPrincipal.setText("");
        if (ViewLogin.usuSelecionado.getCargo().equals("Professor")) {
            jtfNomeAluno.setEditable(true);
            jbExcluir.setEnabled(true);
            jbPesquisarAluno.setEnabled(true);
        }
        pesquisaFiltro();
        alunoId = 0;
        cadAlt = "cad";
    }

    private void carregarAlunos(String filtro) {
        List<AlunoModel> listaAluno;
        listaAluno = alunoController.getListaAlunosController();
        DefaultTableModel tabela = (DefaultTableModel) jTabelaAlunos.getModel();
        tabela.setNumRows(0);
        for (int i = 0; i < listaAluno.size(); i++) {
            if (listaAluno.get(i).getNome().matches(".*(?i)" + filtro + ".*")) {
                tabela.addRow(new Object[]{
                    listaAluno.get(i).getId(),
                    listaAluno.get(i).getNome(),
                    listaAluno.get(i).getAno(),
                    listaAluno.get(i).getTurma()
                });
            }
        }
    }

    private void pesquisarAluno() {
        jfAlunos.setVisible(true);
        jfAlunos.setSize(630, 530);
        jfAlunos.setResizable(false);
        jfAlunos.setLocationRelativeTo(null);
        carregarAlunos(jtfNomeAluno.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfAlunos = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaAlunos = new javax.swing.JTable();
        jbSelecionarAluno = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();
        jtfNomeProfessor = new javax.swing.JTextField();
        jtfNomeAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfNota2 = new javax.swing.JTextField();
        jtfNota1 = new javax.swing.JTextField();
        jtfNota3 = new javax.swing.JTextField();
        jtfNota4 = new javax.swing.JTextField();
        jbPesquisarAluno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfFiltroTabelaPrincipal = new javax.swing.JTextField();
        jbPesquisaFiltro = new javax.swing.JButton();

        jfAlunos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jfAlunos.setTitle("Alunos");

        jTabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Ano", "Turma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTabelaAlunos);
        if (jTabelaAlunos.getColumnModel().getColumnCount() > 0) {
            jTabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTabelaAlunos.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        jbSelecionarAluno.setText("Selecionar Aluno");
        jbSelecionarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSelecionarAluno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSelecionarAluno)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jfAlunosLayout = new javax.swing.GroupLayout(jfAlunos.getContentPane());
        jfAlunos.getContentPane().setLayout(jfAlunosLayout);
        jfAlunosLayout.setHorizontalGroup(
            jfAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jfAlunosLayout.setVerticalGroup(
            jfAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jfAlunos.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(boasVindas);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(740, 580));

        jTabela.setAutoCreateRowSorter(true);
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Professor", "Disciplina", "Aluno", "Ano", "Turma", "1º Bim", "2º Bim ", "3º Bim", "4º Bim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTabela);
        if (jTabela.getColumnModel().getColumnCount() > 0) {
            jTabela.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTabela.getColumnModel().getColumn(3).setMinWidth(50);
            jTabela.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabela.getColumnModel().getColumn(4).setMinWidth(50);
            jTabela.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabela.getColumnModel().getColumn(5).setMinWidth(50);
            jTabela.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(5).setMaxWidth(50);
            jTabela.getColumnModel().getColumn(6).setMinWidth(50);
            jTabela.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(6).setMaxWidth(50);
            jTabela.getColumnModel().getColumn(7).setMinWidth(50);
            jTabela.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(7).setMaxWidth(50);
            jTabela.getColumnModel().getColumn(8).setMinWidth(50);
            jTabela.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTabela.getColumnModel().getColumn(8).setMaxWidth(50);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Professor");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Aluno");

        jbSalvar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-30.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.setEnabled(false);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbAlterar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-exchange-money-30.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-cancelar-30.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbLimpar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-apagar-30.png"))); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.setEnabled(false);
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mova-à-esquerda-30.png"))); // NOI18N
        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        jtfNomeProfessor.setEditable(false);
        jtfNomeProfessor.setEnabled(false);

        jtfNomeAluno.setToolTipText("Deixe em branco para pesquisar todos os alunos.");
        jtfNomeAluno.setEnabled(false);
        jtfNomeAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeAlunoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Notas :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("1º Bim");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("2º Bim");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("3º Bim");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("4º Bim");

        jtfNota2.setEditable(false);
        jtfNota2.setToolTipText("Aperte enter para inserir a nota.");
        jtfNota2.setEnabled(false);
        jtfNota2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfNota2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNota2FocusLost(evt);
            }
        });
        jtfNota2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNota2KeyPressed(evt);
            }
        });

        jtfNota1.setEditable(false);
        jtfNota1.setToolTipText("Aperte enter para inserir a nota.");
        jtfNota1.setEnabled(false);
        jtfNota1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfNota1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNota1FocusLost(evt);
            }
        });
        jtfNota1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNota1KeyPressed(evt);
            }
        });

        jtfNota3.setEditable(false);
        jtfNota3.setToolTipText("Aperte enter para inserir a nota.");
        jtfNota3.setEnabled(false);
        jtfNota3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfNota3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNota3FocusLost(evt);
            }
        });
        jtfNota3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNota3KeyPressed(evt);
            }
        });

        jtfNota4.setEditable(false);
        jtfNota4.setToolTipText("Aperte enter para inserir a nota.");
        jtfNota4.setEnabled(false);
        jtfNota4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfNota4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNota4FocusLost(evt);
            }
        });
        jtfNota4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNota4KeyPressed(evt);
            }
        });

        jbPesquisarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20 (1).png"))); // NOI18N
        jbPesquisarAluno.setText("Pesquisar");
        jbPesquisarAluno.setEnabled(false);
        jbPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarAlunoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Filtrar professor ou aluno:");

        jtfFiltroTabelaPrincipal.setToolTipText("Deixe em branco para resetar a tabela");
        jtfFiltroTabelaPrincipal.setEnabled(false);
        jtfFiltroTabelaPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfFiltroTabelaPrincipalKeyPressed(evt);
            }
        });

        jbPesquisaFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20 (1).png"))); // NOI18N
        jbPesquisaFiltro.setToolTipText("");
        jbPesquisaFiltro.setEnabled(false);
        jbPesquisaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisaFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(jtfNomeAluno))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbPesquisarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbPesquisaFiltro)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtfNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfNota3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(jtfNota4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir)
                            .addComponent(jbLimpar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(734, 734, 734)
                        .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFiltroTabelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAlterar, jbExcluir, jbLimpar, jbSalvar, jbVoltar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbPesquisaFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfFiltroTabelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jbVoltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarAlunoActionPerformed
        pesquisarAluno();
    }//GEN-LAST:event_jbPesquisarAlunoActionPerformed

    private void jbSelecionarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarAlunoActionPerformed
        int linha = jTabelaAlunos.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para avaliar.");
        } else {
            jtfNomeAluno.setText((String) jTabelaAlunos.getValueAt(linha, 1));
            alunoId = (int) jTabelaAlunos.getValueAt(linha, 0);
            jtfNomeAluno.setEditable(false);
            jfAlunos.dispose();
        }
    }//GEN-LAST:event_jbSelecionarAlunoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jTabela.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma avaliação para apagar.");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir a avaliação selecionada?", "ATENÇÃO!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {

                String nomeProfessor = (String) jTabela.getValueAt(linha, 0);
                String nomeAluno = (String) jTabela.getValueAt(linha, 2);

                List<AvaliacaoModel> listaAvaliacoes;
                listaAvaliacoes = avaliacaoController.getListaAvaliacoesController("");
                int idProfessor = 0;
                int idAluno = 0;
                for (int i = 0; i < listaAvaliacoes.size(); i++) {
                    if (listaAvaliacoes.get(i).getNomeProfessor().equals(nomeProfessor)
                            && listaAvaliacoes.get(i).getNomeAluno().equals(nomeAluno)) {
                        idProfessor = listaAvaliacoes.get(i).getIdProfessor();
                        idAluno = listaAvaliacoes.get(i).getIdAluno();
                    }
                }

                if (avaliacaoController.excluirAvaliacaoController(idProfessor, idAluno)) {
                    carregarTabela("");
                    JOptionPane.showMessageDialog(this, "Avaliação excluída com sucesso.");

                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao excluir avaliação.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparFormularios();

    }//GEN-LAST:event_jbLimparActionPerformed

    private void jtfNota1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota1FocusLost
        String converteVirgula = jtfNota1.getText();
        converteVirgula = converteVirgula.replace(',', '.');
        jtfNota1.setText(converteVirgula);
        if (!validaNotas(converteVirgula)) {
            jtfNota1.setText("");
        }
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jtfNota1FocusLost

    private void jtfNota2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota2FocusLost
        String converteVirgula = jtfNota2.getText();
        converteVirgula = converteVirgula.replace(',', '.');
        jtfNota2.setText(converteVirgula);
        if (!validaNotas(converteVirgula)) {
            jtfNota2.setText("");
        }
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jtfNota2FocusLost

    private void jtfNota3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota3FocusLost
        String converteVirgula = jtfNota3.getText();
        converteVirgula = converteVirgula.replace(',', '.');
        jtfNota3.setText(converteVirgula);
        if (!validaNotas(converteVirgula)) {
            jtfNota3.setText("");
        }
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jtfNota3FocusLost

    private void jtfNota4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota4FocusLost
        String converteVirgula = jtfNota4.getText();
        converteVirgula = converteVirgula.replace(',', '.');
        jtfNota4.setText(converteVirgula);
        if (!validaNotas(converteVirgula)) {
            jtfNota4.setText("");
        }
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jtfNota4FocusLost

    private boolean validaNotas(String nota) {
        if (!nota.equals("")) {
            try {
                Double notaConvertida = Double.parseDouble(nota);
                if (notaConvertida < 0 || notaConvertida > 10) {
                    JOptionPane.showMessageDialog(this, "Digite uma nota entre 0 e 10.");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite um valor numérico entre 0 e 10.");
                return false;
            }
        }
        return true;
    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        avaliacaoModel = new AvaliacaoModel();
        avaliacaoModel.setIdProfessor(ViewLogin.usuSelecionado.getId());
        if (!jtfNota1.getText().equals("")) {
            avaliacaoModel.setBim1(Double.parseDouble(jtfNota1.getText()));
        }
        if (!jtfNota2.getText().equals("")) {
            avaliacaoModel.setBim2(Double.parseDouble(jtfNota2.getText()));
        }
        if (!jtfNota3.getText().equals("")) {
            avaliacaoModel.setBim3(Double.parseDouble(jtfNota3.getText()));
        }
        if (!jtfNota4.getText().equals("")) {
            avaliacaoModel.setBim4(Double.parseDouble(jtfNota4.getText()));
        }
       
        if (jtfNomeAluno.getText().equals("")
                || alunoId == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para efetuar o cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cadAlt.equals("cad")) {
                avaliacaoModel.setIdAluno(alunoId);
                String msgRetorno = avaliacaoController.salvarAvaliacaoController(avaliacaoModel);
                if (msgRetorno.equals("")) {
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    carregarTabela("");
                    limparFormularios();
                } else {
                    JOptionPane.showMessageDialog(this, msgRetorno + "\nCadastro não efetuado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    limparFormularios();
                }
            } else {
                List<AlunoModel> listaAluno;
                listaAluno = alunoController.getListaAlunosController();
                for (int i = 0; i < listaAluno.size(); i++) {
                    if (listaAluno.get(i).getNome().equals(jtfNomeAluno.getText())) {
                        avaliacaoModel.setIdAluno(listaAluno.get(i).getId());
                    }
                }

                if (avaliacaoController.atualizarAvaliacaoController(avaliacaoModel)) {
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    carregarTabela("");
                    cadAlt = "cad";
                    jbExcluir.setEnabled(true);
                    jbPesquisarAluno.setEnabled(true);

                    limparFormularios();
                } else {
                    JOptionPane.showMessageDialog(this, "Alteração não efetuada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        cadAlt = "alt";
        int linha = jTabela.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma avaliação para alterar.");
        } else {
            jtfNomeAluno.setText(jTabela.getValueAt(linha, 2).toString());
            jtfNota1.setText(jTabela.getValueAt(linha, 5).toString().replace(',', '.'));
            jtfNota2.setText(jTabela.getValueAt(linha, 6).toString().replace(',', '.'));
            jtfNota3.setText(jTabela.getValueAt(linha, 7).toString().replace(',', '.'));
            jtfNota4.setText(jTabela.getValueAt(linha, 8).toString().replace(',', '.'));
            jbExcluir.setEnabled(false);
            jbPesquisarAluno.setEnabled(false);
            jtfNomeAluno.setEditable(false);
            alunoId = 1;
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtfNota1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota1FocusGained
        jbSalvar.setEnabled(false);
    }//GEN-LAST:event_jtfNota1FocusGained

    private void jtfNota2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota2FocusGained
        jbSalvar.setEnabled(false);
    }//GEN-LAST:event_jtfNota2FocusGained

    private void jtfNota3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota3FocusGained
        jbSalvar.setEnabled(false);
    }//GEN-LAST:event_jtfNota3FocusGained

    private void jtfNota4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNota4FocusGained
        jbSalvar.setEnabled(false);
    }//GEN-LAST:event_jtfNota4FocusGained

    private void jtfNota1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNota1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSalvar.requestFocus();
        }
    }//GEN-LAST:event_jtfNota1KeyPressed

    private void jtfNota2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNota2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSalvar.requestFocus();
        }
    }//GEN-LAST:event_jtfNota2KeyPressed

    private void jtfNota3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNota3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSalvar.requestFocus();
        }
    }//GEN-LAST:event_jtfNota3KeyPressed

    private void jtfNota4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNota4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSalvar.requestFocus();
        }
    }//GEN-LAST:event_jtfNota4KeyPressed


    private void jbPesquisaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisaFiltroActionPerformed
        pesquisaFiltro();
    }//GEN-LAST:event_jbPesquisaFiltroActionPerformed

    private void jtfFiltroTabelaPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltroTabelaPrincipalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisaFiltro();
        }
    }//GEN-LAST:event_jtfFiltroTabelaPrincipalKeyPressed

    private void pesquisaFiltro() {
        String filtro = "";
        if (!jtfFiltroTabelaPrincipal.getText().equals("")) {
            filtro = " " + "and (f.nome like '%" + jtfFiltroTabelaPrincipal.getText() + "%' or a.nome like '%" + jtfFiltroTabelaPrincipal.getText() + "%')";
        }
        carregarTabela(filtro);
    }

    private void jtfNomeAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeAlunoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisarAluno();
        }
    }//GEN-LAST:event_jtfNomeAlunoKeyPressed

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
            java.util.logging.Logger.getLogger(ViewAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAvaliacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabela;
    private javax.swing.JTable jTabelaAlunos;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPesquisaFiltro;
    private javax.swing.JButton jbPesquisarAluno;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JButton jbSelecionarAluno;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JFrame jfAlunos;
    private javax.swing.JTextField jtfFiltroTabelaPrincipal;
    private javax.swing.JTextField jtfNomeAluno;
    private javax.swing.JTextField jtfNomeProfessor;
    private javax.swing.JTextField jtfNota1;
    private javax.swing.JTextField jtfNota2;
    private javax.swing.JTextField jtfNota3;
    private javax.swing.JTextField jtfNota4;
    // End of variables declaration//GEN-END:variables
}
