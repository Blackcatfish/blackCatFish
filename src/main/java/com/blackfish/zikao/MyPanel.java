package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/9
 */
public class MyPanel extends JPanel {
    JButton button1,button2;
    JLabel jLabel1;
    MyPanel(String s1,String s2,String s3){
        button1=new JButton(s1); button2=new JButton(s2);
        jLabel1=new JLabel(s3);
        add(button1);
        add(button2);
        add(jLabel1);
    }

    public static void main(String[] args) {
        MyPanel myPanel,myPanel1;
        JButton jButton;
        myPanel=new MyPanel("确定","取消","标签我在1中");
        myPanel1=new MyPanel("确定","取消","标签我在2中");
        jButton=new JButton("我是个按钮");
        Container container = new Container();
        container.add(myPanel);
        container.add(myPanel1);
        container.add(jButton);
        container.setSize(300,200);
        container.setVisible(true);
    }
}
