

package com.shekhar.snakeandladder.event;

import com.shekhar.snakeandladder.core.Player;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class Transition {

	private Integer i;
	private State s;
	private Integer l;

	public Transition(Integer i, State s, Integer l) {
		this.i = i;
		this.s = s;
		this.l = l;
	}

	public Integer getInitial() {
		return i;

	};

	public State getState() {
		return s;

	};

	public Integer getLast() {
		return l;

	};

	public void transit(Player player) {
		getState().getEvent().init(player).healthDownByOne()
				.execute(getLast() == null ? player.getPostion() + player.getDiceFace() : getLast()).acknowledge();
	}

}
