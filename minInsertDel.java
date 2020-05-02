// Min no of insertions + deletions to convert one string to another
// Question link: https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/

import java.util.*;
import java.io.*;

public class Main
{
    public static int findMin(String s1, String s2, int m, int n, int[][] dp)
    {
        
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                 dp[i][j]=0;
            }
        }
        
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                   dp[i][j] = 1 + dp[i-1][j-1];
                   
                else
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int res1 = m-dp[m][n];
        int res2 = n-dp[m][n];
        return res1 + res2;
        
    }
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		System.out.println(findMin(s1,s2,m,n,dp));
	}
}

