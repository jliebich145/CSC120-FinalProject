import java.util.Random;

public class Monster extends Creature{
    protected int difficulty;

    public Monster(int difficulty, String name){
        super();
        this.name = name;
        this.difficulty = difficulty;
        Random rand = new Random();
        if (difficulty == 1){
            int hp = rand.nextInt(3)+1;
            StarLoot easy = new StarLoot(1);
            this.currenthp = hp;
            this.maxhp = hp;
            this.baseAttack = 1;
            this.attack = 1;
            this.baseDefense = 2;
            this.defense = 2;
            this.inventory = easy;
            this.alive = true;
        }
        else if (difficulty == 2){
            int hp = rand.nextInt(3) + 3;
            StarLoot medium = new StarLoot(3);
            this.currenthp = hp;
            this.maxhp = hp;
            this.baseAttack = 2;
            this.attack = 2;
            this.baseDefense = 3;
            this.defense = 3;
            this.inventory = medium;
            this.alive = true;
        }
        else if (difficulty == 3){
            int hp = rand.nextInt(5) + 5;
            StarLoot hard = new StarLoot(5, 1);
            this.currenthp = hp;
            this.maxhp = hp + (hard.checkTrinkets()*5);
            this.baseAttack = 4;
            this.attack = 4 + hard.checkWeapons();
            this.baseDefense = 5;
            this.defense = 5 + hard.checkArmor();
            this.inventory = hard;
            this.alive = true;
        }
        else{
            int hp = rand.nextInt(6) + 10;
            StarLoot boss = new StarLoot(8, 3);
            this.currenthp = hp;
            this.maxhp = hp + (boss.checkTrinkets()*5);
            this.baseAttack = 7;
            this.attack = 7 + boss.checkWeapons();
            this.baseDefense = 6;
            this.defense = 6 + boss.checkArmor();
            this.inventory = boss;
            this.alive = true;
        }

    }
    
}
