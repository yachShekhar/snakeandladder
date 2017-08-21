
package com.shekhar.snakeandladder.core;

import java.util.Random;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @Date 18-Aug-2017
 */
public class Dice {

	private static int min = 1;
	private static int max = 6;

	public static int random() {
		Random rand = new Random();
		return rand.nextInt(max) + min;
	}
}
