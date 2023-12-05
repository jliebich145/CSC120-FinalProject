import java.util.Hashtable;

public class StarLoot extends Inventory {

    public StarLoot(Item Stardust, int sdAmount, int weapons){
        this.items = new Hashtable<>();
        this.items.put(Stardust, sdAmount);
    }
    
}
