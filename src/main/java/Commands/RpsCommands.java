package Commands;

import View.RpsView;
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
            channel.sendMessage("Play (-rps play, to play in gui otherwise type -rps rock, paper or scissors to play in console), Rules (-rps rules), Quit (-rps quit)").queue();
            Main.jda.addEventListener(new RpsModel(player.getName()));
            Main.jda.addEventListener(new RpsView());
        }
    }
}
