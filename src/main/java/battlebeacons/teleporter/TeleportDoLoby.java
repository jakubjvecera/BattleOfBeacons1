package battlebeacons.teleporter;


import battlebeacons.lobby.Lobby;
import battlebeacons.tymy.Tymy;
import org.bukkit.GameMode;

public class TeleportDoLoby {
    private final Lobby lobby;
    private final Tymy tymy;

    public TeleportDoLoby(Lobby lobby, Tymy tymy) {
        this.lobby = lobby;
        this.tymy = tymy;
    }

    public void teleport() {
        tymy.vratTymy().forEach( tym -> {
            tym.getHraci().forEach(hrac -> {
                var mistovLoby = lobby.nahodneMistoVLobby();
                hrac.setGameMode(GameMode.ADVENTURE);
                hrac.teleport(mistovLoby);
            });
        });
    }
}
