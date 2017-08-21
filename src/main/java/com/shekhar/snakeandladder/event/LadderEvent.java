
package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class LadderEvent extends Event {

	@Override
	public LadderEvent execute(int nextState) {
		player.setPostion(nextState);
		return this;

	}

	@Override
	public void acknowledge() {
		System.out.println(String.format("Got a %s.. Now position is %s ", State.LADDER, player.getPostion()));
	}

}
