package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class MyWindow extends JFrame {
    public MyWindow(int w, int h) {
        setTitle("面板滚动示例");
        Container contentPane = getContentPane();
        contentPane.setPreferredSize(new Dimension());
        contentPane.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout());
        for (int i = 0; i < 6; i++) {
            jPanel.add(new JLabel());
            for (int j = 1; j < 2; j++) {
                jPanel.add(new JButton("按钮"+(2*i+j)));
                jPanel.add(new JLabel("标签"+(2*i+j)));
            }
            jPanel.add(new JLabel());
        }
        jPanel.setBackground(Color.CYAN);
        jPanel.setPreferredSize(new Dimension(w+60,h+60));
        JScrollPane scrollPane = new JScrollPane(jPanel);
        scrollPane.setPreferredSize(new Dimension(w-60,h-60));
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
        pack();
    }
    class ScrollPane extends JScrollPane{
        public ScrollPane(Component component){
            super(component);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }
    }

    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow(430, 350);
    }
}
