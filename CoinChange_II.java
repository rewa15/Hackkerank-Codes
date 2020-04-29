// Ques: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static int coinChange(int[] arr, int v, int n, int[][] dp)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=v;j++)
            {
                if(j==0)
                 dp[i][j]=0;
                 
                if(i==0)
                 dp[i][j]=Integer.MAX_VALUE-1;
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=v;j++)
            {
               if(arr[i-1] <=j)
               {
                   dp[i][j] = Math.min(1+dp[i][j-arr[i-1]],dp[i-1][j]);
               }
               else
                   dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[n][v] == Integer.MAX_VALUE-1)
         return -1;
         
        else
        return dp[n][v];
    }
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t=sc.nextInt();
	    for(int i=0; i<t; i++)
	    {
	        int v=sc.nextInt();
	        int n=sc.nextInt();
	        int[] arr=new int[n];
	        for(int j=0; j<n; j++)
	        {
	            arr[j]=sc.nextInt();
	        }
	        int[][] dp=new int[n+1][v+1];
	        System.out.println(coinChange(arr,v,n,dp));
	    }
	 }
}
