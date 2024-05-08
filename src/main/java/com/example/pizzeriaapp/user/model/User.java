package com.example.pizzeriaapp.user.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean rights;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean userOrAdmin() {
        return rights;
    }

    public void setRights(boolean rights) {
        this.rights = rights;
    }//set "false" if user and "true" if admin.
}
