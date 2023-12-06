import java.util.Random;

public class BlueStar extends Star{
    private int heal;

    public BlueStar(String name){
        super(name);
        Random rand = new Random();
        this.heal = rand.nextInt(10) + 5;
    }

    public Creature Enter(Creature pc){
        pc.changeLocation(this);
        System.out.println("Welcome to " + this.name + "!");
        if(this.visited = true){
            System.out.println("You have already been healed on " + this.name);
        } else{
            this.visited = true;
            System.out.println("The strength of " + this.name + " heals you. You regain " + this.heal + " health.");
            int health = pc.heal(heal);
            System.out.println("You have " + health + " health.");
        }
        return pc;
    }
    
}
