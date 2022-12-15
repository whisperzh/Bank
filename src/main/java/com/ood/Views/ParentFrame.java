package com.ood.Views;

import javax.swing.*;

/**
 *  This class allows us to create a new form BankJFrame
 */
public class ParentFrame extends javax.swing.JFrame {

    JPanel BackgroundPanel;
    JPanel SidePanel;
    JPanel TitlePanel;

    public javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
    public javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
    public javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
    public javax.swing.GroupLayout layout;


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

        layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank ATM");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setVisible(true);
    }
}
