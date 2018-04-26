package cn.com.mine.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//Definition of TreeNode:
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// Definition for ListNode
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class lintCode {
	public static void main(String[] args) {
		lintCode testCase = new lintCode();
		// testCase data Array
		int[] nums = {9,9,9};
		String[] strs = {"ABCDEFG", "ABCEFG", "ABCEFA"};
		// testCase data TreeNode
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node2.right = node3;
		// testCase data ListNode
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		listNode1.next = listNode6;
		listNode6.next = listNode2;
		listNode2.next = listNode7;
		
		listNode4.next = listNode5;
		listNode5.next = listNode3;
		// testCase involve
		System.out.println(testCase.longestCommonPrefix(strs));
		//System.out.println(Arrays.toString(nums));
		// System.out.println(Arrays.toString(testCase.threeSum(nums)));
	}
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
    	return false;
    }
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
    	
    	if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if(j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
