package com.company.pip;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.nio.CharBuffer;

public class ReadData {
    public void readMethod(PipedInputStream in){
        try {
            System.out.println("read :");
            byte[] bytes = new byte[20];
            int readLength = in.read(bytes);
            while (readLength!=-1){
                String newData = new String(bytes,0,readLength);
                System.out.println(newData);
                readLength = in.read(bytes);//线程阻塞
            }
            System.out.println();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //读取字符流
    public void readPiped(PipedReader input){
        try {
            System.out.println("read :");
            char[] chars = new char[20];
            int readLength = input.read(chars);
            while (readLength!=-1){
                String newData = new String(chars,0,readLength);
                System.out.println(newData);
                readLength = input.read(chars);//线程阻塞
            }
            System.out.println();
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
