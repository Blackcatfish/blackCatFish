package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/21
 */
public class MyMouseListener extends JFrame {
    public MyMouseListener(String s) {
        super(s);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setLocation(100, 100);
        JScrollBar xAxis = new JScrollBar(JScrollBar.HORIZONTAL, 50, 1, 0, 100);
        JScrollBar yAxis = new JScrollBar(JScrollBar.VERTICAL, 50, 1, 0, 100);
        MyListener myListener = new MyListener(xAxis, yAxis, 238, 118);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(myListener, BorderLayout.CENTER);
        jPanel.add(xAxis, BorderLayout.SOUTH);
        jPanel.add(yAxis, BorderLayout.EAST);
        contentPane.add(jPanel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    public Dimension gg() {
        return new Dimension(500, 200);
    }

    static class MyListener extends JComponent implements MouseListener, MouseMotionListener, AdjustmentListener {
        private int x, y;
        private JScrollBar xjScrollBar, yjScrollBar;

        private void update(int x, int y) {
            int d;
            d = (int) ((float) x / (float) getSize().width * 100);
            xjScrollBar.setValue(d);
            d = (int) ((float) x / (float) getSize().height * 100);
            yjScrollBar.setValue(d);
        }

        public MyListener(JScrollBar xaxis, JScrollBar yAxis, int x1, int y1) {
            xjScrollBar = xaxis;
            yjScrollBar = yAxis;
            x = x1;
            y = y1;
            xjScrollBar.addAdjustmentListener(this);
            yjScrollBar.addAdjustmentListener(this);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        public void paint(Graphics graphics) {
            graphics.setColor(getBackground());
            graphics.fillOval(0, 0, getSize().width, getSize().height);
            graphics.setColor(Color.BLUE);
            graphics.fillRect(x, y, 50, 50);
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
           if (e.getSource()==xjScrollBar){
                 x=(int)((float)(xjScrollBar.getValue()/100)*getSize().width);
                 repaint();
            }
            if (e.getSource()==xjScrollBar){
                y=(int)((float)(xjScrollBar.getValue()/100)*getSize().height);
                repaint();
            }


        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            update(x, y);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            update(x, y);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        MyMouseListener myMouseListener = new MyMouseListener("jj");

    }
}
