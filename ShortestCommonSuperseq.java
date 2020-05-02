// Shortest common Supersequence

import java.util.*;
import java.io.*;

public class Main
{
    public static int SCS(String s1, String s2, int m, int n, int[][] dp)
    {
        // Logic: Jo longest common subsequence ka part hai, write that once.
        
        int len = s1.length() + s2.length();
        
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
        
        return len - dp[m][n];
        
    }
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		System.out.println(SCS(s1,s2,m,n,dp));
	}
}
