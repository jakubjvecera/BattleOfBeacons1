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
    private final Tymy tymy;

    public Skore(Tymy tymy) {
        this.tymy = tymy;
    }

    public void inicializace() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Skore", "dummy", "Tymy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        update();
        tymy.vratTymy().forEach( tym -> tym.vratHrace().forEach(player -> player.setScoreboard(scoreboard)));
    }

    public void update() {
        var objective = scoreboard.getObjective("Skore");
        for (var tym : tymy.vratTymy()) {
            String jmenoTymu = tym.getJmenoTymu().getChatColor() + tym.getJmenoTymu().getJmeno();
            if (!tym.isAlive()) {
                jmenoTymu = ChatColor.STRIKETHROUGH + jmenoTymu;
            }
            updateScore(tym, objective.getScore(jmenoTymu));
        }
    }

    private void updateScore(Tym tym, Score score) {
        score.setScore((int) tym.vratHrace().stream()
                .filter(hrac -> hrac.getGameMode() != GameMode.SPECTATOR)
                .count());

    }
}