/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.vianna.finance.view;

import br.edu.vianna.finance.model.users.Admin;
import br.edu.vianna.finance.model.users.Client;
import br.edu.vianna.finance.model.users.User;
import br.edu.vianna.finance.view.expenses.ViewListExpenses;
import br.edu.vianna.finance.view.expenses.ViewRegisterExpense;
import br.edu.vianna.finance.view.financialgoal.ViewListFinancialGoals;
import br.edu.vianna.finance.view.financialgoal.ViewRegisterFinancialGoal;
import br.edu.vianna.finance.view.incomes.ViewListIncomes;
import br.edu.vianna.finance.view.incomes.ViewRegisterIncome;
import br.edu.vianna.finance.view.register.ViewListClient;
import br.edu.vianna.finance.view.reports.ViewGoalsReports;
import br.edu.vianna.finance.view.reports.ViewSystemReport;
import br.edu.vianna.finance.view.reports.ViewTransactionReports;

import java.awt.Color;

/**
 *
 * @author Renan Guedes
 */
public class viewPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form viewPrincipal
     */
    public viewPrincipal() {
        initComponents();
        getContentPane().setBackground(Color.darkGray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlNameUser = new javax.swing.JLabel();
        jlBoasVindas = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jExitButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnCadastros = new javax.swing.JMenu();
        jRegisterClient = new javax.swing.JMenuItem();
        jmnReceitas = new javax.swing.JMenu();
        jMenuRegisterIncome = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jConsultListIncomes = new javax.swing.JMenuItem();
        jmnDespesas = new javax.swing.JMenu();
        jMenuRegisterExpense = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jConsultListExpenses = new javax.swing.JMenuItem();
        jmnMetas = new javax.swing.JMenu();
        jMenuRegisterGoal = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuConsultGoals = new javax.swing.JMenuItem();
        jmnRelatorios = new javax.swing.JMenu();
        jmnSystemReport = new javax.swing.JMenuItem();
        jSeparatorR1 = new javax.swing.JPopupMenu.Separator();
        jmnTransactionReports = new javax.swing.JMenuItem();
        jSeparatorR2 = new javax.swing.JPopupMenu.Separator();
        jmnGoalsReports = new javax.swing.JMenuItem();
        jmnAjuda = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(76, 76, 76));

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/47488_accounting_cash_money_office_trade_icon.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jlNameUser.setBackground(new java.awt.Color(76, 76, 76));
        jlNameUser.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlNameUser.setForeground(new java.awt.Color(255, 255, 255));
        jlNameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNameUser.setOpaque(true);

        jlBoasVindas.setBackground(new java.awt.Color(76, 76, 76));
        jlBoasVindas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlBoasVindas.setForeground(new java.awt.Color(255, 255, 255));
        jlBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlBoasVindas.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(76, 76, 76));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("    Seu principal controle de finanças!");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jExitButton.setBackground(new java.awt.Color(0, 102, 51));
        jExitButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-Button-cancel.png"))); // NOI18N
        jExitButton.setText("SAIR");
        jExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jExitButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jExitButton.setMaximumSize(new java.awt.Dimension(82, 29));
        jExitButton.setMinimumSize(new java.awt.Dimension(82, 29));
        jExitButton.setPreferredSize(new java.awt.Dimension(110, 29));
        jExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                    .addComponent(jlBoasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(0, 0, 0, 20));

        jmnCadastros.setText("Cadastros");
        jmnCadastros.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jRegisterClient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jRegisterClient.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRegisterClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-register.png"))); // NOI18N
        jRegisterClient.setText("Cliente");
        jRegisterClient.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jRegisterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterClientActionPerformed(evt);
            }
        });
        jmnCadastros.add(jRegisterClient);

        jMenuBar1.add(jmnCadastros);

        jmnReceitas.setText("Receitas");
        jmnReceitas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenuRegisterIncome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuRegisterIncome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-money.png"))); // NOI18N
        jMenuRegisterIncome.setText("Cadastrar Receitas");
        jMenuRegisterIncome.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jMenuRegisterIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegisterIncomeActionPerformed(evt);
            }
        });
        jmnReceitas.add(jMenuRegisterIncome);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jmnReceitas.add(jSeparator3);

        jConsultListIncomes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jConsultListIncomes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-list.png"))); // NOI18N
        jConsultListIncomes.setText("Consultar Receitas");
        jConsultListIncomes.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jConsultListIncomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultListIncomesActionPerformed(evt);
            }
        });
        jmnReceitas.add(jConsultListIncomes);

        jMenuBar1.add(jmnReceitas);

        jmnDespesas.setText("Despesas");
        jmnDespesas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenuRegisterExpense.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuRegisterExpense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-money.png"))); // NOI18N
        jMenuRegisterExpense.setText("Cadastrar Despesas");
        jMenuRegisterExpense.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jMenuRegisterExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegisterExpenseActionPerformed(evt);
            }
        });
        jmnDespesas.add(jMenuRegisterExpense);

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmnDespesas.add(jSeparator4);

        jConsultListExpenses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jConsultListExpenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-list.png"))); // NOI18N
        jConsultListExpenses.setText("Consultar Despesas");
        jConsultListExpenses.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jConsultListExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultListExpensesActionPerformed(evt);
            }
        });
        jmnDespesas.add(jConsultListExpenses);

        jMenuBar1.add(jmnDespesas);

        jmnMetas.setText("Metas");
        jmnMetas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenuRegisterGoal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuRegisterGoal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-money.png"))); // NOI18N
        jMenuRegisterGoal.setText("Cadastrar Metas");
        jMenuRegisterGoal.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jMenuRegisterGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegisterGoalActionPerformed(evt);
            }
        });
        jmnMetas.add(jMenuRegisterGoal);

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jmnMetas.add(jSeparator5);

        jMenuConsultGoals.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuConsultGoals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-list.png"))); // NOI18N
        jMenuConsultGoals.setText("Consultar Metas");
        jMenuConsultGoals.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jMenuConsultGoals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultGoalsActionPerformed(evt);
            }
        });
        jmnMetas.add(jMenuConsultGoals);

        jMenuBar1.add(jmnMetas);

        jmnRelatorios.setText("Relatórios");
        jmnRelatorios.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jmnSystemReport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmnSystemReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-reports.png"))); // NOI18N
        jmnSystemReport.setText("Relatório do sistema");
        jmnSystemReport.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jmnSystemReport.setPreferredSize(new java.awt.Dimension(182, 28));
        jmnSystemReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSystemReportActionPerformed(evt);
            }
        });
        jmnRelatorios.add(jmnSystemReport);
        jmnRelatorios.add(jSeparatorR1);

        jmnTransactionReports.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmnTransactionReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-reports.png"))); // NOI18N
        jmnTransactionReports.setText("Relatório Receita/Despesa");
        jmnTransactionReports.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jmnTransactionReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnTransactionReportsActionPerformed(evt);
            }
        });
        jmnRelatorios.add(jmnTransactionReports);
        jmnRelatorios.add(jSeparatorR2);

        jmnGoalsReports.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmnGoalsReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-reports.png"))); // NOI18N
        jmnGoalsReports.setText("Relatório Metas Financeiras");
        jmnGoalsReports.setMargin(new java.awt.Insets(5, 6, 3, 6));
        jmnGoalsReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnGoalsReportsActionPerformed(evt);
            }
        });
        jmnRelatorios.add(jmnGoalsReports);

        jMenuBar1.add(jmnRelatorios);

        jmnAjuda.setText("Ajuda");
        jmnAjuda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jmnAjuda.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-help.png"))); // NOI18N
        jMenuItem7.setText("Contate-nos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmnAjuda.add(jMenuItem7);

        jMenuBar1.add(jmnAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterClientActionPerformed
        ViewListClient vrc = new ViewListClient(null, true);
        vrc.setVisible(true);
    }//GEN-LAST:event_jRegisterClientActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jlNameUser.setText("");
        jlBoasVindas.setText("");
        jmnCadastros.setVisible(false);
        jmnDespesas.setVisible(false);
        jmnReceitas.setVisible(false);
        jmnRelatorios.setVisible(false);
        jmnMetas.setVisible(false);
        jmnSystemReport.setVisible(false);
        jmnTransactionReports.setVisible(false);
        jmnGoalsReports.setVisible(false);

        viewLogin vLogin = new viewLogin(this, true);
        vLogin.setVisible(true);

        user = vLogin.getUser();

        if(user instanceof Admin){
            jmnCadastros.setVisible(true);
            jmnRelatorios.setVisible(true);
        }else if(user instanceof Client){
            jmnDespesas.setVisible(true);
            jmnReceitas.setVisible(true);
            jmnRelatorios.setVisible(true);
            jmnMetas.setVisible(true);
            jmnTransactionReports.setVisible(true);
            jmnGoalsReports.setVisible(true);
            jSeparatorR1.setVisible(false);
            jSeparatorR2.setVisible(true);
        }else{
            jmnCadastros.setVisible(true);
            jmnRelatorios.setVisible(true);
            jmnSystemReport.setVisible(true);
            jSeparatorR1.setVisible(false);
            jSeparatorR2.setVisible(false);
        }

        jlNameUser.setText("Olá: " + user.getName() + ".");
        jlBoasVindas.setText("SEJA BEM-VINDO AO SISTEMA.");
    }//GEN-LAST:event_formWindowOpened

    private void jMenuRegisterGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegisterGoalActionPerformed
        ViewRegisterFinancialGoal vrfg = new ViewRegisterFinancialGoal(this, true);
        vrfg.setVisible(true);
    }//GEN-LAST:event_jMenuRegisterGoalActionPerformed

    private void jMenuRegisterIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegisterIncomeActionPerformed
        ViewRegisterIncome vri = new ViewRegisterIncome(this, true);
        vri.setVisible(true);
    }//GEN-LAST:event_jMenuRegisterIncomeActionPerformed

    private void jConsultListIncomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultListIncomesActionPerformed
        ViewListIncomes vli = new ViewListIncomes(this,true);
        vli.setVisible(true);
    }//GEN-LAST:event_jConsultListIncomesActionPerformed

    private void jMenuRegisterExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegisterExpenseActionPerformed
        ViewRegisterExpense vre = new ViewRegisterExpense(this, true);
        vre.setVisible(true);
    }//GEN-LAST:event_jMenuRegisterExpenseActionPerformed

    private void jConsultListExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultListExpensesActionPerformed
        ViewListExpenses vle = new ViewListExpenses(this,true);
        vle.setVisible(true);
    }//GEN-LAST:event_jConsultListExpensesActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitButtonActionPerformed
        formWindowOpened(null);
    }//GEN-LAST:event_jExitButtonActionPerformed

    private void jMenuConsultGoalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultGoalsActionPerformed
        ViewListFinancialGoals vlfg = new ViewListFinancialGoals(this, true);
        vlfg.setVisible(true);
    }//GEN-LAST:event_jMenuConsultGoalsActionPerformed

    private void jmnSystemReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSystemReportActionPerformed
        ViewSystemReport vsr = new ViewSystemReport(this, true);
        vsr.setVisible(true);
    }//GEN-LAST:event_jmnSystemReportActionPerformed

    private void jmnTransactionReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnTransactionReportsActionPerformed
        ViewTransactionReports vtr = new ViewTransactionReports(this, true);
        vtr.setVisible(true);
    }//GEN-LAST:event_jmnTransactionReportsActionPerformed

    private void jmnGoalsReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnGoalsReportsActionPerformed
        ViewGoalsReports vgr = new ViewGoalsReports(this,true);
        vgr.setVisible(true);
    }//GEN-LAST:event_jmnGoalsReportsActionPerformed

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
            java.util.logging.Logger.getLogger(viewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jConsultListExpenses;
    private javax.swing.JMenuItem jConsultListIncomes;
    private javax.swing.JButton jExitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConsultGoals;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuRegisterExpense;
    private javax.swing.JMenuItem jMenuRegisterGoal;
    private javax.swing.JMenuItem jMenuRegisterIncome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenuItem jRegisterClient;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparatorR1;
    private javax.swing.JPopupMenu.Separator jSeparatorR2;
    private javax.swing.JLabel jlBoasVindas;
    private javax.swing.JLabel jlNameUser;
    private javax.swing.JMenu jmnAjuda;
    private javax.swing.JMenu jmnCadastros;
    private javax.swing.JMenu jmnDespesas;
    private javax.swing.JMenuItem jmnGoalsReports;
    private javax.swing.JMenu jmnMetas;
    private javax.swing.JMenu jmnReceitas;
    private javax.swing.JMenu jmnRelatorios;
    private javax.swing.JMenuItem jmnSystemReport;
    private javax.swing.JMenuItem jmnTransactionReports;
    // End of variables declaration//GEN-END:variables

    private static User user;

    public static User getUser(){
        return user;
    }
}