package com.example.springbootpractice.model;

import jakarta.persistence.Entity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("deleted is null")
@SQLDelete(sql = "update public.users set deleted = now() where id=?")
public class Users extends BaseEntity {
    private String username;
    private String password;
    private boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Users() {
    }

    public Users(String username, String password, boolean enabled) {
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

        public Users build(){
            return new Users(username,password,enabled);
        }
    }
}
