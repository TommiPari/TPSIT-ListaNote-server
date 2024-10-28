package it.itismeucci;

import java.util.ArrayList;

public class Users {
    ArrayList<String> users;

    public Users() {
        this.users = new ArrayList<String>();
    }

    synchronized public String verify(String username) {
        if (this.users.contains(username)) {
            return "NO";
        } else {
            this.users.add(username);
            return "SI";
        }
    }

    synchronized public void remove(String username) {
        this.users.remove(username);
    }
}
