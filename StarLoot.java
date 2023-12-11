import java.util.Random;

public class StarLoot extends Inventory {

    public StarLoot(int stardustRoll, int itemRoll){
        super();
        Random rand = new Random();
        for(int i = 0; i < stardustRoll; i++){
            int stardust = rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + 20;
            stardust += this.items.get("stardust");
            this.items.replace("stardust", stardust);
        }
        for(int i = 0; i < itemRoll; i++){
            int item = rand.nextInt(6);
            if(item == 1){
                this.items.replace("weapons", (this.items.get("weapons") + 1));
            }
            else if(item == 2){
                this.items.replace("armor", (this.items.get("armor") + 1));
            }
            else if(item == 3){
                this.items.replace("trinkets", (this.items.get("trinkets") + 1));
            }
        }
    }

    public StarLoot(int stardustRoll){
        this(stardustRoll, -1);
    }

    public String toString(){
        return "Stardust: " + this.items.get("stardust") + "\nWeapons " + this.items.get("weapons") + "\nArmor " + this.items.get("armor") + "\nTrinkets " + this.items.get("trinkets");
    }
    
}
