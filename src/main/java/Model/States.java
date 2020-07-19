package Model;

// All credit goes to: https://stackoverflow.com/a/19204935/12369650

public enum States {
    ROCK(1){
        @Override
        public boolean beats(States other) {
            return other == SCISSORS;
        }
    },
    PAPER(2){
        @Override
        public boolean beats(States other) {
            return other == ROCK;
        }
    },
    SCISSORS(3){
        @Override
        public boolean beats(States other) {
            return other == PAPER;
        }
    };

    private final int value;
    States(int value){
        this.value= value;
    }

    public int getValue(){
        return value;
    }

    public abstract boolean beats(States other);
}
