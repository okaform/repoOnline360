package com.cit360.week11;

//this is for me to return the user with a boolean for checking the password against the username
public class BooleanUserInfo {

    private boolean trueOrNot = false;
    private int listID;
    private String username;
    private String password;

    public boolean isTrueOrNot() {
        return trueOrNot;
    }

    public void setTrueOrNot(boolean trueOrNot) {
        this.trueOrNot = trueOrNot;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public String toString() {
        return "BooleanUserInfo{" +
                "trueOrNot=" + trueOrNot +
                ", listID=" + listID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
