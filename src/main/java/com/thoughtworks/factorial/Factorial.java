package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i < 0){
            throw new IllegalArgumentException();
        }else if(i == 0){
            return 1;
        }else if(i == 1){
           return 1;
        }

        return compute(i-1) * i;
    }
}
