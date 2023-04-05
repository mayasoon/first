package com.company.pip;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class ThreadWrite extends Thread{
    private WriteData writeData;
    private PipedOutputStream out;
    private PipedWriter writer;

    public ThreadWrite(WriteData writeData, PipedOutputStream out) {
        this.writeData = writeData;
        this.out = out;
    }

    public ThreadWrite(WriteData writeData, PipedWriter writer) {
        this.writeData = writeData;
        this.writer = writer;
    }

    @Override
    public void run() {
//        writeData.writeMethod(out);
        writeData.writePiped(writer);
    }
}
