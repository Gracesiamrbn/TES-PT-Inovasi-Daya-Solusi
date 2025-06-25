package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Status {

    @Id
    private int id;
    private String name;

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
