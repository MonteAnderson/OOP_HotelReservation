package com.hotelres;

public class Account {

    private String userName;
    private String password;

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}