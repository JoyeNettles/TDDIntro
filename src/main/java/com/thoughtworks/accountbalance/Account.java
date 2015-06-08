package com.thoughtworks.accountbalance;

/**
 * Created by JOYE NETTLES on 6/8/2015.
 */
public class Account {
    private int balance = 0;

    public Account(int balance){
        this.balance = balance;
    }
    
    public int deposit(float amount){
        this.balance += amount;
        return this.balance;
    }

    public int withdraw(float amount){
        if(this.balance >= amount){
            this.balance -= amount;
        }
        return this.balance;
    }
}
