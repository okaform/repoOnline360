package com.cit360.week06;

public class Account {
    private int id = 0;
    private double balance = 0;


    Account() {
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    double withdraw(double money) {
        return balance-= money;
    }

    double deposit(double money) {
        return balance += money;
    }

    public String toString() {
        return "ID: " + id + "\nBalance: " + balance ;
    }
}
