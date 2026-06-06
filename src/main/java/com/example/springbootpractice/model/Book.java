package com.example.springbootpractice.model;

import jakarta.persistence.Entity;

@Entity
public class Book extends BaseEntity {
    private String name;
    private Integer price;

    public Book() {
    }
    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
