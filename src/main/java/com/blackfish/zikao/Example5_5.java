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
public class Example5_5 {
    public static void main(String[] args) {
        JLabel label1,label2,label3,label4,label5;
        JFrame mw=new JFrame("我是一个窗口");
        mw.setSize(250,200);
        Container contentPane = mw.getContentPane();
        contentPane.setLayout(new BorderLayout());
        label1=new JLabel("东");
        label2=new JLabel("南",JLabel.CENTER);
        label3=new JLabel("西");
        label4=new JLabel("北",JLabel.CENTER);
        label5=new JLabel("中",JLabel.CENTER);
        contentPane.add(label1,"East");
        contentPane.add(label2,"South");
        contentPane.add(label3,"West");
        contentPane.add(label4,"North");
        contentPane.add(label5,"Center");
        mw.setVisible(true);

    }
}
