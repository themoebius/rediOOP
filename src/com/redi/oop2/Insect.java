package com.redi.oop2;

public class Insect extends Vertebrate{
    static final String subclass = "Insect";
    static final double maxAgeYrs = 50;
    final static double maxSpeedKMH = 50;
    final static double avgSizeCM = 0.15;

    static final Main.Defend[] defense = {Main.Defend.HIDE, Main.Defend.RAM};
    static final Main.Attack[] offense = {Main.Attack.POISON, Main.Attack.BITE, Main.Attack.STING, Main.Attack.RAM};

    @Override
    public void sleep(){
        System.out.println("I don't sleep.... I rest!");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("I am a proud %S \n", subclass);
    }

    public void annoyHuman(){
        System.out.printf("Bzzz Bzzz kribble krabble");
    }

    Insect(String name){
        super(name);
    }



}
