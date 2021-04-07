package com.redi.oop2;

public class TheCat extends Feline{

    private String color;
    private boolean motivatedByFood;
    private double age;


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("I'm %.1f years young.\nand my fur is %S\n", this.age, this.color);

        if(this.motivatedByFood){
            System.out.printf("And I really dig food");
        }
        else{
            System.out.println("Eating is not my priority");
        }
    }



    TheCat(String name, String color, boolean motivatedByFood, double age){
        super(name);
        this.name = name;
        this.motivatedByFood = motivatedByFood;
        this.age = age;
        this.color = color;
    }

}
