package com.blackfish.zikao;

import javax.swing.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/12
 */
public class Panel1 extends JFrame {
    JCheckBox jCheckBox,jCheckBox1,jCheckBox2;
    public Panel1(){
        setSize(50,200);
        jCheckBox=new JCheckBox("kj");
        jCheckBox1=new JCheckBox("jj");
        jCheckBox2=new JCheckBox("kk");
        JRadioButton jRadioButton=new JRadioButton("Jj");
        add(jCheckBox1);
        add(jCheckBox);
//        add(jRadioButton);

    }

    public static void main(String[] args) {
        Panel1 panel1 = new Panel1();
        panel1.setVisible(true);
    }
}
