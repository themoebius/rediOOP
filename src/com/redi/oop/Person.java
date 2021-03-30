package com.redi.oop;

import java.util.Date;

public class Person {

    final String name;
    private final Date born;

    Person(String name, Date born){
        this.name = name;
        this.born = born;
    }

    public Date getDoB() {return born;}

}
