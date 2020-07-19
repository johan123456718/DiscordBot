package Commands;

import bootstrap.Main;
import Model.RpsModel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class RpsCommands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        User player = event.getAuthor();
        String msg = event.getMessage().getContentDisplay().toLowerCase();
        if(msg.startsWith(Main.prefix + " start")){
            System.out.println("Starting Rock Paper Scissors game");
            channel.sendMessage("Starting Rock Paper Scissors game").queue();
            Main.jda.addEventListener(new RpsModel(player.getName()));
        }
    }
}
