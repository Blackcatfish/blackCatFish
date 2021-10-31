package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/24
 */
public class Example7_5 extends JFrame {
    Image image;

    public Example7_5() {
        Image myImage = getIconImage();
        image = createImage(size().width, size().height);
        Graphics graphics = image.getGraphics();
        boolean b = graphics.drawImage(image, 0, 0, this);
        BufferedDemo bufferedDemo = new BufferedDemo(myImage);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        if (infoflags == ALLBITS) {

            repaint();
            return false;
        }
        return true;
    }

    static class BufferedDemo extends JFrame {
        public BufferedDemo(Image img) {
            getContentPane().add(new PicPanel(img));
            setTitle("缓冲");
            setSize(300, 300);
            setVisible(true);
        }
    }

    static class PicPanel extends JPanel implements MouseListener, MouseMotionListener {
        int x = 0, y = 0, k = 0, z = 0;
        BufferedImage image, image2;
        boolean update = true;

        public PicPanel(Image img) {
            setBackground(Color.cyan);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            image = new BufferedImage(img.getWidth(this), img.getHeight(this), BufferedImage.TYPE_INT_ARGB);
            image2 = new BufferedImage(img.getWidth(this), img.getHeight(this), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            Graphics2D graphics1 = image2.createGraphics();
            graphics.drawImage(img, 0, 0, this);
            graphics1.drawImage(img, 0, 0, this);
            graphics1.drawRect(1, 1, img.getWidth(this) - 3, img.getHeight(this) - 3);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            if (update) {
                graphics2D.drawImage(image, x, y, this);
            } else {
                graphics2D.drawImage(image2, x, y, this);

            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getX() >= x && e.getX() < x + image.getWidth(this) && e.getY() >= y && e.getY() < y + image2.getHeight(this)) {
                update = false;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                k=e.getX()-x;
                z=e.getY()-y;
                repaint();
            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
if (update){
    x=e.getX()-k;
    y=e.getY()-z;
    repaint();
}
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        Example7_5 example7_5 = new Example7_5();
        example7_5.setVisible(true);
    }
}
