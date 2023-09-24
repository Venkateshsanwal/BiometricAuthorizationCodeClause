package com.example.passwordmanagerappcodeclause.models.generators;

import com.example.passwordmanagerappcodeclause.models.helper.helper;

public class LowerCaseGenerator extends PasswordGenerator{
    private static  final char CHAR_A='a';
    private static  final char CHAR_Z='z';
    @Override
    public String getChar() {
        return String.valueOf((char) (helper.randomChar(CHAR_A,CHAR_Z)));
    }
}
