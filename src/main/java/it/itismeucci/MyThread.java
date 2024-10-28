package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class MyThread extends Thread {
    private Socket s;
    private GlobalNotes gn;
    
    public MyThread(Socket s, GlobalNotes gn) {
        this.s = s;
        this.gn = gn;
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
                        for (String globalNote : gn.notes) {
                            out.writeBytes(globalNote + "\n");
                        } 
                        for (String note : notes) {
                            out.writeBytes(note + "\n");    
                        }
                        out.writeBytes("@\n");
                        break;
                    case "!":
                        break;
                    case "+":
                        String note = in.readLine();  
                        gn.add(note);
                        out.writeBytes("OK" + "\n");
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
