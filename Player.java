public class Player extends Creature {

    /*Class Attributes */
    protected Star location;
    protected Constellation constellation;
    
    /*Constructor */
    public Player(String name, int hp, int baseAttack, int baseDefense, Inventory inventory){
        super(name, hp, baseAttack, baseDefense);
        this.inventory.addStardust(100);
    }

    /* Accessors */
    public Star getLocation(){
        return location;
    }

    /* Change location*/
    public void enterStar(Star location){
        this.location = location;
        this.location.enter(this);
    }

    /* Change constellation */
    public void enterConstellation(Constellation constellation){
        this.location = null;
        this.constellation = constellation;
        System.out.println("Travelling to " + constellation);
    }
}
