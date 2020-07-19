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

import java.util.List;


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
        String player = event.getAuthor().getName();
        List<User> opponents = event.getMessage().getMentionedUsers();
        String playersOpponent;

        if(opponents.size() == 0){
            sendMessageToDiscord("Please mention the user you want to play against!");
        } else {
            playersOpponent = opponents.get(0).getName();
            Main.jda.addEventListener(new PVPCommand(player, playersOpponent));
        }
    }

    private void sendMessageToDiscord(String message){
        MessageChannel channel = event.getChannel();
        channel.sendMessage(message).queue();
    }

}
