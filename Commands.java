public class Commands {

    public Commands(){
    }

    public void use(String command){
        if(command.equalsIgnoreCase("!test")){
            this.test();
        }
        if(command.equalsIgnoreCase("!help")){
            this.help();
        }
        else{
            System.out.println("Command not recognized.");
            this.help();
        }
    }

    public void test(){
        System.out.println("Test success!");
    }

    /* List of all potential commands */
    public void help(){
        System.out.println("Possible Commands:");
    }



}
