package Model;
import bootstrap.Main;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class RpsModel extends ListenerAdapter {
    private Bot bot;
    private RPSGame game;
    private final ArrayList<String> validCommands = new ArrayList<>(Arrays.asList(States.ROCK.toString(),
                                                                                    States.PAPER.toString(),
                                                                                    States.SCISSORS.toString()));

    public RpsModel(String playerName){
        bot = new Bot();
        game = new RPSGame(playerName);
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String message = event.getMessage().getContentDisplay().toUpperCase();
        String move = message.replace(Main.prefix.toUpperCase() + " ", "");
        boolean messageIsValid = message.startsWith(Main.prefix.toUpperCase()) && validCommands.contains(move);
        System.out.println("Message: " + message);
        System.out.println(message.startsWith(Main.prefix));
        System.out.println("Move: " + move);
        System.out.println(messageIsValid);

        if(messageIsValid) {
            String gameMessage = game.play(States.valueOf(move));
            channel.sendMessage("Bot's move: " + game.getBotMove().toString()).queue();
            // TO-DO: refactor this to prevent nulls from going into the play method
            channel.sendMessage(gameMessage).queue();
        }
    }

}
