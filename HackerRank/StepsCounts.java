package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Pawan on 13-06-2019.
 */
public class StepsCounts {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
          int count=0;
          char[] chars=s.toCharArray();
          for(int i=0;i<=chars.length;i++){
              if(chars[i]=='U'){
                  count++;
              }else if(chars[i]=='D'){
                  count--;
              }
          }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();*/

        int result = countingValleys(8, "UDDDUDUU");


    }
}
