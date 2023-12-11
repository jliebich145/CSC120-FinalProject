import java.util.Random;

public class Creature {
    /*Class Attributes */
    protected String name;
    protected int maxhp;
    protected int currenthp;
    protected int baseAttack;
    protected int Attack;
    protected int baseDefense;
    protected int Defense;
    protected Inventory inventory;
    protected Boolean alive;

    /* Constructor */
    public Creature(String name, int hp, int baseAttack, int baseDefense){
        this.name = name;
        this.currenthp = hp;
        this.maxhp = hp;
        this.baseAttack = baseAttack;
        this.Attack = baseAttack;
        this.baseDefense = baseDefense;
        this.Defense = baseDefense;
        this.inventory = new Inventory();
        this.alive = true;
    }

    public Creature(){
        this("", 0, 0, 0);
    }

    public int attack(){
        int damage = 0;
        Random rand = new Random();
        for(int i=0; i < this.Attack; i++){
            damage += (rand.nextInt(5) + 1);
        }
        return damage;
    }
    
    public Boolean attacked(int damage){
        this.currenthp -= (this.Defense - damage);
        return this.checkStatus();
    }

    public Boolean checkStatus(){
        if (this.currenthp <=0){
            this.alive = false;
        }
        return this.alive;
    }

    public int heal(int amountHealed){
        while((maxhp != currenthp) && (amountHealed > 0)){
            currenthp += 1;
            amountHealed -= 1;
        }
        return currenthp;
    }

    public String toString(){
        return this.name + " has " + this.currenthp + " health remaining";
    }
    
}
