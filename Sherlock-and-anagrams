import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        HashMap<String,Integer> map=new HashMap<>(); 
        int totalCount=0;
        
        // 1. Find all possible substrings, sort them.
        // 2. Check if they are present in the hashmap. if yes, add the value to                    totalCount
        //3. Store string and count in hashmap.
        
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                String tempString=s.substring(i,j); 

                char[] arr = tempString.toCharArray();
                Arrays.sort(arr);
                String temp = String.valueOf(arr);

                int test = map.getOrDefault(temp,0); // to avoid null pointer exception
                if(test > 0)
                {
                    totalCount+=test;
                }
                map.put(temp,++test);
            }
        
        }
        return totalCount;       
      
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
