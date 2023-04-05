package com.company.pip;

import java.io.PipedInputStream;
import java.io.PipedReader;

public class ThreadRead extends Thread{

    private ReadData readData;
    private PipedInputStream inputStream;

    private PipedReader reader;

    public ThreadRead(ReadData readData, PipedInputStream inputStream) {
        this.readData = readData;
        this.inputStream = inputStream;
    }

    public ThreadRead(ReadData readData, PipedReader reader) {
        this.readData = readData;
        this.reader = reader;
    }

    @Override
    public void run() {
//        readData.readMethod(inputStream);
        readData.readPiped(reader);
    }

}
