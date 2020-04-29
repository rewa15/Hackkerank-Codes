// Question: https://practice.geeksforgeeks.org/problems/coin-change/0

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static int coinChange(int[] arr, int n, int N, int[][] dp)
    {
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=N; j++)
            {
                if(j==0)
                 dp[i][j]=1;
                 
                if(i==0)
                 dp[i][j]=0;
            }
        }
         
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=N; j++)
            {
                if(arr[i-1]<=j)
                 dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j];
                 
                else
                 dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][N];
    }
    
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t=sc.nextInt();
	    for(int j=0; j<t; j++)
	    {
	    int n=sc.nextInt();
	    int[] arr=new int[n];
		for(int i=0; i<n; i++)
		{
		    arr[i]=sc.nextInt();
		}
		int sum=sc.nextInt();
		int[][] dp = new int[n+1][sum+1];
		System.out.println(coinChange(arr,n,sum,dp));
	    }
	 }
}
