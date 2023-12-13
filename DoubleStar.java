import java.util.Random;

public class DoubleStar extends Star {
    /* Class Attributes */
    private StarLoot doubleStardust;
    private boolean looted;

    /* Constructor */
    public DoubleStar(String name){
        super(name);
        this.type = "(Double Star)";
        Random rand = new Random();
        int stardust = rand.nextInt(1) + 3;
        this.doubleStardust = new StarLoot(stardust);
        this.looted = false;
    }

    /**
     * Find and add treasure to inventory
     * @param pc 
     * */
    public void loot(Player pc){
        if(this.light == true){
            this.looted = true;
            System.out.println("You find " + this.doubleStardust.checkStardust() + " stardust!");
            pc.pickUp(doubleStardust);
        } else{
            System.out.println(this.name + " is dark. Light this double star to reveal loot.");
        }
    }

    public String toString(){
        if(this.light == true){
            if(this.looted == true){
                return this.name + " is glowing! Nothing more to do here!";
            }
            return this.name + " is glowing! There appears to be things to collect here still.";
        }
        return this.name + " is a double star, two stars that orbit eachother so closely they look like one star from far away. Gather stardust to bring it back to light!";
    }
}
