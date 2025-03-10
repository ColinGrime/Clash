package me.colingrimes.primoria.config;

import me.colingrimes.midnight.config.annotation.Configuration;
import me.colingrimes.midnight.message.Message;

import static me.colingrimes.midnight.config.option.OptionFactory.message;

@Configuration("gear.yml")
public interface GearSettings {

	/**************************************************
	 *                 Bow-related Gear               *
	 **************************************************/
	Message<?> BOW_ANCHOR_NAME = message("bows.anchor.name", "Anchor");
	Message<?> BOW_ANCHOR_DESC = message("bows.anchor.desc");

	Message<?> BOW_BLINK_NAME = message("bows.blink.name", "Blink");
	Message<?> BOW_BLINK_DESC = message("bows.blink.desc");

	Message<?> BOW_BUNKER_NAME = message("bows.bunker.name", "Bunker");
	Message<?> BOW_BUNKER_DESC = message("bows.bunker.desc");

	Message<?> BOW_BURROW_NAME = message("bows.burrow.name", "Burrow");
	Message<?> BOW_BURROW_DESC = message("bows.burrow.desc");

	Message<?> BOW_CANNONEER_NAME = message("bows.cannoneer.name", "Cannoneer");
	Message<?> BOW_CANNONEER_DESC = message("bows.cannoneer.desc");

	Message<?> BOW_CHAIN_NAME = message("bows.chain.name", "Chain");
	Message<?> BOW_CHAIN_DESC = message("bows.chain.desc");

	Message<?> BOW_CLUSTER_NAME = message("bows.cluster.name", "Cluster");
	Message<?> BOW_CLUSTER_DESC = message("bows.cluster.desc");

	Message<?> BOW_CORRUPT_NAME = message("bows.corrupt.name", "Corrupt");
	Message<?> BOW_CORRUPT_DESC = message("bows.corrupt.desc");

	Message<?> BOW_DETONATE_NAME = message("bows.detonate.name", "Detonate");
	Message<?> BOW_DETONATE_DESC = message("bows.detonate.desc");

	Message<?> BOW_DISPLACE_NAME = message("bows.displace.name", "Displace");
	Message<?> BOW_DISPLACE_DESC = message("bows.displace.desc");

	Message<?> BOW_DISRUPTOR_NAME = message("bows.disruptor.name", "Disruptor");
	Message<?> BOW_DISRUPTOR_DESC = message("bows.disruptor.desc");

	Message<?> BOW_DOPPEL_NAME = message("bows.doppel.name", "Doppel");
	Message<?> BOW_DOPPEL_DESC = message("bows.doppel.desc");

	Message<?> BOW_EMBER_NAME = message("bows.ember.name", "Ember");
	Message<?> BOW_EMBER_DESC = message("bows.ember.desc");

	Message<?> BOW_FLUX_NAME = message("bows.flux.name", "Flux");
	Message<?> BOW_FLUX_DESC = message("bows.flux.desc");

	Message<?> BOW_GRAPPLE_NAME = message("bows.grapple.name", "Grapple");
	Message<?> BOW_GRAPPLE_DESC = message("bows.grapple.desc");

	Message<?> BOW_HEALER_NAME = message("bows.healer.name", "Healer");
	Message<?> BOW_HEALER_DESC = message("bows.healer.desc");

	Message<?> BOW_HEX_NAME = message("bows.hex.name", "Hex");
	Message<?> BOW_HEX_DESC = message("bows.hex.desc");

	Message<?> BOW_HOMING_NAME = message("bows.homing.name", "Homing");
	Message<?> BOW_HOMING_DESC = message("bows.homing.desc");

	Message<?> BOW_MAGNET_NAME = message("bows.magnet.name", "Magnet");
	Message<?> BOW_MAGNET_DESC = message("bows.magnet.desc");

	Message<?> BOW_METEORITE_NAME = message("bows.meteorite.name", "Meteorite");
	Message<?> BOW_METEORITE_DESC = message("bows.meteorite.desc");

	Message<?> BOW_MIMIC_NAME = message("bows.mimic.name", "Mimic");
	Message<?> BOW_MIMIC_DESC = message("bows.mimic.desc");

	Message<?> BOW_PHASE_NAME = message("bows.phase.name", "Phase");
	Message<?> BOW_PHASE_DESC = message("bows.phase.desc");

	Message<?> BOW_POINT_BLANK_NAME = message("bows.point_blank.name", "Point Blank");
	Message<?> BOW_POINT_BLANK_DESC = message("bows.point_blank.desc");

	Message<?> BOW_QUAKE_NAME = message("bows.quake.name", "Quake");
	Message<?> BOW_QUAKE_DESC = message("bows.quake.desc");

	Message<?> BOW_RAPID_FIRE_NAME = message("bows.rapid_fire.name", "Rapid Fire");
	Message<?> BOW_RAPID_FIRE_DESC = message("bows.rapid_fire.desc");

	Message<?> BOW_REPULSOR_NAME = message("bows.repulsor.name", "Repulsor");
	Message<?> BOW_REPULSOR_DESC = message("bows.repulsor.desc");

	Message<?> BOW_RICOCHET_NAME = message("bows.ricochet.name", "Ricochet");
	Message<?> BOW_RICOCHET_DESC = message("bows.ricochet.desc");

	Message<?> BOW_RIDER_NAME = message("bows.rider.name", "Rider");
	Message<?> BOW_RIDER_DESC = message("bows.rider.desc");

	Message<?> BOW_SEMTEX_NAME = message("bows.semtex.name", "Semtex");
	Message<?> BOW_SEMTEX_DESC = message("bows.semtex.desc");

	Message<?> BOW_SHATTER_NAME = message("bows.shatter.name", "Shatter");
	Message<?> BOW_SHATTER_DESC = message("bows.shatter.desc");

	Message<?> BOW_SNIPER_NAME = message("bows.sniper.name", "Sniper");
	Message<?> BOW_SNIPER_DESC = message("bows.sniper.desc");

	Message<?> BOW_SONAR_NAME = message("bows.sonar.name", "Sonar");
	Message<?> BOW_SONAR_DESC = message("bows.sonar.desc");

	Message<?> BOW_SUMMONER_NAME = message("bows.summoner.name", "Summoner");
	Message<?> BOW_SUMMONER_DESC = message("bows.summoner.desc");

	Message<?> BOW_TELEPORTATION_NAME = message("bows.teleportation.name", "Teleportation");
	Message<?> BOW_TELEPORTATION_DESC = message("bows.teleportation.desc");

	Message<?> BOW_TRAP_NAME = message("bows.trap.name", "Trap");
	Message<?> BOW_TRAP_DESC = message("bows.trap.desc");

	Message<?> BOW_TRIPLET_NAME = message("bows.triplet.name", "Triplet");
	Message<?> BOW_TRIPLET_DESC = message("bows.triplet.desc");

	Message<?> BOW_VOID_NAME = message("bows.void.name", "Void");
	Message<?> BOW_VOID_DESC = message("bows.void.desc");
}
