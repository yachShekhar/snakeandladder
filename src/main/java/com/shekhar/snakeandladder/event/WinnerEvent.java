package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class WinnerEvent extends Event {

	@Override
	public WinnerEvent execute(int nextState) {
		player.setWinner(true);
		return this;

	}

	@Override
	public void acknowledge() {
		System.out.println(String.format("%s! You Won... Yeyyy!!!!", player.getName()));
	}

}
