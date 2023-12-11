import java.util.Hashtable;

public class Inventory {
    /*Class Attributes */
    protected Hashtable<String, Integer> items;

    public Inventory(){
        this.items = new Hashtable<>();
        this.items.put("stardust", 0);
        this.items.put("weapons", 0);
        this.items.put("armor", 0);
        this.items.put("trinket", 0);
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

    /* Add/Remove Items */
    public void removeStardust(int minus){
        Integer stardust = this.checkStardust();
        stardust -= minus;
        this.items.replace("stardust", stardust);
    }

    public void addStardust(int plus){
        Integer stardust = this.checkStardust();
        stardust += plus;
        this.items.replace("stardust", stardust);
    }

    public void addWeapons(int plus){
        Integer weapons = this.checkWeapons();
        weapons += plus;
        this.items.replace("weapons", weapons);
    }

    public void addArmor(int plus){
        Integer armor = this.checkArmor();
        armor += plus;
        this.items.replace("armor", armor);
    }

    public void addTrinkets(int plus){
        Integer trinkets = this.checkTrinkets();
        trinkets += plus;
        this.items.replace("trinkets", trinkets);
    }

    public void addLoot(Inventory loot){
        this.addStardust(loot.items.get("stardust"));
        this.addArmor(loot.items.get("armor"));
        this.addWeapons(loot.items.get("weapons"));
        this.addTrinkets(loot.items.get("trinkets"));
    }
}
