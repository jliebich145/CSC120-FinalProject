import com.google.common.graph.*;

public class Constellation {
    /*Class Attributes */
    private String name;
    private ImmutableGraph<Star> stars;

    /*Constructor */
    public Constellation(String name, ImmutableGraph<Star> stars){
        this.name = name;
        this.stars = stars;
    }

    public String toString(){
        return "Constellation: " + this.name + " Stars in Constellation: " + this.stars;
    }
}