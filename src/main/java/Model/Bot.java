package Model;

import java.util.Random;

public class Bot {
    private States[] states;
    private Random random;

    private final int MOVES = 3;

    public Bot(){
        states = States.values();
        random = new Random();
    }

    public States getRandomMove(){
        return states[random.nextInt(MOVES)];
    }
}
