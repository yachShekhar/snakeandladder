
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

import java.util.Random;

/**
 * @author Chandra Shekhar Yadav
 * @version 1.0
 * @organization Actoserba
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
