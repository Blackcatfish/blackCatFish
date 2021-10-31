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
public class Example5_2 {
    static MyWindow window;
    static MyWindow myWindow;

    public static void main(String[] args) {
        JButton jButton = new JButton("我是按钮");
        String s = "我是第一个窗口";
        String str = "我是第二个窗口";
        myWindow = new MyWindow(s, jButton, Color.cyan, 100, 200);
        myWindow.setVisible(true);
        window = new MyWindow(s, jButton, Color.cyan, 100, 200);
        window.setVisible(true);
    }

    static class MyWindow extends JFrame {
        public MyWindow(String name, JButton jButton, Color color, int w, int h) {
            super();
            setTitle(name);
            setSize(w,h);
            Container contentPane = getContentPane();
            contentPane.add(jButton);
            contentPane.setBackground(color);
        }
    }
}
