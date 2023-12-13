public class Player extends Creature {

    /*Class Attributes */
    protected Star location;
    protected Constellation constellation;
    
    /*Constructor */
    public Player(String name, int hp, int baseAttack, int baseDefense, Inventory inventory){
        super(name, hp, baseAttack, baseDefense);
        this.inventory.addStardust(150);
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

    /* Pick up and add to inventory */
    public void pickUp(Inventory items){
        this.inventory.addLoot(items);
        this.equip(items);

    }

    /* Equip all items in inventory */
    public void equip(Inventory newItems){
        int healthUp = newItems.items.get("trinkets") * 5;
        this.maxhp += healthUp;
        this.attack += newItems.items.get("weapons");
        this.defense += newItems.items.get("armor");
    }
}
