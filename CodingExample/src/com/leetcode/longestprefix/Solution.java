package com.leetcode.longestprefix;
public class Solution {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
//		System.out.println("prefix at start : "+prefix);
		
		for (int i = 1; i < strs.length; i++)
		{
//			System.out.println("index of function : "+strs[i].indexOf(prefix));
			
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
//				System.out.println("count ");
				if (prefix.isEmpty()) return "";
			}
			
//			System.out.println("prefix of function : "+prefix);
		}	
			return prefix;
		
	}


	public static void main(String[] args) {

		String[] strs = {"cir","car"};
		System.out.println(longestCommonPrefix(strs));

	}

}
