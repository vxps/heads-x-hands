import algorithms.AttackAlgorithm;
import entities.Monster;
import entities.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void killingTest(){
        Player player = new Player(10, 10, 100, 1, 10, new AttackAlgorithm());
        Monster monster = new Monster(10, 10, 100, 1, 10, new AttackAlgorithm());
        while (!monster.isDead()){
            player.attack(monster);
        }
        assertEquals(monster.getHealth(), 0);
    }

    @Test
    public void healingTest(){
        Player player = new Player(10, 10, 100, 1, 10, new AttackAlgorithm());
        Monster monster = new Monster(20, 10, 100, 1, 10, new AttackAlgorithm());
        monster.attack(player);
        int hp = player.getHealth();
        player.heal();

        assertNotEquals(hp + player.getMaxHealth() * player.healingPercent, player.getHealth());
    }

    @Test
    public void invalidDataTest(){
        assertThrows(RuntimeException.class, ()->
        {
            Player player = new Player(100, 100, 100, 1, 10, new AttackAlgorithm());
        });
    }
}
