package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class SnakeEvent extends Event {

	@Override
	public SnakeEvent execute(int nextState) {
		player.setPostion(nextState);
		return this;

	}

	@Override
	public void acknowledge() {
		System.out.println(String.format("Oh God! Bitten by %s.. N	Now position is %s ", State.SNAKE, player.getPostion()));
	}

}
