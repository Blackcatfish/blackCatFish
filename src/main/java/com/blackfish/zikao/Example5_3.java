package com.blackfish.zikao;

import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/9
 */
public class Example5_3 {
    public static void main(String[] args) {
        ButtonDemo buttonDemo = new ButtonDemo();
        buttonDemo.setVisible(true);
    }
    static class ButtonDemo extends JFrame implements ActionListener {
            public static final int width=250;
            public static final int height=200;
            ButtonDemo(){
                setSize(width,height);
                Container contentPane = getContentPane();
                contentPane.setBackground(Color.BLUE);
                //采用FlowLayout布局
                contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
                JButton redButton = new JButton("Red");
                redButton.addActionListener(this);
                contentPane.add(redButton);
                JButton greenButton = new JButton("Green");
                greenButton.addActionListener(this);
                contentPane.add(greenButton);
                setLayout(new FlowLayout(FlowLayout.CENTER));



            }
        @Override
        public void actionPerformed(ActionEvent e) {
            Container contentPane = getContentPane();
            if ("Red".equals(e.getActionCommand())){
                contentPane.setBackground(Color.RED);
            }

            if ("Green".equals(e.getActionCommand())){
                contentPane.setBackground(Color.GREEN);
            }

        }
    }
}
