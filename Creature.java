import java.util.Random;

public class Creature {
    /*Class Attributes */
    protected String name;
    protected int maxhp;
    protected int currenthp;
    protected int baseAttack;
    protected int attack;
    protected int baseDefense;
    protected int defense;
    protected Inventory inventory;
    protected Boolean alive;

    /* Constructor */
    public Creature(String name, int hp, int baseAttack, int baseDefense){
        this.name = name;
        this.currenthp = hp;
        this.maxhp = hp;
        this.baseAttack = baseAttack;
        this.attack = baseAttack;
        this.baseDefense = baseDefense;
        this.defense = baseDefense;
        this.inventory = new Inventory();
        this.alive = true;
    }

    /* Overloaded empty constructor */
    public Creature(){
        this("", 0, 0, 0);
    }

    /**
     * Computes a random amount of damage done when attacking
     * @return the amount of damage
     */
    public int attack(){
        int damage = 0;
        Random rand = new Random();
        for(int i=0; i < this.attack; i++){
            damage += (rand.nextInt(1)+1);
        }
        return damage;
    }
    
    /**
     * Computes the net amount of damage taken after subtracting armor value
     * @param damage the amount of damage done
     * @return if the creature is still alive
     */
    public Boolean attacked(int damage){
        int damageTaken = damage - this.defense;
        if(damageTaken > 0){
            this.currenthp -= damageTaken;
            System.out.println("damage taken: " + damageTaken);
        } else{
            System.out.println("Armor blocked all damage");
        }
        return this.checkStatus();
    }

    /**
     * Checks if still alive
     * @return true if alive
     */
    public Boolean checkStatus(){
        if (this.currenthp <=0){
            this.alive = false;
        }
        return this.alive;
    }

    /**
     * Heals the character without going over maxhp
     * @param amountHealed the incoming amount of healing
     * @return how much health they currently have
     */
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
