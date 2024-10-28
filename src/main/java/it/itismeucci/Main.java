package it.itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        ArrayList<String> users = new ArrayList<String>();
        while (true) {
            Socket s = ss.accept();
            MyThread t = new MyThread(s);
            t.start();
        }
    }
}