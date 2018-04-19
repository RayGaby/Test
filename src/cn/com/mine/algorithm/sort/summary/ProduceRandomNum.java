package cn.com.mine.algorithm.sort.summary;

import java.util.Random;

/**  
 * Package: sort  
 *  
 * File: SortRunnable.java   
 *  
 * Copyright @ 2015 Corpration Name  
 *   
 */
public class ProduceRandomNum{

	public synchronized static int[] RandomArray(int num,int n){
		Random random = new Random();
		int[] array = new int[num];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt((int)Math.pow(10, n));
		}
		return array;
	}
	

}
