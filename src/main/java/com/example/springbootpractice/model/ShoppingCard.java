package com.example.springbootpractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingCard extends BaseEntity{
    private int count;
    @ManyToOne
    private Factor factor;
    @ManyToOne
    Book book;

    public ShoppingCard() {
    }

    public ShoppingCard(int count, Factor factor, Book book) {
        this.count = count;
        this.factor = factor;
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public Factor getFactor() {
        return factor;
    }

    public Book getBook() {
        return book;
    }
}
