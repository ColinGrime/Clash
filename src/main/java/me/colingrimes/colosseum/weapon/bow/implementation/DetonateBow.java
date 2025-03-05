package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.annotation.Nonnull;
import java.util.*;

public class DetonateBow extends BaseBow implements Listener {

	private final Map<LivingEntity, List<Arrow>> arrows = new HashMap<>();
	private final Team team;

	public DetonateBow() {
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
		arrows.computeIfAbsent(info.shooter(), (k) -> new ArrayList<>()).add(info.arrow());
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
		info.arrow().setVisualFire(true);
		info.arrow().setGlowing(true);
		team.addEntry(info.arrow().getUniqueId().toString());
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {
		if (event.getAction().name().startsWith("LEFT_CLICK") && arrows.containsKey(info.shooter())) {
			arrows.get(info.shooter()).stream().filter(Entity::isValid).forEach(arrow -> {
				arrow.remove();
				info.world().createExplosion(arrow.getLocation(), 3F);
			});
			arrows.remove(info.shooter());
		}
	}
}
