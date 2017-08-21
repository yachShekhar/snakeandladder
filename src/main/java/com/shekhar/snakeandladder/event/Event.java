
package com.shekhar.snakeandladder.event;

import com.shekhar.snakeandladder.core.Player;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public abstract class Event {
	Player player;

	public Event init(Player player) {
		this.player = player;
		return this;
	}

	public Event healthDownByOne() {
		if (player.getHealth() - 1 <= 0) {
			player.setHealth(player.getDefaultHealth());
			player.setPostion(player.getDefaultPostion());
			System.out.println(
					String.format("Health is 0.. So starting fresh health:%s postion:%s", player.getHealth(), player.getPostion()));
		} else {
			player.setHealth(player.getHealth() - 1);
			System.out.println(String.format("Health is down by 1.. So Health is:%s", player.getHealth()));

		}
		return this;
	}

	public abstract Event execute(int nextState);

	public abstract void acknowledge();

}
