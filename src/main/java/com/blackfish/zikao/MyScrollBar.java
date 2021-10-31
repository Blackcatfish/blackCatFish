package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/21
 */
public class MyScrollBar extends JScrollBar {
    public MyScrollBar(int init, int len, int low, int height) {
        super(JScrollBar.HORIZONTAL, init, len, low, height);
    }

    public Dimension getPreferedSize() {
        return new Dimension(125, 20);
    }

    static class MyScrollBarWindow extends JFrame implements ActionListener, AdjustmentListener {
        private JButton jButton;
        private JTextField jTextField;
        private boolean barOperated;

        MyScrollBarWindow(String s) {
            super(s);
            MyScrollBar myScrollBar = new MyScrollBar(10, 10, 0, 255);
            Container contentPane = getContentPane();
            contentPane.setBackground(Color.LIGHT_GRAY);
            contentPane.setSize(200, 500);
            contentPane.setLayout(new GridLayout(2, 1));
            contentPane.setLocation(200, 400);
            jButton = new JButton("开关滚动条");
            jButton.addActionListener(this);
            barOperated = false;
            myScrollBar.addAdjustmentListener(this);
            jTextField = new JTextField("急急急0");
            contentPane.add(jButton);
            contentPane.add(jTextField);
            contentPane.setVisible(true);
            setVisible(true);
            pack();


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton) {
                if (barOperated) {
                    jTextField.setText("积极");
                    barOperated = !barOperated;

                } else {
                    jTextField.setText("关闭00");
                    barOperated = !barOperated;
                }
            }
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if (barOperated) {
                MyScrollBar adjustable = (MyScrollBar) e.getAdjustable();
                jTextField.setText("讲哦哦就"+adjustable.getValue());
            }
        }
    }

    public static void main(String[] args) {
        MyScrollBarWindow 滚动条 = new MyScrollBarWindow("滚动条");
    }
}
