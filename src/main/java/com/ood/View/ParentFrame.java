package View;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;

/**
 *
 * @author revathivipinachandran
 */


public class ParentFrame extends javax.swing.JFrame {

    JPanel BackgroundPanel;
    JPanel SidePanel;
    JPanel TitlePanel;
    javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
    javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
    javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);




    /**
     * Creates new form BankJFrame
     */
    public ParentFrame() {
        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();

        BackgroundPanel.setLayout(BackgroundPanelLayout);
        SidePanel.setLayout(SidePanelLayout);
        TitlePanel.setLayout(TitlePanelLayout);
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
//                new View.ParentFrame().setVisible(true);
//            }
//        });
//    }


}
