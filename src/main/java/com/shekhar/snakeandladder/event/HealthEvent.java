
package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class HealthEvent extends CursorEvent {

	@Override
	public HealthEvent execute(int nextState) {
		player.setHealth(player.getHealth() + player.getDefaultHealth());
		super.execute(nextState);
		return this;

	}

	@Override
	public void acknowledge() {
		System.out.println(String.format("Got Some '%s'.. Now %s is %s ", State.HEALTH, State.HEALTH, player.getHealth()));
		super.acknowledge();
	}

}
