package Model;

// All credit goes to: https://stackoverflow.com/a/19204935/12369650

public enum Choices {
    ROCK(1){
        @Override
        public boolean beats(Choices other) {
            return other == SCISSORS;
        }
    },
    PAPER(2){
        @Override
        public boolean beats(Choices other) {
            return other == ROCK;
        }
    },
    SCISSORS(3){
        @Override
        public boolean beats(Choices other) {
            return other == PAPER;
        }
    };

    private final int value;
    Choices(int value){
        this.value= value;
    }

    public int getValue(){
        return value;
    }

    public abstract boolean beats(Choices other);
}
