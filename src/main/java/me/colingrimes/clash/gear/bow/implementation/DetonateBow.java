package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
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

public class DetonateBow extends BowGear implements Listener {

	private final Map<Player, DetonateData> arrows = new HashMap<>();
	private final Team team;

	public DetonateBow(@Nonnull Clash plugin) {
		super(plugin, "detonate", GearSettings.BOW_DETONATE_NAME, GearSettings.BOW_DETONATE_DESC, GearGrade.A);
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
	public double getCooldown() {
		return 1;
	}

	@Override
	public boolean removeArrow() {
		return false;
	}

	@Override
	public boolean activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		if (event.getEntity() instanceof Player player) {
			arrows.computeIfAbsent(player, (k) -> new DetonateData(player)).armArrow(bow.arrow());
		}
		return false;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.arrow().setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
		bow.arrow().setInvulnerable(true);
		bow.arrow().setVisualFire(true);
		bow.arrow().setGlowing(true);
		team.addEntry(bow.arrow().getUniqueId().toString());
		return false;
	}

	@Override
	public boolean activate(@Nonnull PlayerInteractEvent event, @Nonnull BowInfo bow) {
		Player player = event.getPlayer();
		if (!event.getAction().name().startsWith("LEFT_CLICK") || !arrows.containsKey(player)) {
			return false;
		}

		DetonateData detonate = arrows.get(player);
		if (player.isSneaking()) {
			detonate.explodeAll();
		} else {
			detonate.explodeArrow();
		}
		return true;
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
