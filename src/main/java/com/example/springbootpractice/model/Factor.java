package com.example.springbootpractice.model;

import jakarta.persistence.*;

@Entity
public class Factor extends BaseEntity{
    @ManyToOne
    private Users user;
    @Enumerated(EnumType.STRING)
    private Payed payed;

    public Factor() {
    }

    public Factor(Users user, Payed payed) {
        this.user = user;
        this.payed = payed;
    }

    public Users getUser() {
        return user;
    }

    public Payed getPayed() {
        return payed;
    }
}
