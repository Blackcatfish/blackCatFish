package com.blackfish.zikao;

import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/8
 */
public class Example4_6 {
    public static void main(String[] args) {
        String s1="public static void, main";
        String s2="StringTokenizer pas2?=new StringTokenizer()";
        StringTokenizer pas1 = new StringTokenizer(s1, ",");
        StringTokenizer pas2 = new StringTokenizer(s2, "?");
        int i = pas1.countTokens();
        int i1 = pas2.countTokens();
        System.out.println("s1有"+i+"单词"+"s2有"+i1+"个单词");
        while (pas1.hasMoreTokens()){
            System.out.println(pas1.nextToken());
        }

    }
}
