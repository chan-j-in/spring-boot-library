package com.example.library.member.domain;

public enum Sex {
    M("male"), F("female");

    final private String sex;
    public String getSex(){
        return sex;
    }

    Sex(String sex){
        this.sex = sex;
    }
}
