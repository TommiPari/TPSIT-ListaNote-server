package it.itismeucci;

import java.util.ArrayList;

public class GlobalNotes {
    ArrayList<String> notes;

    public GlobalNotes() {
        this.notes = new ArrayList<String>();
    }

    synchronized public void add(String note, String username) {
        this.notes.add(note + "=>" + username);
    }
}
