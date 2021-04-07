package com.redi.oop2;

public class Mammal extends Vertebrate{
    static final String subclass = "Mammal";
    static final double maxAgeYrs = 220;
    static final double maxSpeedKMH = 310;


    public void sleep(){
        System.out.println("ZZZZZZZZZZZZzzzzzzzzzzzzZZZZZZZZZZZz");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("I am a proud %S \n", subclass);
    }


    Mammal(String name){
        super(name);
    }

}
