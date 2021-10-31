package com.blackfish.zikao;

/**
 * @Description: 找出质数
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/6
 */
public class Example2_12 {
    public static void main(String[] args) {
        int j,i;
        for ( j = 2; j <=50; j++) {
            for ( i = 2; i <=j/2 ; i++) {
                if ((j % i) == 0) break;
            }
            if (i>j/2){ System.out.println(j+"是质数");
            }
        }
    }
}
