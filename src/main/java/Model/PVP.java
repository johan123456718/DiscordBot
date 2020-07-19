package Model;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PVP extends ListenerAdapter {
    private String player;
    private String opponent;

    public PVP(String player, String opponent) {
        this.player = player;
        this.opponent = opponent;
    }


}
