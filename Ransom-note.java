import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

     HashMap<String,Integer> map1 = new HashMap<>();
     HashMap<String,Integer> map2 = new HashMap<>();
     int counter=0;
     for(int i=0;i<magazine.length;i++)
     {
         if(map1.containsKey(magazine[i]))
         {
             int count1=map1.get(magazine[i]);
             count1++;
             map1.put(magazine[i],count1);
         }
         else
         {
             map1.put(magazine[i],1);
         }
     }
    
    for(int i=0;i<note.length;i++)
     {
         if(map2.containsKey(note[i]))
         {
             int count2=map2.get(note[i]);
             count2++;
             map2.put(note[i],count2);
         }
         else
         {
             map2.put(note[i],1);
         }
     }

     for(int i=0;i<note.length;i++)
     {
         String temp=note[i];
         if(map1.containsKey(temp) && map2.containsKey(temp) && map1.get(temp)>=map2.get(temp))
         {
             counter++;
         }
     }

     if(counter==note.length)
     {
         System.out.println("Yes");
     }
     else
     {
         System.out.println("No");
     }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
