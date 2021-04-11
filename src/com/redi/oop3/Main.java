package com.redi.oop3;

/*
Exercise
In this exercise we will implement a game. This game consist of Characters and Weapons. We have 3 Characters (Human, Alien, Robot), 3 Weapons (Gun, LightSaber, Hammer)

Each character have:
health points between 0 and 100, 100 means the character’s health is full, 0 means the character is dead.
default damage points, when a character does not have a weapon,
this is the default damage points to use when attacking.
weapon
attack: a method used to attack other character.
defend: a method used when being attacked.
Each weapon have:

damage points: when attacking the amount of points to remove from a player’s health.
PS: feel free to choose the different values for characters and weapons.

Implement all the different classes and their related methods needed for this game.
Implement a game class where you have the following:
have 10 characters in the game. (choose weapon or no weapon for each character).
bonus: generate weapon and no weapon randomly.


Choose a random amount of turns or you can use Random (see example below).
On each turn select randomly two characters, the first one will attack the second one.
When the turns end, print the surviving characters.
 */

/*
Homework
Let’s spice up our game a bit. We want to add special effects that can be used by characters. In order to achieve that we need to add for each character:
mana points between 0 and 100. when mana is at 100, the character uses the special effects if they have them when attacking or being attacked.
mana regeneration points. Each time the character is being attacked, the mana is increased by mana regeneration points.
special effect Also we have to add 2 special effects DoubleHitPoint and SuperDefence:
DoubleHitPoint: when used that damage inflected is doubled
SuperDefence: when being attacked, the SuperDefence allow the character to receive no damage.
In the game class try to randomly add special effects to character after each turn and see how the game evolve.

extra challenge
Add to the weapon a decay functionality, this means that a weapon can be used only for a certain amount of time. For each weapon add:

usability between 0 and 100. When a weapon reach 0 usability, it cannot be used any more.
decay rate: on each usage of the weapon the rate the weapon’s usability is decreased by.
In the game class try to randomly add weapons to characters when they reach the decay point.
*/


import com.redi.oop3.character.Character;
import com.redi.oop3.engine.Init;
import com.redi.oop3.weapon.Weapon;

import java.util.*;



public class Main {
    public static ArrayList<Weapon> weaponList = new ArrayList<>();
    public static Map<String, Character> battleMap = Init.startGame();



    public static void main(String[] args) {

        Character fighter1 = null;
        Character fighter2 = null;

        while (battleMap.size() > 2) {
            fighter1 = Init.getRandomCharacter(battleMap);
            fighter2 = Init.getRandomCharacter(battleMap);
            if(Init.isSuicide(fighter1, fighter2))
                fighter2 = Init.getRandomCharacter(battleMap);

            Init.battleDuel(fighter1, fighter2);
        }


        System.out.printf("\n\n\n\n\nWelcome to the last battle:\n");
        battleMap.forEach((k, v) -> System.out.println((k + " survived with " + v.getHealthPoints() + " left")));
        battleMap.forEach((k, v) -> v.setUniqueName(k));
        Collection<Character> values = battleMap.values();
        Character[] finalBattle = values.toArray(new Character[0]);

        Character survivor1 = finalBattle[0];
        Character survivor2 = finalBattle[1];


        Init.battleDuel(survivor1, survivor2);
        System.out.printf("\n\n\n\n\nWe have a winner:\n");
        battleMap.forEach((k, v) -> System.out.println((v.getUniqueName() + " survived with " + v.getHealthPoints() + " left")));





    }
}
