package battlebeacons.lobby;

import org.bukkit.plugin.Plugin;

public final class LobbyCreator {

    private static final String LOBBY_LOCATION_START_CORNER = "LobbyLocationStartCorner";
    private static final String LOBBY_LOCATION_END_CORNER = "LobbyLocationEndCorner";

    private final Plugin plugin;

    public LobbyCreator(Plugin plugin) {
        this.plugin = plugin;
    }

    public battlebeacons.lobby.Lobby createLobby() {
        var  startCorner = plugin.getConfig().getLocation(LOBBY_LOCATION_START_CORNER);
        var  endCorner = plugin.getConfig().getLocation(LOBBY_LOCATION_END_CORNER);
        if (startCorner == null || endCorner == null ) {
            throw new RuntimeException("Lobby neni definovana");
        }
        return new battlebeacons.lobby.Lobby(startCorner, endCorner);
    }
}
