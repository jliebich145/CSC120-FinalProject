import java.util.Random;

public class StarCluster extends Star{
    /* Class Attributes */
    private StarLoot clusterStardust;
    private boolean looted;

    /* Constructor */
    public StarCluster(String name){
        super(name);
        Random rand = new Random();
        int stardust = rand.nextInt(5) + 4;
        this.clusterStardust = new StarLoot(stardust);
        this.looted = false;
    }

    /**
     * Find and add treasure to inventory
     * @param pc 
     * */
    public void Loot(Player pc){
        if(this.light == true){
            this.looted = true;
            System.out.println("You find " + this.clusterStardust.checkStardust() + " stardust!");
            pc.inventory.addLoot(clusterStardust);
        } else{
            System.out.println(this.name + " is dark. Light this star cluster to reveal loot.");
        }
    }

    public String toString(){
        if(this.light == true){
            if(this.looted == true){
                return this.name + " is glowing! Nothing more to do here!";
            }
            return this.name + " is glowing! There appears to be things to collect here still.";
        }
        return this.name + " is a star cluster, many stars that formed closely at the same time. Gather stardust to bring it back to light!";
    }
}
