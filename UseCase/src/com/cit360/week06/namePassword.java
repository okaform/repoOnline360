package com.cit360.week06;

public class namePassword {
    private int i = 0;
    private String name = null;
    private String password = null;

    namePassword(int i, String name, String password) {
        this.i = i;
        this.name = name;
        this.password = password;
    }
    int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
    String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "namePassword{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
