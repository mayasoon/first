package com.company.pip;

import java.io.*;

//通过PipedInputStream PipedOutputStream 建立连接实现线程间通讯，传递数据
public class Run {
    public static void main(String[] args) {
//        try {
//            WriteData writeData = new WriteData();
//            ReadData readData = new ReadData();
//            PipedInputStream inputStream = new PipedInputStream();
//            PipedOutputStream pipedOutputStream = new PipedOutputStream();
//            //连接两个管道传输数据
//            pipedOutputStream.connect(inputStream);
//            ThreadRead read = new ThreadRead(readData,inputStream);
//            read.start();//读先启动 会被阻塞在read
//
//            Thread.sleep(2000);
//            ThreadWrite write = new ThreadWrite(writeData,pipedOutputStream);
//            write.start();
//
//        }catch (IOException | InterruptedException e){
//            e.printStackTrace();
//        }

        //字符流的形式传递数据
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedReader reader = new PipedReader();
            PipedWriter writer = new PipedWriter();

            writer.connect(reader);

            ThreadRead threadRead= new ThreadRead(readData,reader);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData,writer);
            threadWrite.start();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }


    }
}
