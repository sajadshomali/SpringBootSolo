package com.example.springbootpractice.dto.response;

public class UserResponse {
    private  long userId;
    private  String username;
    private  boolean enabled;

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserResponse() {
    }

    public UserResponse(Long userId, String username, boolean enabled ){
        this.userId = userId;
        this.username = username;
        this.enabled = enabled;
    }

    public Build builder(){
        return new Build();
    }

    public static class Build{
        public long userId;
        public String username;
        public boolean enabled;
        public Build userId(Long userId){
            this.userId = userId;
            return this;
        }

        public Build username(String username){
            this.username = username;
            return this;
        }

        public Build enabled(boolean enabled){
            this.enabled = enabled;
            return this;
        }

        public UserResponse build(){
            return new UserResponse(userId,username,enabled);
        }
    }
}
