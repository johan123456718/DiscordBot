package Commands;

import Model.RpsModel;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RpsCommands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String msg = event.getMessage().getContentDisplay();
        if(msg.equalsIgnoreCase("rbs")){
            System.out.println("hello");
        }
    }
}
