package Model;

import java.util.Random;

public class Bot {
    private States currentState;
    private Random random;

    public Bot(){
        currentState = States.Empty;
        random = new Random();
    }

    public States returnBotState(){
        int randomNr = random.nextInt(3) + 1;

        if(randomNr == 1){
            currentState = States.Rock;
            return currentState;
        }else if(randomNr == 2){
            currentState = States.Paper;
            return currentState;
        }else if(randomNr == 3){
            currentState = States.Scissors;
            return currentState;
        }
        return States.Empty;
    }

    public States getCurrentState(){
        return currentState;
    }

}
