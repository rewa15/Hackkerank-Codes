import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static int editDistance(String str1, String str2, int m, int n)
    {
        int[][] cache = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0)
                {
                    cache[i][j]=j;
                }
                else if(j==0)
                {
                    cache[i][j]=i;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    cache[i][j] = cache[i-1][j-1];
                }
                else
                {
                    cache[i][j] =1 + Math.min(cache[i-1][j], Math.min(cache[i][j-1], cache[i-1][j-1]));
                }
            }
        }
        return cache[m][n];
    }
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0; i<t; i++)
	    {
	        int p = sc.nextInt();
	        int q = sc.nextInt();
	        String str1 = sc.next();
	        String str2 = sc.next();
	        System.out.println(editDistance(str1,str2,p,q));
	    }
	 }
}
