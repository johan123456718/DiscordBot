package Model;

import java.util.Random;

public class Bot {
    private States botState;
    private Random random;

    public Bot(){
        random = new Random();
    }

    public States returnBotState(){
        int randomNr = random.nextInt(3) + 1;
        System.out.println(randomNr);

        if(randomNr == 1){
            return States.Rock;
        }else if(randomNr == 2){
            return States.Paper;
        }else if(randomNr == 3){
            return States.Scissors;
        }
        return States.Empty;
    }

}
