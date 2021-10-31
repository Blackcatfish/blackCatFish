package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/24
 */
public class Exmaple7_2 extends JFrame {
    @Override
    public void paint(Graphics g) {
        setSize(380,200);
        for (int i = 0; i <= 10; i++) {
            Color color = new Color(i * 25 + 5, 0, 0);
            g.setColor(color);
            g.fillRect(i*32+5,2,28,28);
        }
        for (int i = 0; i <= 10; i++) {
            Color color = new Color(0,i * 25 + 5, 0);
            g.setColor(color);
            g.fillRect(i*32+5,32,28,28);
        }
        for (int i = 0; i <= 10; i++) {
            Color color = new Color(0, 0,i * 25 + 5);
            g.setColor(color);
            g.fillRect(i*32+5,62,28,28);
        }
        g.draw3DRect(10,20,30,40,true);
        repaint();
    }

    public static void main(String[] args) {
        Exmaple7_2 exmaple7_2 = new Exmaple7_2();
        exmaple7_2.setVisible(true);
    }
}
