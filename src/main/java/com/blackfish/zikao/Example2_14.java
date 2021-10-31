package com.blackfish.zikao;

import javax.swing.*;
import java.awt.*;

/**
 * @Description: 列出星号
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/7
 */
public class Example2_14 {
    public static void main(String[] args) {

        String message = (String) JOptionPane.showInputDialog(null,
                "请输入一个整数",
                "输入对话框",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);
         int n = Integer.parseInt(message);
         if (n%2==0){
             JOptionPane.showMessageDialog(null,"必须是奇数");
         }
        System.out.println(n/2);
        System.out.println((n-(n/2)));
       int k=n-(n/2);
       int m=n/2;
        for (int i=1;i<=k;i++){
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=m;i>=1;i--){
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        Point point = new Point(1, 2);
    }
}
