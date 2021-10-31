package com.blackfish.zikao;

import java.awt.*;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/9/7
 */
public class Example3_1 {

    public static void main(String[] args) {
        Point p1,p2,p3;
        p1=new Point();
        p2=new Point(40,50);
        p3=new Point((int)(p1.getX()+p2.getX()),(int)(p1.getY()+p2.getY()));
        System.out.println("P3.x="+p3.getX()+",P3.y="+p3.getY());
        Point point = new Point(p1.x, p2.y);
        System.out.println("P3.x="+point.x+",P3.y="+point.y);
        System.out.println(Point.distance(1,2,3,4));
        System.out.println(Math.sqrt(4));
        int[] jj={1,2,3,4};
        int length = jj.length;
    }
}
