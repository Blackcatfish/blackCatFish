package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/8
 */
public class Example5_1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("我是一个窗口");
        jFrame.setSize(250,200);
        JButton jButton = new JButton("我是按钮");
        jButton.setBackground(Color.cyan);
        jFrame.getContentPane().setBackground(Color.BLUE);
        jFrame.getContentPane().add(jButton);
        jFrame.setVisible(true);

    }
}
