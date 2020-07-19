package Model;

public class RPSGame {
    private Bot bot;
    private Choices botMove;
    private String playerName;

    public RPSGame(String playerName) {
        bot = new Bot();
        this.playerName = playerName;
    }

    public String play(Choices playerMove){
        botMove = bot.getRandomMove();
        if(playerMove == null){
            return "Error! Wrong move entered!";
        } else if(playerMove == botMove){
            return "It's a tie!";
        } else if(playerMove.beats(botMove)){
            return playerName + " Wins!";
        } else {
            return "Bot Wins!";
        }
    }

    // TO-DO: refactor this to prevent returning Null
    public Choices getBotMove(){
        return botMove;
    }
}
