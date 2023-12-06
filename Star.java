public class Star {
    /*Class Attributes */
    protected String name;
    protected boolean visited;

    public Star(String name){
        this.name = name;
        this.visited = false;
    }

    public String toString(){
        return this.name;
    }

}
