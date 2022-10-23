package com.leetode.romantointeger;

public class RtoI {


	int I = 1;
	int V = 5;
	int X = 10;
	int L = 50;
	int C = 100;
	int D = 500;
	int M = 1000;
	int value = 0;

	RtoI(String s)
	{
		int pos = s.length();
		for(int i =pos-1 ; i>=0;i--)
		{  
			
			if(i>=1 && s.charAt(i) == 'V' && s.charAt(i-1)=='I')
			{
				result('4');
			}
			else if(i>=1 && s.charAt(i) == 'X' && s.charAt(i-1)=='I')
			{
				result('4');
			}
			else if(i>=1 && s.charAt(i) == 'L' && s.charAt(i-1)=='X')
			{
				result('F');
			}
			else if(i>=1 && s.charAt(i) == 'C' && s.charAt(i-1)=='X')
			{
				result('F');
			}
			else if(i>=1 && s.charAt(i) == 'D' && s.charAt(i-1)=='C')
			{
				result('N');
			}
			else if(i>=1 && s.charAt(i) == 'M' && s.charAt(i-1)=='C')
			{
				result('N');
			}
			result(s.charAt(i));
		}		
	}

	public void result(char c)
	{
		switch(c)
		{
		case 'I':
			value = value + I ;
			break;
		case '4':
			value = value - I - I;
			break;
		case 'V':
			value = value + V ;
			break;
		case 'X':
			value = value + X;
			break;
		case 'F':
			value = value - X - X;
			break;
		case 'N':
			value = value - C - C;
			break;
		case 'L':
			value = value + L ;
			break;
		case 'C':
			value = value + C ;
			break;
		case 'D':
			value = value + D ;
			break;
		case 'M':
			value = value + M ;
			break;
		default:
			System.out.println("default");
		}
	}

	public static void main(String[] args) {

		String s = "DLXIX";
		RtoI r = new RtoI(s);
		System.out.println(r.value);

	}

}
