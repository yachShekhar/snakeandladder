
package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public class CursorEvent extends Event {

	@Override
	public CursorEvent execute(int nextState) {
		player.setPostion(nextState);
		return this;

	}

	@Override
	public void acknowledge() {
		System.out.println(String.format("'%s' moved now position is %s ", State.CURSOR, player.getPostion()));
	}

}
