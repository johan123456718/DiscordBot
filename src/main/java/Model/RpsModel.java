package Model;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RpsModel extends ListenerAdapter {
    private Bot bot;

    public RpsModel(){
        bot = new Bot();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        Message message = event.getMessage();
        System.out.println("Bots state: " + bot.returnBotState().toString());
        System.out.println("User answer: "  + message.getContentDisplay());
        System.out.println("Computer answer: " + bot.returnBotState().toString());
        System.out.println("Computers state: " + bot.getCurrentState().toString());
        if(message.getContentDisplay().equalsIgnoreCase(States.Rock.toString()) && bot.getCurrentState().equals(States.Scissors)){
            System.out.println("Users winner");
        }
    }

}
