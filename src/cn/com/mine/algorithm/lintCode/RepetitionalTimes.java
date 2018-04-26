package cn.com.mine.algorithm.lintCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepetitionalTimes {
	public static void main(String[] args) {
		int[] nums = {1 ,2 ,3 ,3 ,5 ,2 ,2 ,3 ,3 ,3 ,5 ,6 ,2 ,2 ,2 ,3 , 3};
		RepetitionalTimes testCase = new RepetitionalTimes();
		int length = nums.length;
		int times = 3;
		testCase.repetitionalTimes(nums, length, times);
	}
	/**
	 * 打印数组中重复次数大于n/k的数
	 * 
	 * 时间复杂度 O(n*k)，空间复杂度 O(k)
	 * 
	 * 思路：每次从数组中删除 K 个不同的数，如果某个数的次数大于 N/K ，这个数最后肯定会剩下来
	 * 
	 * @param nums
	 * @param n
	 * @param k
	 */
	public void repetitionalTimes(int[] nums, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}
			else {				
				if (map.size() == k-1) {		
					allminusOne(map);				
				}
				else {
					map.put(nums[i], 1);
				}
			}
		}
		/********* 注意：删除后剩余的数不一定全是次数大于 N/K 的数 **********/
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			map.put(entry.getKey(), 0);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > n/k) {
				System.out.println(entry.getKey());
			}
		}
	}
	public void allminusOne(HashMap<Integer, Integer> map) {
		//java.util.ConcurrentModificationException
		//对一个集合遍历的同时，有对该集合进行了增删的操作。导致AbstarctList的modCount和expectedModCount的值不一致
		ArrayList<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				list.add(entry.getKey());
			} else {				
				map.put(entry.getKey(), entry.getValue()-1);
			}
		}	
		for (int i = 0; i < list.size(); i++) {
			map.remove(list.get(i));
		}
	}
}
