import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int stepPermsH(int n,int[] cache) {
        
        if(n<0)
         return 0;
        
        if(n==0)
         return 1;
        
        if(cache[n] >0)
         return cache[n];
        return cache[n] = stepPermsH(n-1,cache) + stepPermsH(n-2,cache) + stepPermsH(n-3,cache);

    }
    static int stepPerms(int n) {
       int[] cache = new int[n+1];
       int res = stepPermsH(n,cache);
       return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
