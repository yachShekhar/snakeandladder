
package com.shekhar.snakeandladder.core;

import java.util.HashMap;
import java.util.Map;

import com.shekhar.snakeandladder.event.State;
import com.shekhar.snakeandladder.event.Transition;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 19-Aug-2017
 */
public class Player {
	private String name;
	private Integer health = 5;
	private Integer postion = 1;
	private Boolean isWinner = false;
	private Integer defaultHealth = health;
	private Integer defaultPostion = 1;
	private Game game;
	private Integer diceFace;

	private static Map<Integer, Transition> transitionByCode = new HashMap<>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the defaultHealth
	 */
	public int getDefaultHealth() {
		return defaultHealth;
	}

	/**
	 * @return the defaultPostion
	 */
	public int getDefaultPostion() {
		return defaultPostion;
	}

	/**
	 * @return the postion
	 */
	public int getPostion() {
		return postion;
	}

	/**
	 * @param postion
	 *            the postion to set
	 */
	public void setPostion(int postion) {
		this.postion = postion;
	}

	/**
	 * @return the isWinner
	 */
	public boolean isWinner() {
		return isWinner;
	}

	/**
	 * @param isWinner
	 *            the isWinner to set
	 */
	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	/**
	 * @return the game
	 */
	private Game getGame() {
		return game;
	}

	/**
	 * @param game
	 *            the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the diceFace
	 */
	public Integer getDiceFace() {
		return diceFace;
	}

	/**
	 * @param diceFace
	 *            the diceFace to set
	 */
	private void setDiceFace(Integer diceFace) {
		this.diceFace = diceFace;
	}

	private Map<Integer, Transition> getTransition() {
		if (transitionByCode.isEmpty()) {
			getGame().getTransitions().forEach(t -> {
				Transition transition = transitionByCode.get(t.getInitial());
				if (transition == null) {
					transitionByCode.put(t.getInitial(), t);
				}
			});
		}
		return transitionByCode;
	}

	public void move() {
		print();
		int num = Dice.random(), futurePos = num + getPostion();
		setDiceFace(num);
		System.out.println("Throwing dice.....You got " + num);
		Transition transition;
		if (futurePos > getGame().getNoOfSquare()) {
			System.out.println(String.format("Can't Move.. You need %s to win.", getGame().getNoOfSquare() - getPostion()));
			transition = new Transition(null, State.NO_EVENT, null);
		} else {
			transition = getTransition().get(futurePos);
			transition = transition != null ? transition : new Transition(null, State.CURSOR, futurePos);
		}
		transition.transit(this);
	}

	private void print() {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(String.format("%s(health:%s position:%s)", getName(), getHealth(), getPostion()));
	}

}
