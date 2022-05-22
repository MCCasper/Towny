package com.palmergames.bukkit.towny.event.alliance;

import com.palmergames.bukkit.towny.object.Alliance;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AlliancePreRemoveEnemyEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private final String enemyName;
	private final Alliance enemy;
	private final String allianceName;
	private final Alliance alliance;
	private String cancelMessage = "Sorry this event was cancelled";

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public AlliancePreRemoveEnemyEvent(Alliance alliance, Alliance enemy) {
		super(!Bukkit.getServer().isPrimaryThread());
		this.enemyName = enemy.getName();
		this.enemy = enemy;
		this.alliance = alliance;
		this.allianceName = alliance.getName();
	}

	public String getEnemyName() {
		return enemyName;
	}

	public String getAllianceName() {
		return allianceName;
	}

	public Alliance getEnemy() {
		return enemy;
	}

	public Alliance getAlliance() {
		return alliance;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public String getCancelMessage() {
		return cancelMessage;
	}

	public void setCancelMessage(String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}
}
