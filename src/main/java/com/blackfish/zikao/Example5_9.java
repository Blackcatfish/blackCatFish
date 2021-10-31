package com.blackfish.zikao;

import io.swagger.models.auth.In;
import org.checkerframework.checker.units.qual.K;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class Example5_9 extends JFrame implements ActionListener {
    JTextArea textArea;
    JTextField jTextField;
    JButton jButton,jButton2;
    public Example5_9(){
        setSize(250,150);
        textArea=new JTextArea("",5,1);
        textArea.setBackground(Color.cyan);
        jTextField=new JTextField("",10);
        jTextField.setBackground(Color.PINK);
        jButton=new JButton("求和");
        jButton2=new JButton("重新开始");
        jTextField.setEnabled(false);
        jButton.addActionListener(this);
        jButton2.addActionListener(this);
        add(textArea);
        add(jTextField);
        add(jButton);
        add(jButton2);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton){
            String text = textArea.getText();
            StringTokenizer stringTokenizer = new StringTokenizer(text);
            int n = stringTokenizer.countTokens() ,sum=0,i;
            for (i = 0; i <n-1 ; i++) {
                String tmp = stringTokenizer.nextToken();
                sum+=Integer.parseInt(tmp);
            }
            jTextField.setText(sum+"");
        }else if (e.getSource()==jButton2){
            textArea.setText(null);
            jTextField.setText(null);
        }
    }

    public static void main(String[] args) {
        Example5_9 example5_9 = new Example5_9();
        example5_9.setVisible(true);
    }
}
