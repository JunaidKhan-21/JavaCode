package com.leetcode.palindrome;

public class Palindrome {
	
	Palindrome(int x)
	{
		String pal = String.valueOf(x);
		int strleng = pal.length();
		
		for(int i= 0 ; i<= (int)(Math.floor(pal.length()/2)) ;i++)
		{
			if(pal.charAt(i) != pal.charAt(strleng-i-1))
			{
				System.out.println(pal.charAt(strleng-i-1));
				System.out.println(pal.charAt(i));
				System.out.println("Not a Palindrome :"+pal);
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		new Palindrome(-121);

	}

}
