package cn.com.mine.algorithm.lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TreeSum {
	public static void main(String[] args) {
		TreeSum testCase = new TreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		testCase.threeSum3(nums);
	}

	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @return: Find all unique triplets in the array which gives the sum of
	 *          zero.
	 */
	public List<List<Integer>> threeSum3(int[] numbers) {
		// write your code here
		/********* 双指针O(n^2) **********/
		Arrays.sort(numbers);
		List<List<Integer>> lists = new ArrayList<>();
		int begin, end;
		for (int i = 0; i < numbers.length; i++) {
			begin = i + 1;
			end = numbers.length - 1;
			while (begin < end) {	
				//System.out.println("i:"+i+" ,begin:"+begin+" ,end:"+end);
				if (numbers[i]+numbers[begin]+numbers[end] == 0) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(numbers[i]);
					list.add(numbers[begin]);
					list.add(numbers[end]);
					if (!lists.contains(list)) lists.add(list);
					begin++;
					end--;
				} else if (numbers[i]+numbers[begin]+numbers[end] < 0) {
					begin++;
				} else {
					end--;				
				}
			}
		}
		return lists;
	}

	public List<List<Integer>> threeSum2(int[] numbers) {
		// write your code here
		/********* HashMap O(n^2) **********/
		Arrays.sort(numbers);
		List<List<Integer>> lists = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		int temp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				temp = 0 - numbers[i] - numbers[j];
				if (map.containsKey(temp) && map.get(temp) > j) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(numbers[i]);
					list.add(numbers[j]);
					list.add(temp);
					if (!lists.contains(list)) {
						lists.add(list);
					}
				}
			}
		}
		return lists;
	}

	public List<List<Integer>> threeSum1(int[] numbers) {
		// write your code here
		/********* 穷举法 O(n^3) **********/
		Arrays.sort(numbers);
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				for (int j2 = j + 1; j2 < numbers.length; j2++) {
					if (numbers[i] + numbers[j] + numbers[j2] == 0) {
						ArrayList<Integer> list = new ArrayList<>();
						list.add(numbers[i]);
						list.add(numbers[j]);
						list.add(numbers[j2]);
						if (!lists.contains(list)) {
							for (int k = 0; k < list.size(); k++) {
								System.out.print(list.get(k) + " , ");
							}
							System.out.println();
							lists.add(list);
						}
					}
				}
			}
		}
		return lists;
	}
}
