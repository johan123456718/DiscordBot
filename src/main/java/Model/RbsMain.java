package Model;

import Commands.RpsCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


import javax.security.auth.login.LoginException;

public class RbsMain {
    public static JDA jda;
    public static void main(String[] args){
        try {
            jda = JDABuilder.createDefault("token")
                    .addEventListeners(new RpsCommands())
                    .build();
            jda.awaitReady();
            System.out.println("Finished Building JDA");
        }catch (LoginException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
