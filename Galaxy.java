import java.util.Random;

public class Galaxy extends Star{
    /* Class Attributes */
    private StarLoot galaxyLoot;
    private boolean looted;

    /* Constructor */
    public Galaxy(String name){
        super(name);
        Random rand = new Random();
        int stardust = rand.nextInt(10) + rand.nextInt(10) + 10;
        int loot = rand.nextInt(5) + 3;
        this.galaxyLoot = new StarLoot(stardust, loot); 
        this.looted = false;
    }

    /**
     * Find and add treasure to inventory
     * @param pc 
     * */
    public void Loot(Player pc){
        if(this.light == true){
            this.looted = true;
            System.out.println("You find: \n" + this.galaxyLoot.toString());
            pc.inventory.addLoot(galaxyLoot);
        } else{
            System.out.println(this.name + " is dark. Light this galaxy to reveal loot.");
        }
    }

    public String toString(){
        if(this.light == true){
            if(this.looted == true){
                return this.name + " is glowing! Nothing more to do here!";
            }
            return this.name + " is glowing! There appears to be things to collect here still.";
        }
        return this.name + " is a galaxy that only appears to be in this constellation but is much further away. Gather stardust to bring it back to light!";
    }


    
}
