package entities;

import algorithms.AttackAlgorithm;

public abstract class Creature {
    private final int minParameter = 1;

    private final int maxParameter = 30;

    private final int minHealth = 0;

    private final int attackValue;

    private final int defenceValue;

    private int health;

    private final int maxHealth;

    private final int minDamage;

    private final int maxDamage;

    private AttackAlgorithm attackAlgorithm;

    public Creature(int attackValue, int defenceValue, int health, int minDamage, int maxDamage, AttackAlgorithm attackAlgorithm){

        if (attackValue < minParameter || attackValue > maxParameter)
            throw new RuntimeException("invalid attack value");

        if (defenceValue < minParameter || defenceValue > maxParameter)
            throw new RuntimeException("invalid defence value");

        if (health <= minHealth)
            throw new RuntimeException("invalid health value");

        if (minDamage >= maxDamage)
            throw new RuntimeException("invalid damage parameters");

        this.attackValue = attackValue;
        this.defenceValue = defenceValue;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attackAlgorithm = attackAlgorithm;
        this.maxHealth = health;
    }

    public boolean isDead(){
        return health <= minHealth;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }

    public int getHealth() {
        return health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public AttackAlgorithm getAttackAlgorithm() {
        return attackAlgorithm;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attack(Creature creature);

}
