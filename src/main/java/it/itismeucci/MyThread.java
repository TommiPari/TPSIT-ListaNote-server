package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class MyThread extends Thread {
    private Socket s;
    
    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            ArrayList<String> notes = new ArrayList<String>();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String receive;
            do {
                receive = in.readLine();
                switch (receive) {
                    case "?":
                        for (String note : notes) {
                            out.writeBytes(note + "\n");    
                        }
                        out.writeBytes("@\n");
                        break;
                    case "!":
                        break;
                    default:
                        notes.add(receive);
                        out.writeBytes("OK" + "\n");
                        break;
                }
            } while (!receive.equals("!"));
        } catch (IOException e) {
            System.out.println("Errore!!");
        }
    }
}
