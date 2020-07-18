package com.lambdaschool.todos.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Todos")
public class Todos {

    @Id
    @GeneratedValue
    public long todoid;


    @Column(nullable = false)
    public String discription;


    @Transient
    public boolean completedSwap;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;


    public Todos(long todoid, String discription, boolean completed, User user) {
        this.todoid = todoid;
        this.discription = discription;
        this.completed = completed;
        this.user = user;
    }

    public Todos(User u1, String give_joe_access_rights) {
    }

    public Todos() {

    }


    public boolean isCompletedSwap() {
        return completedSwap;
    }

    public void setCompletedSwap(boolean completedSwap) {
        this.completedSwap = completedSwap;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean completedMethod() {
        return completed;
    }
}
