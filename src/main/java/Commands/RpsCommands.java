package Commands;

import Model.PVP;
import bootstrap.Main;
import Model.RpsModel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;

import java.nio.channels.Channel;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RpsCommands extends ListenerAdapter {
    private final String VS_BOT = Main.prefix + " bot";
    private final String VS_PLAYER = Main.prefix + " pvp";
    private MessageReceivedEvent event;

    @Override
    public void onMessageReceived(MessageReceivedEvent currentEvent){
        event = currentEvent;
        String msg = event.getMessage().getContentDisplay();

        if(msg.startsWith(VS_BOT)){
            System.out.println("Starting Rock Paper Scissors Game!");
            startPVB();
        } else if(msg.startsWith((VS_PLAYER))){
            System.out.println("Starting Rock Paper Scissors Game!");
            startPVP();
        }
    }

    private void startPVB(){
        String player = event.getAuthor().getName();
        sendMessageToDiscord("Starting Rock Paper Scissors Game!");
        Main.jda.addEventListener(new RpsModel(player));
    }

    private void startPVP(){
        User player = event.getAuthor();
        String playerName = player.getName();
        List<User> opponents = event.getMessage().getMentionedUsers();
        User opponent;
        String opponentName;

        if(opponents.size() == 0){
            sendMessageToDiscord("Please mention the user you want to play against!");
        } else {
            opponent = opponents.get(0);
            opponentName = opponents.get(0).getName();
            Main.jda.addEventListener(new PVPCommand(playerName, opponentName));
            sendInstructionsToPlayers(Arrays.asList(player, opponent));
        }
    }

    private void sendMessageToDiscord(String message){
        MessageChannel channel = event.getChannel();
        channel.sendMessage(message).queue();
    }

    private void sendInstructionsToPlayers(List<User> players){
        String instructions = "Do you want to play Rock Paper Scissors? " +
                "\nRespond with `-rps yes` or `-rps no`" +
                "\nPlayers: " + players.get(0).getName() + " and " + players.get(1).getName();

        for(User player: players){
            player.openPrivateChannel()
                    .flatMap(channel -> channel.sendMessage(instructions))
                    .delay(5, TimeUnit.MINUTES)
                    .flatMap(Message::delete);
        }
    }

}
