
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
package com.shekhar.snakeandladder.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.shekhar.snakeandladder.Starter;
import com.shekhar.snakeandladder.event.State;
import com.shekhar.snakeandladder.event.Transition;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @organization Actoserba
 * @Date 19-Aug-2017
 */
public abstract class Game {

	/**
	 * @return the snakeSquare
	 */
	public abstract int[][] getSnakeSquare();

	/**
	 * @return the lifeSquare
	 */
	public abstract int[] getHealthSquare();

	/**
	 * @return the life
	 */
	public abstract int getHealth();

	/**
	 * @return the noOfSquare
	 */
	public abstract int getNoOfSquare();

	public abstract int[][] getLadderSquare();

	public abstract List<Player> getPlayer();

	public abstract List<Transition<Integer, Integer>> getTransitions();

	public abstract Player winner();

	public abstract void play();

	public static GameBuilder init() {
		return new GameBuilder();
	}

	public static class GameBuilder {
		private int[][] ladderSquare;
		private int[][] snakeSquare;
		private int[] healthSqaure;
		private int health = 5;
		private int noOfSquare = 20;
		private String[] players;

		private GameBuilder() {

		}

		/**
		 * @param ladderSquare
		 *            the ladderSquare to set
		 */
		public GameBuilder setLadderSquare(int[][] ladderSquare) {
			this.ladderSquare = ladderSquare;
			return this;
		}

		/**
		 * @param snakeSquare
		 *            the snakeSquare to set
		 */
		public GameBuilder setSnakeSquare(int[][] snakeSquare) {
			this.snakeSquare = snakeSquare;
			return this;
		}

		/**
		 * @param lifeSquare
		 *            the lifeSquare to set
		 */
		public GameBuilder setHealthSquare(int[] lifeSquare) {
			this.healthSqaure = lifeSquare;
			return this;
		}

		/**
		 * @param life
		 *            the life to set
		 */
		public GameBuilder setHealth(int health) {
			this.health = health;
			return this;
		}

		/**
		 * @param noOfSquare
		 *            the noOfSquare to set
		 */
		public GameBuilder setNoOfSquare(int noOfSquare) {
			this.noOfSquare = noOfSquare;
			return this;
		}

		/**
		 * @param players
		 *            the players to set
		 */
		public GameBuilder setPlayers(String[] players) {
			this.players = players;
			return this;
		}

		public Game build() {
			printAboutGame();
			return new SnakeLadderGame(this);
		}

		private void printAboutGame() {
			System.out.println("This is Snake and Ladder Game.");
			System.out.println(String.format("Total No of Squares: %s", noOfSquare));
			System.out.println("Ladder Squares: ");
			for (int[] sq : ladderSquare) {
				System.out.println(Arrays.toString(sq));
			}
			System.out.println("Snake Squares: ");
			for (int[] sq : snakeSquare) {
				System.out.println(Arrays.toString(sq));
			}
			System.out.println(String.format("Health Squares: %s", Arrays.toString(healthSqaure)));
		}

	}

	private static class SnakeLadderGame extends Game {
		private GameBuilder gmBuilder;
		private List<Player> players = new LinkedList<>();
		private List<Transition<Integer, Integer>> transitions = new ArrayList<>();
		private Player winner;

		SnakeLadderGame(GameBuilder gmBuilder) {
			this.gmBuilder = gmBuilder;
		}

		@Override
		public int[][] getSnakeSquare() {
			return gmBuilder.snakeSquare;
		}

		@Override
		public int[] getHealthSquare() {
			return gmBuilder.healthSqaure;
		}

		@Override
		public int getHealth() {
			return gmBuilder.health;
		}

		@Override
		public int getNoOfSquare() {
			return gmBuilder.noOfSquare;
		}

		@Override
		public int[][] getLadderSquare() {
			return gmBuilder.ladderSquare;
		}

		@Override
		public List<Player> getPlayer() {
			if (players.isEmpty())
				for (String plyr : gmBuilder.players) {
					Player player = new Player();
					player.setName(plyr);
					player.setHealth(getHealth());
					player.setGame(this);
					players.add(player);
				}
			return players;
		}

		@Override
		public List<Transition<Integer, Integer>> getTransitions() {
			if (transitions.isEmpty()) {
				for (int[] snakeSq : gmBuilder.snakeSquare) {
					Transition<Integer, Integer> transition = new Transition<>(snakeSq[0], State.SNAKE, snakeSq[1]);
					transitions.add(transition);
				}
				for (int[] ladderSq : gmBuilder.ladderSquare) {
					Transition<Integer, Integer> transition = new Transition<>(ladderSq[0], State.LADDER, ladderSq[1]);
					transitions.add(transition);
				}
				for (int healthSq : gmBuilder.healthSqaure) {
					Transition<Integer, Integer> transition = new Transition<>(healthSq, State.HEALTH, null);
					transitions.add(transition);
				}
				Transition<Integer, Integer> transition = new Transition<>(getNoOfSquare(), State.WINNER, getNoOfSquare());
				transitions.add(transition);
			}
			return transitions;
		}

		@Override
		public Player winner() {
			return winner;
		}

		@Override
		public void play() {
			try (Scanner sc = new Scanner(System.in)) {
				while (true) {
					System.out.println("Press ENTER to continue the game..");
					String nextLine = sc.nextLine();
					Player p = getPlayer().get(0);
					if ("".equals(nextLine)) {
						p.move();
					}
					if ("STOP".equals(nextLine)) {
						System.out.println("stopping the game.........");
						break;
					}
					if ("RESTART".equals(nextLine)) {
						System.out.println("Restarting the game.........");
						Starter.main(null);
						break;
					}
					if (p.isWinner()) {
						winner = p;
						break;
					}
					players.remove(0);
					players.add(p);
				}
			}
		}

	}
}