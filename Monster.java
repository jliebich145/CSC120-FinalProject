import java.util.Random;

public class Monster extends Creature{
    protected int difficulty;

    public Monster(int difficulty, String name){
        super();
        this.name = name;
        this.difficulty = difficulty;
        Random rand = new Random();
        if (difficulty == 1){
            int hp = rand.nextInt(4);
            StarLoot easy = new StarLoot(1);
            this.currenthp = hp;
            this.maxhp = hp;
            this.baseAttack = 1;
            this.Attack = 1;
            this.baseDefense = 2;
            this.Defense = 2;
            this.inventory = easy;
            this.alive = true;
        }
        else if (difficulty == 2){
            int hp = rand.nextInt(4) + 3;
            StarLoot medium = new StarLoot(3);
            this.currenthp = hp;
            this.maxhp = hp;
            this.baseAttack = 2;
            this.Attack = 2;
            this.baseDefense = 4;
            this.Defense = 4;
            this.inventory = medium;
            this.alive = true;
        }
        else if (difficulty == 3){
            int hp = rand.nextInt(6) + 5;
            StarLoot hard = new StarLoot(5, 1);
            this.currenthp = hp;
            this.maxhp = hp + hard.checkTrinkets();
            this.baseAttack = 4;
            this.Attack = 4 + hard.checkWeapons();
            this.baseDefense = 6;
            this.Defense = 6 + hard.checkArmor();
            this.inventory = hard;
            this.alive = true;
        }
        else{
            int hp = rand.nextInt(6) + 10;
            StarLoot boss = new StarLoot(8, 3);
            this.currenthp = hp;
            this.maxhp = hp + boss.checkTrinkets();
            this.baseAttack = 7;
            this.Attack = 7 + boss.checkWeapons();
            this.baseDefense = 6;
            this.Defense = 6 + boss.checkArmor();
            this.inventory = boss;
            this.alive = true;
        }

    }
    
}
