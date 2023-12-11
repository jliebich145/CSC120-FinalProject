public class Commands {

    public Commands(){
    }

    public void use(String command, Player pc){
        if(command.equalsIgnoreCase("help")){
            this.help();
        }
        else if(command.equalsIgnoreCase("attack")){
            this.attack(pc);
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
        else if(command.equalsIgnoreCase("move")){
            //FINISH THIS!!!
        }
        else{
            System.out.println("Command not recognized.");
            this.help();
        }
    }

    // In game commands
    /* Attack enemies on star */
    public void attack(Player pc){
        Star location = pc.getLocation();
        location.attack(pc);
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


    // Out of game commands
    /* List of all potential commands */
    public void help(){
        System.out.println("Possible Commands:");
    }



}
