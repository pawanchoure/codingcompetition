package com.pawanchoure.HackersCup2013;

import java.io.*;
import java.util.*;



/**
 * Created by IntelliJ IDEA.
 * User: Roshan
 * Date: 1/26/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeautifulString2 {
    private String fileName;
    public BeautifulString2(String fileName) {
        this.fileName = fileName;
    }
    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine = null;
            int firstLine = 0;
            int totalLines = 0;
            for (int i= 0; (strLine = bufferedReader.readLine()) != null; i++) {
                if (firstLine == 0 ) {
                    firstLine = Integer.parseInt(strLine);

                } else {
                    if(firstLine == 0) break;
                    if (strLine.length() >= 2 && strLine.length() <= 500) {
                        printBeautifulString(i, strLine);
                    }
                    firstLine--;
                }

            }

        } catch (FileNotFoundException e) {
           System.out.println("File could not found");
        } catch (IOException e) {
            System.out.println("Could not read file");

        }

    }
    private void printBeautifulString(int caseNumber, String strLine) {
        int value = 0;
        Map<Character, Integer> occ = new HashMap<Character, Integer>();
        for (char character: strLine.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) {
                if (!occ.containsKey(character)) {
                    occ.put(character, 1);
                } else {
                    occ.put(character, occ.get(character) + 1);
                }
            }
        }

        List<Integer> total = new ArrayList<Integer>(occ.values());
        Collections.sort(total, Collections.reverseOrder());
        for(Integer integer: total) {
            value+= integer * (26- total.indexOf(integer));
        }
        System.out.println("case:" + caseNumber + " " + value);
    }

    
    public static void main(String args[]) {
        BeautifulString2 beautifulString = new BeautifulString2("D://beautiful_stringstxt.txt");
        beautifulString.readFile();
    }
}
