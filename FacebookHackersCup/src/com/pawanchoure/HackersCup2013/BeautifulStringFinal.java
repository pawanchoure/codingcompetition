package com.pawanchoure.HackersCup2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BeautifulStringFinal {

	private static HashMap<Character, Integer> values=new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] data= new Integer[30];
		ArrayList<Integer> dt=new ArrayList<>();
		ArrayList<Character> charArr=new ArrayList<>();
		
		//Integer total=0;
		int counter=0;
		//String input="SoIjustgoconsultProfessorDalves".toLowerCase();
		String input="Sometimestestcasesarehardtomakeup".toLowerCase();
		String alpha="abcdefghijklmnopqrstuvwxyz";
		while(alpha.length()>counter)
		{
			CharSequence c=alpha.subSequence(counter, counter+1);
			char c1=alpha.charAt(counter);
			if((input.toLowerCase()).contains(c))
			{
				dt.add(countOccurrences(input.toLowerCase(),c1));
			}
			counter++;
		}
		Collections.sort(dt, Collections.reverseOrder());
		
		/*for(int a=0;a <charArr.size();a++)
		{
			int val=dt.get(a);
			int num=val*values.get(charArr.get(a));
			total+=num;
		}
		System.out.println("Total"+total);*/
		
		int j=0;
		int total=0;
		for(int i=26;i>0;i--)
		{
			if(j<dt.size())
			{
				int sum=i*dt.get(j);
				total+=sum;
			}
			j++;
		}
		System.out.println(total);

	}
	
	public static Integer countOccurrences(String haystack, char needle)
	{
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++)
	    {
	        if (haystack.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
}
