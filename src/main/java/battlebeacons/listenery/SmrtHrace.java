package battlebeacons.listenery;


import battlebeacons.teleporter.TeleportDoLoby;
import battlebeacons.tymy.Skore;
import battlebeacons.tymy.Tym;
import battlebeacons.tymy.Tymy;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.List;

public final class SmrtHrace implements Listener {

    private final Tymy tymy;
    private final Skore skore;
    private final TeleportDoLoby teleportDoLoby;

    public SmrtHrace(Tymy tymy, Skore skore, TeleportDoLoby teleportDoLoby) {
        this.tymy = tymy;
        this.skore = skore;
        this.teleportDoLoby = teleportDoLoby;
    }

    @EventHandler
    public void smrtHrace(PlayerDeathEvent playerDeathEvent) {
        if (!tymy.hraJede()) return;
        var player = playerDeathEvent.getEntity();
        var tym = tymy.vratTym(player);
        if (!tym.isAlive()) {
            player.setGameMode(GameMode.SPECTATOR);
            skore.update();
        }

        //test konce hty
        List<Tym> ziveTymy = vratZiveTymy();
        if (ziveTymy.size() <= 1) {
            if (ziveTymy.isEmpty()) {
                //asi nenastane
                tymy.vratTymy().forEach(vsechnyTymy -> vsechnyTymy.zprava("Nikdo nezvitezil", "Remiza poslednich dvou"));
            } else {
                ziveTymy.forEach(zivyTym -> zivyTym.zprava("Vas tym zvitezil", ""));
                tymy.vratTymy().forEach(vsechnyTymy -> vsechnyTymy.zprava("Zvitezit tym " + ziveTymy.get(0).getNastaveniTymu(), ""));
            }
            teleportDoLoby.teleport();
            tymy.konecHry();
        }
    }

    private List<Tym> vratZiveTymy() {
        List<Tym> tymySZivymi = new ArrayList<>();
        for (var tym : tymy.vratTymy()) {
            boolean zivyHracVTeamu = tym.getHraci().stream().anyMatch(hrac -> hrac.getGameMode() != GameMode.SPECTATOR);
            if (zivyHracVTeamu) {
                tymySZivymi.add(tym);
            }
        }
        return tymySZivymi;
    }
}
