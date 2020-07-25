package View;

import bootstrap.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class RpsView extends ListenerAdapter {
    EmbedBuilder eb = new EmbedBuilder();

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event){
        if(event.getReactionEmote().getName().equals("🎱") && !event.getUser().isBot()){

        }
    }

    /* Cred to this site for adding emojis
    https://stackoverflow.com/questions/56761174/how-to-add-reaction-to-an-embed-message-jda
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay().toLowerCase();
        if(msg.startsWith(Main.prefix + " play")) {
            eb.setTitle("Rock, Paper, Scissors motherfucka", null);
            eb.setDescription("Welcome " + event.getAuthor().getName());
            eb.addField("Choose between rock, paper or scissors", "lol", false);
            eb.setColor(new Color(0xF40C0C));
            //channel.sendMessage(eb.build()).queue();
            //channel.sendMessage(eb.build()).complete().addReaction("🥅").queue();
            channel.sendMessage(eb.build()).queue(message -> {
                message.addReaction("🗿").queue();
                message.addReaction("📰").queue();
                message.addReaction("✂️").queue();
            });
        }
    }
}
