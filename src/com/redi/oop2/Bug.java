package com.redi.oop2;

public class Bug extends Insect{
    final static String family = "Bug";
    final static double maxAgeYrs = 0.12;
    final static double maxSpeedKMH = 9;
    final static double avgSizeCM = 5;


    final static Main.Attack[] offense = {Main.Attack.RAM};
    final static Main.Defend[] defense = {Main.Defend.FLEE, Main.Defend.HIDE};

    public void getTrapped(){
        System.out.println("i came in- now i can't get out again");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("I belong to the %S family\n" +
                        "My max. age: %.2f \n" +
                        "My max. speed: %.2f \n" +
                        "My avg. size: %.2f \n",
                family, maxAgeYrs, maxSpeedKMH, avgSizeCM);

        System.out.println("I attacks:");
        for(Main.Attack value : this.offense){
            System.out.println(value);
        }

        System.out.println("I defends:");
        for(Main.Defend value : defense){
            System.out.println(value);
        }
    }

    Bug(String name){
        super(name);
    }


}

