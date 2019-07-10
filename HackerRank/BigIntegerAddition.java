package CodingCompetition.HackerRank;

import java.util.Scanner;

/**
 * Created by Pawan on 6/3/2016.
 */
public class BigIntegerAddition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int counter=0;counter<=n;counter++){
            String testcase1=in.next();
            String testcase2=in.next();
            String output="NO";
            for(int i=0;i<testcase1.length();i++){
                String value=String.valueOf(testcase1.charAt(i));
                if(testcase2!=null && testcase2.contains(value)){
                    output="YES";
                }
                if(output.equalsIgnoreCase("YES"))
                    break;
            }
            System.out.println(output);
        }
    }
}
