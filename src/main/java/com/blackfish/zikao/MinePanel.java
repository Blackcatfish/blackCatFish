package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/13
 */
public class MinePanel extends JPanel {
    JRadioButton button1, button2, button3;
    ButtonGroup group;

    MinePanel() {
        setLayout(new GridLayout(1, 3));
        group = new ButtonGroup();
        button1 = new JRadioButton(MineWindow.fName[0] + "计算机", false);
        button2 = new JRadioButton(MineWindow.fName[1] + "计算机", false);
        button3 = new JRadioButton(MineWindow.fName[2] + "计算机", false);
        group.add(button1);
        group.add(button2);
        group.add(button3);
        add(button1);
        add(button2);
        add(button3);
        add(new JLabel("计算机三选一"));
    }




}
