
package com.shekhar.snakeandladder;

import com.shekhar.snakeandladder.core.Game;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
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
