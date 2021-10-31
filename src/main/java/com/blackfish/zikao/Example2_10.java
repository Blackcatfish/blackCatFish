package com.blackfish.zikao;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/6
 */
public class Example2_10 {
    public static void main(String[] args) {
        int a,b,c;
        for ( a = 3; a <=25 ; a++) {
            for ( b = 1; b< a; b++) {
                for (c = 1; c < b; c++) {
                    if (b*b+c*c==a*a){
                        System.out.println("a="+a+",b="+b+",c="+c);
                    }

                }
            }
        }
    }

}
