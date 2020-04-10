import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the longestIncreasingSubsequence function below.
    // O(n2) Solution
    // Only Passes some of the t.c

    static int helperFun(int[] input, int n)
    {
        int[] output = new int[n];
        output[0]=1; // First index will have minimum that element as a part of subsequence, so 1 element.

        for(int i=1; i<n; i++)
        {
           output[i]=1; // minimum 1 element, so initialize

           for(int j=i-1; j>=0; j--)
           {
               if(input[j] > input[i]) // case when you cannot add the element to subseq
                continue;

               int possibleAnswer = output[j]+1;
               if(possibleAnswer > output[i])
               {
                   output[i]=possibleAnswer;
               }
           }
        }
        
        int best=0;
        for(int i=0; i<n; i++)
        {
            if(best < output[i])
             best = output[i];
        }
        return best; 
    }

    static int longestIncreasingSubsequence(int[] arr) 
    {
       int n = arr.length;
       return helperFun(arr,n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = longestIncreasingSubsequence(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
