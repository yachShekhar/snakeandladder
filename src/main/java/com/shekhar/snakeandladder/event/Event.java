
/*************************************************************************
 *
 * ZIVAME CONFIDENTIAL
 * ___________________
 *
 *  (C) 2017 Actoserba
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Actoserba and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary may be covered by India and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Actoserba.
 */
package com.shekhar.snakeandladder.event;

import com.shekhar.snakeandladder.core.Player;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @organization Actoserba
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
