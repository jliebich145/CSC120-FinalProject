import java.util.Random;

public class BlueStar extends Star{
    /* Class Attribute */
    private int heal;

    /* Constructor */
    public BlueStar(String name){
        super(name);
        this.type = "(Blue Star)";
        Random rand = new Random();
        this.heal = rand.nextInt(10) + 5; 
    }

    /**
     * Healing when entering a blue star
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

    public String toString(){
        if(this.light == true){
            return this.name + " is glowing! Nothing more to do here!";
        }
        return this.name + " is a very hot blue star. Gather stardust to bring it back to light!";
    }
    
}
