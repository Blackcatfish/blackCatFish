package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/21
 */
public class JDialogDemo extends JFrame implements ActionListener {
    private JButton jButton, jButton1;
    private static int flag = 0;
    private static JTextField field, field1;

    JDialogDemo(String s) {
        super(s);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        this.setSize(200, 100);
        this.setLocation(100, 100);
        jButton = new JButton("选择水果");
        jButton1 = new JButton("选择食品");
        jButton.addActionListener(this);
        jButton1.addActionListener(this);
        field = new JTextField(20);
        field1 = new JTextField(20);
        contentPane.add(jButton);
        contentPane.add(jButton1);
        contentPane.add(field);
        contentPane.add(field1);
        this.setVisible(true);
        this.pack();
    }

    public static void returnName(String s) {
        if (flag == 1) {
            field.setText("选择的水果:" + s);

        }
        if (flag == 2) {
            field1.setText("选择的食品：" + s);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyDialog myDialog;
        if (e.getSource() == jButton) {
            myDialog=new MyDialog(this,"水果");
            myDialog.setVisible(true);
            flag=1;
        }
        if (e.getSource() == jButton1) {
            myDialog=new MyDialog(this,"食品");
            myDialog.setVisible(true);
            flag=2;
        }
    }

    class MyDialog extends JDialog implements ActionListener {
        JLabel jLabel;
        JTextField jTextField;
        JButton jButton;

        MyDialog(JFrame jFrame, String s) {
            super(jFrame, s);
            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());
            contentPane.setBackground(Color.LIGHT_GRAY);
            jLabel = new JLabel("输入" + s + "名称");
            jTextField = new JTextField(10);
            jTextField.setEnabled(false);
            contentPane.setSize(200, 100);
            setModal(false);
            jButton = new JButton("确定");
            jButton.addActionListener(this);
            contentPane.add(jLabel);
            contentPane.add(jButton);
            contentPane.add(jTextField);
            setVisible(true);
            pack();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton) {
                JDialogDemo.returnName(jTextField.getText());
                setVisible(false);
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        new JDialogDemo("对话窗口");
    }
}
