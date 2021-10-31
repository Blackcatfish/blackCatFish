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
public class Exmaple7_3 extends JFrame {
    int i=1;
    public Exmaple7_3(){
        setBackground(Color.YELLOW);
    }

    @Override
    public void paint(Graphics g) {
        i=i+8;
        if (i>160){
            i=1;
        }
        g.setColor(Color.red);
        g.fillRect(i,10,20,20);
        g.drawString("jjiji",100,100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {

        g.clearRect(i,10,200,100);
        paint(g);
    }

    public static void main(String[] args) {
        Exmaple7_3 exmaple7_3 = new Exmaple7_3();
        exmaple7_3.setVisible(true);
    }
}
