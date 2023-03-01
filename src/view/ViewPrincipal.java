package view;

import javax.swing.SwingConstants;

/**
 *
 * @author José Orlando
 */
public class ViewPrincipal extends javax.swing.JFrame {

    String boasVindas = "MENU PRINCIPAL - "
            + ViewLogin.usuSelecionado.getNome()
            + " - Modo: "
            + ViewLogin.usuSelecionado.getCargo()
            + (ViewLogin.usuSelecionado.getCargo().equals("Professor")?" - " + ViewLogin.usuSelecionado.getLeciona(): "") 
            + (ViewLogin.usuSelecionado.getCargo().equals("Coordenador")?" - " + ViewLogin.usuSelecionado.getCoordena() : "");

    /**
     * Creates new form ViewPrincipal
     */
    public ViewPrincipal() {
        initComponents();
        setLocationRelativeTo(null);

        jbAlunos.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbAlunos.setHorizontalTextPosition(SwingConstants.CENTER);
        jbAvaliacoes.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbAvaliacoes.setHorizontalTextPosition(SwingConstants.CENTER);
        jbClasses.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbClasses.setHorizontalTextPosition(SwingConstants.CENTER);
        jbDisciplinas.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbDisciplinas.setHorizontalTextPosition(SwingConstants.CENTER);
        jbFuncionarios.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbFuncionarios.setHorizontalTextPosition(SwingConstants.CENTER);
        jbSair.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbSair.setHorizontalTextPosition(SwingConstants.CENTER);

        if (ViewLogin.usuSelecionado.getCargo().equals("Aluno")) {
            jbAlunos.setEnabled(false);
            jbAvaliacoes.setEnabled(true);
            jbClasses.setEnabled(false);
            jbDisciplinas.setEnabled(false);
            jbFuncionarios.setEnabled(false);
        }

        if (ViewLogin.usuSelecionado.getCargo().equals("Coordenador")) {
            jbAlunos.setEnabled(false);
            jbAvaliacoes.setEnabled(true);
            jbClasses.setEnabled(false);
            jbDisciplinas.setEnabled(true);
            jbFuncionarios.setEnabled(false);
        }

        if (ViewLogin.usuSelecionado.getCargo().equals("Professor")) {
            jbAlunos.setEnabled(false);
            jbAvaliacoes.setEnabled(true);
            jbClasses.setEnabled(false);
            jbDisciplinas.setEnabled(false);
            jbFuncionarios.setEnabled(false);
        }

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
        jbAlunos = new javax.swing.JButton();
        jbClasses = new javax.swing.JButton();
        jbAvaliacoes = new javax.swing.JButton();
        jbFuncionarios = new javax.swing.JButton();
        jbDisciplinas = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(boasVindas);
        setResizable(false);

        jbAlunos.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-estudante,-escrivaninha-64.png"))); // NOI18N
        jbAlunos.setText("Alunos");
        jbAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlunosActionPerformed(evt);
            }
        });

        jbClasses.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbClasses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-multidão-64.png"))); // NOI18N
        jbClasses.setText("Classes");
        jbClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClassesActionPerformed(evt);
            }
        });

        jbAvaliacoes.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbAvaliacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisa-64.png"))); // NOI18N
        jbAvaliacoes.setText("Avaliações");
        jbAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAvaliacoesActionPerformed(evt);
            }
        });

        jbFuncionarios.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-64.png"))); // NOI18N
        jbFuncionarios.setText("Funcionários");
        jbFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFuncionariosActionPerformed(evt);
            }
        });

        jbDisciplinas.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbDisciplinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-inteligência-artificial-64.png"))); // NOI18N
        jbDisciplinas.setText("Disciplinas");
        jbDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDisciplinasActionPerformed(evt);
            }
        });

        jbSair.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-64.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbDisciplinas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jbFuncionarios))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jbClasses))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jbAvaliacoes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAlunos, jbAvaliacoes, jbClasses, jbDisciplinas, jbFuncionarios});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlunosActionPerformed
        new ViewAluno().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbAlunosActionPerformed

    private void jbAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAvaliacoesActionPerformed
        new ViewAvaliacao().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbAvaliacoesActionPerformed

    private void jbClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClassesActionPerformed
        new ViewClasse().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbClassesActionPerformed

    private void jbDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDisciplinasActionPerformed
        new ViewDisciplina().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbDisciplinasActionPerformed

    private void jbFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFuncionariosActionPerformed
        new ViewFuncionario().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbFuncionariosActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        new ViewLogin().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSairActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAlunos;
    private javax.swing.JButton jbAvaliacoes;
    private javax.swing.JButton jbClasses;
    private javax.swing.JButton jbDisciplinas;
    private javax.swing.JButton jbFuncionarios;
    private javax.swing.JButton jbSair;
    // End of variables declaration//GEN-END:variables
}
