import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] child) 
    {
       long candies=0;

       int[] left = new int[n];
       int[] right = new int[n];

       Arrays.fill(left,1);
       Arrays.fill(right,1);

       for(int i=1; i<n; i++)
       {
           if(child[i-1] < child[i])
           {
               left[i] = left[i-1]+1;
           }
       }

       for(int i=n-2; i>=0; i--)
       {
           if(child[i+1] < child[i])
           {
               right[i] = right[i+1]+1;
           }
       }

       for(int i=0; i<n; i++)
       {
           candies+=Math.max(left[i],right[i]);
       }
       return candies;
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

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
