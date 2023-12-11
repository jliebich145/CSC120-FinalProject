import java.util.Random;
import java.util.ArrayList;

public class YellowStar extends Star{
    private ArrayList<Monster> enemies;

    public YellowStar(String name){
        super(name);
        this.enemies = new ArrayList<>();
        Random rand = new Random();
        int enemyType = rand.nextInt(3);
        if(enemyType == 1){
            int numEnemy = rand.nextInt(4) + 1;
            Monster starsnake1 = new Monster(1, "Starsnake 1");
            this.enemies.add(starsnake1);
            Monster starsnake2 = new  Monster(1, "Starsnake 2");
            this.enemies.add(starsnake2);
            if(numEnemy == 3 || numEnemy == 4 || numEnemy ==5){
                Monster starsnake3 = new  Monster(1, "Starsnake 3");
                this.enemies.add(starsnake3);
            }
            if(numEnemy == 4 || numEnemy == 5){
                Monster starsnake4 = new  Monster(1, "Starsnake 4");
                this.enemies.add(starsnake4);
            }
            if(numEnemy == 5){
                Monster starsnake5 = new  Monster(1, "Starsnake 5");
                this.enemies.add(starsnake5);
            }
        }
        else if(enemyType == 2){
            int numMedium = rand.nextInt(2);
            int numEasy = rand.nextInt(2);
            Monster starsnake1 = new Monster(1, "Starsnake 1");
            this.enemies.add(starsnake1);
            Monster shrieker1 = new  Monster(2, "Shrieker 1");
            this.enemies.add(shrieker1);
            if(numMedium == 2){
                Monster shrieker2 = new  Monster(2, "Shrieker 2");
                this.enemies.add(shrieker2);
            }
            if(numEasy == 2){
                Monster starsnake2 = new  Monster(1, "Starsnake 2");
                this.enemies.add(starsnake2);
            }
        }
        else{
            Monster devourer = new Monster(3, "devourer");
            this.enemies.add(devourer);
        } 
    }
}
