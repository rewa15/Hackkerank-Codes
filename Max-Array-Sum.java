import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int maxHelper(int[] arr,int[] cache, int j)
    {
        cache[0]=arr[0];
        cache[1]= Math.max(arr[0], arr[1]);
        
        for(int i=2;i<arr.length;i++)
        {
            int option1 = arr[i] + cache[i-2];
            int option2 = cache[i-1];
            cache[i] = Math.max(option1, option2);
        }
        
        return cache[j];
    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) 
    {
      int n=arr.length;
      int[] cache = new int[n+1];
      Arrays.fill(cache,0);
      int res = maxHelper(arr,cache,n-1);
      return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
