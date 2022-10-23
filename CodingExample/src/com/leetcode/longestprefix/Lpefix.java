package com.leetcode.longestprefix;

public class Lpefix {

	String f = "";
	Lpefix(String[] strs)
	{
		int srlen = strs.length;
		int maxlen = strs[0].length();
		int index = maxlen;
		
		if(srlen == 1)
		{
			f = strs[0];
		}
		
		for(int i= 0;i<srlen;i++)
		{     
			if(maxlen > strs[i].length()) {
				maxlen = strs[i].length();
				index = maxlen;
			}
		}
//		System.out.println("length of substring : "+ index);
		for(int i =0;i<srlen;i++)
		{
			for(int j = i+1; j<srlen ; j++)
			{
//				System.out.println("I :"+i+" J:"+j);
//				System.out.println(strs[i].substring(0, index));
//				System.out.println(strs[j].substring(0, index));
//				System.out.println("continue");

				if(strs[i].substring(0, index).equals(strs[j].substring(0,index)))
				{
						f = strs[i].substring(0, index);
//						System.out.println("Value of f1 : "+f);
				}
				else
				{
					do
					{
						index = index -1;
						f = strs[i].substring(0, index);
//						System.out.println("index changed : "+index);
//						System.out.println("Value of f1 : "+f);
//						System.out.println("vaue of j :"+strs[j].substring(0, index));
						
					}
					while(!f.equals(strs[j].substring(0,index)));
					
				}
			}
		}
		
	}

	public static void main(String[] args) {

//		String [] sr = {"cir","car"};
//		String [] sr = {"fl","flow","flower"};
		String [] sr = {"il","aw","flo"};
		Lpefix l = new Lpefix(sr);
		System.out.println(l.f);

	}

}
