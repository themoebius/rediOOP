package com.redi.oop3.weapon;

public class Weapon {

    private int damagePoints;
    private int weaponDecay;
    private int weaponStatus;
    private int skillPointsNeeded;

    private String category;
    private boolean canDualWield;
    private boolean isMagic;
    private boolean isActive;



//Constructor
    public Weapon(int damagePoints, int weaponDecay, int skillPointsNeeded, String category, boolean dualWield, boolean isMagic){
        this.damagePoints = damagePoints;
        this.weaponDecay = weaponDecay;
        this.skillPointsNeeded = skillPointsNeeded;
        this.category = category;
        this.canDualWield = dualWield;
        this.isActive = true;
        this.weaponStatus = 100;
    }

    //getters
    public int getDamagePoints() {
        return damagePoints;
    }
    public int getWeaponStatus() { return weaponStatus; }
    public String getCategory() { return category; }
    public boolean isCanDualWield() { return canDualWield; }



    public void causeDecay() {
        if (weaponDecay > 0) {
            weaponDecay -= 5;
        } else {
            isActive = false;
        }
    }
}
