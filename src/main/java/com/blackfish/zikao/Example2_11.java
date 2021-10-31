package com.blackfish.zikao;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/6
 */
public class Example2_11 {
    public static void main(String[] args) {
        int a, b, c, d;
        for ( a = 1; a <= 4; a++) {
            for ( b = 1; b <=4; b++) {
                if (a==b) continue;;
                for ( c = 1; c <=4; c++) {
                        if (c==a|c==b) continue;
                        d=10-a-b-c;
                        if(((a==1)!=(b==2))&&((c==1)!=(d==3))&&((d==2)!=(a==3))){
                            System.out.println("a="+a+"b="+b+"c="+c+"d="+d);
                    }
                }
            }
        }
    }
}
