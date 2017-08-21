
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
public class Transition<I, L> {

	private I i;
	private State s;
	private L l;

	public Transition(I i, State s, L l) {
		this.i = i;
		this.s = s;
		this.l = l;
	}

	public I getInitial() {
		return i;

	};

	public State getState() {
		return s;

	};

	public L getLast() {
		return l;

	};

	public void transit(Player player) {
		getState().getEvent().init(player).healthDownByOne()
				.execute(getLast() == null ? player.getPostion() + player.getDiceFace() : (int) getLast()).acknowledge();
	}

}
