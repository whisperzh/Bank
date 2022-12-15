package com.ood.Views;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author newfashionedoats
 */
public class StocksOwned extends javax.swing.JFrame {

    /**
     * Creates new form StocksOwned
     */
    private ViewContainer viewContainer;
    public StocksOwned() {
        viewContainer=ViewContainer.getInstance();
        initComponents();
    }


        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            BackgroundPanel = new javax.swing.JPanel();
            TitlePanel = new javax.swing.JPanel();
            jLabel16 = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();
            jButton5 = new javax.swing.JButton();
            jButton6 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            BackgroundPanel.setBackground(new java.awt.Color(234, 227, 227));
            BackgroundPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));

            TitlePanel.setBackground(new java.awt.Color(252, 250, 250));
            TitlePanel.setPreferredSize(new java.awt.Dimension(900, 52));

            jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
            jLabel16.setForeground(new java.awt.Color(102, 0, 51));
            jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel16.setText("STOCK INFORMATION");
            jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
            TitlePanel.setLayout(TitlePanelLayout);
            TitlePanelLayout.setHorizontalGroup(
                    TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TitlePanelLayout.createSequentialGroup()
                                    .addGap(464, 464, 464)
                                    .addComponent(jLabel16)
                                    .addContainerGap(711, Short.MAX_VALUE))
            );
            TitlePanelLayout.setVerticalGroup(
                    TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TitlePanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(102, 102, 102));
            jLabel1.setText("Latest Stock Prices");

            jTable1.setBackground(new java.awt.Color(234, 234, 234));
            jTable1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                    },
                    new String [] {
                            "Company Name", "Price", "Stocks Bought", "Stocks Value Owned"
                    }
            ));
            jScrollPane1.setViewportView(jTable1);

            jButton5.setBackground(new java.awt.Color(238, 86, 34));
            jButton5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
            jButton5.setForeground(new java.awt.Color(224, 240, 234));
            jButton5.setText("Sell Stocks");
            jButton5.setBorderPainted(false);
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            jButton6.setBackground(new java.awt.Color(238, 86, 34));
            jButton6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
            jButton6.setForeground(new java.awt.Color(224, 240, 234));
            jButton6.setText("DashBoard");
            jButton6.setBorderPainted(false);
            jButton6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton6ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
            BackgroundPanel.setLayout(BackgroundPanelLayout);
            BackgroundPanelLayout.setHorizontalGroup(
                    BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1443, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1)))
            );
            BackgroundPanelLayout.setVerticalGroup(
                    BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1449, Short.MAX_VALUE)
                                    .addGap(34, 34, 34))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            viewContainer.getPage("SellStocks").setVisible(true);
            this.setVisible(false);
        }

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            viewContainer.getPage("CustomerDashboard").setVisible(true);
            this.setVisible(false);
        }

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
                java.util.logging.Logger.getLogger(StocksOwned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(StocksOwned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(StocksOwned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(StocksOwned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new StocksOwned().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JPanel BackgroundPanel;
        private javax.swing.JPanel TitlePanel;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        // End of variables declaration
    }
