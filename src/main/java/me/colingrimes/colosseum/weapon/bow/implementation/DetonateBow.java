package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.display.Display;
import me.colingrimes.midnight.scheduler.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.annotation.Nonnull;
import java.util.*;

public class DetonateBow extends BaseBow implements Listener {

	private final Map<Player, DetonateData> arrows = new HashMap<>();
	private final Team team;

	public DetonateBow(@Nonnull Colosseum plugin) {
		super("detonate", "&c&lDetonate", "&7Fire an arrow -> Left Click to explode!");
		Scoreboard scoreboard = Objects.requireNonNull(Bukkit.getScoreboardManager()).getMainScoreboard();
		Team team = scoreboard.getTeam("arrowMines");
		if (scoreboard.getTeam("arrowMines") != null) {
			this.team = team;
		} else {
			this.team = scoreboard.registerNewTeam("arrowMines");
			this.team.setColor(ChatColor.RED);
		}
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {
		if (event.getEntity() instanceof Player player) {
			arrows.computeIfAbsent(player, (k) -> new DetonateData(player)).armArrow(info.arrow());
		}
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
		info.arrow().setInvulnerable(true);
		info.arrow().setVisualFire(true);
		info.arrow().setGlowing(true);
		team.addEntry(info.arrow().getUniqueId().toString());
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {
		Player player = event.getPlayer();
		if (!event.getAction().name().startsWith("LEFT_CLICK") || !arrows.containsKey(player)) {
			return;
		}

		DetonateData detonate = arrows.get(player);
		if (player.isSneaking()) {
			detonate.explodeAll();
		} else {
			detonate.explodeArrow();
		}
	}

	private class DetonateData {
		private final LinkedList<Arrow> arrows = new LinkedList<>();
		private final Display display = Display.actionBar("&cArmed Arrows: &l0");
		private final Player player;

		public DetonateData(@Nonnull Player player) {
			this.player = player;
			this.display.show(player);
		}

		public void armArrow(@Nonnull Arrow arrow) {
			arrows.add(arrow);
			update();
		}

		public void explodeArrow() {
			Arrow arrow = arrows.pollLast();
			if (arrow == null) {
				return;
			} else if (arrow.isValid()) {
				arrow.remove();
				arrow.getWorld().createExplosion(arrow.getLocation(), 3F);
			}
			update();
		}

		public void explodeAll() {
			for (Arrow arrow : arrows) {
				if (arrow.isValid()) {
					arrow.remove();
					arrow.getWorld().createExplosion(arrow.getLocation(), 3F);
				}
			}
			arrows.clear();
			update();
		}

		public void update() {
			display.setText("&cArmed Arrows: &l" + arrows.size());
			if (arrows.isEmpty()) {
				Scheduler.sync().runLater(() -> {
					if (arrows.isEmpty()) {
						display.hide(player);
						DetonateBow.this.arrows.remove(player);
					}
				}, 20L);
			}
		}
	}
}
