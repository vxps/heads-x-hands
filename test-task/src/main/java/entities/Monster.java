package entities;


import algorithms.AttackAlgorithm;

public class Monster extends Creature{
    public Monster(int attackValue, int defenceValue, int health, int minDamage, int maxDamage, AttackAlgorithm attackAlgorithm) {
        super(attackValue, defenceValue, health, minDamage, maxDamage, attackAlgorithm);
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
