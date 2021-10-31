package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/14
 */
public class MenuDemo extends JFrame implements ActionListener {
    public static JTextField jTextField;
    private void addItem(JMenu jMenu,String menuName,ActionListener listener){
        JMenuItem jMenuItem = new JMenuItem();
        jMenuItem.setActionCommand(menuName);
        jMenuItem.addActionListener(listener);
        jMenu.add(jMenuItem);
    }
    public MenuDemo(){
        setTitle("jjjj");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setLocation(100,200);
        this.setSize(100,200);
        JMenu jMenu = new JMenu("ji积极");
        addItem(jMenu,"任力是狗1",this);
        addItem(jMenu,"任力是狗2",this);
        addItem(jMenu,"任力是狗3",this);
        JMenu jMenu1 = new JMenu("任力是狗4");
        addItem(jMenu1,"任力是狗4",this);
        addItem(jMenu1,"任力是狗4",this);
        addItem(jMenu1,"任力是狗4",this);
        addItem(jMenu1,"任力是狗4",this);
        JMenuBar jMenuBar = new JMenuBar();
        jTextField=new JTextField();
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);
        contentPane.add(jTextField,BorderLayout.NORTH);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        jTextField.setText("菜单"+e.getActionCommand());
    }
}
