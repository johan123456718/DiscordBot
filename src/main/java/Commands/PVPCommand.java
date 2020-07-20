package Commands;

import Model.Choices;
import Model.PVP;
import bootstrap.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class PVPCommand extends ListenerAdapter {
    private PVP pvpLogic;
    private final int MAX_ROUNDS = 3;
    private final ArrayList<String> validCommands = new ArrayList<>(Arrays.asList(  Choices.ROCK.toString(),
                                                                                    Choices.PAPER.toString(),
                                                                                    Choices.SCISSORS.toString()));

    public PVPCommand(String player, String opponent) {
        pvpLogic = new PVP(player, opponent);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String message = event.getMessage().getContentDisplay().toUpperCase();
        String move = message.replace(Main.prefix.toUpperCase() + " ", "");
        String validMessage = ;
        boolean messageIsValid = message.startsWith(validMessage) && validCommands.contains(move);

        if(messageIsValid && pvpLogic.getRounds() < MAX_ROUNDS){
            // TO-DO: get moves from PLayer and opponent
            pvpLogic.play(null, null);
            channel.sendMessage(pvpLogic.getRoundResults()).queue();
        }
    }

    private boolean playerAcceptsGame(String message){
        String validMessage = (Main.prefix + " y").toUpperCase();
        return message.startsWith(validMessage);
    }

    private


}

/*
- Send DM to players
- Record moves from Players
 */
