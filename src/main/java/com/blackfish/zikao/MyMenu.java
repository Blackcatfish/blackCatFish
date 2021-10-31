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
 * @Date: 2021/9/14
 */
public class MyMenu extends JFrame implements ActionListener {
    MenuDemo menuDemo;
    JButton jButton;
    boolean flag;
    public MyMenu(){
        jButton=new JButton("打开");
        flag=true;
        menuDemo = new MenuDemo();
        jButton.addActionListener(this);
        Container contentPane = getContentPane();
        contentPane.add(jButton);
        contentPane.setBackground(Color.GRAY);
        setVisible(true);
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton){
            if (flag){
                menuDemo.setVisible(true);
                flag=false;
                jButton.setLabel("关闭");
            }else {

                    menuDemo.setVisible(false);
                    flag=true;
                    jButton.setLabel("打开");

            }
        }
    }

    public static void main(String[] args) {
        MyMenu myMenu = new MyMenu();
    }
}
