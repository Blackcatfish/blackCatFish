package com.blackfish.zikao;

import java.applet.Applet;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/8
 */
public class Example3_20 extends Applet {
    int pos;
    public void  init(){
        pos=5;
    }
    public void start (){
        repaint();
    }
    public void stop(){}
    public void paint(Graphics g){
        g.drawString("你好",20,pos);
        pos=(pos+20)%100+5;
    }

}
