package com.example.springbootpractice.model;

import jakarta.persistence.*;

@Entity
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Payed payed;

    public Factor() {
    }

    public Factor(User user, Payed payed) {
        this.user = user;
        this.payed = payed;
    }

    public User getUser() {
        return user;
    }

    public Payed getPayed() {
        return payed;
    }
}
