import java.util.Scanner;
import java.util.ArrayList;
import com.google.common.graph.*;
import java.util.Iterator;

public class Commands {
    Scanner input;

    public Commands(){
        this.input = new Scanner(System.in);
    }

    public boolean use(String command, Player pc, StarfallGame gameObjects){
        boolean gameOver = false;
        if(command.equalsIgnoreCase("help")){
            this.help();
        }
        else if(command.equalsIgnoreCase("attack")){
            gameOver = this.attack(pc);
        }
        else if(command.equalsIgnoreCase("loot")){
            this.loot(pc);
        }
        else if(command.equalsIgnoreCase("light")){
            this.light(pc);
        }
        else if(command.equalsIgnoreCase("star status")){
            this.checkStarStatus(pc);
        }
        else if(command.equalsIgnoreCase("constellation status")){
            this.checkConstellationStatus(pc);
        }
        else if(command.equalsIgnoreCase("travel")){
            this.travel(pc, gameObjects.constellations);
        }
        else if(command.equalsIgnoreCase("move")){
            this.move(pc);
        }
        else if(command.equalsIgnoreCase("inventory")){
            this.inventory(pc);
        }
        else if(command.equalsIgnoreCase("end game")){
            return true;
        }
        else if(command.equalsIgnoreCase("index")){
            this.index();
        }
        else{
            System.out.println("Command not recognized.");
            this.help();
        }
        return gameOver;
    }

    // In game commands
    /**
     * Attacks enemies on a star
     * @param pc
     * @return true if killed (game over)
     */
    public boolean attack(Player pc){
        if(pc.getLocation() == null){
            System.out.println("Travel to a star to use this command");
            return false;
        }
        Star location = pc.getLocation();
        return location.attack(pc, this);
    }

    /**
     * Runs the loot command for the star the player is on, if on a star
     * @param pc the character
     */
    public void loot(Player pc){
        if(pc.getLocation() == null){
            System.out.println("Travel to a star to use this command");
            return;
        }
        Star location = pc.getLocation();
        location.loot(pc);
    }

    /**
     * Runs the method to deposit stardust and light a star, if the player is on a star
     * @param pc the character
     */
    public void light(Player pc){
        if(pc.getLocation() == null){
            System.out.println("Travel to a star to use this command");
            return;
        }
        Star location = pc.getLocation();
        location.light(pc);
    }

    /**
     * Check if there is anything left to do on the star, if the player is on a star
     * @param pc the character
     */
    public void checkStarStatus(Player pc){
        if(pc.getLocation() == null){
            System.out.println("Travel to a star to use this command");
            return;
        }
        Star location = pc.getLocation();
        System.out.println(location);
    }

    /**
     * Checks the status of the constellation the player is in, if they are in a constellation
     * @param pc the character
     */
    public void checkConstellationStatus(Player pc){
        if(pc.constellation == null){
            System.out.println("Travel to a constellation to use this command");
            return;
        }
        pc.constellation.status();
    }

    /**
     * Prints inventory
     * @param pc the character
     */
    public void inventory(Player pc){
        System.out.println(pc.inventory);
    }

    /**
     * Move to a new star given you are in a constellation
     * @param pc
     */
    public void move(Player pc){
        if(pc.constellation == null){
            System.out.println("You are not yet in a constellation. Use \"TRAVEL\" to go to a constellation!");
            return;
        }
        int response = -1;
        boolean valid = false;
        System.out.println("Which star would you like to travel to?");
        ImmutableGraph<Star> stars = pc.constellation.getStars();
        Iterator<Star> starIterator = null;
        if(pc.location == null){
            starIterator = stars.nodes().iterator();
        }
        else{
            starIterator = stars.adjacentNodes(pc.location).iterator();
        }
        ArrayList<Star> starList = new ArrayList<>();
        int i = 1;
        Star iteratingStar = null;
        while(starIterator.hasNext()){
            iteratingStar = starIterator.next();
            starList.add(iteratingStar);
            System.out.println(i + ": " + iteratingStar.name);
            i++;
        }
        while(valid == false){
            valid = true;
            response = this.inputNum();
            if(response > starList.size() || response < 1){
                valid = false;
                System.out.println("Not a valid selection. Please enter associated integer.");
            }
        }
        pc.enterStar(starList.get(response - 1));
    }

