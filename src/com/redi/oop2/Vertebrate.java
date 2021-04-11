package com.redi.oop2;

class Vertebrate{
    final static String classification = "Vertebrate";
    String name;
    final static double maxAgeYrs = 512;
    final static double maxSpeedKMH = 389;

    Main.Defend[] defense = Main.Defend.values();
    Main.Attack[] offense = Main.Attack.values();



    public void sleep(){
        System.out.println("I sleep most of the day");
    }



    public void printInfo() {
        System.out.printf("\nHello, my name is %S \n" +
                        "I classify as: %S \n",
                        name, classification);
    }


    Vertebrate(String name){
        this.name= name;
    }

}
