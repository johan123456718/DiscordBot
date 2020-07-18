package Model;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
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
        Boolean messageChecker = message.getContentDisplay().equalsIgnoreCase(States.Rock.toString()) ||
                message.getContentDisplay().equalsIgnoreCase(States.Paper.toString()) ||
                message.getContentDisplay().equalsIgnoreCase(States.Scissors.toString());

        if(messageChecker) {
            System.out.println("User answer: " + message.getContentDisplay());
            System.out.println("Computer answer: " + bot.returnBotState().toString());

            if (message.getContentDisplay().equalsIgnoreCase(States.Rock.toString()) && bot.getCurrentState().equals(States.Rock)) {
                System.out.println("It's a tie ");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Rock.toString()) && bot.getCurrentState().equals(States.Paper)) {
                System.out.println("Bot wins");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Rock.toString()) && bot.getCurrentState().equals(States.Scissors)) {
                System.out.println("Player wins");
            }
            //---------------------//
            if (message.getContentDisplay().equalsIgnoreCase(States.Paper.toString()) && bot.getCurrentState().equals(States.Rock)) {
                System.out.println("Player wins");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Paper.toString()) && bot.getCurrentState().equals(States.Paper)) {
                System.out.println("It's a tie");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Paper.toString()) && bot.getCurrentState().equals(States.Scissors)) {
                System.out.println("Bot wins");
            }

            //---------------------//

            if (message.getContentDisplay().equalsIgnoreCase(States.Scissors.toString()) && bot.getCurrentState().equals(States.Rock)) {
                System.out.println("Bot wins");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Scissors.toString()) && bot.getCurrentState().equals(States.Paper)) {
                System.out.println("Player wins");
            }

            if (message.getContentDisplay().equalsIgnoreCase(States.Scissors.toString()) && bot.getCurrentState().equals(States.Scissors)) {
                System.out.println("It's a tie");
            }
        }
    }

}