    /**
     * Travels to a new constellatoin
     * @param pc the character
     * @param constellations the list of constellations
     */
    public void travel(Player pc, ArrayList<Constellation> constellations){
        String response;
        System.out.println("Which constellation would you like to travel to?");
        System.out.println(constellations);
        boolean valid = false;
        while (valid == false){
            response = this.input();
            valid = true;
            if(response.equalsIgnoreCase("Ursa Major")){
                pc.enterConstellation(constellations.get(0));
            }
            else if(response.equalsIgnoreCase("Ursa Minor")){
                pc.enterConstellation(constellations.get(1));
            }
            else if(response.equalsIgnoreCase("Cassiopeia")){
                pc.enterConstellation(constellations.get(2));
            }
            else if(response.equalsIgnoreCase("Perseus")){
                pc.enterConstellation(constellations.get(3));
            }
            else if(response.equalsIgnoreCase("Andromeda")){
                pc.enterConstellation(constellations.get(4));
            }
            else if(response.equalsIgnoreCase("Pegasus")){
                pc.enterConstellation(constellations.get(5));
            }
            else if(response.equalsIgnoreCase("Cygnus")){
                pc.enterConstellation(constellations.get(6));
            }
            else if(response.equalsIgnoreCase("Lyra")){
                pc.enterConstellation(constellations.get(7));
            }
            else if(response.equalsIgnoreCase("Aquila")){
                pc.enterConstellation(constellations.get(8));
            }
            else if(response.equalsIgnoreCase("Delphinus")){
                pc.enterConstellation(constellations.get(9));
            }
            else if(response.equalsIgnoreCase("Auriga")){
                pc.enterConstellation(constellations.get(10));
            }
            else if(response.equalsIgnoreCase("Taurus")){
                pc.enterConstellation(constellations.get(11));
            }
            else if(response.equalsIgnoreCase("Orion")){
                pc.enterConstellation(constellations.get(12));
            }
            else if(response.equalsIgnoreCase("Gemini")){
                pc.enterConstellation(constellations.get(13));
            }
            else if(response.equalsIgnoreCase("Leo")){
                pc.enterConstellation(constellations.get(1));
            }
            else{
                valid = false;
                System.out.println("Not a valid constellation. Please enter a constellation from the list.");
            }
        }
        pc.constellation.status();
        this.move(pc);
    }


    // Out of game commands
    /* List of all potential commands */
    public void help(){
        System.out.println("Possible Commands:");
        System.out.println("Help: opens the list of commands");
        System.out.println("Attack: starts combat with enemies on a star, if they exist");
        System.out.println("Loot: collects stardust and items on a star, assuming the star is lit and they exist");
        System.out.println("Light: consumes stardust to light the star you are on");
        System.out.println("Move: allows you to move between stars following the constellation maps");
        System.out.println("Travel: allows you to move between constellations");
        System.out.println("Star Status: shows the status of the star you are on");
        System.out.println("Constellation Status: shows the status of the constellation you are in");
        System.out.println("Inventory: shows your inventory");
        System.out.println("Index: shows a glossary of important terms");
        System.out.println("End Game: ends the game");
    }

    /* Index of terms */
    public void index(){
        System.out.println("---------------");
        System.out.println("Index of Terms!");
        System.out.println("---------------");
        System.out.println("Goal: Gather stardust to bring stars back to light");
        System.out.println("---------------");
        System.out.println("Inventory Terms");
        System.out.println("Stardust: Bits of starlight that can be deposited on stars to make them glow");
        System.out.println("Weapons: Increase the damage you do by 1");
        System.out.println("Armor: Decrease the damage you take by 1");
        System.out.println("Trinkets: Increase your health by 5");
        System.out.println("---------------");
        System.out.println("Star Types");
        System.err.println("Yellow Star: Average stars protected by a variety of enemies");
        System.out.println("Red Stars: Cold stars protected by a boss monster");
        System.out.println("Blue Stars: Hot stars that heal when you first enter");
        System.out.println("Double Stars: Two stars that orbit eachother containing stardust");
        System.out.println("Star Clusters: Groups of stars that formed at the same time containing lots of stardust");
        System.out.println("Nebulae: Star-forming regions of hot gas and dust. These heal when you enter and contain stardust along with the potential for other loot");
        System.out.println("Galaxies: Huge collections of stars containing lots of stardust and loot");
        System.out.println("Constellations: A group of stars forming a pattern in the sky");
    }

    // Program commands
    /* Scanner */
    public String input(){
        return this.input.nextLine();
    }

    /* Scanner for integers */
    public int inputNum(){
        int response = 0;
        try{
            response = this.input.nextInt();
        } catch(Exception e){
            System.out.println("Enter an integer!");
        }
        input.nextLine(); //Clear buffer
        return response;
    }



}
