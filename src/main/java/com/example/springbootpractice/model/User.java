package com.example.springbootpractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private boolean enabled;

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static Build builder(){
        return new Build();
    }

    public static class Build{
        public String username;
        public String password;
        public boolean enabled;

        public Build username(String username){
            this.username = username;
            return this;
        }

        public Build password(String password){
            this.password = password;
            return this;
        }

        public Build enabled(boolean enabled){
            this.enabled = enabled;
            return this;
        }

        public User build(){
            return new User(username,password,enabled);
        }
    }
}
