package com.example.passwordmanagerappcodeclause.models.generators;

import com.example.passwordmanagerappcodeclause.models.helper.helper;

public class UpperCaseGenerator extends PasswordGenerator {
    private static  final char CHAR_A='A';
    private static  final char CHAR_Z='Z';
    @Override
    public String getChar() {
        return String.valueOf((char) (helper.randomChar(CHAR_A,CHAR_Z)));
    }
}
