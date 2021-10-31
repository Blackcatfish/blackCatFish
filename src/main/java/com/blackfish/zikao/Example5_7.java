package com.blackfish.zikao;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class Example5_7 extends JFrame implements ActionListener {
    CardLayout cardLayout;
    MYPanel2[] myPanel2s;
    JPanel jPanel;
    private void addButton(JPanel jPanel,String butName,ActionListener listener){
        JButton jButton = new JButton(butName);
        jButton.setActionCommand(butName);
        jButton.addActionListener(listener);
        jPanel.add(jButton);
    }
    public  Example5_7(){
        setLayout(new BorderLayout());
        cardLayout=new CardLayout();
        setSize(400,500);
        setTitle("示例");
        jPanel=new JPanel();
        jPanel.setLayout(cardLayout);
        myPanel2s=new MYPanel2[10];
        for (int i = 0; i < myPanel2s.length; i++) {
            myPanel2s[i]=new MYPanel2(i+1);
            jPanel.add("A"+i,myPanel2s[i]);
        }
        JPanel jPanel1 = new JPanel();
        addButton(jPanel1,"第一个",this);
        addButton(jPanel1,"最后一个",this);
        addButton(jPanel1,"前一个",this);
        addButton(jPanel1,"后一个",this);
        add(jPanel,"Center");
        add(jPanel1,"South");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("第一个".equals(e.getActionCommand())) cardLayout.first(jPanel);
        if ("最后一个".equals(e.getActionCommand())) cardLayout.last(jPanel);
        if ("前一个".equals(e.getActionCommand())) cardLayout.previous(jPanel);
        if ("后一个".equals(e.getActionCommand())) cardLayout.next(jPanel);
    }

    public static void main(String[] args) {
        Example5_7 example5_7 = new Example5_7();
        example5_7.setVisible(true);
    }
}
