
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
package com.shekhar.snakeandladder;

import com.shekhar.snakeandladder.core.Game;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @organization Actoserba
 * @Date 18-Aug-2017
 */
public class Starter {
	public static void main(String[] args) {
		int[][] ladderSquare = { { 4, 14 }, { 9, 17 } };
		int[][] snakeSquare = { { 15, 5 }, { 19, 2 } };
		int[] healthSquare = { 7, 13 };
		int health = 5;
		int noOfSquare = 20;
		String[] players = { "Archana", "Shekhar" };

		Game game = Game.init().setHealth(health).setLadderSquare(ladderSquare).setHealthSquare(healthSquare).setNoOfSquare(noOfSquare)
				.setSnakeSquare(snakeSquare).setPlayers(players).build();
		game.play();
		System.out.println("game finished............");
	}
}
