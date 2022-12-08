package com.ood.View;

public class CommonPage {

    protected ParentFrame frame = new ParentFrame();


    public CommonPage(){
        initComponents();
    }

    public void initComponents(){

        frame.BackgroundPanel.setBackground(new java.awt.Color(234, 227, 227));
        frame.BackgroundPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));

        frame.SidePanel.setBackground(new java.awt.Color(102, 0, 0));


        frame.SidePanelLayout.setHorizontalGroup(
                frame.SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 331, Short.MAX_VALUE)
        );
        frame.SidePanelLayout.setVerticalGroup(
                frame.SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1079, Short.MAX_VALUE)
        );

        frame.TitlePanel.setBackground(new java.awt.Color(252, 250, 250));
        frame.TitlePanel.setPreferredSize(new java.awt.Dimension(900, 52));

        frame.TitlePanelLayout.setHorizontalGroup(
                frame.TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1583, Short.MAX_VALUE)
        );
        frame.TitlePanelLayout.setVerticalGroup(
                frame.TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 52, Short.MAX_VALUE)
        );

        frame.BackgroundPanelLayout.setHorizontalGroup(
                frame.BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame.BackgroundPanelLayout.createSequentialGroup()
                                .addComponent(frame.SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frame.TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1583, Short.MAX_VALUE))
        );
        frame.BackgroundPanelLayout.setVerticalGroup(
                frame.BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frame.BackgroundPanelLayout.createSequentialGroup()
                                .addComponent(frame.TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(615, 1027, Short.MAX_VALUE))
                        .addComponent(frame.SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frame.layout.setHorizontalGroup(
                frame.layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(frame.BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame.layout.setVerticalGroup(
                frame.layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frame.layout.createSequentialGroup()
                                .addComponent(frame.BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(View.ParentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(View.ParentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(View.ParentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(View.ParentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                frame.setVisible(true);
//            }
//        });
//    }

    /* Create and display the form */



}
