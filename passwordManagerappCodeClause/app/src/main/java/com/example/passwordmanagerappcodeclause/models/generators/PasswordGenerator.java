package com.example.passwordmanagerappcodeclause.models.generators;

import com.example.passwordmanagerappcodeclause.models.helper.helper;

import java.util.ArrayList;

public abstract class PasswordGenerator {
    public static ArrayList<PasswordGenerator> generators;

    public static void clear(){
        if(generators!=null){
            generators.clear();
        }
        else{
            generators= new ArrayList<>();
        }
    }

    public static  void add(PasswordGenerator pwdg){
        generators.add(pwdg);
    }

    public  abstract String getChar();

    public static boolean isEmpty(){
        return generators.isEmpty();
    }

    private static  PasswordGenerator getRandomPassGen(){
        if(generators==null){
            generators=new ArrayList<>();
            add(new LowerCaseGenerator());
        }
        if(generators.size()==1) return generators.get(0);
        int randomIndex = helper.randVal(generators.size());
        return generators.get(randomIndex);
    }

    public static String generatePassword(int sizeOfPassword){
        StringBuilder password = new StringBuilder();

        while(sizeOfPassword!=0){
            password.append(getRandomPassGen().getChar());
            sizeOfPassword--;
        }
        return password.toString();
    }


}
