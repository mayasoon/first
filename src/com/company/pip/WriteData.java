package com.company.pip;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

//线程间通讯的流，负责写数据
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        System.out.println("write : ");
        try {
            for (int i = 0; i < 40; i++) {
                String outData = "-"+(i+1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //可以传递字符流
    public void writePiped(PipedWriter out){
        System.out.println("write : ");
        try {
            for (int i = 0; i < 40; i++) {
                String outData = "-我-";
                out.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
