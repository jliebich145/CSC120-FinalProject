import java.util.ArrayList;

public class StarfallGame {
    /* Class Attributes */
    boolean gameOver;
    boolean win;
    String nextPhrase; //Holds a response to the palyer
    String response; //Holds the player's input
    Commands gameCommands;
    SetUp gameSetUp;
    ArrayList<Constellation> constellations;
    Player playerCharacter; //The character

    /* Constructor */
    public StarfallGame(){
        System.out.println("Welcome to Starfall! Game Loading...");
        this.gameOver = false;
        this.win = false;
        this.gameCommands = new Commands();
        System.out.println("Please enter your name: ");
        this.response = this.gameCommands.input();
        this.gameCommands = new Commands();
        this.gameSetUp = new SetUp();
        this.constellations = this.gameSetUp.constellationsAndStars(); 
        System.out.println();
        this.playerCharacter = this.gameSetUp.playerCharacter(this.response);
        System.out.println("Game Loaded! Ready to Play!");
        this.nextPhrase = "In the distant future, a dark force has taken over the night sky. One by one, the stars have vanished. Using the constellations as your guide, your goal is to bring the stars back to light by collecting stardust and channeling its energy back into the stars. Be warned that the dark forces at play have not left these stars undefended. Use \"TRAVEL\" to select a constellation to start your journey in!";
        System.out.println(this.nextPhrase);
        this.nextPhrase = "What would you like to do? (Hint: enter \"HELP\" for list of commands!)";
    }

    /* Gameplay sequence */
    public boolean dialogue(){
        System.out.println(nextPhrase);
        this.response = this.gameCommands.input();
        this.gameOver = this.checkCommands(response);
        this.checkWin();
        return this.gameOver;
    }


    /* Ends Game */
    public void endGame(){
        this.gameOver = true;
    }

    /* Checks if game is won */
    public void checkWin(){
        this.win = true;
        for(int i = 0; i < constellations.size(); i++){
            if(constellations.get(i).getComplete() == false){
                this.win = false;
            }
        }
    }

    /* Sends response to check commands */
    public boolean checkCommands(String response){
        this.gameOver = this.gameCommands.use(response, this.playerCharacter, this);
        return this.gameOver;
    }


    public static void main(String[] args) {
        StarfallGame g = new StarfallGame();
        //Welcome, etc.
        while(g.gameOver == false){
            g.dialogue();
        }
        if(g.win == true){
            System.out.println("As the stars once again begin to shine in their constellations overhead, the dark force is banished from this world. You win!");
        }
        System.out.println("Game Ended. Goodbye!");
    }
}