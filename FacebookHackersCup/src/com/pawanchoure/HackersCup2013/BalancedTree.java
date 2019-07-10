package com.pawanchoure.HackersCup2013;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Program to check Balanced Smiley
 * @author Pawan
 *
 */
public class BalancedTree {

	public static void main(String[] args) {
		int j=0;
		Scanner sc = new Scanner(System.in);
		try
		{
			int input = sc.nextInt();
			if(input>50)
			{
				System.out.println("Please Try Again and Enter a Valid Number in Range 0-50");
			}
			while (input > 0 && input <= 50) {
				j++;
				Scanner ip = new Scanner(System.in);
				String inputText = ip.nextLine();
				if(inputText.length()>100)
				{
					System.out.println("The Length of String cannot be greater than 100");
				}
				else
				{
					System.out.println("Case #"+j+": "+checkBalancedParenthesis(inputText));
				}
				input--;
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please Try Again with a Valid Number");
		}

	}

	/**
	 * Function to validate the input based on the certain Criteria
	 * @param inputText
	 * @return String
	 */
	public static String checkBalancedParenthesis(String inputText) {
		Character temp=null;

		/*
		 * To Check whether the String is Empty
		 */

		if (inputText.isEmpty())
			return "YES";

		/*
		 * To Check whether the String is contain A-Z |Space|:
		 */
		if (isValidPattern(inputText))
			return "YES";
		

		/*
		 * To Check whether the String is contained balanced opening and closing
		 * parenthesis
		 */
		if (inputText.contains("(") || inputText.contains(")")) {
			Stack<Character> ip = new Stack<>();
			for (int i = 0; i < inputText.length(); i++) {
				Character c = inputText.charAt(i);
				if(c==':')
				{
				  temp=c;	
				}
				
				if (c == '(') {
					if(temp!=null && temp==':')
					{
						temp=null;
					}
					else
					{
						ip.push(c);
						temp=null;
					}
				}
				if (c == ')') {
					if(temp!=null && temp==':' && !ip.isEmpty() && ip.peek()!='(')
					{
						temp=null;
					}
					else
					{
						if (!ip.empty())
						{
							ip.pop();
							temp=null;
						}
							

					}
				}
			}
			if (ip.empty())
				return "YES";
		}
		return "NO";

	}

	/**
	 * Function to check whether the input string  contains 
	 * A) a to z
	 * B) Space
	 * C) Colon(:)
	 * @param s
	 * @return boolean
	 */
	public static boolean isValidPattern(String s) {
		return s.matches("[a-zA-Z0-9: ]+");
	}
}
