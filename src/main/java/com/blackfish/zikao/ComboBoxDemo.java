package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/14
 */
public class ComboBoxDemo extends JFrame implements ActionListener, ItemListener {
    public static final int width=350;
    public static final int height=150;
    String sports[]={"足球","篮球","乒乓球"};
    JTextField jTextField;
    JComboBox comboBox;
    public ComboBoxDemo(){
        setSize(width,height);
        setTitle("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(new FlowLayout());
        comboBox=new JComboBox(sports);
        comboBox.addActionListener(this);
        comboBox.addItemListener(this);
        comboBox.setEditable(true);
        contentPane.add(comboBox);
        jTextField=new JTextField(10);
        contentPane.add(jTextField);
        this.setVisible(true);
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboBox){
            jTextField.setText(comboBox.getSelectedItem().toString());
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboBox){
            jTextField.setText(comboBox.getSelectedItem().toString());
        }
    }

    public static void main(String[] args) {
        ComboBoxDemo comboBoxDemo = new ComboBoxDemo();
    }
}
