package algorithms;

import entities.Creature;

public class AttackAlgorithm {

    private final int minCubeValue = 1;

    private final int maxCubeValue = 6;

    private final int firstSuccessfulValue = 5;


    private final int secondSuccessfulValue = 6;

    public int attackValue(Creature attacker, Creature defender){
        int attackModifier = attacker.getAttackValue() - defender.getDefenceValue() + 1;

        if (attackModifier <= 0)
            return 0;

        for (int i = 0; i < attackModifier; i++) {
            int randomValue = minCubeValue + (int)(Math.random() * maxCubeValue);
            if (isSuccessful(randomValue))
                return attacker.getMinDamage() + (int)(Math.random() * attacker.getMaxDamage());
        }

        return 0;
    }

    public boolean isSuccessful(int value){
        return value == firstSuccessfulValue || value == secondSuccessfulValue;
    }

}
