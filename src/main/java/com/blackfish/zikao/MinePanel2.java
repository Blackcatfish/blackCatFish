package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

class MinePanel2 extends JPanel {
        JCheckBox jCheckBox1, jCheckBox2, jCheckBox3;
        ButtonGroup group;

        MinePanel2() {
            setLayout(new GridLayout(1, 3));
            group = new ButtonGroup();
            jCheckBox1 = new JCheckBox("购买1台");
            jCheckBox2 = new JCheckBox("购买2台");
            jCheckBox3 = new JCheckBox("购买3台");
            group.add(jCheckBox1);
            group.add(jCheckBox2);
            group.add(jCheckBox3);
            add(jCheckBox1);
            add(jCheckBox2);
            add(jCheckBox3);
            add(new JLabel("多选"));
        }
    }