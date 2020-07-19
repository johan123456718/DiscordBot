package Model;

import java.util.Random;

public class Bot {
    private Choices[] states;
    private Random random;

    private final int MOVES = 3;

    public Bot(){
        states = Choices.values();
        random = new Random();
    }

    public Choices getRandomMove(){
        return states[random.nextInt(MOVES)];
    }
}
