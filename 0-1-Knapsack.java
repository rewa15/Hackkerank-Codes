import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    // Code: Pure DP code
    public static int knapsackDP(int[] value, int[] weight, int w, int n, int[][] dp)
    {
        // Step-1 : Initialize (Base condition in recursion, is initialization in top-down)
        
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<w+1; j++)
            {
                if(i==0 || j==0)
                 dp[i][j]=0;
            }
        }
        
        // Step-2 : Recursion ko change
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
               if(weight[i-1]<=j)
               {
                   dp[i][j] = Math.max(value[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
               }
               else
               {
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        return dp[n][w];
        
    }
     
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
	        
	        // Jo var change ho rahe hai, unki table banae
	        int[][] dp = new int[n+1][w+1];
	        
	        System.out.println(knapsackDP(value, weight, w, n, dp));
	    }
	 }
}
