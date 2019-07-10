package CodingCompetition.Barclays;

import java.util.*;

/**
 * Created by Pawan on 2/5/2015.
 */
public class Spelling {
    public static void main(String args[]) {
        System.out.println(distance(new String[]{"topcoder"},"tppcoder"));

    }

    private static int distance(String[] dictionary, String word) {
        Set<String> matchWord = new TreeSet<String>();
        if(dictionary!=null && dictionary.length==0)
            return -1;
        char[] charArray = word.toCharArray();
        Set<String> dict= new TreeSet<String>();
        for(String i:dictionary){
            dict.add(i);
        }
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < word.length(); j++) {
                sb.append(word.charAt(j)); // O(1) complexity.
                if (dict.contains(sb.toString())) {
                    return 0;
                }
            }
        }
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(word.charAt(i));
            Iterator<String> strIterator=dict.iterator();
            while (strIterator.hasNext()){
                String inputWord=strIterator.next();
                if(inputWord.contains(sb2)){
                    matchWord.add(inputWord);
                }

            }
        }


        return -1;
    }
}
