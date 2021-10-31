package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/21
 */
public class Problem1 extends JFrame implements ItemListener {
    JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4;
    JTextField jTextField;

    public Problem1() {
        Container r = getContentPane();
        r.setLayout(new BorderLayout());
        r.setSize(200, 200);
        jCheckBox1 = new JCheckBox("足球");
        jCheckBox2 = new JCheckBox("篮球");
        jCheckBox3 = new JCheckBox("篮球2");
        jCheckBox4 = new JCheckBox("篮球3");
        jTextField = new JTextField();
        r.add(jCheckBox1);
        r.add(jCheckBox2);
        r.add(jCheckBox3);
        r.add(jCheckBox4);
        r.add(jTextField);
        add(jCheckBox1);
        add(jCheckBox2);
        add(jCheckBox3);
        add(jCheckBox4);
        add(jTextField);
        setSize(500,200);
        setVisible(true);
        pack();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jCheckBox1) {
            jTextField.setText(jCheckBox1.getText());
        }
        if (e.getSource() == jCheckBox2) {
            jTextField.setText(jCheckBox2.getText());
        }
        if (e.getSource() == jCheckBox3) {
            jTextField.setText(jCheckBox3.getText());
        }
        if (e.getSource() == jCheckBox4) {
            jTextField.setText(jCheckBox4.getText());
        }
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
    }
}
