public class RedStar extends Star{
    Monster boss;
    boolean beat;

    public RedStar(String name){
        super(name);
        this.type = "(Red Star)";
        this.beat = false;
        this.boss = new Monster(4, "The Boss");
    }

    /*
    * Enter a fight with the boss until winning, fleeing, or dying
    * @param pc the player
    * @param command the gameCommands in order to use the scanner
    */
    public boolean attack(Player pc, Commands command){
        boolean attack = true;
        String response = "";
        boolean valid = false;
        boolean alive = true;
        while(this.boss.alive == true && attack == true){
            System.out.println(this.boss);
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
            alive = this.boss.attacked(pc.attack());
            if (alive == true){
                System.out.println("Boss attacking...");
                alive = pc.attacked(this.boss.attack());
                if(alive == false){
                    System.out.println("You Died.");
                    return true;
                }
            } 
            System.out.println("You have " + pc.currenthp + " health remaining");  
        }
        System.out.println("Congratulations! You defeated the boss");
        pc.pickUp(this.boss.inventory);
        this.beat = true;
        System.out.println("You receive: " + this.boss.inventory.toString() + " for defeating the boss!");
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
        return this.name + " is a cool red star. It is the home of a powerful enemy. Gather stardust and defeat the monster to bring it back to light!";
    }
}
