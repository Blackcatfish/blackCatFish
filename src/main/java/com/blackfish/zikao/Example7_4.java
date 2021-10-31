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
public class Example7_4 extends JFrame {
    public static void main(String[] args) {
        GraphicsDemo graphicsDemo = new GraphicsDemo();
    }

    static class ShapesDemo extends JPanel {
        ShapesDemo() {
            setBackground(Color.orange);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.cyan);
            g.setXORMode(Color.BLUE);
            g.setColor(Color.YELLOW);
            g.fillRect(20, 20, 80, 40);
            g.setColor(Color.pink);
            g.fillRect(60, 20, 80, 40);
            g.setColor(Color.GREEN);
            g.fillRect(20, 70, 80, 40);
            g.fillRect(60, 70, 80, 40);
            g.setColor(Color.green);
            g.drawLine(80,100,180,200);
            g.drawLine(100,100,200,200);
            g.drawLine(140,140,200,200);
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(20,30,160,30);
            g.drawLine(20,75,160,75);
        }
    }
    static class GraphicsDemo extends JFrame{
        public GraphicsDemo(){
            this.getContentPane().add(new ShapesDemo());
            setTitle("jjoj");
            setSize(500,200);
            setVisible(true);
        }
    }
}
