package com.blackfish.zikao;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/8
 */
public class Example4_3 {
    public static void main(String[] args) {
        boolean b[][]=new boolean[4][];
        for (int i = 0; i < b.length; i++) {
            b[i]=new boolean[i+i];
        }
        for (int i = 0; i < b.length; i++) {
            for (int i1 = 0; i1 < b[i].length; i1++) {
                System.out.println(b[i][i1]);
            }
        }
    }
}
