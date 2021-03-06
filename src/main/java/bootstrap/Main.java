package bootstrap;

import Commands.RpsCommands;
import View.RpsView;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda;
    public static String prefix;
    public static RpsView view;
    public static void main(String[] args){
        String fileName = "src/main/resources/config/bot.properties";
        try {
            Config config = new Config(fileName);
            prefix = config.getPrefix();
            jda = JDABuilder.createDefault(config.getToken())
                    .addEventListeners(new RpsCommands())
                    .build();
            jda.awaitReady();
            System.out.println("Finished Building JDA");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
