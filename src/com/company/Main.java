package com.company;

import apple.laf.JRSUIConstants;
import net.sourceforge.sizeof.SizeOf;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationHandler;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        SizeOf.skipStaticField(true);
        SizeOf.setMinSizeToLog(10);
        int p = 1000000000;
        final Data data;
        final Student student = new Student(11,"niaho");
        student.age = 12;
        student.name = "ixoa";
        System.out.println(student.name);
        compareString();
//        System.out.println("Size "+SizeOf.sizeOf(map));
//        System.out.println("Integer "+Integer.SIZE);
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        modify(p1,p2);
        System.out.println(p1.x+ "   "+p1.y);
        System.out.println(p2.x+"   "+p2.y);

        String abc = "abc";
        abc.replace('b','d');//因为字符串被final关键字修饰，所以替换后会生成一个新的字符串在方法区，如果没有赋值给属性就是垃圾对象，下一次gc会被回收。
        System.out.println(abc);

    }

    public static void eq(){
        String s = new String("test");
        System.out.println(s.equals("test"));
    }

    public static String ten2Hex2(int num) {

//        String strHex1 = Integer.toHexString(valueTen).toUpperCase();//高位不用补0
        String strHex2 = String.format("%032d", num).toUpperCase();//高位补0
        return strHex2;
    }

    public static void compareString(){
        String s1 = "abc";
        String s3 = "abc";
        String s2 = new String("abc");
        try {
            KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println((s1==s2)+"  "+s1.equals(s2)+"  "+(s1==s3));
    }


    static class Point{
        private int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }


    }
    private static void modify(Point p1,Point p2){//入栈后p2引用改变了
        Point te = p1;
        p1 = p2;
        p2 = te;
        p1.setXY(5,5);
        p2 = new Point(5,5);

    }

}
