package battlebeacons.teleporter;

import org.bukkit.entity.Player;

import java.util.List;

final class Odpocet implements Runnable {

    private final List<Player> hraci;
    private volatile boolean odpocet;

    public Odpocet(List<Player> hraci) {
        this.hraci = hraci;
    }

    @Override
    public void run() {
        odpocet = true;
        var count = 5;
        for (int i = count; i > 0; i--) {
            for (Player hrac : hraci) {
                hrac.sendTitle("Hra zacne za: ", i + "", 0, convertSecToTicks(1), 0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
        odpocet = false;
    }

    public boolean jeOdpocet() {
        return odpocet;
    }

    private static int convertSecToTicks(int sec) {
        return sec * 20;
    }
}
