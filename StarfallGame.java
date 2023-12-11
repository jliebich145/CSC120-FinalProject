import java.util.ArrayList;

public class StarfallGame {
    boolean gameOver;
    String nextPhrase;
    String response;
    Commands GameCommands;
    SetUp GameSetUp;
    ArrayList<Constellation> constellations;
    Player playerCharacter;

    public StarfallGame(){
        System.out.println("Welcome to Starfall! Game Loading...");
        this.gameOver = false;
        this.GameCommands = new Commands();
        System.out.println("Please enter your name: ");
        this.response = this.GameCommands.input();
        this.GameCommands = new Commands();
        this.GameSetUp = new SetUp();
        this.constellations = this.GameSetUp.ConstellationsAndStars(); 
        System.out.println();
        this.playerCharacter = this.GameSetUp.PlayerCharacter(this.response);
        System.out.println("Game Loaded! Ready to Play!");
        this.nextPhrase = "INTRO STUFF!!!";
        System.out.println(this.nextPhrase);
        this.nextPhrase = "What would you like to do next? (Hint: enter \"HELP\" for list of commands!)";
    }

    /* Gameplay sequence */
    public boolean dialogue(){
        System.out.println(nextPhrase);
        this.response = this.GameCommands.input();
        this.gameOver = this.checkCommands(response);
        return this.gameOver;
    }


    /* Ends Game */
    public void endGame(){
        this.gameOver = true;
    }

    /* Sends response to check commands */
    public boolean checkCommands(String response){
        this.gameOver = this.GameCommands.use(response, this.playerCharacter, this);
        return this.gameOver;
    }


    public static void main(String[] args) {
        StarfallGame g = new StarfallGame();
        //Welcome, etc.
        while(g.gameOver == false){
            g.dialogue();
        }
        System.out.println("Game Ended. Goodbye!");
    }
}