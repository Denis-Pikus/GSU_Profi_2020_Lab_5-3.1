package com.company;

public class TextFactory {
    private String str;

    public TextFactory() {
    }

    public String[] create(String str){
        return str.split(":");
    }
}
