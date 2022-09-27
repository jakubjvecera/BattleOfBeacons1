package battlebeacons.tymy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public final class Skore {

    private Scoreboard scoreboard;
    private final battlebeacons.tymy.Tymy tymy;

    public Skore(battlebeacons.tymy.Tymy tymy) {
        this.tymy = tymy;
    }

    public void inicializace() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        tymy.vratTymy().forEach(tym -> tym.getHraci().forEach(player -> player.setScoreboard(scoreboard)));
        pocatecniUpdate();
    }

    public void pocatecniUpdate() {
        Objective objective = scoreboard.registerNewObjective("Skore", "dummy", "Tymy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        for (var tym : tymy.vratTymy()) {
            String jmenoTymu = tym.getNastaveniTymu().getChatColor() + tym.getNastaveniTymu().getJmeno();
            if (!tym.isAlive()) {
                jmenoTymu = tym.getNastaveniTymu().getChatColor() + ChatColor.STRIKETHROUGH.toString() + tym.getNastaveniTymu().getJmeno();
            }
            updateScore(tym, objective.getScore(jmenoTymu));
        }
    }

    public void update() {
        var objective = scoreboard.getObjective("Skore");
        for (var tym : tymy.vratTymy()) {
            String jmenoTymu = tym.getNastaveniTymu().getChatColor() + tym.getNastaveniTymu().getJmeno();
            if (!tym.isAlive()) {
                objective.unregister();
                pocatecniUpdate();
                return;
            }
            updateScore(tym, objective.getScore(jmenoTymu));
        }
    }

    private void updateScore(battlebeacons.tymy.Tym tym, Score score) {
        score.setScore((int) tym.getHraci().stream()
                .filter(hrac -> hrac.getGameMode() != GameMode.SPECTATOR)
                .count());

    }
}