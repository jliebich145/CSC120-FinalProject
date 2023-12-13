import java.util.Iterator;
import com.google.common.graph.*;

public class Constellation {
    /*Class Attributes */
    private String name;
    private ImmutableGraph<Star> stars;
    private boolean complete;

    /*Constructor */
    public Constellation(String name, ImmutableGraph<Star> stars){
        this.name = name;
        this.stars = stars;
        this.complete = false;
    }

    /* Accessor */
    public ImmutableGraph<Star> getStars(){
        return this.stars;
    }

    public boolean getComplete(){
        this.checkComplete();
        return this.complete;
    }


    /**
     * Checks if the star is lit
     */
    public void checkComplete(){
        Iterator<Star> starIterator = this.stars.nodes().iterator();
        Star iteratingStar = null;
        while(starIterator.hasNext()){
            iteratingStar = starIterator.next();
            if(iteratingStar.light == true){
                this.complete = true;
            }
        } 
    }
    
    /**
     * Prints status of the constellation (state of each star and type of star, if visited)
     */
    public void status(){
        System.out.println(this.name + " Status:");
        Iterator<Star> starIterator = this.stars.nodes().iterator();
        Star iteratingStar = null;
        boolean incomplete = false;
        while(starIterator.hasNext()){
            iteratingStar = starIterator.next();
            if(iteratingStar.light == true){
                System.out.println(iteratingStar.name + ": glowing " + iteratingStar.getType());
            } else{
                if(iteratingStar.visited == true){
                    System.out.println(iteratingStar.name + ": dark " + iteratingStar.getType());
                }else{
                    System.out.println(iteratingStar.name + ": dark");
                }
                incomplete = true;
            }
        }
        if(incomplete == true){
            System.out.println("Overall Status: Incomplete");
        } else{
            System.out.println("Overall Status: Complete!");
        }
    }

    public String toString(){
        return this.name;
    }
}