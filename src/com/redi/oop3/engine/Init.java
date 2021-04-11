package com.redi.oop3.engine;

import com.redi.oop3.Main;
import com.redi.oop3.character.Alien;
import com.redi.oop3.character.Character;
import com.redi.oop3.character.Human;
import com.redi.oop3.character.Robot;
import com.redi.oop3.weapon.Gun;
import com.redi.oop3.weapon.Hammer;
import com.redi.oop3.weapon.LightSaber;
import com.redi.oop3.weapon.Weapon;

import java.util.*;

public class Init {
    static Scanner scanner = new Scanner(System.in);

    //setting up game: taking input from user to determine game-mode(1v1 | battle-royal)
    //and participants-
    //The List to draw weapons from and the Map to draw Characters from ( both in Main) are filled here
    //Characters get created and max. 2 weapons get assigned per Character
    public static Map<String, Character> startGame() {
        Map<String, Character> battleMap = new HashMap<String, Character>();
        int gameMode;
        int participants;

        String characterNumber = "character";

        System.out.println("Welcome to the survival- combat game experience");
        System.out.println("Please choose a game mode: enter '1' for 1v1 or '2' for BattleRoyal");

        gameMode = scanner.nextInt();
        if (gameMode == 1) {
            participants = 2;
        } else {
            System.out.println("You chose BattleRoyal! Please enter the number of participants here");
            participants = scanner.nextInt();
        }


        //fill n*2 random WeaponArray first- it needs to be there bc the Characters draw weapons from here @creation
        for (int i = participants * 2; i > 0; i--) {
            int randomFiller = (int) (Math.random() * 10);
            if (randomFiller > 8) {
                Main.weaponList.add(new LightSaber());
            } else if (randomFiller > 5) {
                Main.weaponList.add(new Gun());
            } else {
                Main.weaponList.add(new Hammer());
            }
        }

        //Create n Characters here and add to battleSet
        for (int i = participants; i > 0; i--) {
            int randomFiller = (int) (Math.random() * 10);
            if (randomFiller > 8) {
                battleMap.put("Alien_" + i, new Alien());
            } else if (randomFiller > 5) {
                battleMap.put("Robot_" + i, new Robot());
            } else {
                battleMap.put("Human_" + i, new Human());
            }
        }
        return battleMap;
    }

    //selecting random Weapon from Weapon-List
    public static Weapon getRandomWeapon(List<Weapon> weaponList) {
        Random random = new Random();
        int selector = random.nextInt(weaponList.size());
        return weaponList.get(selector);
    }

    //selecting random Character from Character-Map
    public static Character getRandomCharacter(Map<String, Character> inputMap) {
        Random random = new Random();
        List<String> keys = new ArrayList<String>(inputMap.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        Character randomCharacter = inputMap.get(randomKey);
        randomCharacter.setUniqueName(randomKey);
        return randomCharacter;
    }

    //The battle- method for 1v1
    public static int battleDuel(Character fighter1, Character fighter2) {
        int rounds = 0;

        //uncomment for battles until 1 participants health reaches <=0
        while (fighter1.getHealthPoints() > 0 & fighter2.getHealthPoints() > 0){

        //uncomment for shuffling fighters as soon as an attack is blocked
        //while (fighter1.attack(fighter2)){

            if (fighter1.attack(fighter2)) {
                rounds ++;
                if(fighter2.getHealthPoints() > 0){
                    continue;
                }
                else{
                    break;
                }

            } else if (fighter2.attack(fighter1)) {
                rounds ++;
                if(fighter1.getHealthPoints() > 0){
                    continue;
                }
                else{
                    break;
                }
            }
            else{
                continue;
            }
        }
       return rounds;
    }

    //method to check if 2 randomly selected Characters are == to prevent a Character ending up battling itself
    public static boolean isSuicide(Character fighter1, Character fighter2){
        return fighter1.getUniqueName().equals(fighter2.getUniqueName()) ? true : false;
    }

}


