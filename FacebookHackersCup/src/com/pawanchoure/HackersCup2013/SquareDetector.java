package com.pawanchoure.HackersCup2013;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pawan
 * Date: 11/23/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class SquareDetector {

    public static void main(String[] args) {
        int testCounter=1;
        Scanner sc = new Scanner(System.in);
        try
        {
            int testcases = sc.nextInt();
            if(testcases<=0)
                System.out.println("Invalid Testcase Number");
            while (testCounter<=testcases) {
                Detect(testCounter);
                testCounter++;
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please try Again with a valid Input");
        }
    }

    /**
     * Method to Create A Grid based on the User Input which will be used
     * to validate the Square Pattern
     * @param j testcase number
     * Sample created Grid  1st Digit maintain the count for the Pattern
     *                      2nd Digit maintain the location for continues pattern start
     *                      3rd Digit maintain the location for continues pattern end
     *                      4th Digit maintain the dimension for the pattern
     *  Example:        5:1:5:5
     */
    public static void Detect(int j) {
        Scanner input = new Scanner(System.in);
        Boolean isValidInput=false;
        //Create a HashMap to store the Grid values
        HashMap<Integer,String> values=new HashMap<Integer, String>();
        int inputText = input.nextInt();
        for(int i=1;i<=inputText;i++)
        {
            Scanner inputString = new Scanner(System.in);
            String characters= inputString.nextLine();
            //Used to track whether the pattern # is continues
            Character prev='.';
            int counter=0,to=0,from=0,dimension=0;
            for(Integer k=1;k<=characters.length();k++)
            {
                Character text=characters.charAt(k-1);
                //Only Process the valid Inputs
                if(text=='.' || text=='#')
                {
                   if(text=='#')
                   {
                       counter++;
                        if(prev!='#')
                        {
                                to=k;
                                from=k;
                        }
                       else
                            from=k;
                   }
                    prev=text;
                }
                else
                    isValidInput=true;

                //To make sure the dimension is zero when no valid pattern # entry is found
                if(to==0 && from==0)
                    dimension=0;
                else
                    dimension=from-to+1;
            }
            values.put(i,counter+":"+to+":"+from+":"+dimension);
        }
        if(isValidInput==false)
            System.out.println("Case #" + j + ": " + validateSquare(values));
        else
            System.out.println("Case #" + j + ": " +"Invalid Input");
    }

    /**
     * Mathod used to Validate the Pattern
     * @param values  Hashmap
     * @return  YES/NO based on Business Logic
     */
    private static String validateSquare(HashMap<Integer, String> values) {
        //Stack to main the Dimension,To and From Position which will be used to validate the pattern
        Stack<String> stringStack= new Stack<String>();
        Stack<String> stringTo= new Stack<String>();
        Stack<String> stringFrom= new Stack<String>();
        int rows=0;
        int index=0;

        for (Map.Entry entry : values.entrySet()) {
            String val=entry.getValue().toString();
            String[] valArr=val.split(":");
            System.out.println("key,val: " + entry.getKey() + "," + entry.getValue());
            //Count and Dimension Match  First Filter
            if(!valArr[0].equals(valArr[3]))
                return "NO";
            //Only put Non-Zero Dimension
            if(stringStack.isEmpty() && !valArr[3].equals("0"))   {
                index=index+Integer.valueOf(entry.getKey().toString());
                stringStack.push(valArr[3]);
                rows++;
                stringTo.push(valArr[2]);
                stringFrom.push(valArr[2]);
            }

            else if(!valArr[3].equals("0"))
            {
                rows++;
                if(!stringStack.peek().equals(valArr[3]))
                    stringStack.push(valArr[3]);
                if(!stringTo.peek().equals(valArr[2]))
                    stringTo.push(valArr[2]);
                if(!stringFrom.peek().equals(valArr[2]))
                     stringFrom.push(valArr[2]);
            }
        }

        System.out.println("StringStack Size :"+stringStack.size());
        //Dimension should be constant across all rows
        if(stringStack.size()>1)
            return "NO";

       // System.out.println("StringStack Peek Value :"+stringStack.peek());
        System.out.println("Rows : :"+rows);
        //Dimension and Rows should be equal
        if(stringStack.size()!=0 && !stringStack.peek().equals(String.valueOf(rows)))
            return "NO";

        // Rows should be in Sequence
        if(index!=0 && index % rows!=1)
            return "NO";

        //Check To and From are same
        if(stringTo.size()>1 || stringFrom.size()>1)
            return "NO";

        return "YES";
    }
}
