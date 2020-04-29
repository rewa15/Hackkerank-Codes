import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
 
    public static int rodCuttingDP(int[] length, int[] price, int n, int N, int[][] dp)
    {
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=N+1; j++)
            {
                if(i==0 || j==0)
                 dp[i][j]=0;
            }
        }
         
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=N+1; j++)
            {
                if(length[i-1]<=j)
                 dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                 
                else
                 dp[i][j] = dp[i-1][j];
            }
        }
    }

	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0; i<t; i++)
	    {
	        int n = sc.nextInt();
	       
	        int[] length = new int[n];
	        int[] price = new int[n];
	        for(int j=0; j<n; j++)
	        {
	            length[j] = sc.nextInt();
	        }
	        
	        for(int k=0; k<n; k++)
	        {
	            price[k] = sc.nextInt();
	        }
	        
	        int N=n;
	        int[][] dp = new int[n+1][N+1];
	        System.out.println(rodCuttingDP(length, price, n, N, dp));
	    }
	 }
}
