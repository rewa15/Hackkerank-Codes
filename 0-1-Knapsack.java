import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    // Code: Recursion+ Memo
    public static int knapsackR(int[] value, int[] weight, int w, int n, int[][] dp)
    {
        // Choose the minimum possible valid input
        // Base case
        
        if(n==0 || w==0)
         return 0;
        
        // Memoize
        if(dp[n][w] > 0)
        {
            return dp[n][w];
        }
        // Choice, diagram
        if(weight[n-1] <= w)
        {
            return dp[n][w] = Math.max(value[n-1]+knapsack(value,weight,w-weight[n-1],n-1), knapsack(value,weight,w,n-1));
        }
        
        else
        {
            return dp[n][w] = knapsack(value,weight,w,n-1);
        }
    }
    
    // Code: Simple Recursion
    public static int knapsack(int[] value, int[] weight, int w, int n)
    {
        // Choose the minimum possible valid input
        // Base case
        
        if(n==0 || w==0)
         return 0;
         
        // Choice, diagram
        if(weight[n-1] <= w)
        {
            return Math.max(value[n-1]+knapsack(value,weight,w-weight[n-1],n-1), knapsack(value,weight,w,n-1));
        }
        
        else
        {
            return knapsack(value,weight,w,n-1);
        }
    }
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0; i<t; i++)
	    {
	        int n = sc.nextInt();
	        int w = sc.nextInt();
	        int[] value = new int[n];
	        int[] weight = new int[n];
	        for(int j=0; j<n; j++)
	        {
	            value[j] = sc.nextInt();
	        }
	        
	        for(int k=0; k<n; k++)
	        {
	            weight[k] = sc.nextInt();
	        }
	        int[][] dp = new int[n+1][w+1];
	        System.out.println(knapsackR(value, weight, w, n, dp));
	    }
	 }
}
