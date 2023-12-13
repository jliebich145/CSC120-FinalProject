import java.util.Random;
import java.util.ArrayList;

public class YellowStar extends Star{
    /* Class Attributes */
    private ArrayList<Monster> enemies;
    private boolean beat;

    /* Constructor */
    public YellowStar(String name){
        super(name);
        this.type = "(Yellow Star)";
        this.beat = false;
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

   /*
    * Enter a fight with the enemies until winning, fleeing, or dying
    * @param pc the player
    * @param command the gameCommands in order to use the scanner
    */
    public boolean attack(Player pc, Commands command){
        boolean attack = true;
        String response = "";
        boolean valid = false;
        boolean alive = true;
        int attackEnemy = 0;
        Monster currentMonster;
        while(this.enemies.size()>0 && attack == true){
            System.out.println("Remaining Enemies: " + this.enemies);
            valid = false;
            while(valid == false){
                System.out.println("Would you like to attack or flee?");
                response = command.input();
                if(response.equalsIgnoreCase("attack")){
                    valid = true;
                }
                else if(response.equalsIgnoreCase("flee")){
                    return false;
                }
                else{
                    System.out.println("Please input \"attack\" or \"flee\" ");
                }
            }
            for(int i = 0; i < this.enemies.size(); i++){
                int number = i + 1;
                System.out.println(number + ": " + this.enemies.get(i));
            }
            valid = false;
            while(valid == false){
                System.out.println("Enter corresponding integer to attack enemy: ");
                attackEnemy = command.inputNum();
                if(attackEnemy > 0 && attackEnemy <= this.enemies.size()){
                    valid = true;
                }
                else{
                    System.out.println("Not a valid enemy");
                }
            }
            currentMonster = this.enemies.get(attackEnemy - 1);
            alive = currentMonster.attacked(pc.attack());
            if (alive == false){
                System.out.println("Monster killed!");
                pc.pickUp(currentMonster.inventory);
                System.out.println("You receive: " + currentMonster.inventory.toString() + " for defeating this monster!");
                this.enemies.remove(attackEnemy-1);
            }
            if(this.enemies.size()>0){
                System.out.println("Enemies attacking...");
                for(int i = 0; i < this.enemies.size(); i++){
                    currentMonster = this.enemies.get(i);
                    alive = pc.attacked(currentMonster.attack());
                    if(alive == false){
                        System.out.println("You Died.");
                        return true;
                    }
                }
            }
            System.out.println("You have " + pc.currenthp + " health remaining");  
        }
        System.out.println("Congratulations! You defeated all the enemies");
        this.beat = true;
        return false;
    }

    /*
     * Remove 25 stardust to light the star as long as enemies have been defeated
     * @param pc the player
     */
    public void light(Player pc){
        if(this.light == true){
            System.out.println(this.name + " is already lit!");
            return;
        }
        else if(this.beat == false){
            System.out.println("Defeat the enemies to light this star!");
            return;
        }
        int stardust = pc.inventory.checkStardust();
        if(stardust >= 25){
            pc.inventory.removeStardust(25);
            this.light = true;
            System.out.println("You channel 25 stardust into " + this.name + " and its power is rejuvinated");
        } else{
            System.out.println("You do not have enough stardust to light " + this.name + ". Explore glowing locations to find more!");
        }

    }

    public String toString(){
        if(this.light == true){
            return this.name + " is glowing! Nothing more to do here!";
        }
        return this.name + " is a yellow star of average heat and energy. It is defended by enemies. Gather stardust and defeat the monsters to bring it back to light!";
    }
}
