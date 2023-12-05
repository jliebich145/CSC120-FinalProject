import java.util.Hashtable;

public class Inventory {
    /*Class Attributes */
    protected Hashtable<Item, Integer> items;

    public Inventory(){
        this.items = new Hashtable<>();
    }
}
