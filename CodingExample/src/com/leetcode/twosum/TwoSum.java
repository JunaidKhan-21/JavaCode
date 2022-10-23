package com.leetcode.twosum;


// Code to find the sum of two numbers in an array 
// Complexity is n^2

import java.util.Scanner;

class Nums{
	int inarray[],lenar,temp;

	Nums()	
	{
		System.out.println("Please Enter the length of inputs that you want to take  : ");
		Scanner sc = new Scanner(System.in);
		lenar = sc.nextInt();
		temp = lenar;
		inarray = new int[lenar];
		System.out.println("Enter the inputs  : ");

		while(temp>0)
		{    
			inarray[inarray.length - temp]= sc.nextInt();
			temp-=1;
		}
		temp = lenar;

		while(temp>0)
		{    

			System.out.println("inarray["+(inarray.length - temp)+"]   :  " +inarray[inarray.length - temp] );
			temp-=1;
		}
		System.out.println("please enter the target that you want to print : ");
		int target = sc.nextInt();
		sc.close();
		printresult(inarray,target);
	}

	public void printresult(int inarray[],int target)
	{
		for(int i = 0; i<inarray.length-1;i++)
		{
			for(int j= i+1 ; j<=inarray.length-1 ;j++ )
			{

				if(inarray[i]+ inarray[j] == target)
				{
					System.out.println(" position of the arrray are : " + i +" "+ j );
					System.out.println(" values are : "+inarray[i] +"  "+ inarray[j]);
				}
			}
		}

	}
}

public class TwoSum {
	public static void main(String[] args) {
		new Nums();

	}

}
