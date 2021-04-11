package com.redi.oop2;

import com.redi.oop3.weapon.Weapon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    enum Attack {
        BITE, SCRATCH, STING, POISON, RAM
    }

    enum Defend {
        BARK, SCREECH, HISS, RAM, FLUFF, HIDE, FLEE
    }

    public static void main(String[] args) {
        Vertebrate paul = new Feline("hauskatze");
    //paul.printInfo();

        Canine hugo = new Canine("haushund");
    //hugo.printInfo();

        Vertebrate basic = new Vertebrate("testo");
    //basic.printInfo();

        Mammal jodie = new Mammal("haussäuger");
    //jodie.printInfo();

        Insect hans = new Insect("hans");
    //hans.printInfo();

        Bug horst = new Bug("horst");
    //horst.printInfo();


        TheCat testCat = new TheCat("Chefkoch", "yellowish", false, 11);

        TheDog testDog = new TheDog("Scooby", "black",true, 4.5);

        Vertebrate[] allMyAnimals = new Vertebrate[]{horst, hans, jodie, basic, hugo, paul, testDog, testCat};

        for(Vertebrate animal : allMyAnimals){
            animal.printInfo();
        }
    }
}
