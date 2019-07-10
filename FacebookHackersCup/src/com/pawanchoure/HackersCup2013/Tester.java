package com.pawanchoure.HackersCup2013;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int[] arr= {6, 5, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] arr= {3,2,1};
		int j=0;
		int total=0;
		for(int i=26;i>0;i--)
		{
			if(j<arr.length)
			{
				int sum=i*arr[j];
				total+=sum;
			}
			j++;
		}

		System.out.println(total);
	}

}
