package Model;

import java.util.StringJoiner;

public class PVP {
    // TO-DO: Refactor out player and opponent attribute, into Player Class
    private String playerName;
    private String opponentName;
    private String playerMoveStr;
    private String opponentMoveStr;
    private String roundResults;
    private int playerPoints;
    private int opponentPoints;
    private int rounds;

    private final String TIE = "TIE";
    private final String PLAYER = "PLAYER";
    private final String OPPONENT = "OPPONENT";

    public PVP(String playerName, String opponentName) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.playerMoveStr = "";
        this.opponentMoveStr = "";
        this.roundResults = "";
        this.playerPoints = 0;
        this.opponentPoints = 0;
        this.rounds = 0;
    }


    public String getRoundResults(){
        // TO-DO Refactor this later; not sure if its needed
        if(roundResults.isEmpty()){
            throw new IllegalCallerException("Call `play()` method first!");
        }
        return roundResults;
    }

    public int getRounds(){
        return rounds;
    }

    public void play(Choices playerMove, Choices opponentMove){

        playerMoveStr = playerMove.toString();
        opponentMoveStr = opponentMove.toString();

        if(playerMove == opponentMove){
            runGame(TIE);
        } else if(playerMove.beats(opponentMove)){
            runGame(PLAYER);
        } else if(opponentMove.beats(playerMove)){
            runGame(OPPONENT);
        } else {
            runGame("error");
        }
    }

    private void runGame(String winner){
        rounds++;
        switch(winner){
            case TIE:
                roundResults = gameMessage("It's a tie!");
                break;
            case PLAYER:
                playerPoints++;
                roundResults =  gameMessage(playerName + " wins!");
                break;
            case OPPONENT:
                opponentPoints++;
                roundResults = gameMessage(opponentName + " wins!");
                break;
            default:
                roundResults =  "Error! Wrong move entered!";
                break;
        }
    }

    private String gameMessage(String matchResults){
        StringJoiner gameMessage = new StringJoiner("\n");

        String opponentStats = opponentName + " points: " + opponentPoints;
        String playerStats = playerName + " points: " + playerPoints;
        String pMove = "Player Move: " + playerMoveStr;
        String oMove = "Player Move: " + opponentMoveStr;
        String numberOfRounds = "Number of rounds: " + rounds;

        gameMessage.add(opponentStats).add(playerStats).add(pMove).add(oMove).add(matchResults).add(numberOfRounds);

        return gameMessage.toString();
    }


}
