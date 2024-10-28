package it.itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        GlobalNotes gn = new GlobalNotes();
        while (true) {
            Socket s = ss.accept();
            MyThread t = new MyThread(s,gn);
            t.start();
        }
    }
}