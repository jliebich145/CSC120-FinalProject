import java.util.Scanner;

public class StarfallGame {
    boolean gameOver;
    Scanner input;
    String nextPhrase;
    String action;
    Commands gameCommands;
    SetUp gameSetUp;

    public StarfallGame(){
        System.out.println("Welcome to Starfall! Game Loading...");
        this.gameOver = false;
        this.input = new Scanner(System.in);
        this.nextPhrase = "Test Phrase. Please Respond:";
        this.action = "Test Fail";
        this.gameCommands = new Commands();
        this.gameSetUp = new SetUp();
        System.out.println("Game Loaded! Ready to Play!");
    }

    public boolean dialogue(){
        System.out.println(nextPhrase);
        this.action = this.input.nextLine();
        if(this.action.startsWith("!")){
            this.gameCommands.use(action);
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