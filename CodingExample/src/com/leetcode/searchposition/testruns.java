package com.leetcode.searchposition;

class One{

	int[] nums = {1,4,6,7,8,9};
	int ret = 0;
	int len = nums.length;
	int itera = len/2;


	public int max(int target)
	{
        
		if(nums[itera]==target)
		{
			ret = itera;
		}
		
		if(nums[itera]>target)
		{
			for(int i =itera;i>=0;i--)
			{
				if(nums[i]<target)
				{
					ret = i+1;
					break;
				}
				if(nums[i] == target)
				{
					ret = i;
					break;
				}
				System.out.println("ret: "+ret);
			}
		}
		if(nums[itera]<target)
		{
			for(int i = itera;i<len;i++)
			{
				if(nums[i]>target)
				{
					ret = i;
					break;
				}
				if(nums[i] == target)
				{
					ret = i;
					break;
				}
			}
		}
		if(nums[len-1]<target)
		{
			ret = len;
		}
		return ret;
	}
}

public class testruns {

	public static void main(String[] args) {
		One o = new One();
		System.out.println(o.max(6));
	}
}
