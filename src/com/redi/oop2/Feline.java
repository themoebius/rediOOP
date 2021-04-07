package com.redi.oop2;

public class Feline extends Mammal{

    final String family = "Felidae";
    static final double avgSizeCM = 130;
    static final double maxSpeedKMH = 125;
    static final double maxAgeYrs = 29;


    static final Main.Defend[] defense = {Main.Defend.HISS, Main.Defend.SCREECH, Main.Defend.FLUFF, Main.Defend.HIDE};
    static final Main.Attack[] offense = {Main.Attack.BITE, Main.Attack.SCRATCH};


    public void catchMouse(){
        System.out.printf("...caught the mouse");
    }


    @Override
    public void sleep(){
        String delayText = "I still have to sleep an average of 16 hours...just leave me be";
        char[] delayArray = delayText.toCharArray();

        for(char ch : delayArray){
            System.out.print(""+ch);
            try{
                Thread.sleep(50);
            }
            catch(Exception e){
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


    Feline(String name){
        super(name);
    }


}
