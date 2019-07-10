package com.pawanchoure.HackersCup2013;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BeautifulString {

	private static HashMap<Character, Integer> values=new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner ip = new Scanner(System.in);
		//String inputText = ip.nextLine();
		buildValues();
		Integer[] data= new Integer[30];
		ArrayList<Integer> dt=new ArrayList<>();
		ArrayList<Character> charArr=new ArrayList<>();
		
		Integer total=0;
		int counter=0;
		//String input="SoIjustgoconsultProfessorDalves".toLowerCase();
		String input="Ignorepunctuationplease".toLowerCase();
		String alpha="abcdefghijklmnopqrstuvwxyz";
		while(alpha.length()>counter)
		{
			CharSequence c=alpha.subSequence(counter, counter+1);
			char c1=alpha.charAt(counter);
			if((input.toLowerCase()).contains(c))
			{
				dt.add(countOccurrences(input.toLowerCase(),c1));
				charArr.add(c1);
			}
			counter++;
		}
		Collections.sort(dt, Collections.reverseOrder());
		Collections.sort(charArr);
		
		for(int a=0;a <charArr.size();a++)
		{
			int val=dt.get(a);
			int num=val*values.get(charArr.get(a));
			total+=num;
		}
		System.out.println("Total"+total);
		

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
	
	public static HashMap<Character, Integer> buildValues()
	{
		String alpha="abcdefghijklmnopqrstuvwxyz";
		Integer val=26;
		
		for(int k=0;k<alpha.length();k++)
		{
			values.put(alpha.charAt(k),val);
			val--;
		}
		return values;
		
	}
	

}
