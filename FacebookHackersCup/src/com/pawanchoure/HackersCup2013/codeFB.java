package com.pawanchoure.HackersCup2013;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



/**
 * @author Pawan
 */
public class codeFB {
    private String fileName;
    
    //Characters used for looping
    private final String characters="abcdefghijklmnopqrstuvwxyz";
    
    public codeFB(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Function to Read File
     */
    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine = null;
            int firstLine = 0;
            int intCounter=0;
            for (int i= 0; (strLine = bufferedReader.readLine()) != null; i++) {
                if (firstLine == 0 && intCounter==0) {
                    firstLine = Integer.parseInt(strLine);
                    intCounter=Integer.parseInt(strLine);

                } else {
                    if(firstLine == 0) break;
                    if (strLine.length() >= 2 && strLine.length() <= 500) {
                        printBeautifulString(i, strLine);
                    }
                    firstLine--;
                }
               if(intCounter <5 || intCounter >50)
               {
            	   System.out.println("Please enter Integer greater than 4 and less than 501");
            	   break;
               }
                	
            }

        } catch (FileNotFoundException e) {
           System.out.println("File could not found");
        } catch (IOException e) {
            System.out.println("Could not read file");

        }

    }
    
    /**
     * Function to calculate the occurrences of inputChar in a inputString
     * @param inputString
     * @param inputChar
     * @return count
     */
	public Integer countOccurrences(String inputString, char inputChar)
	{
	    int count = 0;
	    for (int i=0; i < inputString.length(); i++)
	    {
	        if (inputString.charAt(i) == inputChar)
	        {
	             count++;
	        }
	    }
	    return count;
	}
    
	/**
	 * Function to Evaluate the Beauty if the String and prints its value
	 * @param caseNumber
	 * @param strLine
	 */
    private void printBeautifulString(int caseNumber, String strLine) {
    	int whileCounter=0;
		int forCounter=0;
		int total=0;
    	ArrayList<Integer> integerArray=new ArrayList<>();
		while(characters.length()>whileCounter)
		{
			CharSequence c=characters.subSequence(whileCounter, whileCounter+1);
			char c1=characters.charAt(whileCounter);
			if((strLine.toLowerCase()).contains(c))
			{
				integerArray.add(countOccurrences(strLine.toLowerCase(),c1));
			}
			whileCounter++;
		}
    	
		Collections.sort(integerArray, Collections.reverseOrder());
		
		for(int i=26;i>0;i--)
		{
			if(forCounter<integerArray.size())
			{
				int sum=i*integerArray.get(forCounter);
				total+=sum;
			}
			forCounter++;
		}
		 System.out.println("Case #"+caseNumber+": "+ total);
    }
	public static void main(String[] args) {
        BeautifulString2 beautifulString = new BeautifulString2("D://beautiful_stringstxt.txt");
        beautifulString.readFile();
	}

}
