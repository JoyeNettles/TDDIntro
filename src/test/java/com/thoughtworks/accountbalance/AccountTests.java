package com.thoughtworks.accountbalance;

import com.thoughtworks.factorial.Factorial;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {


    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        assertThat(new Account(100).deposit(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        assertThat(new Account(100).withdraw(50), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        assertThat(new Account(50).withdraw(100), is(50));
    }
}
