package com.pawanchoure.HackersCup2013;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BS {
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
			HashMap<Character, Character> charSet=new HashMap<>();
			String input="ABbCcc".toLowerCase();
			//String alpha="abcdefghijklmnopqrstuvwxyz";
/*			while(alpha.length()>counter)
			{
				CharSequence c=alpha.subSequence(counter, counter+1);
				char c1=alpha.charAt(counter);
				if((input.toLowerCase()).contains(c))
				{
					dt.add(countOccurrences(input.toLowerCase(),c1));
					charArr.add(c1);
				}
				counter++;
			}*/
			for(int j=0;j<input.length();j++)
			{
				Character c1=input.charAt(j);
				if(!charSet.containsKey(c1))
				{
					dt.add(countOccurrences(input,c1));
					charArr.add(c1);
					charSet.put(c1, c1);
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
