public class Star {
    /*Class Attributes */
    protected String name;
    protected boolean visited;
    protected boolean light;

    /* Constructor */
    public Star(String name){
        this.name = name;
        this.visited = false;
        this.light = false;
    }

    /*Accessors */
    public boolean getLight(){
        return light;
    }

    public void enter(Player pc){
        System.out.println("Entering " + this.name + "...\n" + this.toString());
        this.visited = true;
        return;
    }

    /**
     * Allows a character to fight enemies
     * @param pc
     */
    public boolean attack(Player pc, Commands command){
        if(this.light == true){
            System.out.println("No enemies to attack on " + this.name);
        } else{
            System.out.println(this.name + " is dark. Light this location to reveal enemies.");
        }
        return false;
    }

    /**
     * Allows a character to pick up loot
     * @param pc
     */
    public void loot(Player pc){
        if(this.light == true){
            System.out.println("No loot to collect on " + this.name);
        } else{
            System.out.println(this.name + " is dark. Light this location to reveal loot.");
        }
    }

    /**
     * Allows the character to light a star
     * @param pc
     */
    public void light(Player pc){
        if(this.light == true){
            System.out.println(this.name + " is already lit!");
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

    public void exit(Player pc){
        System.out.println(this.toString() + "Leaving " + this.name + "...");
    }

    public String toString(){
        if(this.light == true){
            return this.name + " is glowing! Nothing more to do here!";
        }
        return this.name + " is still dark. Gather stardust to light this star!";
    }

}
