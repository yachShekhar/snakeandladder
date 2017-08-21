package com.shekhar.snakeandladder.event;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 21-Aug-2017
 */
public enum State {
	CURSOR(new CursorEvent()), LADDER(new LadderEvent()), SNAKE(new SnakeEvent()), HEALTH(new HealthEvent()), WINNER(
			new WinnerEvent()), NO_EVENT(new NoEvent());
	Event event;

	State(Event event) {
		this.event = event;
	}

	public Event getEvent() {
		return this.event;
	}

}
