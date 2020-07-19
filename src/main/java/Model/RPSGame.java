package Model;

public class RPSGame {
    private Bot bot;
    private States botMove;
    private String playerName;
    private int playerPoints;
    private int botPoints;
    private int nrOfGames;

    public RPSGame(String playerName) {
        bot = new Bot();
        this.playerName = playerName;
        this.playerPoints = 0;
        this.botPoints = 0;
        this.nrOfGames = 0;
    }

    public String play(States playerMove){
        botMove = bot.getRandomMove();
        if(playerMove == null){
            return "Error! Wrong move entered!";
        } else if(playerMove == botMove){
            nrOfGames++;
            return "It's a tie!";
        } else if(playerMove.beats(botMove)){
            nrOfGames++;
            playerPoints++;
            return playerName + " wins the round";
        } else {
            nrOfGames++;
            botPoints++;
            return "Bot wins the round!";
        }
    }

    public int getPlayerPoints(){
        return playerPoints;
    }

    public int getBotPoints(){
        return botPoints;
    }

    public int getNrOfGames(){
        return nrOfGames;
    }


    public boolean doPlayerWin(){
        if(playerPoints == botPoints){
            return false;
        }else if(playerPoints < botPoints){
            return false;
        }else{
            return true;
        }
    }

    public boolean doBotWin(){
        if(botPoints == playerPoints){
            return false;
        }else if(botPoints < playerPoints){
            return false;
        }else{
            return true;
        }
    }

    public String getWinner(){
        if(doPlayerWin()){
            return "Player wins the game";
        }
        if(doBotWin()){
            return "The bot wins the game";
        }
        return "The game ends with a tie";
    }

    // TO-DO: refactor this to prevent returning Null
    public States getBotMove(){
        return botMove;
    }
}
