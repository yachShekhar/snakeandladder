
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

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @organization Actoserba
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
