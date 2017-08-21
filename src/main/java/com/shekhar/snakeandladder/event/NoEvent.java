package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class NoEvent extends Event {

	@Override
	public NoEvent execute(int nextState) {
		return this;
	}

	@Override
	public void acknowledge() {

	}

}
