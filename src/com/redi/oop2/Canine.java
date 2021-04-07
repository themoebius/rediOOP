package com.redi.oop2;

public class Canine extends Mammal{
    final String family = "Canine";


    static final double maxAgeYrs = 29;
    static final double maxSpeedKMH = 72;
    static final double avgSizeCM = 65;


    static final Main.Defend[] defense = {Main.Defend.FLUFF, Main.Defend.HIDE, Main.Defend.BARK};
    static final Main.Attack[] offense = {Main.Attack.BITE};


    public void catchBall(){
        System.out.printf("...caught the ball");
    }


    @Override
    public void sleep(){
        String delayText = "I still have to sleep an average of 13 hours...but if you want to play- I'm all up for it";
        char[] delayArray = delayText.toCharArray();

        for (char ch : delayArray) {
            System.out.print("" + ch);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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


    Canine(String name){
        super(name);
    }

}
