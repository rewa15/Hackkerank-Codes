// Min no of deletions to make a string palindrome
// Ques link: https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/

import java.util.*;
import java.io.*;

public class Main
{
    public static int minDeletions(String s1, String s2, int m, int n, int[][] dp)
    {
        // Logic: min deletions means get longest palindrimic subsq, by deleting min chars do length of LPS subtract from string len 
        
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
        
        return m - dp[m][n];
        
    }
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s1 = sc.next();
		char[] arr = s1.toCharArray();
		String s2="";
		for(int i=arr.length-1; i>=0;i--)
		{
		    s2+=arr[i]+"";
		}
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		System.out.println(minDeletions(s1,s2,m,n,dp));
	}
}



