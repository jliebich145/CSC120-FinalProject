import java.util.Random;

public class Nebula extends Star{
    /* Class Attributes */
    private int heal;
    private StarLoot nebulaLoot;
    private boolean looted;

    /* Constructor */
    public Nebula(String name){
        super(name);
        this.type = "(Nebula)";
        Random rand = new Random();
        this.heal = rand.nextInt(10) + 5; 
        int stardust = rand.nextInt(2) + 2;
        int loot = rand.nextInt(2)+1;
        this.nebulaLoot = new StarLoot(stardust, loot); 
        this.looted = false;
    }

    /**
     * Entering a nebula heals you
     * @param pc
     */
    public void enter(Player pc){
        System.out.println("Entering " + this.name + "...");
        System.out.println(this.toString());
        if(this.visited == true){
            System.out.println("You have already been healed on " + this.name);
        } else{
            this.visited = true;
            System.out.println("The strength of " + this.name + " heals you. You regain " + this.heal + " health.");
            int health = pc.heal(heal);
            System.out.println("You have " + health + " health.");
        }
    }

    /**
     * Find and add treasure to inventory
     * @param pc 
     * */
    public void loot(Player pc){
        if(this.light == true){
            this.looted = true;
            System.out.println("You find: \n" + this.nebulaLoot.toString());
            pc.pickUp(nebulaLoot);
        } else{
            System.out.println(this.name + " is dark. Light this nebula to reveal loot.");
        }
    }

    public String toString(){
        if(this.light == true){
            if(this.looted == true){
                return this.name + " is glowing! Nothing more to do here!";
            }
            return this.name + " is glowing! There appears to be things to collect here still.";
        }
        return this.name + " is a nebula, a cloud of dust and gas. Gather stardust to bring it back to light!";
    }
}
