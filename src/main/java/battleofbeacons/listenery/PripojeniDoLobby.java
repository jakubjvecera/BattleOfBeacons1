package battlebeacons.listenery;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import battlebeacons.lobby.Lobby;

public class PripojeniDoLobby implements Listener {

    private final Lobby lobby;

    public PripojeniDoLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent playerJoinEvent) {
        var player  = playerJoinEvent.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(lobby.nahodneMistoVLobby());
    }
}
