package entities;

import algorithms.AttackAlgorithm;

public class Player extends Creature{

    private int healingCount = 4;

    public final double healingPercent = 0.3;

    public Player(int attackValue, int defenceValue, int health, int minDamage, int maxDamage, AttackAlgorithm attackAlgorithm) {
        super(attackValue, defenceValue, health, minDamage, maxDamage, attackAlgorithm);
    }

    public void heal(){
        if (healingCount == 0)
            throw new RuntimeException("heal count expired");

        healingCount -= 1;
        int hp = getHealth() + (int) (getMaxHealth() * healingPercent);
        setHealth(Math.min(hp, getMaxHealth()));
    }

    @Override
    public void attack(Creature creature) {
        if (creature == null)
            throw new RuntimeException("creature you want to attack is null");

        if (creature.isDead())
            throw new RuntimeException("creature you want to attack already dead");

        int attackValue = getAttackAlgorithm().attackValue(this, creature);
        creature.setHealth(creature.getHealth() - attackValue);
    }
}

