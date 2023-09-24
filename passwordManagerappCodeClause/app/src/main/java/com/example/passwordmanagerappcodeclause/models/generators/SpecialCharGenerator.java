package com.example.passwordmanagerappcodeclause.models.generators;

import com.example.passwordmanagerappcodeclause.models.helper.helper;

public class SpecialCharGenerator extends PasswordGenerator{
    private static  final char [] SPECIAL_CHAR_ARRAY="?.<>,}{/;*&$#@!%^()".toCharArray();
    @Override
    public String getChar() {
        return String.valueOf(SPECIAL_CHAR_ARRAY[helper.randomChar(0,SPECIAL_CHAR_ARRAY.length-1)]);
    }
}
