import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) 
    {
      HashMap<Character,Integer> map1=new HashMap<>();
      HashMap<Character,Integer> map2=new HashMap<>();
      String res="";
     int counter=0;
     for(int i=0;i<s1.length();i++)
     {
         char temp1=s1.charAt(i);
         if(map1.containsKey(temp1))
         {
             int count1=map1.get(temp1);
             count1++;
             map1.put(temp1,count1);
         }
         else
         {
             map1.put(temp1,1);
         }
     }
    
    for(int i=0;i<s2.length();i++)
     {
         char temp2=s2.charAt(i);
         if(map2.containsKey(temp2))
         {
             int count2=map2.get(temp2);
             count2++;
             map2.put(temp2,count2);
         }
         else
         {
             map2.put(temp2,1);
         }
     }

     for(int i=0;i<s1.length();i++)
     {
         char temp=s1.charAt(i);
         if(map1.containsKey(temp) && map2.containsKey(temp))
         {
             counter++;
         }
     }

     if(counter>0)
     {
         res="YES";
     }
     else
     {
         res="NO";
     }
     return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
