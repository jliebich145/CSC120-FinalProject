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
        else if(command.equalsIgnoreCase("check status")){
            this.checkStatus(pc);
        }
        else if(command.equalsIgnoreCase("travel")){
            this.travel(pc, gameObjects.constellations);
        }
        else if(command.equalsIgnoreCase("move")){
            this.move(pc);
        }
        else if(command.equalsIgnoreCase("end game")){
            return true;
        }
        else{
            System.out.println("Command not recognized.");
            this.help();
        }
        return gameOver;
    }

    // In game commands
    /* Attack enemies on star */
    public boolean attack(Player pc){
        Star location = pc.getLocation();
        return location.attack(pc, this);
    }

    /* Collect loot on star */
    public void loot(Player pc){
        Star location = pc.getLocation();
        location.loot(pc);
    }

    /* Deposit stardust to complete objective */
    public void light(Player pc){
        Star location = pc.getLocation();
        location.light(pc);
    }

    /* Check if there is anything remaining to do on star */
    public void checkStatus(Player pc){
        Star location = pc.getLocation();
        System.out.println(location.toString());
    }

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
            response = this.inputNum();
            valid = true;
            if(response > starList.size() || response < 1){
                valid = false;
                System.out.println("Not a valid selection. Please enter associated integer.");
            }
        }
        pc.enterStar(starList.get(response - 1));
    }

    /* Travel to a new constellation */
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
        this.move(pc);
    }


    // Out of game commands
    /* List of all potential commands */
    public void help(){
        System.out.println("Possible Commands:");
    }

    // Program commands
    /* Scanner */
    public String input(){
        return this.input.nextLine();
    }

    public int inputNum(){
        int response = this.input.nextInt();
        input.nextLine(); //Clear buffer
        return response;
    }



}
