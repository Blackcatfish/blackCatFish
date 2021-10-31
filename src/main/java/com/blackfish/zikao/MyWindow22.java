package com.blackfish.zikao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/13
 */
public class MyWindow22 extends JFrame implements ListSelectionListener {
    JList jList1,jList;
    String sports[]={"足球","棒球","羽毛球","乒乓球","排球","篮球"};
    String news[]={"央视新闻","人民日报","中华日报","安徽日报"};
    JTextArea jTextArea,jTextArea1;
    MyWindow22(String s){
        super(s);
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLUE);
        contentPane.setLayout(new GridLayout(2,2));
        contentPane.setSize(200,5000);
        jList=new JList(news);
        jList.setVisibleRowCount(3);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(this);
        jList.setBackground(Color.GRAY);
        jList1=new JList(sports);
        jList1.setVisibleRowCount(2);
        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList1.addListSelectionListener(this);
        jList1.setBackground(Color.orange);
        contentPane.add(jList);
        contentPane.add(jList1);
        jTextArea=new JTextArea(10,20);
        jTextArea.setBackground(Color.cyan);
        jTextArea1=new JTextArea(10,20);
        jTextArea1.setBackground(Color.pink);
        contentPane.add(jTextArea);
        contentPane.add(jTextArea1);
        this.setVisible(true);
        this.pack();

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource()==jList){
            jTextArea.setText("");
            Object selectedValue = ((JList) e.getSource()).getSelectedValue();
            String s = selectedValue.toString();
            for (int i = 0; i < news.length; i++) {
                if (news[i].equals(s)){
                    jTextArea.append(s);
                }
            }

        }else if (e.getSource()==jList1){
            jTextArea1.setText("");
            int temp[] =jList1.getSelectedIndices();
            for (int i = 0; i < temp.length; i++) {
                jTextArea1.append(sports[temp[i]]);
            }
        }

    }

    public static void main(String[] args) {
        MyWindow22 kkk = new MyWindow22("kkk");
    }
}
