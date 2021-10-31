package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/21
 */
public class MouseWindow extends JPanel {
    public void print(int r) {
        Graphics graphics = getGraphics();
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillOval(10, 10, r, r);
    }

    static class MyMouseWindow extends JFrame implements MouseListener {
        JTextArea jTextField;
        MouseWindow mouseWindow;
        int x, y, r = 10;
        int mouseFlag = 0;
        static String mouseSates[] = {"鼠标按下", "鼠标松开", "鼠标进来", "鼠标离开", "鼠标双击", "鼠标滚轮"};
MyMouseWindow (String s){
    super(s);
    Container contentPane = getContentPane();
    contentPane.setBackground(Color.pink);
    contentPane.setSize(200,500);
    contentPane.setLayout(new GridLayout(1,2));
    this.setLocation(100,200);
    this.setSize(10,20);
    mouseWindow=new MouseWindow();
    contentPane.add(mouseWindow);
    jTextField=new JTextArea(100,200);
    jTextField.setBackground(Color.orange);
    contentPane.add(jTextField);
    addMouseListener(this);
    setVisible(true);
    pack();




}
public void paint(Graphics graphics){
    jTextField.setText(mouseSates[mouseFlag]+"了，位置："+x+"y:"+y);

}
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                x = e.getX();
                y = e.getY();
                mouseFlag = 4;
                repaint();
            } else {
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x=e.getX();
            y=e.getY();
            mouseFlag=0;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x=e.getX();
            y=e.getY();
            mouseFlag=1;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            x=e.getX();
            y=e.getY();
            mouseFlag=2;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            x=e.getX();
            y=e.getY();
            mouseFlag=3;
            repaint();
        }
    }

    public static void main(String[] args) {
        new MyMouseWindow("鼠标00");
    }
}
