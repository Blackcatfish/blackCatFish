package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class MYPanel2 extends JPanel {
    int x;
JLabel jLabel;
MYPanel2(int a){
        x=a;
        getSize();
        jLabel=new JLabel("我是第"+x+"个标签");
        add(jLabel);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,50);
    }

    public static void main(String[] args) {
        int i=8;
        String s="ABCDEFG";
        System.out.println(s.substring(3)+s.substring(3,5));
        switch (i){
            default:
                System.out.println("ll");
            case 0:
                System.out.println("ljjjj");
                break;
            case 1:
                System.out.println("kkk");
        }

    }
}
