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

    public ImmutableGraph<Star> getStars(){
        return this.stars;
    }

    public String toString(){
        return this.name;
    }
}