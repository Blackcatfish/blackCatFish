package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MineWindow extends JFrame implements ItemListener {
        MinePanel minePanel;
        MinePanel2 minePanel2;
        JLabel label1, label2;
        JTextArea jTextArea,textArea;
        static String fName[]={"惠普","戴尔","华为"};
        static double priTbl[][]={{1.2,0.2,235},{2.5,53.2,56.4},{25.2,52.5,45.3}};
        static int production=-1;
        MineWindow(String s){
                super(s);
                Container contentPane = this.getContentPane();
                contentPane.setLayout(new GridLayout(3,2));
                this.setLocation(100,100);
                this.setSize(400,100);
                minePanel=new MinePanel();
                minePanel2=new MinePanel2();
                label1=new JLabel("产品",JLabel.CENTER);
                label2=new JLabel("价格",JLabel.CENTER);
                textArea=new JTextArea();
                jTextArea=new JTextArea();
                contentPane.add(label1);
                contentPane.add(label2);
                contentPane.add(jTextArea);
                contentPane.add(textArea);
                contentPane.add(minePanel);
                contentPane.add(minePanel2);
                minePanel.button1.addItemListener(this);
                minePanel.button2.addItemListener(this);
                minePanel.button3.addItemListener(this);
                minePanel2.jCheckBox1.addItemListener(this);
                minePanel2.jCheckBox2.addItemListener(this);
                minePanel2.jCheckBox3.addItemListener(this);
                this.setVisible(true);
                this.pack();
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
                if (e.getItemSelectable() == minePanel.button1) {
                        production = 0;
                        jTextArea.setText(fName[0] + "jjjjj");
                        System.out.println(jTextArea.getText());
                        textArea.setText("");
                } else if (e.getItemSelectable() == minePanel.button2) {
                        production = 1;
                        jTextArea.setText(fName[1] + "jjjjj");
                        textArea.setText("");
                } else if (e.getItemSelectable() == minePanel.button2) {
                        production = 2;
                        jTextArea.setText(fName[2] + "jjjjj");
                        textArea.setText("");
                }else {
                        if (production==-1) return;
                        if (e.getItemSelectable()==minePanel2.jCheckBox1){
                                textArea.setText("kkokoo"+priTbl[production][0]);
                        }
                        if (e.getItemSelectable()==minePanel2.jCheckBox2){
                                textArea.setText("kkokoo"+priTbl[production][1]);
                        }
                        if (e.getItemSelectable()==minePanel2.jCheckBox3){
                                textArea.setText("kkokoo"+priTbl[production][2]);
                        }
                }
        }

        public static void main(String[] args) {
                MineWindow jjsij = new MineWindow("jjsij");
        }
}