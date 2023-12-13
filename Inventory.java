import java.util.Hashtable;

public class Inventory {
    /*Class Attributes */
    protected Hashtable<String, Integer> items;

    /* Constructor */
    public Inventory(){
        this.items = new Hashtable<>();
        this.items.put("stardust", 0);
        this.items.put("weapons", 0);
        this.items.put("armor", 0);
        this.items.put("trinkets", 0);
    }

    /* Accessors */
    public int checkStardust(){
        return this.items.get("stardust");
    }

    public int checkWeapons(){
        return this.items.get("weapons");
    }

    public int checkArmor(){
        return this.items.get("armor");
    }

    public int checkTrinkets(){
        return this.items.get("trinkets");
    }

    /**
     * Removes stardust when lighting a star
     * @param minus the amount removed
     */
    public void removeStardust(int minus){
        Integer stardust = this.checkStardust();
        stardust -= minus;
        this.items.replace("stardust", stardust);
    }

    /**
     * Adds stardust to inventory
     * @param plus the amount to add
     */
    public void addStardust(int plus){
        Integer stardust = this.checkStardust();
        stardust += plus;
        this.items.replace("stardust", stardust);
    }

    /**
     * Adds weapons to inventory
     * @param plus the amount to add
     */
    public void addWeapons(int plus){
        Integer weapons = this.checkWeapons();
        weapons += plus;
        this.items.replace("weapons", weapons);
    }

    /**
     * Adds armor to inventory
     * @param plus the amount to add
     */
    public void addArmor(int plus){
        Integer armor = this.checkArmor();
        armor += plus;
        this.items.replace("armor", armor);
    }

    /**
     * Adds trinkets to inventory
     * @param plus the amount to add
     */
    public void addTrinkets(int plus){
        Integer trinkets = this.checkTrinkets();
        trinkets += plus;
        this.items.replace("trinkets", trinkets);
    }

    /**
     * Adds all loot possible from a star
     * @param loot an inventory of loot, usually as StarLoot
     */
    public void addLoot(Inventory loot){
        this.addStardust(loot.items.get("stardust"));
        this.addArmor(loot.items.get("armor"));
        this.addWeapons(loot.items.get("weapons"));
        this.addTrinkets(loot.items.get("trinkets"));
    }

    public String toString(){
        return "Stardust (used to light stars): " + this.items.get("stardust") + "\nWeapons (increase your attack power): " + this.items.get("weapons") + "\nArmor (increase your defense): " + this.items.get("armor") + "\nTrinkets (increase your health): " + this.items.get("trinkets");
    }
}
