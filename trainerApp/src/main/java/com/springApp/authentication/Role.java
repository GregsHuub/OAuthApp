package com.springApp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    private int id;
    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
