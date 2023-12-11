public class RedStar extends Star{
    Monster boss;
    public RedStar(String name){
        super(name);
        this.boss = new Monster(4, "Boss");
    }
}
