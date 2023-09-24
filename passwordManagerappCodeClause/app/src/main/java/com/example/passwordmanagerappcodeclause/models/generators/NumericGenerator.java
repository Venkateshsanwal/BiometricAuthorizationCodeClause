package com.example.passwordmanagerappcodeclause.models.generators;

import com.example.passwordmanagerappcodeclause.models.helper.helper;

public class NumericGenerator extends PasswordGenerator {
    private static  final char CHAR_0='0';
    private static  final char CHAR_9='9';
    @Override
    public String getChar() {
        return String.valueOf((char) (helper.randomChar(CHAR_0,CHAR_9)));
    }
}
