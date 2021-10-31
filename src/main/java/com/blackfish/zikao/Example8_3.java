package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

public class Example8_3 extends JFrame implements Runnable {//实现 Runnable 接口
    Thread redBall, blueBall;
    Graphics redPen, bluePen;
    int blueSeta = 0, redSeta = 0;

    public Example8_3() {
        setSize(250, 200);
        redBall = new Thread(this);
        blueBall = new Thread(this);
        redPen = getGraphics();
        bluePen = getGraphics();
        redPen.setColor(Color.red);
        bluePen.setColor(Color.blue);
        setBackground(Color.gray);
    }

    public void start() {
        redBall.start();
        blueBall.start();
    }

    public void run() {//定义线程的运行代码
        int x, y;
        while (true) {
            if (Thread.currentThread() == redBall) {
                x = (int) (80.0 * Math.cos(3.1415926 / 180.0 * redSeta));
                y = (int) (80.0 * Math.sin(3.1415926 / 180.0 * redSeta));
                redPen.setColor(Color.gray);//用底色画圆，擦除原先所画圆点
                redPen.fillOval(100 + x, 100 + y, 10, 10);
                redSeta += 3;
                if (redSeta >= 360) redSeta = 0;
                x = (int) (80.0 * Math.cos(3.1415926 / 180.0 * redSeta));
                y = (int) (80.0 * Math.sin(3.1415926 / 180.0 * redSeta));
                redPen.setColor(Color.red);
                redPen.fillOval(100 + x, 100 + y, 10, 10);
                try {
                    redBall.sleep(20);
                } catch (InterruptedException e) {
                }

            } else if (Thread.currentThread() == blueBall) {
                x = (int) (80.0 * Math.cos(3.1415926 / 180.0 * blueSeta));
                y = (int) (80.0 * Math.sin(3.1415926 / 180.0 * blueSeta));
                bluePen.setColor(Color.gray);//用底色画圆，擦除原先所画圆点
                bluePen.fillOval(150 + x, 100 + y, 10, 10);
                blueSeta -= 3;
                if (blueSeta <= -360) blueSeta = 0;
                x = (int) (80.0 * Math.cos(3.1415926 / 180.0 * blueSeta));
                y = (int) (80.0 * Math.sin(3.1415926 / 180.0 * blueSeta));
                bluePen.setColor(Color.blue);
                bluePen.fillOval(150 + x, 100 + y, 10, 10);
                try {
                    blueBall.sleep(40);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Example8_3 example8_3 = new Example8_3();
        example8_3.setVisible(true);
    }
}