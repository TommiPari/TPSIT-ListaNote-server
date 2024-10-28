package it.itismeucci;

import java.util.ArrayList;

public class GlobalNotes {
    ArrayList<String> notes;

    public GlobalNotes() {
        this.notes = new ArrayList<String>();
    }

    public void add(String note) {
        this.notes.add(note);
    }
}
