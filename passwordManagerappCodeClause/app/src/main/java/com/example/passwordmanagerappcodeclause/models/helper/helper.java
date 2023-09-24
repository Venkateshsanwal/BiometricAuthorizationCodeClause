package com.example.passwordmanagerappcodeclause.models.helper;

public class helper {
    public static int randVal(int size){
        double rand = Math.random();
        return  (int) (rand*size);
    }

    public static  int randomChar(int min,int max){
        return randVal(max-min+1)+min;
    }
}
