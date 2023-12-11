import java.util.ArrayList;
import java.util.Scanner;

public class StarfallGame {
    boolean gameOver;
    Scanner input;
    String nextPhrase;
    String response;
    Commands GameCommands;
    SetUp GameSetUp;
    ArrayList<Constellation> constellations;
    Player playerCharacter;

    public StarfallGame(){
        System.out.println("Welcome to Starfall! Game Loading...");
        this.gameOver = false;
        this.input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        this.response = this.input.nextLine();
        this.nextPhrase = "INTRO STUFF!!!";
        this.GameCommands = new Commands();
        this.GameSetUp = new SetUp();
        this.constellations = this.GameSetUp.ConstellationsAndStars(); 
        System.out.println();
        this.playerCharacter = this.GameSetUp.PlayerCharacter(this.response);
        System.out.println(constellations);
        System.out.println("Game Loaded! Ready to Play!");
    }

    public boolean dialogue(){
        System.out.println(nextPhrase);
        this.response = this.input.nextLine();
        if(response.equals("1") || response.equals("2") || response.equals("3") || response.equals("4") ||response.equals("5")){
            // RESPONSE NUMBER THINGY
        } else{
            this.GameCommands.use(response, this.playerCharacter);
        }
        return this.gameOver;
    }

    /* Ends Game */
    public void endGame(){
        this.gameOver = true;
    }


    public static void main(String[] args) {
        StarfallGame g = new StarfallGame();
        //Welcome, etc.
        while(!g.gameOver){
            //get user input
            g.dialogue();
            //respond
            //check for gameOver
            g.endGame(); //REMOVE LATER (preventing infinite loop while testing set-up)
        }
        System.out.println("Game Ended. Goodbye!");
    }
}