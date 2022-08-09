package com.crm.Mobicentrum.GenericUtility;

import java.util.Random;

/**
 * This class is used to handle java specific methods
 * @author JOLLU KISHORE
 *
 */
public class JavaUtility {
	/**
	 * This method is used to get random numbers
	 * @return value
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int value = r.nextInt(10000);
		return value;
	}
}
