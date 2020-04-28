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
                   dp[i][j] = Math.max(value[i-1]+dp[i][j-weight[i-1]], dp[i-1][j]); // Only change is can call recursion on same item again
               }
               else
               {
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        return dp[n][w];
        
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
