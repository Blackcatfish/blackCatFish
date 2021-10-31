package com.blackfish.zikao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class Example5_8 extends JFrame implements ActionListener {
    static JTextField jTextField1,jTextField2;
    public Example5_8(){
        setSize(500,400);
        setTitle("5——8");
        jTextField1=new JTextField(10);
        jTextField2=new JTextField(10);
        add(jTextField1);
        add(jTextField2);
        jTextField1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jTextField1){
            long l = Long.parseLong(jTextField1.getText());
            jTextField2.setText(String.valueOf(l*l));
        }
    }

    public static void main(String[] args) {
        Example5_8 example5_8 = new Example5_8();
        example5_8.setVisible(true);
    }
}
