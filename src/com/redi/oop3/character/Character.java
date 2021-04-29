package com.redi.oop3.character;


import com.redi.oop3.Main;
import com.redi.oop3.engine.Init;
import com.redi.oop3.weapon.Weapon;



public class Character {
    private String type;
    private String uniqueName;
    private double healthPoints;
    private int damagePoints;
    private int manaPoints;
    private int skillPoints;
    private boolean isTwoHanded;
    private Weapon[] weaponList = new Weapon[2];
    private Weapon weapon;
    private int weaponCount;
    public boolean isLoser;
    //attack-method:
    //math to calculate attack-points depending on luck and base-stats of Character & Weapon happens here

    public boolean attack(Character opponent) {
        double randomMultiplier = Math.random();
        double randomWeaponMultiplier = Math.random();
        boolean weaponDualWield = false;

        //check if Character has 2 weapons and has the according skill (isTwoHanded)...
        boolean characterDualWield = this.getWeaponCount() == 2 & this.isTwoHanded ? true : false;

        //check if both weapons can be used for dualWielding...
        if (characterDualWield) {
            weaponDualWield = this.getWeaponsCarried()[0].isCanDualWield() & this.getWeaponsCarried()[1].isCanDualWield();
        }

        //if both checks are true, the character can use both weapons at once..
        boolean doDualWield = characterDualWield & weaponDualWield;

        System.out.println(this.getUniqueName() + " v " + opponent.getUniqueName());

        //calculating hitPoints depending on skill/ weapons / luck
        double attackDamage = weapon == null ? (randomMultiplier * (this.damagePoints + this.skillPoints) / 10) :
                doDualWield ?
                        (randomMultiplier * (this.damagePoints + this.skillPoints) / 10) +
                                (randomWeaponMultiplier * (this.weapon.getDamagePoints() + ((double) this.weapon.getWeaponStatus() / 10))) +
                                (randomWeaponMultiplier * (this.getWeaponsCarried()[1].getDamagePoints() + ((double) this.getWeaponsCarried()[1].getWeaponStatus() / 10)))
                        : (randomMultiplier * (this.damagePoints + this.skillPoints) / 10) +
                        (randomWeaponMultiplier * (this.weapon.getDamagePoints() + ((double) this.weapon.getWeaponStatus() / 10)));
        if (opponent.isLoser && opponent.getUniqueName().equals(this.getUniqueName())) {
            System.out.println("Suicide or life after death are not unlocked yet...");
            return false;
        } else {

            if (!opponent.doDefend() & opponent.getHealthPoints() > 0 & !opponent.isLoser & !this.isLoser) {
                opponent.setHealthPoints(opponent.getHealthPoints() - attackDamage);
                if (doDualWield) {
                    System.out.printf("%s attacked with 2 weapons: %s and %s\n", this.getUniqueName(), this.getWeaponsCarried()[0].getCategory(), this.getWeaponsCarried()[1].getCategory());
                    System.out.printf("Attack damage: %.2f\n", attackDamage);
                } else if (this.weapon == null) {
                    System.out.printf("%s attacked without a weapon\n", this.getUniqueName());
                    System.out.printf("Attack damage: %.2f\n", attackDamage);
                } else {
                    System.out.printf("Regular Attack with %s\n", this.weapon.getCategory());
                    System.out.printf("Attack damage: %.2f\n", attackDamage);
                }

                System.out.printf("%s new health points: %.2f\n", opponent.getUniqueName(), opponent.getHealthPoints());
                if (opponent.getHealthPoints() > 0) {

                    //Comment / uncomment for attack until 1st block or attack changing each round
                    //return true;
                    attack(opponent);
                } else {
                    System.out.println(this.getUniqueName() + " won!");
                    opponent.isLoser = true;
                    Main.battleMap.remove(opponent.getUniqueName());
                    return false;
                }
            } else if (opponent.getHealthPoints() <= 0) {
                opponent.isLoser = true;
                Main.battleMap.remove(opponent.getUniqueName());

                return false;

            } else if (this.isLoser) {
                System.out.printf("...has a winner: %s\n", opponent.getUniqueName());
                return false;
            } else {
                System.out.println(opponent.getUniqueName() + " parried the attack! No damage was dealt!");
                return false;
            }
            return false;
        }

    }
    public boolean doDefend(){
        return Math.random() < 0.5 ? false : true;
    }

    //method to assign weapons randomly - utilized @Character initialization
    public void getWeapon(){
        int weaponCounter = 0;
        if(this.isTwoHanded){
            for(int i = 0; i < 2; i++){
                if(doDefend()){
                    Weapon addWeapon = Init.getRandomWeapon(Main.weaponList);
                    this.setWeaponListItem(addWeapon, i);
                    weaponCounter++;
                }
            }
            this.weapon = getWeaponsCarried()[0] == null ? getWeaponsCarried()[1] : getWeaponsCarried()[0];
        }
        else{
            if(doDefend()){
                this.weapon = Init.getRandomWeapon(Main.weaponList);
                if(this.weapon != null) {
                    weaponCounter = 1;
                }
                else{
                    weaponCounter = 0;
                }
            }
        }
    setWeaponCount(weaponCounter);
    }

//setters
    public void setHealthPoints(double healthPoints){ this.healthPoints = healthPoints; }
    public void setDamagePoints(int damagePoints) { this.damagePoints = damagePoints; }
    public void setManaPoints(int manaPoints){ this.manaPoints = manaPoints; }
    public void setSkillPoints(int skillPoints) { this.skillPoints = skillPoints; }
    public void setTwoHanded(boolean canDualWield){ this.isTwoHanded = canDualWield; }
    public void setWeaponCount(int weaponCount){ this.weaponCount = weaponCount; }
    public void setUniqueName(String uniqueName) { this.uniqueName = uniqueName; }
    public void setWeaponListItem(Weapon weapon, int position) { getWeaponsCarried()[position] = weapon; }

//getters
    public String getUniqueName() { return uniqueName; }
    public String getType() { return type; }
    public Weapon[] getWeaponsCarried(){ return this.weaponList; }
    public double getHealthPoints() { return healthPoints; }
    public int getWeaponCount() { return weaponCount; }

    //Constructor
    public Character(String type, int damagePoints, double healthPoints, int manaPoints, int skillPoints, boolean isTwoHanded){
        this.damagePoints = damagePoints;
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.skillPoints = skillPoints;
        this.type = type;
        this.isTwoHanded = isTwoHanded;
        this.getWeapon();
    }

}
